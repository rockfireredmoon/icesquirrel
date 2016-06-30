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

import java.util.Map;

public abstract class AbstractSquirrelFunction extends AbstractSquirrelDataType<AbstractSquirrelFunction>
		implements SquirrelCallable {

	public final static String TYPE_NAME = "function";

	public static class SquirrelFunctionClass extends DefaultSquirrelClass<AbstractSquirrelFunction> {

		public SquirrelFunctionClass() {
			super(AbstractSquirrelFunction.class, TYPE_NAME);
		}

		@Function
		public Object call(AbstractSquirrelFunction function, Object _this, Object... args) {
			return doCall(function, _this, new SquirrelArray(args));
		}

		@Function
		public Object pcall(AbstractSquirrelFunction function, Object _this, Object... args) {
			try {
				return doCall(function, _this, new SquirrelArray(args));
			} catch (SquirrelException se) {
				SquirrelRuntime.LOG.fine("Sinking error in protected call.");
				return null;
			}
		}

		@Function
		public Object acall(AbstractSquirrelFunction function, Object _this, SquirrelArray args) {
			return doCall(function, _this, toArgArr(args));
		}

		@Function
		public Object pacall(AbstractSquirrelFunction function, Object _this, SquirrelArray args) {
			try {
				return doCall(function, _this, toArgArr(args));
			} catch (SquirrelException se) {
				SquirrelRuntime.LOG.fine("Sinking error in protected call.");
				return null;
			}
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}

		private SquirrelArray toArgArr(SquirrelArray arguments) {
			SquirrelArray argArr = new SquirrelArray(arguments);
			argArr.remove(0);
			return argArr;
		}

		private Object doCall(AbstractSquirrelFunction func, Object _this, SquirrelArray arguments) {
			SquirrelExecutionContext.get().newExecution(_this, 1);
			try {
				return SquirrelExecutionContext.get().getProcessor().evaluateCallable(
						(AbstractSquirrelFunction) SquirrelExecutionContext.get().execution().getEnvironment(), arguments);
			} finally {
				SquirrelExecutionContext.get().popExecution();
			}
		}
	};

	public final static SquirrelFunctionClass CLASS = new SquirrelFunctionClass();

	private boolean varargs;
	protected SquirrelTable arguments;
	private boolean generator;
	private SquirrelTable freeVariables = new SquirrelTable();

	@SuppressWarnings("unchecked")
	public AbstractSquirrelFunction(Object... args) {
		super(CLASS);
		arguments = new SquirrelTable();
		for (Object o : args) {
			if (o instanceof Map.Entry) {
				Map.Entry<Object, Object> e = (Map.Entry<Object, Object>) o;
				arguments.insertLocal(e.getKey(), e.getValue());
			} else {
				arguments.insertLocal(o, null);
			}
		}
	}

	// @Override
	// public SquirrelDataType get(Object key) {
	// return getClassDeclaration().get(key);
	// }

	public SquirrelTable getFreeVariables() {
		return freeVariables;
	}

	public boolean isGenerator() {
		return generator;
	}

	public void setGenerator(boolean generator) {
		this.generator = generator;
	}

	@Override
	public SquirrelTable getSignature() {
		return arguments;
	}

	public void format(SquirrelPrintWriter writer, int depth) {
		String indent = SquirrelPrinter.identString(depth);
		writer.print("function(");
		if (varargs) {
			writer.print("...");
		} else {
			int i = 0;
			if (arguments != null) {
				for (Map.Entry<Object, Object> en : arguments.entrySet()) {
					if (i > 0) {
						writer.print(", ");
					}
					writer.print(en.getKey().toString());
					Object value = en.getValue();
					if (en.getValue() != null) {
						writer.print(" = ");
						SquirrelPrinter.format(writer, value, depth == -1 ? -1 : depth + 1);
					}
					i++;
				}
			}
		}
		// TODO
		writer.print(") {");
		if (indent != null) {
			writer.println();
			writer.print(indent);
		}
		int idx = 0;
		if (idx > 0 && indent != null) {
			writer.println();
			writer.print(indent);
		}
		writer.print("}");
	}

	public int compareTo(AbstractSquirrelFunction o) {
		return String.valueOf(this).compareTo(String.valueOf(o));
	}
}
