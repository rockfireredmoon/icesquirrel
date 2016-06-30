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

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class JavaSquirrelFunction extends AbstractSquirrelFunction {

	private Method method;
	private Class<?> javaClass;
	private boolean isStatic;

	public JavaSquirrelFunction(Class<?> javaClass, Method method) {
		super();
		this.method = method;
		this.isStatic = Modifier.isStatic(method.getModifiers());
		this.javaClass = javaClass;
	}

	public Method getMethod() {
		return method;
	}

	public Class<?> getJavaClass() {
		return javaClass;
	}

	@Override
	public Object evaluate(SquirrelArray callArguments) {
		SquirrelRuntime.LOG.fine(String.format("Evaluating function %s", method.getName()));

		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		SquirrelExecution execution = ctx.execution();
		Class<?>[] parameterTypes = method.getParameterTypes();
		Object obj = execution.getEnvironment();

		SquirrelArray allArgs = new SquirrelArray();
		allArgs.addAll(callArguments);

		AbstractSquirrelClass clazz = ctx.getRuntime().getClass(obj);
		try {

			if (!isStatic) {
				// When calling Java 'functions', the first argument is the
				// instance to
				// work on
				// Class<?>[] p = parameterTypes;
				// parameterTypes = new Class[parameterTypes.length + 1];
				// System.arraycopy(p, 0, parameterTypes, 1, p.length);
				// p[0] = Object.class;
				allArgs.add(0, obj);
			}

			/*
			 * If the last argument in a method's signature is an array, it is a
			 * varargs call, so collapse any remaining arguments into an array
			 */

			if (parameterTypes.length > 0 && method.isVarArgs()) {

				int sz = allArgs.size() - parameterTypes.length + 1;
				Object[] vararg = (Object[]) Array.newInstance(parameterTypes[parameterTypes.length - 1].getComponentType(), sz);
				for (int j = 0; j < sz; j++) {
					vararg[j] = convert(allArgs.get(sz + j));
				}
				for (int j = 0; j < sz; j++) {
					allArgs.remove(allArgs.size() - 1);
				}
				allArgs.add(vararg);
			}

			for (boolean cast : new boolean[] { false, true }) {
				List<Object> actualArgs = JavaTypeConverter.getActualArgs(parameterTypes, allArgs, cast);
				if (actualArgs != null) {
					return method.invoke(isStatic ? null : clazz, actualArgs.toArray(new Object[0]));
				}
			}

			throw new RuntimeException("No matching function.");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
			throw new RuntimeException(String.format("Failed to invoke java method for %s#%s.", javaClass, method.getName()), e);
		}
	}

	private Object convert(Object o) {
		if (o instanceof SquirrelObjectWrapper) {
			return ((SquirrelObjectWrapper) o).getObject();
		}
		return o;
	}
}
