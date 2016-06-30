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
package org.icesquirrel.stdlib;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.AbstractSquirrelObject;
import org.icesquirrel.runtime.Function;
import org.icesquirrel.runtime.JavaSquirrelClass;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelTable;

public class Str {

	@Function
	public static String format(String formatter, Object... arguments) {
		return String.format(formatter, arguments);
	}

	@Function
	public static String lstrip(String str) {
		char c;
		while (str.length() > 0) {
			c = str.charAt(0);
			if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
				str = str.substring(1);
			} else {
				break;
			}
		}
		return str;
	}

	@Function
	public static String strip(String str) {
		return str.trim();
	}

	@Function
	public static String rstrip(String str) {
		char c;
		while (str.length() > 0) {
			c = str.charAt(str.length() - 1);
			if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
				str = str.substring(0, str.length() - 2);
			} else {
				break;
			}
		}
		return str;
	}

	@Function
	public static RegexpObject regexp(String str) {
		return new RegexpObject(str);
	}

	@Function
	public static SquirrelArray split(String str, String... sep) {
		SquirrelArray arr = new SquirrelArray();
		StringTokenizer t = sep.length == 0 ? new StringTokenizer(str) : new StringTokenizer(str, sep[0]);
		while (t.hasMoreTokens()) {
			arr.add(t.nextToken());
		}
		return arr;
	}

	public static final class RegexpClass extends JavaSquirrelClass<RegexpObject> {
		public RegexpClass() {
			super(RegexpObject.class, "regexp");
		}

		@Function
		public SquirrelArray capture(RegexpObject obj, String str, Long... start) {
			Matcher m = obj.pattern.matcher(start.length == 0 ? str : str.substring(start[0].intValue()));
			if (m.find()) {
				SquirrelArray a = new SquirrelArray();
				a.add(obj.addToTable(m, new SquirrelTable(), 0));
				for (int i = 0; i < m.groupCount(); i++) {
					a.add(obj.addToTable(m, new SquirrelTable(), i + 1));
				}
				return a;
			} else {
				return null;
			}
		}

		@Function
		public boolean match(RegexpObject obj, String str) {
			return obj.pattern.matcher(str).matches();
		}

		@Function
		public SquirrelTable search(RegexpObject obj, String str, Long... start) {
			Matcher m = obj.pattern.matcher(start.length == 0 ? str : str.substring(start[0].intValue()));
			if (m.find()) {
				return obj.addToTable(m, new SquirrelTable(), 0);
			}
			return null;
		}
	}

	public static final class RegexpObject extends AbstractSquirrelObject {
		private Pattern pattern;

		private final static AbstractSquirrelClass CLASS = new RegexpClass();

		public RegexpObject(String str) {
			super(CLASS);

			// TODO more to do
			str = str.replace("\\p", "\\p{Punct}");
			str = str.replace("\\P", "\\P{Punct}");
			// \c control charactrs
			// \C non control charactrs
			Stdlib.LOG.fine(String.format("Regexp %s", str));

			pattern = Pattern.compile(str);
		}

		private SquirrelTable addToTable(Matcher m, SquirrelTable t, int g) {
			t.insert("begin", new Long(m.start(g)));
			t.insert("end", new Long(m.end(g)));
			return t;
		}

		@Override
		public Object getObject() {
			return this;
		}
	}

}
