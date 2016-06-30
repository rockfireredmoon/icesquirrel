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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractSquirrelClass extends SquirrelTable implements SquirrelObjectWrapper {

	public static class SquirrelClassClass extends JavaSquirrelClass<AbstractSquirrelClass> {
		public SquirrelClassClass() {
			super(AbstractSquirrelClass.class);
		}

		@Function(name = "getattributes")
		public SquirrelTable getattributes(AbstractSquirrelClass clazz, Object member) {
			return (SquirrelTable) getAttributes().get(member);
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	private final static SquirrelClassClass CLASS = new SquirrelClassClass();

	private AbstractSquirrelClass superClass;
	private String typeName;
	private SquirrelTable attributes;

	protected AbstractSquirrelClass(String typeName, Class<?> javaClass) {
		super();
		this.typeName = typeName;
		try {
			for (Method m : getClass().getMethods()) {
				Function f = m.getAnnotation(Function.class);
				if (f != null && !Modifier.isStatic(m.getModifiers())) {
					final String k = f.name().equals("") ? m.getName() : f.name();
					if (!containsKey(k)) {
						insertLocal(k, new JavaSquirrelFunction(getClass(), m));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object getObject() {
		return CLASS;
	}

	@Override
	public AbstractSquirrelClass getClassDeclaration() {
		return CLASS;
	}

	@Function
	public AbstractSquirrelClass getclass(Object o) {
		return this;
	}

	public SquirrelTable getAttributes() {
		if (attributes == null) {
			attributes = new SquirrelTable();
		}
		return attributes;
	}

	public AbstractSquirrelClass getSuperClass() {
		return superClass;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setSuperClass(AbstractSquirrelClass superClass) {
		this.superClass = superClass;
	}

	@Override
	public boolean containsKey(Object key) {
		boolean ck = super.containsKey(key);
		SquirrelRuntime runtime = SquirrelExecutionContext.get().getRuntime();
		if (!ck && runtime != null) {
			return runtime.getBuiltInFunctions().containsKeyLocally((Object) key);
		}
		return ck;
	}

	@Override
	protected Object doGet(Object key) {
		try {
			return super.doGet(key);
		} catch (IllegalArgumentException iae) {
			if (getSuperClass() != null) {
				try {
					getSuperClass().getOrFail(key);
				} catch (IllegalArgumentException iae2) {
				}
			}

			SquirrelRuntime runtime = SquirrelExecutionContext.get().getRuntime();
			if (runtime == null) {
				throw iae;
			}
			try {
				return runtime.getBuiltInFunctions().getOrFail(key);
			} catch (IllegalArgumentException iae2) {
				throw new IllegalArgumentException(iae.getMessage() + " in " + getClass(), iae2);
			}
		}
	}

	@Override
	public Object clone() {
		throw new UnsupportedOperationException();
	}

	public Object add(Object obj, Object val) {
		try {
			return runIfMeta(obj, "_add", val);
		} catch (IllegalArgumentException iae) {
		}
		if (val instanceof String) {
			return String.valueOf(obj) + String.valueOf(val);
		}
		throw new UnsupportedOperationException();
	}

	private Object runIfMeta(Object env, String key, Object... args) {
		if (env instanceof SquirrelTable && ((SquirrelTable) env).containsKey(key)) {
			AbstractSquirrelFunction func = (AbstractSquirrelFunction) ((SquirrelTable) env).get(key);
			SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
			ctx.newExecution(env, 0);
			try {
				return ctx.getProcessor().evaluateCallable(func, new SquirrelArray(args));
			} finally {
				ctx.popExecution();
			}
		}
		throw new IllegalArgumentException();
	}

	public Object sub(Object obj, Object val) {
		try {
			return runIfMeta(obj, "_sub", val);
		} catch (IllegalArgumentException iae) {
		}
		throw new UnsupportedOperationException();
	}

	public Object mul(Object obj, Object val) {
		try {
			return runIfMeta(obj, "_mul", val);
		} catch (IllegalArgumentException iae) {
		}
		throw new UnsupportedOperationException();
	}

	public Object div(Object obj, Object val) {
		try {
			return runIfMeta(obj, "_div", val);
		} catch (IllegalArgumentException iae) {
		}
		throw new UnsupportedOperationException();
	}

	public Object modulo(Object obj, Object val) {
		try {
			return runIfMeta(obj, "_modulo", val);
		} catch (IllegalArgumentException iae) {
		}
		throw new UnsupportedOperationException();
	}

	public Object typeof(Object obj) {
		try {
			return runIfMeta(obj, "_typeof");
		} catch (IllegalArgumentException iae) {
		}
		return getTypeName();
	}

	public Object left(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object right(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object rightUnsigned(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object not(Object obj) {
		throw new UnsupportedOperationException();
	}

	public Object and(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object xor(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object or(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object bool(Object obj) {
		throw new UnsupportedOperationException();
	}

	public Object lessThan(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object lessThanEquals(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object moreThan(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	public Object moreThanEquals(Object obj, Object val) {
		throw new UnsupportedOperationException();
	}

	protected Set<Object> keysOfType(Class<?> dataTypeClass) {
		Set<Object> l = new LinkedHashSet<>();
		for (Map.Entry<Object, Object> en : entrySet()) {
			if (en.getKey().getClass().equals(dataTypeClass)) {
				l.add(en.getKey());
			}
		}
		return l;
	}

	protected Set<Object> keysOfValuesOfType(Class<?> dataTypeClass) {
		Set<Object> l = new LinkedHashSet<>();
		for (Map.Entry<Object, Object> en : entrySet()) {
			if ((en.getValue() == null && dataTypeClass == null)
					|| (en.getValue() != null && en.getValue().getClass().equals(dataTypeClass))) {
				l.add(en.getKey());
			}
		}
		return l;
	}

	public void format(SquirrelPrintWriter writer, int depth) {
		String indent = SquirrelPrinter.identString(depth);
		writer.print("class");
		if (superClass != null) {
			writer.print(" extends ");
			superClass.format(writer, depth == -1 ? -1 : depth + 1);
		}
		writer.print(" {");
		if (indent != null) {
			writer.println();
			writer.print(indent);
		}
		int idx = 0;
		// idx = format(writer, depth, indent, idx,
		// keysOfType(SquirrelVariable.class));
		idx = format(writer, depth, indent, idx, keysOfValuesOfType(AbstractSquirrelFunction.class));
		if (indent != null) {
			writer.print(indent);
		}
		writer.print("}");
	}

	private int format(SquirrelPrintWriter writer, int depth, String indent, int idx, Set<Object> keySet) {
		for (Object key : keySet) {
			if (idx > 0) {
				if (indent != null) {
					writer.print(indent);
				}
			}
			writer.print(SquirrelPrinter.format(key));
			writer.print(" = ");
			SquirrelPrinter.format(writer, get(key), depth == -1 ? -1 : depth + 1);
			if (indent != null) {
				writer.println(" ;");
			}
			idx++;
		}
		return idx;
	}

	public abstract Object construct(SquirrelArray argumentValues);
}
