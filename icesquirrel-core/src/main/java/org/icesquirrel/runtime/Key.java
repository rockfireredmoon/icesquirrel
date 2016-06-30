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

public class Key implements Map.Entry<Object, Object> {

	private Object key;
	private Object val;

	public Key() {
		this(null, null);
	}

	public Key(Object key) {
		this(key, null);
	}

	public Key(Object key, Object val) {
		this.key = key;
		this.val = val;
	}

	@Override
	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	@Override
	public Object getValue() {
		return val;
	}

	@Override
	public Object setValue(Object val) {
		Object o = this.val;
		this.val = val;
		return o;
	}

	@Override
	public String toString() {
		return "Key [key=" + key + ", val=" + val + "]";
	}

}