package org.icesquirrel.jsr223;

import java.util.List;

import org.icesquirrel.interpreter.SquirrelInterpretedScript;
import org.icesquirrel.runtime.AbstractSquirrelObject;
import org.icesquirrel.runtime.AbstractSquirrelTest;
import org.junit.Assert;
import org.junit.Test;

public class TestJava extends AbstractSquirrelTest {

	@Test
	public void testInstantiate() throws Exception {
		List<?> l = (List<?>) ((AbstractSquirrelObject) (SquirrelInterpretedScript.run(getClass().getResourceAsStream(
				"/java/instantiate.nut")))).getObject();
		Assert.assertEquals(1, l.size());
	}
}
