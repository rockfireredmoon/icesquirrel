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

return n;