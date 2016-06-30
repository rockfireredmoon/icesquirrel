print("This should come out on console");
local clazz = "Boo";
print("CLASS\n");
print(clazz);

class BClass {
	function DoSomething() {
		print("I AM DOING SOMETHING!\n");
	}
	
	function DoSomethingElse() {
		print("This should NOT come out on console\n");
	}
}

function outsideAFunction(a,b,c) {
	print("Im outside!");
	// Some function
	b.DoSomething();
}

outsideAFunction(1,BClass(),3);
