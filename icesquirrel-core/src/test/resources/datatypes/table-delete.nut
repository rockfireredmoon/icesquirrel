a <- {
    test1=1234
    deleteme="now"
}

delete a.test1
local z = delete a.deleteme ; //this will assign to the string "now"
print ("delete: " + z);
return z;