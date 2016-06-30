// Integer (Java long)
local a = 34456787;
local a1 = 7;
local a2 = 45;
local a3 = 783;
print("a = " + a + " a1 = " + a1 + " a2 = " + a2 + " a3 = " + a3 + "\n");

// Integer hex
local aHex = 0xff0000;
print("aHex = " + aHex + "\n");

// Integer octal
local aOctal = 0753;
print("aOctal = " + aOctal + "\n");


// Integer number
local aChar = 'a';
print("aChar = " + aChar + "\n");

// Float 
local aFloat = 1.52;
print("aFloat = " + aFloat + "\n");

// Float E
local aFloatE = 1.e2;
print("aFloatE = " + aFloatE + "\n");

// Float E-
local aFloatEN = 1.e-2;
print("aFloatEN = " + aFloatEN + "\n");

// String
local aString = "I'm a string";
print("aString = " + aString + "\n");


local isTrue = true;
print ("isTrue = " + isTrue + "\n");

local isFalse = false;
print ("isFalse = " + isFalse + "\n");

local isNull = null;
print ("isNull = " + isNull + "\n");

local anArray = [ "a1", "a2", "a3" ] ;
print ("anArray = " + anArray + "\n");

local aMultiline = @"
	this is a multiline string
	it will ""embed"" all the new line
	characters
";
print("aMultiline = " + aMultiline + "\n");

return [ a, a1, a2, a3, aHex, aOctal, aChar, aFloat, aFloatE, aFloatEN, aString, isTrue, isFalse, isNull, anArray, aMultiline ];
