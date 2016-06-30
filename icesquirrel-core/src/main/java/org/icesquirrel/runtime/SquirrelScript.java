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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;

import org.iceparser.SquirrelParser.ScriptContext;

public abstract class SquirrelScript implements SquirrelCallable {

	public final static String TYPE_NAME = "script";

	public static class SquirrelScriptClass extends AbstractSquirrelClass {
		public SquirrelScriptClass() {
			super(TYPE_NAME, SquirrelScriptClass.class);
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	public final static SquirrelScriptClass CLASS = new SquirrelScriptClass();

	protected Object result;
	protected String sourceName;
	protected ScriptContext script;
	protected SquirrelArray arguments = new SquirrelArray();
	protected SquirrelRuntime runtime;
	protected SquirrelTable rootTable;

	// @Override
	// public AbstractSquirrelClass getClassDeclaration() {
	// return CLASS;
	// }

	public SquirrelScript(Object... args) {
		this(SquirrelRuntime.getDefaultRuntime());
	}

	public SquirrelScript(SquirrelRuntime runtime, Object... args) {
		super();
		this.runtime = runtime;

		this.arguments.addAll(Arrays.asList(args));
	}

	public SquirrelScript(InputStream in, Object... args) throws Exception {
		this((String) null, in, args);
	}

	public SquirrelScript(String sourceName, InputStream in, Object... args) throws Exception {
		this(args);
		execute(in);
	}

	public SquirrelScript(String in, Object... args) throws Exception {
		this((String) null, in, args);
	}

	public SquirrelScript(String sourceName, String in, Object... args) throws Exception {
		this(args);
		execute(in);
	}

	public SquirrelScript(SquirrelRuntime runtime, String in, Object... args) throws Exception {
		this(null, runtime, in, args);
	}

	public SquirrelScript(String sourceName, SquirrelRuntime runtime, String in, Object... args) throws Exception {
		this(runtime, args);
		this.sourceName = sourceName;
		execute(in);
	}

	public SquirrelScript(SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		this(null, runtime, in, args);
	}

	public SquirrelScript(String sourceName, SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		this(runtime, args);
		this.sourceName = sourceName;
		execute(in);
	}

	public SquirrelTable setRootTable(SquirrelTable rootTable) {
		SquirrelTable oldRootTable = this.rootTable;
		this.rootTable = rootTable;
		return oldRootTable;
	}

	public SquirrelTable getRootTable() {

		if (rootTable == null) {
			rootTable = new SquirrelTable();
			if (SquirrelRuntime.LOG.isLoggable(Level.FINE)) {
				rootTable.insertLocal("_DBG_TABLE_TYPE", "script");
			}
			rootTable.addDelegate(runtime.getRuntimeTable());
			rootTable.addDelegate(runtime.getConstTable());
			rootTable.addDelegate(runtime.getBuiltInFunctions());
		}

		return rootTable;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Object getResult() {
		return result;
	}

	public void execute(String in) throws Exception {
		execute(new ByteArrayInputStream(in.getBytes()));
	}

	public void execute(final InputStream in) throws Exception {
		execute(in, true);
	}

	public abstract void execute(final InputStream in, boolean runErrorHandler) throws Exception;

	public void format(PrintWriter writer, int depth) {
		writer.println(toString());
	}

	@Override
	public Object evaluate(SquirrelArray arguments) {
		try {
			SquirrelExecutionContext.get().getProcessor().processStatements(script.stat());
		} catch (Return rv) {
			return rv.getReturnValue();
		}
		return null;
	}

	@Override
	public SquirrelTable getSignature() {
		SquirrelTable sig = new SquirrelTable();
		int i = 0;
		for (Object arg : arguments) {
			sig.insertLocal("__arg" + (i++), arg);
		}
		return sig;
	}
}
