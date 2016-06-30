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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapts a java class to a squirrel class.
 * 
 * @see JavaSquirrelClass
 */
public class BridgeSquirrelClass extends AbstractSquirrelClass {

	private Class<?> javaClass;

	public BridgeSquirrelClass(Class<?> javaClass) {
		super("class", javaClass);
		this.javaClass = javaClass;
		try {
			for (Method m : javaClass.getMethods()) {
				//
				final String k = new String(m.getName());
				BridgeSquirrelFunction f;
				if (containsKeyLocally(k)) {
					f = (BridgeSquirrelFunction) get(k);
				} else {
					f = new BridgeSquirrelFunction(javaClass);
					insert(new String(m.getName()), f);
				}
				f.getMethods().add(m);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object construct(SquirrelArray arguments) {
		try {
			for (boolean cast : new boolean[] { false, true }) {
				for (Constructor<?> m : javaClass.getConstructors()) {
					List<Object> actualArgs = JavaTypeConverter.getActualArgs(m.getParameterTypes(), arguments, cast);
					if (actualArgs != null) {
						return new JavaSquirrelObject(this, m.newInstance(actualArgs.toArray(new Object[0]))) {
						};
					}
				}
			}
			throw new RuntimeException("Could not find matching constructor for " + javaClass);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	@Function
	public AbstractSquirrelClass getclass() {
		return this;
	}

	public static class BridgeSquirrelFunction extends AbstractSquirrelFunction {

		private List<Method> method;
		private Class<?> javaClass;

		public BridgeSquirrelFunction(Class<?> javaClass) {
			super();
			this.method = new ArrayList<>();
			this.javaClass = javaClass;
		}

		public List<Method> getMethods() {
			return method;
		}

		public Class<?> getJavaClass() {
			return javaClass;
		}

		@Override
		public Object evaluate(SquirrelArray arguments) {
			try {
				SquirrelRuntime.LOG.fine(String.format("Evaluating function"));
				SquirrelExecution execution = SquirrelExecutionContext.get().execution();
				Object eobj = execution.getEnvironment();
				Object obj = eobj instanceof SquirrelObjectWrapper ? ((SquirrelObjectWrapper) eobj).getObject() : eobj;
				for (boolean cast : new boolean[] { false, true }) {
					for (Method m : method) {
						List<Object> actualArgs = JavaTypeConverter.getActualArgs(m.getParameterTypes(), arguments, cast);
						if (actualArgs != null) {
							return m.invoke(Modifier.isStatic(m.getModifiers()) ? null : obj, actualArgs.toArray(new Object[0]));
						}
					}
				}
				throw new SquirrelException("No method matches.");
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
				throw new RuntimeException(String.format("Failed to invoked java method for %s.", javaClass), e);
			}
		}

	}

}
