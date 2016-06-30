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

public class TestMath extends AbstractSquirrelTest {

	@Test
	public void testMatrix() throws Exception {
		SquirrelArray arr = (SquirrelArray) SquirrelInterpretedScript.run(getClass().getResourceAsStream("/math/matrix.nut"));
		Assert.assertEquals(283740l, arr.get(0));
		Assert.assertEquals(1077225l, arr.get(1));
		Assert.assertEquals(1470030l, arr.get(2));
		Assert.assertEquals(1873320l, arr.get(3));
	}

	@Test
	public void testAck() throws Exception {
		Assert.assertEquals(13l, SquirrelInterpretedScript.run(getClass().getResourceAsStream("/math/ackermann.nut")));
	}

	@Test
	public void testFibonaci() throws Exception {
		Assert.assertEquals(1l, SquirrelInterpretedScript.run(getClass().getResourceAsStream("/math/fibonacci.nut")));
	}
}
