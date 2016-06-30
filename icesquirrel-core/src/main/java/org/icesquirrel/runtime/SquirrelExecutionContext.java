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

import java.util.List;
import java.util.Stack;

public class SquirrelExecutionContext {

	private final static ThreadLocal<SquirrelExecutionContext> context = new ThreadLocal<>();

	public final static boolean is() {
		return context.get() != null;
	}

	public final static SquirrelExecutionContext get() {
		SquirrelExecutionContext ctx = context.get();
		if (ctx == null) {
			ctx = new SquirrelExecutionContext();
		}
		return ctx;
	}

	private AbstractSquirrelFunction errorHandler;
	private SquirrelRuntime runtime;
	private SquirrelTable root;
	private SquirrelProcessor processor;
	private Stack<SquirrelExecution> executions = new Stack<>();

	public void start(SquirrelTable root, SquirrelRuntime runtime, SquirrelProcessor processor) {
		if (context.get() != null) {
			throw new IllegalStateException("Already in an execution context.");
		}
		this.runtime = runtime;
		this.root = root;
		this.processor = processor;

		context.set(this);
	}

	public int getLineNumber() {
		return execution().getLine();
	}

	public String getSource() {
		return execution().getSource();
	}

	public SquirrelExecution newExecution(Object environment, int lineNumber) {
		return newExecution(environment, lineNumber, getSource());
	}

	/**
	 * Create a new execution context. The 'stack frame' table returned is where
	 * local variables for the context will be stored. This table delegates to
	 * the environment
	 * 
	 * @param environment
	 * @param lineNumber
	 * @return stack frame
	 */
	public SquirrelExecution newExecution(Object environment, int lineNumber, String source) {
		SquirrelRuntime.LOG.fine(String.format("New execution for %s @ %d", environment, lineNumber));
		SquirrelExecution execution = new SquirrelExecution(environment, lineNumber, source);
		executions.push(execution);
		return execution;
	}

	public void setLine(int line) {
		execution().setLine(line);
	}

	public List<SquirrelExecution> stack() {
		return executions;
	}

	public SquirrelExecution popExecution() {
		SquirrelExecution pop = executions.pop();
		SquirrelRuntime.LOG.fine(String.format("Popped execution %s", pop));
		return pop;
	}

	public SquirrelProcessor getProcessor() {
		return processor;
	}

	public void setRoot(SquirrelTable root) {
		this.root = root;
	}

	public SquirrelTable getRoot() {
		return root;
	}

	public SquirrelRuntime getRuntime() {
		return runtime;
	}

	public AbstractSquirrelFunction getErrorHandler() {
		return errorHandler;
	}

	public void setErrorHandler(AbstractSquirrelFunction errorHandler) {
		this.errorHandler = errorHandler;
	}

	public void stop() {
		context.remove();
	}

	public SquirrelExecution execution() {
		return (SquirrelExecution) executions.peek();
	}
}
