local a = 10;
local b = 20;
local passes = 0;

// Equals
if(a == b)
	print("10 = 20. Fail");
else { 
	print("10 != 20. Pass");
	passes = passes + 1;
}

a = 5;
b = 15;

// Not equals
if(a != b) {
	print("5 != 15. Pass\n");
	passes = passes + 1;
}
else {
	print("5 == 15. Fail\n");
}

// In
local alist = { a1 = "a1", a2 = "a2", a3 = "a3" };
local aitem = "a1";
if(aitem in alist) {
	print("a1 in a1,a2,a3. Pass\n");
	passes = passes + 1;
}
else {
	print("a1 not in a1,a2,a3. Fail\n");
}

// Instance of TODO");
local ca, ck;
ca = ( ck=1,ck+2 ); //a becomes 3
if(ca == 3) {	
	print("1+2=3. Pass\n");
	passes = passes + 1;
}
else {	
	print("1+2=3. Fail (" + ca + ")\n");
}

	
return passes;
