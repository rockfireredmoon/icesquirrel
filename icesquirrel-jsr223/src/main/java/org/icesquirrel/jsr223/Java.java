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

import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.BridgeSquirrelClass;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;

public class Java {

	public static final class New extends AbstractSquirrelFunction {

		final static String CLASS_NAME = "class";

		public New() {
			super(CLASS);
		}

		@Override
		public Object evaluate(SquirrelArray arguments) {
			String no = (String) SquirrelExecutionContext.get().execution().get(CLASS);
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if (cl == null) {
				cl = New.class.getClassLoader();
			}
			try {
				BridgeSquirrelClass clazz = new BridgeSquirrelClass(Class.forName(no, true, cl));
				SquirrelArray arr = new SquirrelArray(arguments);
				arr.remove(0);
				return clazz.construct(arr);
			} catch (Exception e) {
				throw new SquirrelException("Failed to load Java class.", e);
			}
		}

	}
}
