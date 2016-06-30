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
import java.util.List;

/**
 * Adapts a java class to a squirrel class, including the methods that have been
 * annotated with the {@link Function} annotation.
 * 
 * @see BridgeSquirrelClass
 */
public class JavaSquirrelClass<T> extends AbstractSquirrelClass {

	private Class<T> javaClass;

	public JavaSquirrelClass(Class<T> javaClass) {
		this(javaClass, "class");
	}

	public JavaSquirrelClass(Class<T> javaClass, String typeName) {
		super(typeName, javaClass);
		this.javaClass = javaClass;
	}

	@Override
	public Object construct(SquirrelArray arguments) {
		try {
			Class<?>[] parms = JavaTypeConverter.getNativeArgumentClasses(arguments);
			for (boolean cast : new boolean[] { false, true }) {
				for (Constructor<?> m : javaClass.getConstructors()) {
					List<Object> actualArgs = JavaTypeConverter.getActualArgs(m.getParameterTypes(), arguments, cast);
					if (actualArgs != null) {
						return javaClass.getConstructor(parms).newInstance(actualArgs.toArray(new Object[0]));
					}
				}
			}
			throw new SquirrelException("No constructor matches.");
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException ioe) {
			throw new RuntimeException(ioe);
		}
	}

	@Function
	public SquirrelTable getattributes(JavaSquirrelClass<?> clazz, Object member) {
		if (clazz.getAttributes().containsKey(member)) {
			return (SquirrelTable) clazz.getAttributes().get(member);
		}
		return null;
	}

	@Function
	public SquirrelTable getattributes(JavaSquirrelClass<?> clazz, Object member, SquirrelTable attr) {
		return (SquirrelTable) clazz.getAttributes().insert(member, attr);
	}
}
