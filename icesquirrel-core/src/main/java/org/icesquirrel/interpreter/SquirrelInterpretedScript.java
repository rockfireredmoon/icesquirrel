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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.iceparser.SquirrelLexer;
import org.iceparser.SquirrelParser;
import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.runtime.SquirrelScript;

public class SquirrelInterpretedScript extends SquirrelScript {

	public final static Object run(File in, Object... args) throws Exception {
		FileInputStream fin = new FileInputStream(in);
		try {
			return run(in.getPath(), SquirrelRuntime.getDefaultRuntime(), fin, args);
		} finally {
			fin.close();
		}
	}

	public final static Object run(URL in, Object... args) throws Exception {
		if (in == null) {
			throw new IllegalArgumentException("URL may not be null.");
		}
		final InputStream stream = in.openStream();
		if (stream == null) {
			throw new FileNotFoundException(String.format("Could not open %s.", in));
		}
		try {
			return run(in.toExternalForm(), SquirrelRuntime.getDefaultRuntime(), stream, args);
		} finally {
			stream.close();
		}
	}

	public final static Object run(InputStream in, Object... args) throws Exception {
		return run(SquirrelRuntime.getDefaultRuntime(), in, args);
	}

	public final static Object run(SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		return run(null, runtime, in, args);
	}

	public final static Object run(String sourceName, SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		return new SquirrelInterpretedScript(sourceName, runtime, in, args).getResult();
	}

	public final static Object run(SquirrelRuntime runtime, String script, Object... args) throws Exception {
		return run(null, runtime, script, args);
	}

	public final static Object run(String sourceName, SquirrelRuntime runtime, String script, Object... args) throws Exception {
		return new SquirrelInterpretedScript(sourceName, runtime, script, args).getResult();
	}

	public SquirrelInterpretedScript(InputStream in, Object... args) throws Exception {
		super(in, args);
	}

	public SquirrelInterpretedScript(Object... args) {
		super(args);
	}

	public SquirrelInterpretedScript(SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		super(runtime, in, args);
	}

	public SquirrelInterpretedScript(SquirrelRuntime runtime, Object... args) {
		super(runtime, args);
	}

	public SquirrelInterpretedScript(SquirrelRuntime runtime, String in, Object... args) throws Exception {
		super(runtime, in, args);
	}

	public SquirrelInterpretedScript(String sourceName, InputStream in, Object... args) throws Exception {
		super(sourceName, in, args);
	}

	public SquirrelInterpretedScript(String in, Object... args) throws Exception {
		super(in, args);
	}

	public SquirrelInterpretedScript(String sourceName, SquirrelRuntime runtime, InputStream in, Object... args) throws Exception {
		super(sourceName, runtime, in, args);
	}

	public SquirrelInterpretedScript(String sourceName, SquirrelRuntime runtime, String in, Object... args) throws Exception {
		super(sourceName, runtime, in, args);
	}

	public SquirrelInterpretedScript(String sourceName, String in, Object... args) throws Exception {
		super(sourceName, in, args);
	}

	public void execute(final InputStream in, boolean runErrorHandler) throws Exception {
		SquirrelExecutionContext ctx = null;
		boolean wasNewContext = false;
		if (SquirrelExecutionContext.is()) {
			ctx = SquirrelExecutionContext.get();
		} else {
			ctx = new SquirrelExecutionContext();
			ctx.start(getRootTable(), runtime, new SquirrelInterpretedProcessor());
			wasNewContext = true;
		}
		try {
			SquirrelLexer l = new SquirrelLexer(new ANTLRInputStream(in));
			SquirrelParser p = new SquirrelParser(new CommonTokenStream(l));
			p.addErrorListener(new BaseErrorListener() {
				@Override
				public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
						String msg, RecognitionException e) {
					throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
				}
			});
			script = p.script();
			getRootTable().insertLocal("ARGS", arguments);
			ctx.newExecution(getRootTable(), 1, sourceName);
			try {
				result = ctx.getProcessor().evaluateCallable(this, arguments);
			} finally {
				ctx.popExecution();
			}
		} catch (SquirrelException | IOException | IllegalArgumentException ioe) {
			AbstractSquirrelFunction errorHandler = ctx.getErrorHandler();
			if (runErrorHandler && errorHandler != null) {
				ctx.newExecution(this, 1, sourceName);
				try {
					result = ctx.getProcessor().evaluateCallable(errorHandler, new SquirrelArray(ioe.getMessage()));
				} finally {
					ctx.popExecution();
				}
			}
			throw ioe;
		} finally {
			if (wasNewContext) {
				ctx.stop();
			}
		}
	}

}