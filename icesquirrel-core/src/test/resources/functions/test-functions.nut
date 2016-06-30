function withVarArgs(a, b, ...) {
	print("Do something " + a + " " + b);
}

function withArgsWithDefaults(a, b, c = 2) {
	print("Do something " + a + " " + b);
}

local a1 = withVarArgs(1, 2, 3, 4, 5, 6);
print(a1);

local a2 = withArgsWithDefaults(1, 2);
print(a2);

return [ a1, a2 ];

