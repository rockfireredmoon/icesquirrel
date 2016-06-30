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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.script.Bindings;

import org.icesquirrel.runtime.BridgeSquirrelClass;
import org.icesquirrel.runtime.JavaSquirrelObject;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelTable;
import org.icesquirrel.runtime.SquirrelType;

public final class BindingsAdapter implements Bindings {

	private SquirrelTable table;

	public BindingsAdapter(SquirrelTable table) {
		this.table = table;
	}

	public SquirrelTable getTable() {
		return table;
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public boolean isEmpty() {
		return table.isEmpty();
	}

	@Override
	public boolean containsValue(Object value) {
		return table.containsValue(value);
	}

	@Override
	public void clear() {
		table.clear();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set keySet() {
		return table.keySet();
	}

	@Override
	public Collection<Object> values() {
		return table.values();
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set entrySet() {
		return table.entrySet();
	}

	@Override
	public Object put(String name, Object value) {
		if (value instanceof Class<?>) {
			value = new BridgeSquirrelClass((Class<?>) value);
		} else if (value instanceof Method) {
			BridgeSquirrelClass.BridgeSquirrelFunction bridgeSquirrelFunction = new BridgeSquirrelClass.BridgeSquirrelFunction(
					((Method) value).getDeclaringClass());
			bridgeSquirrelFunction.getMethods().add((Method) value);
			value = bridgeSquirrelFunction;
		} else if (value instanceof SquirrelType || value instanceof Number || value instanceof String || value instanceof Boolean
				|| value == null) {
		} else if (value instanceof List) {
			value = new SquirrelArray((List) value);
		} else if (value instanceof Object) {
			value = new JavaSquirrelObject(new BridgeSquirrelClass(value.getClass()), value) {
			};
		}
		return table.insert(name, value);
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void putAll(Map toMerge) {
		table.insertAll(toMerge);
	}

	@Override
	public boolean containsKey(Object key) {
		return table.containsKey(key);
	}

	@Override
	public Object get(Object key) {
		return table.get(key);
	}

	@Override
	public Object remove(Object key) {
		return table.remove(key);
	}
}