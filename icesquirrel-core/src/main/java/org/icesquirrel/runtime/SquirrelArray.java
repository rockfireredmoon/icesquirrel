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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SquirrelArray implements Serializable, SquirrelIndexable, SquirrelType<SquirrelArray>, List<Object> {

	public final static String TYPE_NAME = "array";

	public static class SquirrelArrayClass extends DefaultSquirrelClass<SquirrelArray> {

		public SquirrelArrayClass() {
			super(SquirrelArray.class, TYPE_NAME);
		}

		@Function
		public Long len(SquirrelArray array) {
			return (long) array.size();
		}

		@Function
		public Object add(SquirrelArray array, Object val) {
			array.add(val);
			return val;
		}

		@Function
		public Object append(SquirrelArray array, Object val) {
			array.add(val);
			return val;
		}

		@Function
		public Object push(SquirrelArray array, Object val) {
			array.add(val);
			return val;
		}

		@Function
		public Object extend(SquirrelArray array, SquirrelArray val) {
			array.addAll(val);
			return val;
		}

		@Function
		public Object pop(SquirrelArray array) {
			if (array.isEmpty()) {
				throw new SquirrelException("Array is empty.");
			}
			return array.remove(array.size() - 1);
		}

		@Function
		public Object top(SquirrelArray array) {
			if (array.isEmpty()) {
				throw new SquirrelException("Array is empty.");
			}
			return array.get(0);
		}

		@Function
		public Object insert(SquirrelArray array, Long index, Object val) {
			array.add(index.intValue(), val);
			return val;
		}

		@Function
		public Object remove(SquirrelArray array, Long index) {
			return array.remove(index.intValue());
		}

		@Function
		public Object resize(SquirrelArray array, Long size, Object... fillObj) {
			int sz = size.intValue();
			int osize = array.size();
			int fill = sz - osize;
			if (fill > 0) {
				for (int i = 0; i < fill; i++) {
					array.add(fillObj.length == 0 ? null : fillObj[0]);
				}
			} else {
				while (sz < array.size()) {
					array.remove(0);
				}
			}
			return array;
		}

		@Function
		public Object sort(SquirrelArray array, final AbstractSquirrelFunction... comparator) {
			if (comparator.length > 0) {
				Collections.sort(array, new Comparator<Object>() {
					@Override
					public int compare(Object o1, Object o2) {
						Number evaluate = (Number) comparator[0].evaluate(new SquirrelArray(o1, o2));
						return evaluate.intValue();
					}
				});
			} else {
				Collections.sort(array, new Comparator<Object>() {

					@SuppressWarnings("unchecked")
					@Override
					public int compare(Object o1, Object o2) {
						return ((Comparable<Object>) o1).compareTo(o2);
					}
				});
			}
			return array;
		}

		@Function
		public Object reverse(SquirrelArray array) {
			Collections.reverse(array);
			return array;
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	public final static SquirrelArrayClass CLASS = new SquirrelArrayClass();

	private static final long serialVersionUID = 196595566781198215L;
	private List<Object> backing;

	public SquirrelArray() {
		backing = new ArrayList<Object>();
	}

	@SuppressWarnings("unchecked")
	public SquirrelArray(List<? extends Object> backing) {
		this.backing = (List<Object>) backing;
	}

	public SquirrelArray(int size) {
		backing = new ArrayList<Object>();
	}

	public SquirrelArray(SquirrelArray array) {
		this();
		addAll(array);
	}

	public SquirrelArray(Object... values) {
		this();
		addAll(Arrays.asList(values));
	}

	@Override
	public AbstractSquirrelClass getClassDeclaration() {
		return CLASS;
	}

	public String toString() {
		return String.format("(array: 0x%08x)", hashCode());
	}

	public void format(SquirrelPrintWriter writer, int depth) {
		String indent = SquirrelPrinter.identString(depth);
		writer.print("[");
		if (indent != null && size() > 0) {
			writer.println();
			writer.print(indent);
		}
		int idx = 0;
		for (Object val : this) {
			if (idx > 0) {
				writer.print(",");
				if (indent != null) {
					writer.println();
					writer.print(indent);
				}
			}
			SquirrelPrinter.format(writer, val, depth == -1 ? -1 : depth + 1);
			idx++;
		}
		if (idx > 0 && indent != null) {
			writer.println();
			writer.print(indent);
		}
		writer.print("]");
	}

	@Override
	public int compareTo(SquirrelArray o) {
		return String.valueOf(this).compareTo(String.valueOf(o));
	}

	@Override
	public SquirrelArray clone() {
		SquirrelArray arr = new SquirrelArray();
		arr.addAll(this);
		return arr;
	}

	@Override
	public Iterator<Object> iterator() {
		return backing.iterator();
	}

	@Override
	public int size() {
		return backing.size();
	}

	@Override
	public boolean isEmpty() {
		return backing.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return backing.contains(o);
	}

	@Override
	public Object[] toArray() {
		return backing.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return backing.toArray(a);
	}

	@Override
	public boolean add(Object e) {
		return backing.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return backing.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return backing.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		return backing.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Object> c) {
		return backing.addAll(index, c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return backing.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return backing.retainAll(c);
	}

	@Override
	public void clear() {
		backing.clear();
	}

	@Override
	public void add(int index, Object element) {
		backing.add(index, element);
	}

	@Override
	public Object remove(int index) {
		return backing.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return backing.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return backing.lastIndexOf(o);
	}

	@Override
	public ListIterator<Object> listIterator() {
		return backing.listIterator();
	}

	@Override
	public ListIterator<Object> listIterator(int index) {
		return backing.listIterator(index);
	}

	@Override
	public List<Object> subList(int fromIndex, int toIndex) {
		return backing.subList(fromIndex, toIndex);
	}

	@Override
	public Object get(int index) {
		return backing.get(index);
	}

	@Override
	public Object set(int index, Object val) {
		return backing.set(index, val);
	}
}
