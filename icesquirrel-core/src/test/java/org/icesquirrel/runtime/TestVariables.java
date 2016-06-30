
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

public class TestVariables extends AbstractSquirrelTest {

	@Test
	public void testReturnValue() throws Exception {
		Assert.assertEquals(20l,
				SquirrelInterpretedScript.run(getClass().getResourceAsStream("/variables/test-return-values.nut")));
	}

	@Test
	public void testReturnValueScopes() throws Exception {
		Assert.assertEquals(138l,
				SquirrelInterpretedScript.run(getClass().getResourceAsStream("/variables/test-return-values-scopes.nut")));
	}

	@Test
	public void testAssignUsingExpression() throws Exception {
		Assert.assertEquals(10l,
				SquirrelInterpretedScript.run(getClass().getResourceAsStream("/variables/assign-using-expression.nut")));
	}

	@Test
	public void testConstAndEnum() throws Exception {
		SquirrelArray run = (SquirrelArray) SquirrelInterpretedScript
				.run(getClass().getResourceAsStream("/variables/test-const-and-enum.nut"));
		Assert.assertEquals(6l, run.size());
		Assert.assertEquals(1l, run.get(0));
		Assert.assertEquals("2", run.get(1));
		Assert.assertEquals(2.3d, run.get(2));
		Assert.assertEquals(6l, run.get(3));
		Assert.assertEquals("7", run.get(4));
		Assert.assertEquals(8.3d, run.get(5));
	}
}
