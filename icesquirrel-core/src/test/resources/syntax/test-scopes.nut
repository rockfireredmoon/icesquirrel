print("script this: " + this + "\n");
print(":: : " + getroottable() + "\n");

// Global
::A <- "67";
::B <- {
	C = "341",
	D = "890"
};
C <- "999";

// Local
local A = "1";
local B = {};
B["C"] <- 520;
B["D"] <- "Huh?";

print(C + "\n");
C = "998";
print(C + "\n");
local C = 5;
print(C + "\n");
C = "999";
print(C + "\n");
local localOnly = true;

// Local function

local lFunction = function() {
	return "LF230";
}

function cFunction() {
	return "CF887";
}

function bFunction() {
	return "B66";
}

function aFunction(B) {
	// B and A are both local to this function
	// this refers to environment the function is in (i.e. the global table)
	local A = "L981"; 
	local XXXX = C;
	print("this: " + this + "\n");
	//print("parent: " + this.parent + "\n");
	print("    aFunction this.a             : " + this.A + "\n");
	print("    aFunction B[C]               : " + B["C"] + "\n");
	print("    aFunction A                  : " + A + "\n");
	print("    aFunction C                  : " + C + "\n");
	print("    aFunction this.bfunction     : " + this.bFunction() + "\n");
	print("    aFunction cfunction          : " + cFunction() + "\n");
	return this.A + B["C"] + A + C + this.bFunction() + cFunction();
}

/*

// 'this' is the root table in the script
print("Script (this)        : " + this.A + "\n");
print("                       " + this.B + "\n");
print("                       " + this.C + "\n");

// no scope is the current environment (local)
print("Script (no scope)    : " + A + "\n");
print("                       " + B + "\n");
print("                       " + C + "\n");
print("Script (global scope): " + ::A + "\n");
print("                       " + ::B + "\n");
print("                       " + ::C + "\n");
*/

local F = aFunction({C = "F720"});
print("A Function: " + F + "\n");
local R = "A=" + A + ",B.C=" + B.C + ",B.D=" + B.D + ",C=" + C + ",this.A=" + this.A + ",this.B[\"C\"]=" + this.B["C"] + ",this.B[\"D\"]=" + this.B["D"] + ",this.C=" + this.C + ",::B[\"C\"]=" + ::B["C"] + ",::B[\"D\"]=" + ::B["D"] + ",::C=" + ::C + ",F=" + F;
print("Result: " + R +"\n");
return R;
