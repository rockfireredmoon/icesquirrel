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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaTypeConverter {

	public static List<Object> getActualArgs(Class<?>[] parameterTypes, SquirrelArray arguments, boolean cast) {
		if (parameterTypes.length == arguments.size()) {
			List<Object> actualArgs = new ArrayList<>();
			Iterator<Object> it = arguments.iterator();
			for (Class<?> pc : parameterTypes) {
				Object argobj = it.next();
				if (argobj instanceof SquirrelObjectWrapper) {
					argobj = ((SquirrelObjectWrapper) argobj).getObject();
				}
				if (cast && (pc == Double.class || pc == double.class) && argobj instanceof Number) {
					actualArgs.add(((Number) argobj).doubleValue());
				} else if (cast && (pc == Long.class || pc == long.class) && argobj instanceof Number) {
					actualArgs.add(((Number) argobj).longValue());
				} else if (cast && (pc == Integer.class || pc == int.class) && argobj instanceof Number) {
					actualArgs.add(((Long) argobj).intValue());
				} else if (cast && (pc == Float.class || pc == float.class) && argobj instanceof Number) {
					actualArgs.add(((Number) argobj).floatValue());
				} else if (cast && (pc == Short.class || pc == short.class) && argobj instanceof Number) {
					actualArgs.add(((Number) argobj).shortValue());
				} else if (pc.isAssignableFrom(argobj.getClass())) {
					actualArgs.add(argobj);
				}
			}
			if (actualArgs.size() == parameterTypes.length) {
				return actualArgs;
			}
		}
		return null;
	}

	public static Class<?>[] getNativeArgumentClasses(List<Object> args) {
		// TODO needs to be smarter
		Class<?>[] l = new Class<?>[args.size()];
		int idx = 0;
		for (Object o : args) {
			l[idx++] = o.getClass();
		}
		return l;
	}

}
