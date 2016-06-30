local thisIsScriptLocal = "A_Script_Local";
this.A <- "somethingAtRoot";

function teststack(arg)
{
	local aFunctionLocal = "A_Function_Local";
	local zz = { A = "2", B = "C" };
}

teststack("10");
print(::A);
