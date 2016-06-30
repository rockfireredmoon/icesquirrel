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

import org.antlr.v4.runtime.tree.ParseTree;
import org.iceparser.SquirrelParser.BlockContext;
import org.iceparser.SquirrelParser.ExpContext;
import org.iceparser.SquirrelParser.StatContext;
import org.iceparser.SquirrelParser.TableconstructorContext;

public abstract class SquirrelProcessor {

	protected final static SquirrelArray EMPTY_ARRAY = new SquirrelArray();

	/**
	 * Process a statement.
	 * 
	 * @param block
	 *            block of statements to process
	 */
	public final void processStatements(List<StatContext> blocks) {
		for (StatContext block : blocks) {
			processStatement(block);
		}
	}

	/**
	 * Process a statement.
	 * 
	 * @param statement
	 *            block of statements to process
	 */
	public final void processStatement(StatContext statement) {
		SquirrelRuntime.LOG.fine("Statement: " + statement.getText());
		if (statement.getText().startsWith("functionbFunction(){return\"B66\";}")) {
			System.out.println("***");
		}
		try {
			for (int i = 0; i < statement.getChildCount(); i++) {
				ParseTree tree = statement.getChild(i);
				if (tree instanceof BlockContext) {
					processBlock((BlockContext) tree);
				} else {
					processStatement(tree);
				}
			}
		} catch (IllegalArgumentException iae) {
			throw new SquirrelException(iae.getMessage(), iae);
		}
	}

	/**
	 * Process all of a blocks' statements. The return value (if any) will be on
	 * the stack.
	 * 
	 * @param block
	 * @return
	 */
	public final void processBlock(BlockContext block) {
		for (StatContext c : block.stat()) {
			processStatement(c);
		}
	}

	public abstract void processStatement(ParseTree statement);

	public abstract Object evaluate(ExpContext exp);

	public abstract Object evaluateCallable(SquirrelCallable callable, SquirrelArray arguments);

	public abstract void processTable(TableconstructorContext tableContext, SquirrelTable table);

}
