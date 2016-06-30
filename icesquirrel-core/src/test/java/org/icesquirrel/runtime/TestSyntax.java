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

public class TestSyntax extends AbstractSquirrelTest {

	@Test
	public void testWhitespaceAndSeparators() throws Exception {
		SquirrelArray array = (SquirrelArray) SquirrelInterpretedScript
				.run(getClass().getResourceAsStream("/syntax/test-whitespace-and-separators.nut"));
		Assert.assertEquals(11, array.size());
	}

	@Test
	public void testClassAttributes() throws Exception {
		Assert.assertEquals(4l, (long) SquirrelInterpretedScript.run(getClass().getResource("/syntax/classattributes.nut")));
	}

	@Test
	public void testScopes() throws Exception {
		Assert.assertEquals(
				"A=1,B.C=520,B.D=Huh?,C=999,this.A=67,this.B[\"C\"]=341,this.B[\"D\"]=890,this.C=998,::B[\"C\"]=341,::B[\"D\"]=890,::C=998,F=67F720L981998B66CF887",
				SquirrelInterpretedScript.run(getClass().getResource("/syntax/test-scopes.nut")));
	}

	@Test
	public void testSyntax() throws Exception {
		Assert.assertEquals("C", SquirrelInterpretedScript.run(getClass().getResourceAsStream("/syntax/test-syntax.nut")));
	}

	@Test
	public void testCommas() throws Exception {
		final SquirrelArray arr = (SquirrelArray) SquirrelInterpretedScript
				.run(getClass().getResourceAsStream("/syntax/test-commas.nut"));
		Assert.assertArrayEquals(
				new Object[] { 1l, null, 1l, 1l, 11l, 123l, 2l, 1l, 1l, null, 1l, 1l, 3l, 2l, 5l, 37l, 988l, 1l, 3l },
				arr.toArray(new Object[] {}));
	}

	@Test
	public void testCoroutine() throws Exception {
		Assert.assertEquals("I'm done", SquirrelInterpretedScript.run(getClass().getResourceAsStream("/syntax/coroutines.nut")));
	}

	@Test
	public void testMeta() throws Exception {
		Assert.assertEquals("I'm done", SquirrelInterpretedScript.run(getClass().getResourceAsStream("/syntax/metamethods.nut")));
	}

	@Test
	public void testFree() throws Exception {
		Assert.assertEquals(106l, SquirrelInterpretedScript.run(getClass().getResourceAsStream("/syntax/free.nut")));
	}

}
