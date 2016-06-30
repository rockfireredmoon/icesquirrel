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

import java.util.concurrent.Semaphore;

public class SquirrelCoroutine extends AbstractSquirrelObject implements Runnable {
	public final static String TYPE_NAME = "coroutine";

	public static class SquirrelCoroutineClass extends DefaultSquirrelClass<SquirrelCoroutine> {

		public SquirrelCoroutineClass() {
			super(SquirrelCoroutine.class, TYPE_NAME);
		}

		@Function
		public Object call(SquirrelCoroutine coroutine, Object... args) {
			return coroutine.call(new SquirrelArray(args));
		}

		@Function
		public Object wakeup(SquirrelCoroutine coroutine, Object... param) {
			return coroutine.wakeup(param.length == 0 ? null : param[0]);
		}

		@Function
		public String getstatus(SquirrelCoroutine coroutine) {
			return coroutine.status;
		}

		@Override
		public Object construct(SquirrelArray argumentValues) {
			throw new UnsupportedOperationException();
		}
	};

	public final static SquirrelCoroutineClass CLASS = new SquirrelCoroutineClass();

	private Thread thread;
	private SquirrelRuntime runtime;
	private Semaphore semaphore = new Semaphore(1);
	private Semaphore suspend = new Semaphore(1);
	private Object output;
	private String status = IDLE;
	private Object input;
	private SquirrelArray arguments;
	private AbstractSquirrelFunction function;
	private SquirrelProcessor processor;
	private AbstractSquirrelFunction errorHandler;
	private String source;

	private final static String IDLE = "idle";
	private final static String RUNNING = "running";
	private final static String SUSPENDED = "suspended";

	public SquirrelCoroutine(AbstractSquirrelFunction function) {
		super(CLASS);
		this.function = function;

		final SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
		runtime = ctx.getRuntime();
		source = ctx.getSource();
		processor = ctx.getProcessor();
		errorHandler = ctx.getErrorHandler();

		thread = new Thread(this, function.toString());

		addDelegate(runtime.getRuntimeTable());
		addDelegate(runtime.getConstTable());
		addDelegate(runtime.getBuiltInFunctions());
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
		writer.println("{coroutine}");
	}

	@Override
	public Object clone() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void run() {
		SquirrelExecutionContext ctx = new SquirrelExecutionContext();
		ctx.start(this, runtime, processor);
		ctx.setRoot(this);
		ctx.setErrorHandler(errorHandler);
		ctx.newExecution(this, 1, source);
		try {
			output = processor.evaluateCallable(function, arguments);
		} finally {
			ctx.popExecution();
			ctx.stop();

			// Release the lock call or wakeup is holding
			semaphore.release();
		}

	}

	private Object wakeup(Object param) {
		if (status != SUSPENDED) {
			throw new IllegalStateException("Not " + SUSPENDED);
		}
		try {
			this.input = param;
			suspend.release();
			semaphore.acquire();
			try {
				status = RUNNING;

				// This acquire will block until a ::suspend or when the
				// function
				// completes
				semaphore.acquire();
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException ie) {
			throw new SquirrelException(ie);
		}

		return output;
	}

	private Object call(SquirrelArray arguments) {
		if (status != IDLE) {
			throw new SquirrelException(String.format("Coroutine is not in the %s state, it is %s.", IDLE, status));
		}

		this.arguments = arguments;

		try {
			semaphore.acquire();
			try {
				status = RUNNING;
				thread.start();

				// This acquire will block until a ::suspend or when the
				// function
				// completes
				semaphore.acquire();
			} finally {
				semaphore.release();
			}
		} catch (InterruptedException ie) {
			throw new SquirrelException(ie);
		}

		return output;
	}

	public Object suspend(Object result) {
		if (status != RUNNING) {
			throw new SquirrelException(String.format("Coroutine is not in the %s state, it is %s.", RUNNING, status));
		}
		this.output = result;
		status = SUSPENDED;
		try {
			semaphore.release();
			suspend.acquire();
			suspend.acquire();
		} catch (InterruptedException ie) {
			throw new SquirrelException(ie);
		} finally {
			suspend.release();
		}
		return input;
	}

	@Override
	public Object getObject() {
		return this;
	}
}
