
;

;
;
local arg="SomeValueToIgnore";
local a = 20;





function testy(arg)
{
    local a=10;
    print("ARG: " + arg + " A: " + a + "\n");
    return arg;
};
	
return testy(a);
