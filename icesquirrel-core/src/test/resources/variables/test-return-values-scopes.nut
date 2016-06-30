local d = 1 + 2 + 3
local e = 6666 + 78
print(d + "\n");
local arg="SomeValueToIgnore";

local a = 20;
::b <- 30;
::c <- 40;
local e = a + b + ( c + d );
b = 2;

function testy(arg) {
	print("arg: " + arg + "\n");
    local a=10;
    local z = arg +  ( this.b + this.c );
    return arg +  ( this.b + this.c );
}

local z = testy(e);
print("e = " + e + " z = " + z + "\n"); 
return z;

