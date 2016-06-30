local now = date();
foreach(key,val in now) {
	print("  n: " + key + " = " + val + "\n");
}

local home = getenv("HOME");
print("HOME: " + home + "\n");

system("ls -x");

local ttime = time();
print("time: " + ttime + "\n");

local cclock = clock();
print("clock: " + cclock + "\n");