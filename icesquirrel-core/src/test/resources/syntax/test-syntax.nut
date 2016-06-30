1,2,3;

A <- {};
A["A"] <- {
	B = "C",
	["D"] = ("G", "F", "E"),
	[1] = "E",
	["1" + "2"] = "Q",
	F = ["A", "B", "C", "D" ]
};


A[1] <- 2;
A[["A","B"]] <- { };
A["Z"] <- { B = "E" };
A[("A" + "B")] <- { B = "E" };

// TODO VVV This bit breaks!
print(A["A"]["B"] + "\n");
print(A["A"]["D"] + "\n");
print(A["A"].F[3] + "\n");
print(A["A"]["12"] + "\n");
return A["A"]["B"];
