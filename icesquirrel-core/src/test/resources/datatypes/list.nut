/*translation of the list test from The Great Computer Language Shootout 
*/

function compare_arr(a1,a2)
{
	foreach(i,val in a1)
		if(val!=a2[i])return null;
	return 1;	
}

function test()
{
	local size=10000
	print("resizing to " + size + "\n");
	local l1=[]; l1.resize(size);
	print("filling " + size + "\n");
	for(local i=0;i<size;i+=1) l1[i]=i;
	print("cloning\n");
	local l2=clone l1;
	local l3=[]
	
	print("reversing\n");
	l2.reverse();
	print("reversed\n");
	print("l2\n");
	while(l2.len()>0) {
		l3.append(l2.pop());
	}
	print("l3\n");
	while(l3.len()>0)
		l2.append(l3.pop());
	print("reversing again\n");
	l1.reverse();
	print("reversed again, comparing\n");
	if(compare_arr(l1,l2)) {
		return l1.len();
	}
	return null;
}

local n = ARGS.len()!=0?ARGS[0].tointeger():1
for(local i=0;i<n;i+=1)
	if(!test())
	{
		print("failed");
		return;
	}
	else
	{
		print("test ok\n");
	}
	
print(" oki doki");
return true;