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

import java.io.StringWriter;

public class SquirrelPrinter {

	public static String identString(int depth) {
		if (depth < 0) {
			return null;
		}
		StringBuilder indent = new StringBuilder();
		for (int i = 0; i < depth * 4; i++) {
			indent.append(' ');
		}
		return indent.toString();
	}

	public static String format(Object object) {
		return format(object, -1);
	}

	public static void format(SquirrelPrintWriter writer, Object object) {
		format(writer, object, -1);
	}

	public static String format(Object object, int depth) {
		StringWriter sw = new StringWriter();
		SquirrelPrintWriter pw = new SquirrelPrintWriter(sw);
		format(pw, object, depth);
		return sw.toString();
	}

	public static void format(SquirrelPrintWriter writer, Object object, int depth) {
		if (object instanceof String) {
			writer.write("\"" + escapeString((String) object) + "\"");
		} else if (object instanceof SquirrelType<?>) {
			((SquirrelType<?>) object).format(writer, depth);
		} else {
			writer.write(String.valueOf(object));
		}
		writer.flush();
	}

	public static String escapeString(String str) {
		return escapeString(str, false, true);
	}

	public static String escapeString(String str, boolean escapeSingleQuote, boolean escapeDoubleQuote) {
		StringBuilder bui = new StringBuilder(str.length());
		for (char c : str.toCharArray()) {
			if (c == '\t') {
				bui.append("\\t");
			} else if (c == '\r') {
				bui.append("\\r");
			} else if (c == '\n') {
				bui.append("\\n");
			} else if (c == '\b') {
				bui.append("\\b");
			} else if (c == '\0') {
				bui.append("\\0");
			} else if (c == 0x0b) {
				bui.append("\\v");
			} else if (c == 0x07) {
				bui.append("\\a");
			} else if (c == 0x0c) {
				bui.append("\\f");
			} else if (c == '\\' && escapeSingleQuote) {
				bui.append("\\'");
			} else if (c == '"' && escapeDoubleQuote) {
				bui.append("\\\"");
			} else if (c == '\\') {
				bui.append("\\\\");
			} else {
				bui.append(c);
			}
		}
		return bui.toString();
	}

}
