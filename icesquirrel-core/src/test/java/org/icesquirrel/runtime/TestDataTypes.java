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

import org.icesquirrel.interpreter.SquirrelInterpretedScript;
import org.junit.Assert;
import org.junit.Test;

public class TestDataTypes extends AbstractSquirrelTest {

	@Test
	public void testSimpleArray() throws Exception {
		SquirrelArray array = (SquirrelArray) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/simple-array.nut"));
		System.out.println(array);
		Assert.assertEquals(3, array.size());
		Assert.assertEquals("a1", array.get(0));
		Assert.assertEquals("a2", array.get(1));
		Assert.assertEquals("a3", array.get(2));
	}

	@Test
	public void testTableDelete() throws Exception {
		Assert.assertEquals("now", ((String) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/table-delete.nut"))));
	}

	@Test
	public void testTable() throws Exception {
		SquirrelTable array = (SquirrelTable) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/test-table.nut"));
		Assert.assertEquals(7, array.size());
		Assert.assertEquals(1l, array.get("A"));
		Assert.assertEquals("2", array.get("B"));
		Assert.assertEquals(true, array.get("C"));
		Assert.assertEquals(SquirrelArray.class, array.get("D").getClass());
		Assert.assertEquals(null, array.get("F"));
		Assert.assertEquals(1.23d, array.get("G"));

		Assert.assertEquals(array.get("E").getClass(), SquirrelTable.class);
		SquirrelTable inner = (SquirrelTable) array.get("E");
		Assert.assertEquals("value", inner.get("table"));
		Assert.assertEquals("value2", inner.get("table2"));
		Assert.assertEquals("value3", inner.get("table3"));
	}

	@Test
	public void testAll() throws Exception {
		SquirrelArray array = (SquirrelArray) SquirrelInterpretedScript
				.run(getClass().getResourceAsStream("/datatypes/test-all.nut"));
		Assert.assertEquals(34456787l, array.get(0));
		Assert.assertEquals(7l, array.get(1));
		Assert.assertEquals(45l, array.get(2));
		Assert.assertEquals(783l, array.get(3));
		Assert.assertEquals((long) 0xff0000, array.get(4));
		Assert.assertEquals((long) 0753, array.get(5));
		Assert.assertEquals((long) 'a', array.get(6));
		Assert.assertEquals(1.52d, array.get(7));
		Assert.assertEquals(100d, array.get(8));
		Assert.assertEquals(0.01d, array.get(9));
		Assert.assertEquals("I'm a string", array.get(10));
		Assert.assertEquals(true, array.get(11));
		Assert.assertEquals(false, array.get(12));
		Assert.assertEquals(null, array.get(13));
		Assert.assertArrayEquals(new Object[] { "a1", "a2", "a3" }, ((SquirrelArray) array.get(14)).toArray(new Object[0]));
		Assert.assertEquals("\n\tthis is a multiline string\n\tit will \"embed\" all the new line\n\tcharacters\n", array.get(15));
	}

	@Test
	public void testArray() throws Exception {
		SquirrelArray array = (SquirrelArray) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/array.nut"));
		Assert.assertEquals("1", array.get(0));
		Assert.assertEquals(1l, array.get(1));
	}

	@Test
	public void testList() throws Exception {
		Assert.assertTrue((Boolean) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/list.nut")));
	}

	@Test
	public void testClass() throws Exception {
		SquirrelArray array = (SquirrelArray) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/class.nut"));
		Assert.assertEquals(12l, array.get(0));
		Assert.assertEquals(14l, array.get(1));
		Assert.assertEquals(16l, array.get(2));
		Assert.assertEquals(99l, array.get(3));
	}

	@Test
	public void testMethCall() throws Exception {
		Assert.assertEquals(1l, (long) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/methcall.nut")));
	}

	@Test
	public void testGenerator() throws Exception {
		Assert.assertEquals(1l, (long) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/yield.nut")));
	}

	@Test
	public void testGenerators() throws Exception {
		Assert.assertEquals(1l, (long) SquirrelInterpretedScript.run(getClass().getResource("/datatypes/generators.nut")));
	}
}
