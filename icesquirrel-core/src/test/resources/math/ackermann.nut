/*
*
* Original Javascript version by David Hedbor(http://www.bagley.org/~doug/shootout/)
*
*/
print(1)

ZA <- "XX";

function zz() {
	return 2;
}

function Ack(M, N) {
	print("in Ack " + M + "," + N + "\n");
    if (M == 0) {
    	return( N + 1 );
    }
    print("zz = " + zz() + " ZA: " + ZA + " ::ZA " + ::ZA + "\n");
    if (N == 0) {
    	return( Ack(M - 1, 1) );
    }
    return( Ack(M - 1, Ack(M, (N - 1))) );
}

local n;

if(ARGS.len()!=0) {
	n = ARGS[0].tointeger();
  	if(n < 1) { 
  		n = 1;
  	}
} else {   
	n = 1;
}

print("n="+n+"\n");
local ack = Ack(3, n);
print("Ack(3,"+ n+ "):"+ ack + "\n");

return ack;
