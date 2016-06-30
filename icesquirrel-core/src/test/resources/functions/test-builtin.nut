enabledebuginfo(true);


local anArray = array(10, [ "a1", "a2" ]);
print(anArray + "\n");

local filledArray = array(20, anArray);
print(filledArray + "\n");

enabledebuginfo(false);
print("do some stuff!\n");
enabledebuginfo(true);
print("do some more stuff!\n");
print("do yet  more stuff!\n");
print("and do yet  more stuff!\n");

::a <- "SomeVal";
print("::a = " + getroottable()["a"] + "\n");

//const aConst = 55;
//print("aConst = " + getconsttable()["aConst"]);

local f = compilestring("local z = 22 ; return z");
print("script: " + f() + "\n");

class SomeClass {
}
local instance = SomeClass();

print("int " + type(1) + "\n");
print("str " + type("str") + "\n");
print("tab " + type({ a = 1, b = 2}) + "\n");
print("arr " + type(["1", "2"]) + "\n");
print("flo " + type(1.2) + "\n");
print("bool " + type(true) + "\n");
print("null " + type(null) + "\n");
print("func " + type(f) + "\n");
print("clazz " + type(SomeClass) + "\n");
print("instance " + type(instance) + "\n");

print("gc: " + collectgarbage() + "\n");

local ff = function() {
	print(getstackinfos(0) + "\n");
};
ff();

return true;
