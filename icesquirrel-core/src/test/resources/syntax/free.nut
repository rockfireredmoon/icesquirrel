local a = 1;
local b = 1;

function withFreeVar(x,v):(a,b) {
	print("in func: x=" + x + " v=" + v + " a=" + a + " b=" + b + "\n");
	return x + v + a + b;
}

a = 2;
b = 3;

local z = withFreeVar(6, 98);
print("result: " + z + "\n");
return z;