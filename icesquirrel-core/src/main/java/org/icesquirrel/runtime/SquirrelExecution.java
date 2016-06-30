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

public class SquirrelExecution extends SquirrelTable {

	private int line;
	private String source;
	private Object environment;
	private SquirrelArray varargs;

	public SquirrelExecution(Object environment, int line, String source) {
		insertLocal("this", environment);

		if (environment instanceof SquirrelTable) {
			// TODO might need to get the previous environment if this one is
			// not a table?
			addDelegate((SquirrelTable) environment);
		}
		this.environment = environment;
		this.line = line;
		this.source = source;
	}

	public SquirrelArray getVarargs() {
		return varargs;
	}

	public void setVarargs(SquirrelArray varargs) {
		this.varargs = varargs;
	}

	public Object getEnvironment() {
		return environment;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	/**
	 * Get if the key is local variable in scope. When an execution should be
	 * able to access the current executions stack frame, it should add it as a
	 * delegate. This is used for example by loops that may define local
	 * variables whose scope is restricted to the loop.
	 * 
	 * @param key
	 * @return local variable
	 */
	public boolean isLocal(Object key) {
		if (containsKeyLocally(key)) {
			return true;
		}
		for (SquirrelTable t : getDelegates()) {
			if (t instanceof SquirrelExecution) {
				if (((SquirrelExecution) t).isLocal(key)) {
					return true;
				}
			}
		}
		return false;
	}

}
