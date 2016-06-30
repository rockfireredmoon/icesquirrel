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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.logging.Level;

import org.icesquirrel.interpreter.SquirrelInterpretedFunction;
import org.icesquirrel.interpreter.SquirrelInterpretedScript;
import org.icesquirrel.runtime.AbstractSquirrelClass;
import org.icesquirrel.runtime.AbstractSquirrelObject;
import org.icesquirrel.runtime.Function;
import org.icesquirrel.runtime.JavaSquirrelClass;
import org.icesquirrel.runtime.SquirrelException;
import org.icesquirrel.runtime.SquirrelExecutionContext;
import org.icesquirrel.runtime.SquirrelRuntime;
import org.icesquirrel.stdlib.Blob.BlobObject;

public class File extends AbstractSquirrelObject {

	@Function
	public static Object dofile(String path, Object... arguments) {
		boolean raiseError = false;
		if (arguments.length > 0) {
			raiseError = ((Boolean) arguments[1]);
		}
		try {
			FileInputStream fin = new FileInputStream(new java.io.File(path));
			try {
				SquirrelInterpretedScript scr = new SquirrelInterpretedScript(SquirrelExecutionContext.get().getRuntime());
				scr.execute(fin, raiseError);
				return scr.getResult();
			} finally {
				fin.close();
			}
		} catch (Exception ioe) {
			throw new SquirrelException(java.lang.String.format("Error while loading script %s", path), ioe);
		}
	}

	@Function
	public static Object loadfile(String path, Object... arguments) {
		boolean raiseError = false;
		if (arguments.length > 0) {
			raiseError = ((Boolean) arguments[0]);
		}
		try {
			FileInputStream fin = new FileInputStream(new java.io.File(path));
			try {
				SquirrelInterpretedFunction scr = new SquirrelInterpretedFunction();
				scr.compile(fin, raiseError);
				return scr;
			} finally {
				fin.close();
			}
		} catch (Exception ioe) {
			throw new SquirrelException(java.lang.String.format("Error while loading script %s", path), ioe);
		}
	}

	@Function
	public static void writeclosuretofile() {
		throw new UnsupportedOperationException();
	}

	public static final class FileClass extends JavaSquirrelClass<File> {
		public FileClass() {
			super(File.class, "file");
		}

		@Function
		public Object eos(File file) throws IOException {
			return file.impl.available() == 0 ? true : null;
		}

		@Function
		public Object flush(File file) throws IOException {
			try {
				file.impl.flush();
				return true;
			} catch (Exception e) {
				SquirrelRuntime.LOG.log(Level.FINE, "Failed to flush.", e);
				return null;
			}
		}

		@Function
		public void close(File file) throws IOException {
			file.impl.close();
		}

		@Function
		public Long len(File file) throws IOException {
			return file.impl.len();
		}

		@Function
		public BlobObject readblob(File file, Long size) {
			Blob blob = new Blob(size.intValue());
			BlobObject b = new BlobObject(blob);
			byte[] arr = blob.getData().array();
			try {
				file.impl.read(arr);
			} catch (IOException ioe) {
				throw new SquirrelException("I/O error reading file.", ioe);
			}
			return b;
		}

		@Function
		public Object readn(File file, String type) throws IOException {
			return file.impl.readn(type);
		}

		@Function
		public void seek(File file, Long pointer, String... origin) throws IOException {
			char org = origin.length > 0 ? origin[0].charAt(0) : 'b';
			switch (org) {
			case 'b':
				file.impl.position(pointer.intValue());
				break;
			case 'c':
				file.impl.position(file.impl.position() + pointer.intValue());
				break;
			case 'e':
				file.impl.position(file.impl.len() - pointer.intValue());
				break;
			}
			throw new UnsupportedOperationException();
		}

		@Function
		public Long tell(File file) throws IOException {
			return file.impl.position();
		}

		@Function
		public void writeblob(File file, BlobObject blob) throws IOException {
			Blob b = (Blob) blob.getObject();
			byte[] arr = b.getData().array();
			file.impl.write(arr);
		}

		@Function
		public void writen(File file, Object data, String type) throws IOException {
			file.impl.writen(data, type);
		}
	}

	public final static AbstractSquirrelClass CLASS = new FileClass();

	interface FileImpl {

		int available() throws IOException;

		void flush() throws IOException;

		long len();

		void close() throws IOException;

		int read(byte[] arr) throws IOException;

		Object readn(String type) throws IOException;

		long position() throws IOException;

		void position(long pos) throws IOException;

		void write(byte[] arr) throws IOException;

		void writen(Object data, String type) throws IOException;

	}

	public static class InFileImpl implements FileImpl {

		private DataInputStream in;
		private java.io.File file;
		private long pos;

		public InFileImpl(InputStream in) {
			in = new DataInputStream(in);
		}

		public InFileImpl(java.io.File file) throws FileNotFoundException {
			this.file = file;
			in = new DataInputStream(new FileInputStream(file));
		}

		@Override
		public int available() throws IOException {
			return in.available();
		}

		@Override
		public void flush() throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public long len() {
			return file.length();
		}

		@Override
		public void close() throws IOException {
			in.close();
		}

		@Override
		public int read(byte[] arr) throws IOException {
			int read = in.read(arr);
			pos += read;
			return read;
		}

		@Override
		public Object readn(String type) throws IOException {
			char t = type.charAt(0);
			switch (t) {
			case 'i':
				Object r = in.readInt();
				pos += 4;
				return r;
			case 's':
				r = in.readShort();
				pos += 4;
				return r;
			case 'w':
				r = in.readShort() & 0x0000ffff;
				pos += 2;
				return r;
			case 'c':
				r = in.read();
				pos++;
				return r;
			case 'b':
				r = in.read() & 0xff;
				pos++;
				return r;
			case 'f':
				r = in.readFloat();
				pos += 4;
				return r;
			case 'd':
				r = in.readDouble();
				pos += 8;
				return r;
			}
			throw new UnsupportedOperationException();
		}

		@Override
		public long position() {
			return pos;
		}

		@Override
		public void position(long pos) throws IOException {
			this.pos = pos;
			in.reset();
			in.skip(pos);
		}

		@Override
		public void write(byte[] arr) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void writen(Object data, String type) {
			throw new UnsupportedOperationException();
		}
	}

	public static class OutFileImpl implements FileImpl {

		private DataOutputStream out;
		private int filePointer;
		private java.io.File file;

		public OutFileImpl(OutputStream out) {
			this.out = new DataOutputStream(out);
		}

		public OutFileImpl(java.io.File file, boolean append, boolean fail) throws IOException {
			if (fail && !file.exists()) {
				throw new IOException("File exists.");
			}
			out = new DataOutputStream(new FileOutputStream(file, append));
			this.file = file;
		}

		@Override
		public void flush() throws IOException {
			out.flush();
		}

		@Override
		public int available() throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public long len() {
			return java.lang.Math.max(filePointer, file == null ? 0 : file.length());
		}

		@Override
		public void close() throws IOException {
			out.close();
		}

		@Override
		public int read(byte[] arr) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object readn(String type) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public long position() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void position(long pos) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Override
		public void write(byte[] arr) throws IOException {
			out.write(arr);
		}

		@Override
		public void writen(Object data, String type) throws IOException {
			char t = type.charAt(0);
			switch (t) {
			case 'l':
				out.writeLong(((Number) data).longValue());
				break;
			case 'i':
				out.writeInt(((Number) data).intValue());
				break;
			case 's':
				out.writeShort(((Number) data).shortValue());
				break;
			case 'w':
				out.writeShort(((Number) data).shortValue() & 0xffff);
				break;
			case 'c':
				out.write(((Number) data).byteValue());
				break;
			case 'b':
				out.write(((Number) data).byteValue() & 0xff);
				break;
			case 'f':
				out.writeFloat(((Number) data).floatValue());
				break;
			case 'd':
				out.writeDouble(((Number) data).doubleValue());
				break;
			}
			throw new UnsupportedOperationException();
		}
	}

	public static class InOutFileImpl implements FileImpl {

		private RandomAccessFile inout;
		private java.io.File file;

		InOutFileImpl(java.io.File file) throws IOException {

			inout = new RandomAccessFile(file, "rw");
			this.file = file;
		}

		@Override
		public int available() throws IOException {
			return (int) (file.length() - inout.getFilePointer());
		}

		@Override
		public void flush() throws IOException {
		}

		@Override
		public long len() {
			return file.length();
		}

		@Override
		public void close() throws IOException {
			inout.close();
		}

		@Override
		public int read(byte[] arr) throws IOException {
			return inout.read(arr);
		}

		@Override
		public Object readn(String type) throws IOException {
			char t = type.charAt(0);
			switch (t) {
			case 'i':
				return inout.readInt();
			case 's':
				return inout.readShort();
			case 'w':
				return inout.readShort() & 0x0000ffff;
			case 'c':
				return inout.read();
			case 'b':
				return inout.read() & 0xff;
			case 'f':
				return inout.readFloat();
			case 'd':
				return inout.readDouble();
			}
			throw new UnsupportedOperationException();
		}

		@Override
		public long position() throws IOException {
			return inout.getFilePointer();
		}

		@Override
		public void position(long pos) throws IOException {
			inout.seek(pos);
		}

		@Override
		public void write(byte[] arr) throws IOException {
			inout.write(arr);
		}

		@Override
		public void writen(Object data, String type) throws IOException {
			char t = type.charAt(0);
			switch (t) {
			case 'l':
				inout.writeLong(((Number) data).longValue());
				break;
			case 'i':
				inout.writeInt(((Number) data).intValue());
				break;
			case 's':
				inout.writeShort(((Number) data).shortValue());
				break;
			case 'w':
				inout.writeShort(((Number) data).shortValue() & 0xffff);
				break;
			case 'c':
				inout.write(((Number) data).byteValue());
				break;
			case 'b':
				inout.write(((Number) data).byteValue() & 0xff);
				break;
			case 'f':
				inout.writeFloat(((Number) data).floatValue());
				break;
			case 'd':
				inout.writeDouble(((Number) data).doubleValue());
				break;
			}
			throw new UnsupportedOperationException();
		}
	}

	private FileImpl impl;

	public File(FileImpl impl) {
		super(CLASS);
		this.impl = impl;
	}

	public File(String path, String mode) throws IOException {
		super(CLASS);
		java.io.File file = new java.io.File(path);

		boolean read = false, write = false, update = false, append = false, fail = false, binary = false;

		for (char c : mode.toCharArray()) {
			if (c == 'r') {
				read = true;
			} else if (c == 'w') {
				write = true;
			} else if (c == '+') {
				update = true;
			} else if (c == 'a') {
				update = true;
			} else if (c == 'x') {
				fail = true;
			} else if (c == 'b') {
				binary = true;
			}
		}

		if (read && !write && !append && !update) {
			impl = new InFileImpl(file);
		} else if (!update && (write || append)) {
			impl = new OutFileImpl(file, append, fail);
		} else if (update) {
			impl = new InOutFileImpl(file);
		}
	}

	@Override
	public Object getObject() {
		return this;
	}

}
