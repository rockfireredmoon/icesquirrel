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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.iceparser.SquirrelLexer;
import org.iceparser.SquirrelParser;
import org.iceparser.SquirrelParser.ScriptContext;
import org.icesquirrel.runtime.SquirrelMain;
import org.icesquirrel.runtime.SquirrelProcessor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class SquirrelCompiler {
	public final static Logger LOG = Logger.getLogger("COMPILER");

	private String namespace;
	private File output = new File(System.getProperty("user.dir"));

	public void compile(String in, String scriptName) throws Exception {
		compile(new ByteArrayInputStream(in.getBytes()), scriptName);
	}

	public void compile(InputStream in, String scriptName) throws Exception {
		SquirrelLexer l = new SquirrelLexer(new ANTLRInputStream(in));
		SquirrelParser p = new SquirrelParser(new CommonTokenStream(l));
		p.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
			}
		});
		ScriptContext script = p.script();

		// Determine class name
		String className = convertClassName((namespace == null ? "" : namespace + ".") + scriptName);
		LOG.info(String.format("Generating class %s", className));

		// Write the class definition and main() method
		ClassWriter cw = new ClassWriter(0);
		cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object",
				new String[] { convertClassName(SquirrelMain.class.getName()) });
		final MethodVisitor visitMethod = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "(L[java/lang/String;)V",
				null, null);
		compileMain(cw, visitMethod, script);

		visitMethod.visitEnd();

		// Finish writing the main class
		cw.visitEnd();

		// Output the class file
		File dir = namespace == null ? output : new File(output, namespace.replace('.', File.separatorChar));
		if (!dir.exists() && !dir.mkdirs()) {
			throw new IOException(String.format("Could not create output directory %s", dir));
		}
		File classFile = new File(dir, scriptName + ".class");
		LOG.info(String.format("Writing class to %s", classFile.getPath()));
		FileOutputStream fos = new FileOutputStream(classFile);
		try {
			fos.write(cw.toByteArray());
		} finally {
			fos.close();
		}

	}

	public void compileMain(ClassWriter cw, MethodVisitor visitMethod, ScriptContext script) {
		SquirrelProcessor processor = new SquirrelCompilingProcessor(cw, visitMethod);
	}

	static String convertClassName(String className) {
		return className.replace('.', '/');
	}

	public void setOutput(File output) {
		this.output = output;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

}
