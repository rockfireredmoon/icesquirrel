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


public final class SquirrelStringClass extends DefaultPrimitiveClass<String> {
	public final static String TYPE_NAME = "string";
	public final static SquirrelStringClass CLASS = new SquirrelStringClass();

	public SquirrelStringClass() {
		super(String.class, TYPE_NAME);
	}

	@Function
	public Long len(String str) {
		return (long) str.length();
	}

	@Function
	public String slice(String str, Long start, Long... end) {
		if (end.length > 0) {
			return str.substring(start.intValue(), end[0].intValue());
		} else {
			return str.substring(start.intValue());
		}
	}

	@Function
	public Long find(String str, String substr, Long... start) {
		if (start.length > 0) {
			return (long) str.indexOf(substr, start[0].intValue());
		} else {
			return (long) str.indexOf(substr);
		}
	}

	@Function
	public String tolower(String str) {
		return str.toLowerCase();
	}

	@Function
	public String toupper(String str) {
		return str.toUpperCase();
	}

	@Override
	public Object construct(SquirrelArray argumentValues) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object add(Object obj, Object val) {
		return String.valueOf(obj) + String.valueOf(val);
	}

}
