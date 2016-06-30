function geny(n)
{
    for(local i=0;i<n;i+=1)
        yield i;
    return null;
}

local gtor=geny(10);
print("GTOR: " + gtor + "\n");
local x;
while((x=resume gtor) != null) { print(x+"\n"); }