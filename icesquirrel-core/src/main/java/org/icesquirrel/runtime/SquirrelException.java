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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

@SuppressWarnings("serial")
public class SquirrelException extends RuntimeException {

	private int line;
	private String message;
	private SquirrelExecutionContext ctx;

	public SquirrelException() {
		super();
		init();
	}

	public SquirrelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		init();
	}

	public SquirrelException(String message, Throwable cause) {
		super(message, cause);
		init();
	}

	public SquirrelException(String message) {
		super(message);
		init();
	}

	public SquirrelException(Throwable cause) {
		super(cause);
		init();
	}

	public SquirrelExecutionContext getExecutionContext() {
		return ctx;
	}

	private void init() {
		ctx = SquirrelExecutionContext.get();
		line = ctx.execution().getLine();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.println(String.format("AN ERROR HAS OCCURED [%s]", super.getMessage()));
		pw.println();
		pw.println("CALLSTACK");
		for (SquirrelExecution f : ctx.stack()) {
			pw.println(String.format("%s [%s] %s line [%d]", ctx.getRuntime().getClass(f.getEnvironment()).getTypeName(),
					f.toString(), f.getSource(), f.getLine()));
		}
		pw.println();
		pw.println("LOCALS");
		SquirrelTable local = ctx.execution();
		for (Map.Entry<Object, Object> en : local.entrySet()) {
			pw.println(String.format("[%s] [%s]", en.getKey(), en.getValue()));
		}
		message = sw.toString();
	}

	@Override
	public String getMessage() {
		return message;
	}

	public int getLine() {
		return line;
	}

}
