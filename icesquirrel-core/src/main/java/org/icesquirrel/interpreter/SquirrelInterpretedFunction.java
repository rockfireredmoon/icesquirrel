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

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.iceparser.SquirrelLexer;
import org.iceparser.SquirrelParser;
import org.iceparser.SquirrelParser.ArglistContext;
import org.iceparser.SquirrelParser.ExpContext;
import org.iceparser.SquirrelParser.FuncargsContext;
import org.iceparser.SquirrelParser.NameContext;
import org.iceparser.SquirrelParser.StatContext;
import org.iceparser.SquirrelParser.YieldContext;
import org.icesquirrel.runtime.AbstractSquirrelFunction;
import org.icesquirrel.runtime.Return;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelTable;

public class SquirrelInterpretedFunction extends AbstractSquirrelFunction {

	private boolean varargs;
	private List<StatContext> functionBody;

	public SquirrelInterpretedFunction() {
	}

	public SquirrelInterpretedFunction(StatContext functionBody, FuncargsContext functionSignature) {
		super();
		this.functionBody = Arrays.asList(functionBody);

		AbstractParseTreeVisitor<YieldContext> visitor = new AbstractParseTreeVisitor<YieldContext>() {

			@Override
			public YieldContext visitChildren(RuleNode node) {
				System.err.println("VISIT CHILDREN: " + node.getText());
				// TODO Auto-generated method stub
				return super.visitChildren(node);
			}

			@Override
			protected boolean shouldVisitNextChild(RuleNode node, YieldContext currentResult) {
				// TODO Auto-generated method stub
				boolean shouldVisitNextChild = super.shouldVisitNextChild(node, currentResult);
				System.err.println(
						"VISIT SHOULD VISIT: " + node.getText() + " = " + shouldVisitNextChild + " / YIELD : " + currentResult);
				return shouldVisitNextChild;
			}

			@Override
			public YieldContext visit(ParseTree tree) {
				System.err.println("VISIT: " + tree.getText());
				return super.visit(tree);
			}

		};
		YieldContext yield = visitor.visit(functionBody);
		// YieldContext yield = functionBody.accept(visitor);
		if (yield != null) {
			System.err.println("REMOVEME! GOT YIELD");
		}

		// setGenerator(functionBody.getText().contains("yi));
		// TODO
		// vararg support

		// TODO
		// friend variables

		// Arguments
		ArglistContext parlist = functionSignature.arglist();
		if (parlist != null) {
			varargs = parlist.VARARGS() != null;
			if (!varargs) {
				for (NameContext name : parlist.namelist().name()) {
					String nameText = name.NAME().getText();
					ExpContext exp = name.exp();
					Object value = null;
					if (exp != null) {
						value = SquirrelExecutionContext.get().getProcessor().evaluate(exp);
					}
					arguments.insertLocal(nameText, value);
				}
			}
		}
	}

	public void compile(InputStream in, boolean runErrorHandler) throws Exception {
		SquirrelExecutionContext ctx = SquirrelExecutionContext.get();
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
			functionBody = p.script().stat();
		} catch (SquirrelException | IOException | IllegalArgumentException ioe) {
			AbstractSquirrelFunction errorHandler = ctx.getErrorHandler();
			if (runErrorHandler && errorHandler != null) {
				ctx.newExecution(this, 1, null);
				try {
					ctx.getProcessor().evaluateCallable(errorHandler, new SquirrelArray(ioe.getMessage()));
				} finally {
					ctx.popExecution();
				}
			}
			throw ioe;
		}
	}

	@Override
	public Object evaluate(SquirrelArray arguments) {
		try {
			for (StatContext ctx : functionBody) {
				SquirrelExecutionContext.get().getProcessor().processStatement(ctx);
			}
		} catch (Return rv) {
			return rv.getReturnValue();
		}
		return null;
	}

	@Override
	public SquirrelTable getSignature() {
		return arguments;
	}

}
