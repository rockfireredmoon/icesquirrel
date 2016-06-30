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

public class SquirrelGenerator extends SquirrelTable {
	public final static String TYPE_NAME = "generator";

	public static class SquirrelCoroutineClass extends DefaultSquirrelClass<SquirrelGenerator> {

		public SquirrelCoroutineClass() {
			super(SquirrelGenerator.class, TYPE_NAME);
		}

		@Function
		public String getstatus(SquirrelGenerator generator) {
			return generator.status;
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	public final static SquirrelCoroutineClass CLASS = new SquirrelCoroutineClass();

	private String status = SUSPENDED;

	private AbstractSquirrelFunction function;

	private final static String DEAD = "dead";
	private final static String RUNNING = "running";
	private final static String SUSPENDED = "suspended";

	public SquirrelGenerator(AbstractSquirrelFunction function) {
		this.function = function;
	}

	@Override
	public int compareTo(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public AbstractSquirrelClass getClassDeclaration() {
		return CLASS;
	}

	@Override
	public void format(SquirrelPrintWriter writer, int depth) {
		writer.println(toString());
	}

	@Override
	public Object clone() {
		throw new UnsupportedOperationException();
	}

}
