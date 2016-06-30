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
package org.icesquirrel.runtime;

import java.util.List;
import java.util.logging.Level;

import org.icesquirrel.interpreter.SquirrelInterpretedScript;

public class DefaultBuiltIn {

	@Function
	public static void print(Object exp) {
		System.out.println(exp);
	}

	@Function
	public static Object collectgarbage() {
		System.gc();
		return Boolean.TRUE;
	}

	@Function
	public static SquirrelArray array(Long size, Object... fill) {
		SquirrelArray arr = new SquirrelArray(size.intValue());
		if (fill.length > 0) {
			arr.addAll((SquirrelArray) fill[0]);
		}
		return arr;
	}

	@Function(name = "assert")
	public static boolean _assert(Object val) {
		if (!SquirrelMath.bool(val)) {
			throw new SquirrelException("Assertion error.");
		}
		return Boolean.TRUE;
	}

	@Function
	public static AbstractSquirrelFunction compilestring(final String scriptText) {
		return new AbstractSquirrelFunction() {
			@Override
			public Object evaluate(SquirrelArray arguments) {
				try {
					return SquirrelInterpretedScript.run(SquirrelExecutionContext.get().getRuntime(), scriptText);
				} catch (Exception e) {
					throw new SquirrelException("I/O error when compiling.", e);
				}
			}
		};
	}

	@Function
	public static boolean enabledebuginfo(Boolean enable) {
		if (enable) {
			SquirrelRuntime.setLogLevel(Level.FINER);
		} else {
			SquirrelRuntime.setLogLevel(Level.WARNING);
		}
		return true;
	}

	@Function
	public static SquirrelTable getconsttable() {
		return SquirrelExecutionContext.get().getRuntime().getConstTable();
	}

	@Function
	public static SquirrelTable getroottable() {
		return SquirrelExecutionContext.get().getRoot();
	}

	@Function
	public static SquirrelTable getstackinfos(Long level) {
		List<SquirrelExecution> stackFrames = SquirrelExecutionContext.get().stack();
		return stackFrames.get(stackFrames.size() - level.intValue() - 1);
	}

	@Function
	public static SquirrelCoroutine newthread(AbstractSquirrelFunction func) {
		return new SquirrelCoroutine(func);
	}

	@Function
	public static boolean setconsttable(SquirrelTable table) {
		SquirrelExecutionContext.get().getRuntime().setConstTable(table);
		return true;
	}

	@Function
	public static boolean setroottable(SquirrelTable table) {
		SquirrelExecutionContext.get().setRoot(table);
		return true;
	}

	@Function
	public static boolean setdebughook(AbstractSquirrelFunction func) {
		throw new UnsupportedOperationException();
	}

	@Function
	public static boolean seterrorhandler(AbstractSquirrelFunction func) {
		SquirrelExecutionContext.get().setErrorHandler(func);
		return true;
	}

	@Function
	public static Object suspend(AbstractSquirrelFunction func) {
		return ((SquirrelCoroutine) SquirrelExecutionContext.get().execution().getEnvironment()).suspend(func);
	}

	@Function
	public static String type(Object o) {
		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		AbstractSquirrelClass clazz = ctx.getRuntime().getClass(o);
		return new String(o == null || clazz == null ? "null" : clazz.getTypeName());
	}
}
