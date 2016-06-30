local arr=["one","two","three"]
local done = 0;

::print("FOREACH\n");

foreach(i,val in arr)
{
	::print("index ["+i+"]="+val+"\n");
}
::print("FOR\n");
done++;

for(local i=0;i<arr.len();i+=1)
{
	::print("index ["+i+"]="+arr[i]+"\n");
}
done++;

::print("WHILE\n");

local i=0;
while(i<arr.len())
{
	::print("index ["+i+"]="+arr[i]+"\n");
	i+=1;
}
done++;
::print("DO WHILE\n");

local i=0;
do
{
	::print("index ["+i+"]="+arr[i]+"\n");
	i+=1;
}while(i<arr.len());
done++;

return done;