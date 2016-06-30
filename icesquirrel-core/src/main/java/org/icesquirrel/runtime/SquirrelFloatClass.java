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

public final class SquirrelFloatClass extends DefaultPrimitiveClass<Double> {
	public final static AbstractSquirrelClass CLASS = new SquirrelFloatClass();

	public SquirrelFloatClass() {
		super(Double.class, "float");
	}

	@Function
	public String tochar(Double obj) {
		return String.valueOf(obj).substring(0, 1);
	}

	@Override
	public Object add(Object obj, Object val) {
		return val instanceof String ? String.valueOf(obj) + String.valueOf(val)
				: ((Number) obj).doubleValue() + ((Number) val).doubleValue();
	}

	@Override
	public Object sub(Object obj, Object val) {
		return ((Number) obj).doubleValue() - ((Number) val).doubleValue();
	}

	@Override
	public Object div(Object obj, Object val) {
		return ((Number) obj).doubleValue() / ((Number) val).doubleValue();
	}

	@Override
	public Object mul(Object obj, Object val) {
		return ((Number) obj).doubleValue() * ((Number) val).doubleValue();
	}

	@Override
	public Object modulo(Object obj, Object val) {
		return ((Number) obj).doubleValue() % ((Number) val).doubleValue();
	}

	@Override
	public Object lessThan(Object obj, Object val) {
		return ((Number) obj).doubleValue() < ((Number) val).doubleValue();
	}

	@Override
	public Object lessThanEquals(Object obj, Object val) {
		return ((Number) obj).doubleValue() <= ((Number) val).doubleValue();
	}

	@Override
	public Object moreThan(Object obj, Object val) {
		return ((Number) obj).doubleValue() > ((Number) val).doubleValue();
	}

	@Override
	public Object moreThanEquals(Object obj, Object val) {
		return ((Number) obj).doubleValue() >= ((Number) val).doubleValue();
	}

}
