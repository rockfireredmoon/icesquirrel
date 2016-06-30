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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SquirrelRuntime {

	public final static Logger LOG = Logger.getLogger("RUNTIME");
	public final static Level DEFAULT_LOG_LEVEL = Level.parse(System.getProperty("squirrel.debug", "WARNING"));

	public static final String VERSION = "0.0.1-" + System.getProperty("java.version");
	public static final String SQUIRREL_VERSION = "2.2.5";

	public static ConsoleHandler consoleHandler;
	static {
		consoleHandler = new ConsoleHandler();
		setLogLevel(DEFAULT_LOG_LEVEL);
		for (Handler h : new ArrayList<Handler>(Arrays.asList(LOG.getHandlers()))) {
			LOG.removeHandler(h);
		}
		LOG.addHandler(consoleHandler);
	}

	protected static SquirrelRuntime instance;

	public final static long RUNTIME_START = System.currentTimeMillis();

	private BuiltInFunctions builtInFunctions;
	private SquirrelTable constTable;
	private Map<String, AbstractSquirrelClass> classes = new HashMap<>();
	protected SquirrelTable runtimeTable;
	private ServiceLoader<SquirrelPlugin> plugins;

	public static SquirrelRuntime getDefaultRuntime() {
		if (instance == null) {
			instance = new DefaultSquirrelRuntime();
		}
		return instance;
	}

	public SquirrelRuntime() {
		super();
		constTable = new SquirrelTable();
		if (LOG.isLoggable(Level.FINE)) {
			constTable.insertLocal("_DBG_TABLE_TYPE", "root");
		}
		builtInFunctions = new BuiltInFunctions(DefaultBuiltIn.class);
		runtimeTable = new SquirrelTable();

		plugins = ServiceLoader.load(SquirrelPlugin.class);
		for (Iterator<SquirrelPlugin> it = plugins.iterator(); it.hasNext();) {
			it.next().init(this);
		}
	}

	public AbstractSquirrelClass getClass(Object o) {
		if (o == null) {
			return null;
		} else if (o instanceof SquirrelType) {
			return ((SquirrelType<?>) o).getClassDeclaration();
		} else if (o instanceof String) {
			return SquirrelStringClass.CLASS;
		} else if (o instanceof Long || o instanceof Integer) {
			return SquirrelIntegerClass.CLASS;
		} else if (o instanceof Double || o instanceof Float) {
			return SquirrelFloatClass.CLASS;
		} else if (o instanceof Boolean) {
			return SquirrelBoolClass.CLASS;
		} else {
			throw new IllegalArgumentException(String.format("Unknown type %s", o.getClass()));
		}
	}

	public void loadClass(AbstractSquirrelClass squirrelClass) {
		LOG.fine(String.format("Registering class %s for type %s", squirrelClass.getClass(), squirrelClass.getTypeName()));
		classes.put(squirrelClass.getTypeName(), squirrelClass);
	}

	public AbstractSquirrelClass resolveClass(String typeName) {
		return classes.get(typeName);
	}

	public static void setLogLevel(Level level) {
		consoleHandler.setLevel(level);
		LOG.setLevel(level);
	}

	public SquirrelTable getConstTable() {
		return constTable;
	}

	public void setConstTable(SquirrelTable constTable) {
		this.constTable = constTable;
	}

	public SquirrelTable getRuntimeTable() {
		return runtimeTable;
	}

	public BuiltInFunctions getBuiltInFunctions() {
		return builtInFunctions;
	}

	public void setBuiltInFunctions(BuiltInFunctions builtInFunctions) {
		this.builtInFunctions = builtInFunctions;
	}

	public static class DefaultSquirrelRuntime extends SquirrelRuntime {
		public DefaultSquirrelRuntime() {
		}
	}
}
