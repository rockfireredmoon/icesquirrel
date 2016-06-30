
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
package org.icesquirrel.compiler;

import org.antlr.v4.runtime.tree.ParseTree;
import org.iceparser.SquirrelParser.DeclareContext;
import org.iceparser.SquirrelParser.ExpContext;
import org.iceparser.SquirrelParser.LocalvarContext;
import org.iceparser.SquirrelParser.TableconstructorContext;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelCallable;
import org.icesquirrel.runtime.SquirrelProcessor;
import org.icesquirrel.runtime.SquirrelTable;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class SquirrelCompilingProcessor extends SquirrelProcessor {

	private MethodVisitor main;
	private ClassWriter cw;

	public SquirrelCompilingProcessor(ClassWriter cw, MethodVisitor main) {
		this.cw = cw;
		this.main = main;
	}

	@Override
	public void processStatement(ParseTree statement) {
		if (statement instanceof LocalvarContext) {
			LocalvarContext lvc = (LocalvarContext) statement;
			for (DeclareContext decl : lvc.declarelist().declare()) {
			}
		}
	}

	@Override
	public Object evaluate(ExpContext exp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object evaluateCallable(SquirrelCallable callable, SquirrelArray arguments) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void processTable(TableconstructorContext tableContext, SquirrelTable table) {
		// TODO Auto-generated method stub

	}
}
