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

/**
 * Exception thrown by scripts themselves (which can throw any object)
 */
public class SquirrelRuntimeException extends SquirrelException {

	private static final long serialVersionUID = 1L;
	private Object object;

	public SquirrelRuntimeException(Object message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(String.valueOf(message), cause, enableSuppression, writableStackTrace);
		init(message);
	}

	public SquirrelRuntimeException(Object message, Throwable cause) {
		super(String.valueOf(message), cause);
		init(message);
	}

	public SquirrelRuntimeException(Object message) {
		super(String.valueOf(message));
		init(message);
	}

	public SquirrelRuntimeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SquirrelRuntimeException() {
		super();
	}

	public Object getObject() {
		return object;
	}

	private void init(Object object) {
		this.object = object;
	}
}
