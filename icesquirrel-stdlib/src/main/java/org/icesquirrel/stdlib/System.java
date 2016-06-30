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

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.icesquirrel.runtime.Function;
import org.icesquirrel.runtime.SquirrelArray;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecution;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.runtime.SquirrelTable;
import org.icesquirrel.runtime.SquirrelUtil;

public class System {
	@Function
	public static boolean rename(String oldname, String newname) {
		return new java.io.File(oldname.toString()).renameTo(new java.io.File(newname.toString()));
	}

	@Function
	public static boolean remove(String path) {
		return new java.io.File(path.toString()).delete();
	}

	@Function
	public static Double time() {
		return (double) java.lang.System.currentTimeMillis() / 1000d;
	}

	@Function
	public static Long clock() {
		return java.lang.System.currentTimeMillis() - SquirrelRuntime.RUNTIME_START;
	}

	@Function
	public static String getenv(String key) {
		return java.lang.System.getenv(key);
	}

	@Function
	public static Boolean system(String cmd) {
		ProcessBuilder pb = new ProcessBuilder(SquirrelUtil.split(cmd.toString()));
		pb.redirectErrorStream(true);
		try {
			Process p = pb.start();
			try {
				byte[] buf = new byte[65536];
				int r;
				InputStream in = p.getInputStream();
				while ((r = in.read(buf)) != -1) {
					java.lang.System.out.write(buf, 0, r);
				}
			} finally {
				p.waitFor();
			}
			return p.exitValue() == 0 ? true : null;
		} catch (IOException | InterruptedException ie) {
			throw new SquirrelException(ie);
		}
	}

	@Function
	public static SquirrelTable date(Object... args) {
		// TODO format
		Calendar cal = Calendar.getInstance();
		SquirrelArray time = args.length > 0 ? (SquirrelArray) args[0] : null;
		String format = args.length > 1 ? (String) args[1] : null;
		if (time != null) {
			cal.set(Calendar.HOUR, ((Number) time.get(0)).intValue());
			cal.set(Calendar.HOUR_OF_DAY, ((Number) time.get(1)).intValue());
		}
		SquirrelTable t = new SquirrelTable();
		t.insert("sec", cal.get(Calendar.SECOND));
		t.insert("min", cal.get(Calendar.MINUTE));
		t.insert("hour", cal.get(Calendar.HOUR_OF_DAY));
		t.insert("day", cal.get(Calendar.DAY_OF_MONTH));
		t.insert("year", cal.get(Calendar.YEAR));
		t.insert("wday", cal.get(Calendar.DAY_OF_WEEK));
		t.insert("yday", cal.get(Calendar.DAY_OF_YEAR));
		return t;
	}

}
