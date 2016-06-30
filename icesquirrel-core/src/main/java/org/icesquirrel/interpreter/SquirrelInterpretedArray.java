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
package org.icesquirrel.interpreter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.iceparser.SquirrelLexer;
import org.iceparser.SquirrelParser;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelRuntime;

public class SquirrelInterpretedArray extends SquirrelArray {

	private static final long serialVersionUID = 1L;

	public static SquirrelInterpretedArray array(String squirrel) {
		return array(SquirrelRuntime.getDefaultRuntime(), squirrel);
	}

	public static SquirrelInterpretedArray array(SquirrelRuntime runtime, String squirrel) {
		return array(runtime, new ByteArrayInputStream(squirrel.getBytes()));
	}

	public final static SquirrelInterpretedArray array(InputStream in) {
		return array(SquirrelRuntime.getDefaultRuntime(), in);
	}

	public final static SquirrelInterpretedArray array(SquirrelRuntime runtime, InputStream in) {
		SquirrelExecutionContext ctx = null, actualCtx = null;
		if (!SquirrelExecutionContext.is()) {
			// TODO use a shared table?
			final SquirrelInterpretedTable table = new SquirrelInterpretedTable();
			actualCtx = ctx = new SquirrelExecutionContext();
			ctx.start(table, SquirrelRuntime.getDefaultRuntime(), new SquirrelInterpretedProcessor());
		} else {
			actualCtx = SquirrelExecutionContext.get();
		}
		try {
			SquirrelInterpretedArray array = new SquirrelInterpretedArray();
			actualCtx.newExecution(array, 0, null);
			try {
				array.compile(in);
				return array;
			} finally {
				actualCtx.popExecution();
			}
		} catch (SquirrelException se) {
			throw se;
		} catch (Exception e) {
			throw new SquirrelException("Failed to evaluate table.", e);
		} finally {
			if (ctx != null) {
				ctx.stop();
			}
		}
	}

	public SquirrelInterpretedArray() {
		super();
	}

	public SquirrelInterpretedArray(int size) {
		super(size);
	}

	public SquirrelInterpretedArray(Object... values) {
		super(values);
	}

	public void compile(String squirrel) throws IOException, SquirrelException {
		compile(new ByteArrayInputStream(squirrel.getBytes()));
	}

	public void compile(InputStream in) throws IOException, SquirrelException {
		clear();
		SquirrelLexer l = new SquirrelLexer(new ANTLRInputStream(in));
		SquirrelParser p = new SquirrelParser(new CommonTokenStream(l));
		p.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
			}
		});
		((SquirrelInterpretedProcessor) SquirrelExecutionContext.get().getProcessor()).processArray(p.arrayconstructor(), this);
	}

}
