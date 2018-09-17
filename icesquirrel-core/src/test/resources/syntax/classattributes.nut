//attributes of Foot

class Foo </ classtest = "freakin class attribute"/> {
	//constructor
	</ contest = "freakin constructor attribute"/> 
	constructor(a)
	{
		testy = ["stuff",1,2,3];
	}
	//attributes of PrintTesty
	</ test = "freakin attribute"/>
	function PrintTesty()
	{
		foreach(i,val in testy)
		{
			::print("idx = "+i+" = "+val+" \n");
		}
	}
	//attributes of testy
	</ flippy = 10 , second = [1,2,3] />
	testy = null;
	
	
	function None() {
	}
}

local count = 0;
foreach(member,val in Foo)
{
	::print(member+"\n");
	local attr = Foo.getattributes(member);
	::print("attr: " + attr +"\n");
	if(attr != null) {
	//if((attr = Foo.getattributes(member)) != null) {
		foreach(i,v in attr)
		{
			count++;
			::print("\t"+i+" = "+(typeof v)+"\n");
		}
	}
	else {
		::print("\t<no attributes>\n")
	}
}
print(count + "\\n");
return count;