package org.icesquirrel.stdlib;

import org.icesquirrel.interpreter.SquirrelInterpretedScript;
import org.icesquirrel.runtime.AbstractSquirrelTest;
import org.junit.Assert;
import org.junit.Test;

public class TestStdlib extends AbstractSquirrelTest {

	@Test
	public void testFile() throws Exception {
		Assert.assertEquals("387,STUFF!,STUFF!", SquirrelInterpretedScript.run(getClass().getResourceAsStream("/stdlib/file.nut")));
	}

	@Test
	public void testSystem() throws Exception {
		SquirrelInterpretedScript.run(getClass().getResourceAsStream("/stdlib/system.nut"));
	}

	@Test
	public void testString() throws Exception {
		SquirrelInterpretedScript.run(getClass().getResourceAsStream("/stdlib/string.nut"));
	}
}
