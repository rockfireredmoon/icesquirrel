/** 
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 Emerald Icemoon (emerald.icemoon@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
 * associated documentation files (the "Software"), to deal in the Software without restriction, 
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, 
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial 
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.icesquirrel.jsr223;

import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map.Entry;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.apache.commons.io.input.ReaderInputStream;
import org.icesquirrel.interpreter.SquirrelInterpretedProcessor;
import org.icesquirrel.interpreter.SquirrelInterpretedScript;
import org.icesquirrel.runtime.BridgeSquirrelClass;
import org.icesquirrel.runtime.JavaSquirrelObject;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelObjectWrapper;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.runtime.SquirrelTable;

public class IcesquirrelScriptEngine extends AbstractScriptEngine {

	private IcesquirrelScriptEngineFactory factory;

	IcesquirrelScriptEngine(IcesquirrelScriptEngineFactory factory) {
		this.factory = factory;
	}

	@Override
	public Object eval(String script, ScriptContext context) throws ScriptException {
		return eval(new StringReader(script), context);
	}

	@Override
	public Object eval(Reader reader, ScriptContext context) throws ScriptException {

		SquirrelInterpretedScript sis = new SquirrelInterpretedScript();

		/*
		 * If the global bindings is already a SquirrelTable, use that directly.
		 * A squirrel table is kind of compatible with a bindings object, except
		 * the key may be an Object instead of a string.
		 */
		Bindings bindings = context.getBindings(ScriptContext.GLOBAL_SCOPE);
		if (bindings instanceof BindingsAdapter) {
			sis.setRootTable(((BindingsAdapter) bindings).getTable());
		} else {
			// Otherwise copy global bindings into our root table
			for (Entry<String, Object> s : bindings.entrySet()) {
				bind(sis, s);
			}
		}

		// Now the engine scoped bindings. If these are already a squirrel
		// table, add them as
		// a delegate, otherwise copy
		Bindings engBindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
		SquirrelTable addedDelegate = null;
		if (engBindings instanceof BindingsAdapter) {
			BindingsAdapter ba = (BindingsAdapter) engBindings;
			if (ba.getTable() != sis.getRootTable()) {
				SquirrelTable pt = sis.setRootTable(ba.getTable());
				if (pt != null && !ba.getTable().getDelegates().contains(pt)) {
					ba.getTable().addDelegate(pt);
					addedDelegate = pt;
				}
			}
		} else {
			for (Entry<String, Object> s : engBindings.entrySet()) {
				bind(sis, s);
			}
		}

		SquirrelRuntime runtime = SquirrelRuntime.getDefaultRuntime();
		SquirrelExecutionContext ctx = null;
		if (!SquirrelExecutionContext.is()) {
			ctx = new SquirrelExecutionContext();
			ctx.start(sis.getRootTable(), runtime, new SquirrelInterpretedProcessor());
		}

		try {
			try {
				// TODO encoding
				sis.execute(new ReaderInputStream(reader));
			} catch (SquirrelException se) {
				// TODO line number etc
				throw new ScriptException(se);
			} catch (Exception e) {
				// TODO line number etc
				throw new ScriptException(e);
			}
			Object result = sis.getResult();
			if (result instanceof SquirrelObjectWrapper) {
				return ((SquirrelObjectWrapper) result).getObject();
			}
			return result;
		} finally {
			if (addedDelegate != null) {
				sis.getRootTable().removeDelegate(addedDelegate);
			}
			if (ctx != null) {
				ctx.stop();
			}
		}
	}

	private void bind(SquirrelInterpretedScript sis, Entry<String, Object> s) {
		Object value = s.getValue();
		if (value instanceof Class<?>) {
			value = new BridgeSquirrelClass((Class<?>) value);
		} else if (value instanceof Method) {
			BridgeSquirrelClass.BridgeSquirrelFunction bridgeSquirrelFunction = new BridgeSquirrelClass.BridgeSquirrelFunction(
					((Method) value).getDeclaringClass());
			bridgeSquirrelFunction.getMethods().add((Method) value);
			value = bridgeSquirrelFunction;
		} else if (value instanceof List) {
			value = new SquirrelArray((List) value);
		} else if (value instanceof Object) {
			value = new JavaSquirrelObject(new BridgeSquirrelClass(value.getClass()), value) {
			};
		}
		sis.getRootTable().insertLocal(s.getKey(), value);
	}

	@Override
	public Bindings createBindings() {
		return new BindingsAdapter(new SquirrelTable());
	}

	@Override
	public ScriptEngineFactory getFactory() {
		return factory;
	}

	class SquirrelContext extends SimpleScriptContext {

	}
}
