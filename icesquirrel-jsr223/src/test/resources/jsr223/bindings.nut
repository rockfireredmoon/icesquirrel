print("A string: " + aString);
print("Another string: " + anotherString);
print("An integer: " + anInteger);
print("A long: " + aLong);
print("A short: " + aShort);
print("A byte: " + aByte);
print("A float: " + aFloat);
print("A double: " + aDouble);
local tot = anInteger + aLong + aShort + aByte + aFloat + aDouble;
local str = aString + anotherString;
print("tot: " + tot);
print("str: " + str);
return [str, tot];