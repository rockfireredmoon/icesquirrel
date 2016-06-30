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

import java.nio.ByteBuffer;
import java.util.Iterator;

import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.Function;
import org.icesquirrel.runtime.JavaSquirrelClass;
import org.icesquirrel.runtime.JavaSquirrelObject;
import org.icesquirrel.runtime.SquirrelIndexable;

/**
 * Implementation of 'Blob' object and global symbols
 */
public class Blob {

	@Function
	public static BlobObject newblob(Long size) {
		return new BlobObject(new Blob(size.intValue()));
	}

	@Function
	public static Long castf2i(Number number) {
		return number.longValue();
	}

	@Function
	public static Double casti2f(Number number) {
		return number.doubleValue();
	}

	@Function
	public static Long swap2(Number number) {
		short val = number.shortValue();
		return new Long(Short.reverseBytes(val));
	}

	@Function
	public static Long swap4(Number number) {
		int val = number.intValue();
		return new Long(Integer.reverseBytes(val));
	}

	@Function
	public static Long swapfloat(Number number) {
		double val = number.doubleValue();
		return new Long(Long.reverseBytes(Double.doubleToRawLongBits(val)));
	}

	public static final class BlobObject extends JavaSquirrelObject implements SquirrelIndexable {

		public BlobObject(Blob blob) {
			super(CLASS, blob);
		}

		@Override
		public Long get(int index) {
			return ((Blob) getObject()).get(index);
		}

		@Override
		public Iterator<Object> iterator() {
			return new Iterator<Object>() {

				private int pos = 0;

				@Override
				public boolean hasNext() {
					return pos < ((Blob) getObject()).blob.limit();
				}

				@Override
				public Long next() {
					return ((Blob) getObject()).get(pos++);
				}

				@Override
				public void remove() {
					throw new UnsupportedOperationException();
				}

			};
		}

		@Override
		public Long set(int index, Object val) {
			return ((Blob) getObject()).set(index, (Long) val);
		}

	}

	private ByteBuffer blob;
	private final static AbstractSquirrelClass CLASS = new JavaSquirrelClass(Blob.class);

	protected Blob(ByteBuffer blob) {
		this.blob = blob;
	}

	protected Blob(int size) {
		blob = ByteBuffer.allocate(size);
	}

	public ByteBuffer getData() {
		return blob;
	}

	@Function
	public Object eos() {
		return blob.remaining() > 0 ? null : true;
	}

	@Function
	public Object flush() {
		// No concept of flush
		return true;
	}

	@Function
	public Long len() {
		return new Long(blob.limit());
	}

	@Function
	public BlobObject readblob(Number size) {
		ByteBuffer newBlob = ByteBuffer.allocate(size.intValue());
		blob.get(newBlob.array());
		return new BlobObject(new Blob(newBlob));
	}

	@Function
	public Object readn(String type) {
		switch (type.toString().charAt(0)) {
		case 'l':
			return new Long(blob.getLong());
		case 'i':
			return new Long(blob.getInt());
		case 's':
			return new Long(blob.getShort());
		case 'w':
			return new Long((int) blob.getShort() & 0x0000ffff);
		case 'c':
			return new Long(blob.get());
		case 'b':
			return new Long((int) blob.get() & 0x000000ff);
		case 'f':
			return new Double(blob.getFloat());
		case 'd':
			return new Double(blob.getDouble());
		}
		throw new UnsupportedOperationException();
	}

	@Function
	public void resize(Number size) {
		int is = size.intValue();
		ByteBuffer newBlob = ByteBuffer.allocate(is);
		byte[] arr = blob.array();
		newBlob.put(arr, 0, java.lang.Math.min(arr.length, is));
		newBlob.rewind();
		blob = newBlob;
	}

	@Function
	public void swap2() {
		byte[] arr = blob.array();
		byte x;
		for (int i = 0; i < blob.limit(); i++) {
			x = arr[0];
			arr[0] = arr[1];
			arr[1] = x;
		}
	}

	@Function
	public void swap4() {
		byte[] arr = blob.array();
		byte x;
		for (int i = 0; i < blob.limit(); i++) {
			x = arr[0];
			arr[0] = arr[3];
			arr[3] = x;
			x = arr[1];
			arr[1] = arr[2];
			arr[2] = x;
		}
	}

	@Function
	public void seek(Number pointer, String... origin) {
		char org = origin.length > 0 ? origin[0].charAt(0) : 'b';
		switch (org) {
		case 'b':
			blob.position(pointer.intValue());
			break;
		case 'c':
			blob.position(blob.position() + pointer.intValue());
			break;
		case 'e':
			blob.position(blob.limit() - pointer.intValue());
			break;
		}
		throw new UnsupportedOperationException();
	}

	@Function
	public Long tell() {
		return new Long(blob.position());
	}

	@Function
	public void writeblob(BlobObject blob) {
		this.blob.put(((Blob) blob.getObject()).blob.array());
	}

	@Function
	public void writen(Object data, char type) {
		switch (type) {
		case 'i':
			blob.putInt(((Number) data).intValue());
			break;
		case 's':
			blob.putShort(((Number) data).shortValue());
			break;
		case 'w':
			blob.putShort((short) (((Number) data).intValue() & 0x0000ffff));
			break;
		case 'c':
			blob.put((byte) (((Number) data).byteValue() & 0x000000ff));
			break;
		case 'b':
			blob.put((byte) (((Number) data).byteValue() & 0x000000ff));
			break;
		case 'f':
			blob.putFloat((((Number) data).floatValue()));
			break;
		case 'd':
			blob.putDouble((((Number) data).doubleValue()));
			break;
		}
		throw new UnsupportedOperationException();
	}

	private Long get(int index) {
		return new Long(blob.get(index));
	}

	private Long set(int index, Long val) {
		blob.put(index, val.byteValue());
		return val;
	}
}
