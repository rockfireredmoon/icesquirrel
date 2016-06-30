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

import org.icesquirrel.runtime.BuiltInFunctions;
import org.icesquirrel.runtime.SquirrelPlugin;
import org.icesquirrel.runtime.SquirrelRuntime;

public class Plugin implements SquirrelPlugin {

	@Override
	public void init(SquirrelRuntime runtime) {
		BuiltInFunctions table = runtime.getBuiltInFunctions();

		table.add(File.class);
		table.add(Blob.class);
		table.add(Str.class);
		table.add(org.icesquirrel.stdlib.System.class);
		table.add(org.icesquirrel.stdlib.Math.class);

		table.insertLocal("file", File.CLASS);
		table.insertLocal("stderr", new File(new File.OutFileImpl(java.lang.System.err)));
		table.insertLocal("stdout", new File(new File.OutFileImpl(java.lang.System.out)));
		table.insertLocal("stdin", new File(new File.InFileImpl(java.lang.System.in)));
		table.insertLocal("PI", java.lang.Math.PI);
		table.insertLocal("RAND_MAX", 1);
	}

}
