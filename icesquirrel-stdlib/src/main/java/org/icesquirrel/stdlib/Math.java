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

import java.util.Random;

import org.icesquirrel.runtime.Function;
import org.icesquirrel.runtime.SquirrelExecutionContext;

public class Math {
	final static String X = "x";
	final static String Y = "y";

	private final static Random RANDOM = new Random();

	@Function
	public static Number abs(Number number) {
		if (number instanceof Integer) {
			return java.lang.Math.abs(number.intValue());
		} else {
			return java.lang.Math.abs(number.longValue());
		}
	}

	@Function
	public static Number acos(Number number) {
		return java.lang.Math.acos(number.doubleValue());
	}

	@Function
	public static Number asin(Number number) {
		return java.lang.Math.asin(number.doubleValue());
	}

	@Function
	public static Number atan(Number number) {
		return java.lang.Math.asin(number.doubleValue());
	}

	@Function
	public static Number atan2(Number a, Number b) {
		return java.lang.Math.atan2(a.doubleValue(), b.doubleValue());
	}

	@Function
	public static Number ceil(Number number) {
		return java.lang.Math.ceil(number.doubleValue());
	}

	@Function
	public static Number cos(Number number) {
		return java.lang.Math.cos(number.doubleValue());
	}

	@Function
	public static Number exp(Number number) {
		return java.lang.Math.exp(number.doubleValue());
	}

	@Function
	public static Number fabs(Number number) {
		return java.lang.Math.abs(number.doubleValue());
	}

	@Function
	public static Number floor(Number number) {
		return java.lang.Math.floor(number.doubleValue());
	}

	@Function
	public static Number log(Number number) {
		return java.lang.Math.log(number.doubleValue());
	}

	@Function
	public static Number log10(Number number) {
		return java.lang.Math.log10(number.doubleValue());
	}

	@Function
	public static Number pow(Number x, Number y) {
		return java.lang.Math.pow(x.doubleValue(), y.doubleValue());
	}

	@Function
	public static Number tan(Number number) {
		return java.lang.Math.tan(number.doubleValue());
	}

	@Function
	public static Number sin(Number number) {
		return java.lang.Math.sin(number.doubleValue());
	}

	@Function
	public static Number sqrt(Number number) {
		return java.lang.Math.sqrt(number.doubleValue());
	}

	@Function
	public static Number rand() {
		return RANDOM.nextDouble()
				* ((Number) SquirrelExecutionContext.get().getRuntime().getBuiltInFunctions().get("RAND_MAX")).doubleValue();
	}

	@Function
	public static boolean srand(Long seed) {
		RANDOM.setSeed(seed);
		return true;
	}
}
