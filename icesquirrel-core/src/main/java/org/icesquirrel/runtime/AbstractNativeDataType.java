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

public abstract class AbstractNativeDataType<T> extends AbstractSquirrelDataType {

	protected final T value;

	public AbstractNativeDataType(T value, AbstractSquirrelClass clazz) {
		super(clazz);
		this.value = value;
	}

	public final T getValue() {
		return value;
	}

	@Override
	public final int hashCode() {
		return value.hashCode();
	}

	@Override
	public void format(SquirrelPrintWriter writer, int depth) {
		writer.print(toString());
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	// @Override
	// public SquirrelDataType get(Object key) {
	// return getClassDeclaration().get(key);
	// }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int compareTo(Object o) {
		if (o instanceof Comparable && o instanceof AbstractNativeDataType
				&& ((AbstractNativeDataType) o).getValue() instanceof Comparable) {
			return ((Comparable) o).compareTo(((Comparable) ((AbstractNativeDataType) o).getValue()));
		}
		return String.valueOf(this).compareTo(String.valueOf(o));
	}
}
