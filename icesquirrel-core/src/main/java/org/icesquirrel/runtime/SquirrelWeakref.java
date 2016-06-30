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

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class SquirrelWeakref extends WeakReference<Object> implements SquirrelType<SquirrelWeakref> {
	public final static String TYPE_NAME = "weakref";

	public static class SquirrelWeafrefClass extends DefaultPrimitiveClass<SquirrelWeakref> {
		public SquirrelWeafrefClass() {
			super(SquirrelWeakref.class, TYPE_NAME);
		}

		@Function
		public Object ref(SquirrelWeakref weakref) {
			return weakref.get();
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	public final static SquirrelStringClass CLASS = new SquirrelStringClass();

	public SquirrelWeakref(Object referent, ReferenceQueue<Object> q) {
		super(referent, q);
	}

	public SquirrelWeakref(Object referent) {
		super(referent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(SquirrelWeakref o) {
		return ((Comparable<Object>) get()).compareTo(o.get());
	}

	@Override
	public AbstractSquirrelClass getClassDeclaration() {
		return CLASS;
	}

	@Override
	public void format(SquirrelPrintWriter writer, int depth) {
		writer.println(toString());
	}

	@Override
	public SquirrelWeakref clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
