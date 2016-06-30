local ex = regexp(@"(\d+) ([a-zA-Z]+)(\p)");
local string = "stuff 123 Test;";
local res = ex.capture(string);
foreach(i,val in res)
{
	print(format("match number[%02d] %s\n",
			i,string.slice(val.begin,val.end))); //prints "Test"
}