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

import java.util.ArrayList;
import java.util.List;

public class SquirrelUtil {

	public static List<String> split(String str) {
		List<String> l = new ArrayList<String>();
		boolean esc = false;
		boolean quoted = false;
		StringBuilder w = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (c == '\'' && !esc) {
				quoted = !quoted;
			} else if (c == '\\' && !esc) {
				esc = true;
			} else if (c == ' ' && !quoted && !esc) {
				l.add(w.toString());
				w.setLength(0);
			} else {
				w.append(c);
			}
		}
		if (w.length() > 0) {
			l.add(w.toString());
		}
		return l;
	}

	public static String unkey(String str) {
		if (str.startsWith("[") && str.endsWith("]")) {
			return str.substring(1, str.length() - 1);
		}
		throw new IllegalArgumentException("'" + str + "' is not formatted as a key.");
	}

	public static String unquote(String str) {
		if (str.startsWith("\"") && str.endsWith("\"")) {
			return str.substring(1, str.length() - 1);
		}
		throw new IllegalArgumentException("'" + str + "' is not quote.");
	}

	public static String unescapeString(String str) {
		return unescapeString(str, false, true);
	}

	public static String escape(String val) {
		return val;
	}

	public static String unescapeString(String str, boolean unescapeSingleQuotes, boolean unescapeDoubleQuotes) {
		boolean esc = false;
		StringBuilder bui = new StringBuilder(str.length());
		for (Character c : str.toCharArray()) {
			if (c == '\\' && !esc) {
				esc = true;
			} else if (esc) {
				switch (c) {
				case 't':
					bui.append('\t');
					break;
				case 'a':
					bui.append((char) 0x07);
					break;
				case 'b':
					bui.append('\b');
					break;
				case 'n':
					bui.append('\n');
					break;
				case 'r':
					bui.append('\r');
					break;
				case 'v':
					bui.append((char) 0x0b);
					break;
				case 'f':
					bui.append((char) 0x0c);
					break;
				case '\\':
					bui.append('\\');
					break;
				case '0':
					bui.append('\0');
					break;
				case '\'':
					if (unescapeSingleQuotes) {
						bui.append('\\');
					} else {
						throw new IllegalArgumentException(
								"Escaped single quote, but single quotes are not escaped in this context.");
					}
					break;
				case '"':
					if (unescapeDoubleQuotes) {
						bui.append('"');
					} else {
						throw new IllegalArgumentException(
								"Escaped double quote, but single quotes are not escaped in this context.");
					}
					break;
				default:
					throw new IllegalArgumentException("Illegal escape sequence '" + c + "'");
				}
				esc = false;
			} else {
				bui.append(c);
			}
		}
		return bui.toString();
	}
}
