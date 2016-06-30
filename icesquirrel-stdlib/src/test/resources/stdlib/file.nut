local myfile = file("src/test/resources/stdlib/file.nut", "r");
local flen = myfile.len();
print(format("len: %s\n",  flen));
myfile.close();

local res = dofile("src/test/resources/stdlib/file2.nut");

local func = loadfile("src/test/resources/stdlib/file2.nut");
local res2 = func();

local result = flen + "," + res + "," + res2;
print(format("Result: %s\n", result));
return result; 