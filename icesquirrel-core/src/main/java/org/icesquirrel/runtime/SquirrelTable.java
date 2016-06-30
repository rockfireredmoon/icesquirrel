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
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SquirrelTable implements SlotMap, SquirrelType<Object> {

	public final static String TYPE_NAME = "table";

	public static class SquirrelTableClass extends DefaultSquirrelClass<SquirrelTable> {

		public SquirrelTableClass() {
			super(SquirrelTable.class, TYPE_NAME);
		}

		@Function
		public Long len(SquirrelTable table) {
			return (long) table.size();
		}

		@Function
		public Object rawget(SquirrelTable table, Object key) {
			return table.getLocal(key);
		}

		@Function
		public Object rawset(SquirrelTable table, Object key, Object val) {
			return table.insertLocal(key, val);
		}

		@Function
		public Object rawdelete(SquirrelTable table, Object key) {
			return table.removeLocal(key);
		}

		@Function
		public Object rawin(SquirrelTable table, Object key) {
			return table.containsKeyLocally(key);
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	protected Map<Object, Object> backing = new LinkedHashMap<>();
	protected List<SquirrelTable> delegate = new ArrayList<>();
	protected static AbstractSquirrelClass clazz;

	// public SquirrelTable() {
	// this(null);
	// }

	public SquirrelTable() {
		super();
	}

	@SuppressWarnings("unchecked")
	public SquirrelTable(Map<? extends Object, ? extends Object> backing) {
		super();
		this.backing = (Map<Object, Object>) backing;
	}

	public SquirrelTable(Object... slots) {
		for (int i = 0; i < slots.length; i += 2) {
			insert(slots[i], slots[i + 1]);
		}
	}

	@Override
	public AbstractSquirrelClass getClassDeclaration() {
		if (clazz == null) {
			clazz = new SquirrelTableClass();
		}
		return clazz;
	}

	public SquirrelTable(SquirrelTable delegate) {
		this.delegate.add(delegate);
	}

	public List<SquirrelTable> getDelegates() {
		return delegate;
	}

	public void addDelegate(SquirrelTable table) {
		if (table == this) {
			throw new IllegalArgumentException("Cannot add self as a delegate.");
		}
		if (this.delegate.contains(table)) {
			throw new IllegalArgumentException("Already a delegate.");
		}
		this.delegate.add(table);
	}

	public void removeDelegate(SquirrelTable table) {
		this.delegate.add(table);
	}

	public void setDelegate(SquirrelTable... delegate) {
		this.delegate.clear();
		this.delegate.addAll(Arrays.asList(delegate));
	}

	public void setBacking(Map<Object, Object> backing) {
		this.backing = backing;
	}

	public Object get(String key, Object val) {
		return containsKey(key) ? get(key) : val;
	}

	public void format(SquirrelPrintWriter writer, int depth) {
		writeAsTable(writer, depth);
	}

	public Object insert(Key key) {
		// TODO this should do delegation?
		return backing.put(key.getKey(), key.getValue());
	}

	public Object insert(Object key, Object value) {
		try {
			return put(key, value);
		} catch (IllegalArgumentException iae) {
			return backing.put(key, value);
		}

		// // TODO delegation?
		// if(backing.containsKey(key)) {
		// return backing.put(key, value);
		// }
		// else {
		// for(SquirrelTable t : delegate) {
		// if(t.c)
		// }
		// }
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
	public boolean containsKey(Object key) {
		if (backing.containsKey(key)) {
			return true;
		}
		for (SquirrelTable t : delegate) {
			if (t.containsKey(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		return backing.containsValue(value);
	}

	public Object getLocal(Object key) {
		if (!(key instanceof Object)) {
			throw new IllegalArgumentException(String.format("Key is not a Squirrel data type. %s", key));
		}
		if (backing.containsKey(key)) {
			return backing.get(key);
		}
		throw new IllegalArgumentException(String.format("No index %s", key));
	}

	public Object insertLocal(Object key, Object val) {
		if (!(key instanceof Object)) {
			throw new IllegalArgumentException(String.format("Key is not a Squirrel data type. %s", key));
		}
		return backing.put(key, val);
	}

	@Override
	public Object get(Object key) {
		try {
			return getOrFail(key);
		} catch (IllegalArgumentException iae) {
			return null;
		}
	}

	@Override
	public Object getOrFail(Object key) {
		try {
			return doGet(key);
		} catch (IllegalArgumentException iae) {
			if (containsKey("_get")) {
				AbstractSquirrelFunction func = (AbstractSquirrelFunction) doGet("_get");
				// New execution
				SquirrelExecutionContext.get().newExecution(this, 0);
				try {
					return SquirrelExecutionContext.get().getProcessor().evaluateCallable(func, new SquirrelArray((Object) key));
				} finally {
					SquirrelExecutionContext.get().popExecution();
				}
			} else {
				throw iae;
			}
		}
	}

	protected Object doGet(Object key) {
		if (!(key instanceof Object)) {
			throw new IllegalArgumentException(String.format("Key is not a Squirrel data type. %s", key));
		}
		try {
			return getLocal(key);
		} catch (IllegalArgumentException iae) {
		}
		for (SquirrelTable t : delegate) {
			try {
				return t.getOrFail(key);
			} catch (IllegalArgumentException iae) {
			}
		}
		throw new IllegalArgumentException(String.format("No index %s", key));
	}

	@Override
	public Object put(Object key, Object value) {
		try {
			return doPut(key, value);
		} catch (IllegalArgumentException iae) {
			if (containsKey("_set")) {
				AbstractSquirrelFunction func = (AbstractSquirrelFunction) doGet("_set");
				// New execution
				SquirrelExecutionContext.get().newExecution(this, 0);
				try {
					return SquirrelExecutionContext.get().getProcessor()
							.evaluateCallable(func, new SquirrelArray((Object) key, (Object) value));
				} finally {
					SquirrelExecutionContext.get().popExecution();
				}
			} else {
				throw iae;
			}
		}
	}

	private Object doPut(Object key, Object value) {
		if (backing.containsKey(key)) {
			return backing.put(key, value);
		}
		for (SquirrelTable t : delegate) {
			try {
				t.put(key, value);
				return value;
			} catch (IllegalArgumentException iae) {
			}
		}
		throw new IllegalArgumentException(String.format("The index %s does not exist.", key));
	}

	@Override
	public Object remove(Object key) {
		if (backing.containsKey(key)) {
			return backing.remove(key);
		}
		for (SquirrelTable t : delegate) {
			if (t.containsKey(key)) {
				return t.remove(key);
			}
		}
		throw new IllegalArgumentException(String.format("The index %s does not exist.", key));
	}

	public Object removeLocal(Object key) {
		return backing.remove(key);
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		for (Map.Entry<? extends Object, ? extends Object> s : m.entrySet()) {
			// TODO need to check delegate
			if (!backing.containsKey(s.getKey())) {
				throw new IllegalArgumentException(String.format("Key %s does not exist.", s.getKey()));
			}
		}
		backing.putAll(m);
	}

	public void insertAll(Map<? extends Object, ? extends Object> m) {
		for (Map.Entry<? extends Object, ? extends Object> s : m.entrySet()) {
			insert(s.getKey(), s.getValue());
		}
	}

	public void insertAllLocally(Map<? extends Object, ? extends Object> m) {
		backing.putAll(m);
	}

	@Override
	public void clear() {
		backing.clear();
	}

	@Override
	public Set<Object> keySet() {
		return backing.keySet();
	}

	@Override
	public Collection<Object> values() {
		return backing.values();
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		return backing.entrySet();
	}

	@Override
	public String toString() {
		return String.format("( %s : 0x%08x )", getClassDeclaration().getTypeName(), hashCode());
	}

	public boolean containsKeyLocally(Object key) {
		return backing.containsKey(key);
	}

	@Override
	public int compareTo(Object o) {
		return String.valueOf(this).compareTo(String.valueOf(o));
	}

	@Override
	public Object clone() {
		SquirrelTable table = new SquirrelTable();
		table.backing.putAll(backing);
		table.delegate.addAll(delegate);
		return table;
	}

	public Key getKey(Object key) {
		Key pair = new Key();
		try {
			pair.setValue(getLocal(key));
			pair.setKey(this);
			return pair;
		} catch (IllegalArgumentException iae) {
		}
		for (SquirrelTable t : delegate) {
			try {
				return t.getKey(key);
			} catch (IllegalArgumentException iae) {
			}
		}
		throw new IllegalArgumentException(String.format("No index %s", key));
	}

	protected void writeAsTable(SquirrelPrintWriter writer, int depth) {
		String indent = SquirrelPrinter.identString(depth);
		writer.print("{");
		if (indent != null && size() > 0) {
			writer.println();
			writer.print(indent);
		}
		int idx = 0;
		for (Object key : keySet()) {
			if (idx > 0) {
				writer.print(",");
				if (indent != null) {
					writer.println();
					writer.print(indent);
				}
			}
			if (writer.isConciseKeys() && key instanceof String && ((String) key).matches("([a-zA-Z]|_)+([a-zA-Z0-9]|_)*")) {
				writer.print(key.toString());
			} else {
				writer.print("[" + SquirrelPrinter.format(key) + "]");
			}
			writer.print(" = ");
			SquirrelPrinter.format(writer, get(key), depth == -1 ? -1 : depth + 1);
			idx++;
		}
		if (idx > 0 && indent != null) {
			writer.println();
			writer.print(indent);
		}
		writer.print("}");
	}
}
