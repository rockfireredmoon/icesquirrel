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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SquirrelPrintWriter extends PrintWriter {

	private boolean conciseKeys;

	public SquirrelPrintWriter(Writer out) {
		super(out);
	}

	public SquirrelPrintWriter(OutputStream out) {
		super(out);
	}

	public SquirrelPrintWriter(String fileName) throws FileNotFoundException {
		super(fileName);
	}

	public SquirrelPrintWriter(File file) throws FileNotFoundException {
		super(file);
	}

	public SquirrelPrintWriter(Writer out, boolean autoFlush) {
		super(out, autoFlush);
	}

	public SquirrelPrintWriter(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	public SquirrelPrintWriter(String fileName, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(fileName, csn);
	}

	public SquirrelPrintWriter(File file, String csn) throws FileNotFoundException, UnsupportedEncodingException {
		super(file, csn);
	}

	public boolean isConciseKeys() {
		return conciseKeys;
	}

	public void setConciseKeys(boolean conciseKeys) {
		this.conciseKeys = conciseKeys;
	}

}
