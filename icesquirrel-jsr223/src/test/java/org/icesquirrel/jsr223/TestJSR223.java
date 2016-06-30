package org.icesquirrel.jsr223;

import java.awt.Point;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.icesquirrel.runtime.AbstractSquirrelTest;
import org.icesquirrel.runtime.SquirrelTable;
import org.junit.Assert;
import org.junit.Test;

public class TestJSR223 extends AbstractSquirrelTest {
	
	@Test
	public void testList() throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		List<String> alist = new ArrayList<String>();
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		Bindings b = engine.createBindings();
		b.put("Alist", alist);
		alist.add("A value 1");
		alist.add("A value 2");
		engine.eval("Alist.push(\"A value 3\")", b);
		Assert.assertEquals(3, alist.size());
	}

	@Test
	public void testRootTable() throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		factory.setBindings(new BindingsAdapter(new SquirrelTable()));
		factory.put("SomeKey", "SomeValue");
		factory.put("SomeNumber", 1);
		factory.put("AnotherNumber", 65.4f);
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		Assert.assertArrayEquals(new Object[] { "SomeValue", 66l }, ((List) engine.eval("return [::SomeKey , (::SomeNumber + ::AnotherNumber)]")).toArray(new Object[0]));
	}
	
	public static String aTestFunction(String someParm) {
		return someParm.toUpperCase();
	}
	
	@Test
	public void testMethod() throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		factory.put("aTestFunction", TestJSR223.class.getMethod("aTestFunction", String.class));
		Assert.assertEquals("SOME LOWER CASE STUFF", engine.eval("return aTestFunction(\"some lower case stuff\")"));
	}
	
	@Test
	public void testClass() throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		factory.put("Point", Point.class);
		Assert.assertEquals(new Point(55, 66), (Point)engine.eval("return Point(55,66)"));
	}
	
	@Test
	public void testEngineBindings() throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		engine.put("aString", "Some string");
		engine.put("anotherString", "Another string");
		engine.put("anInteger", 1);
		engine.put("aLong", 67l);
		engine.put("aShort", 981l);
		engine.put("aByte", (byte) 128);
		engine.put("aFloat", 1.234f);
		engine.put("aDouble", 6781.692f);
		Assert.assertArrayEquals(new Object[] { "Some stringAnother string", 7703l }, ((List) engine.eval(new InputStreamReader(getClass()
				.getResourceAsStream("/jsr223/bindings.nut")))).toArray(new Object[0]));
	}

	@Test
	public void testSimpleEval() throws Exception {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("Squirrel");
		engine.eval("print(\"Hello, World\")");
	}
}
