/*translation of the methcall test from The Great Computer Language Shootout 
*/

print("this in script is " + this + "\n");

Toggle <- {
	bool=null
}

function Toggle::value() {
	return bool;
}

function Toggle::activate() {
	bool = !bool;
	return this;
}

function Toggle::new(startstate) {
	::print("this in Toggle::new is " + this + " " + this.len() + " items\n");
	local newo=clone this;
	newo.bool = startstate;
	return newo;
}

NthToggle <- {
	count_max=null
	count=0
}

function NthToggle::new(start_state,max_counter)
{
	local newo=delegate ::Toggle.new(start_state) : clone this;	
	newo.count_max <- max_counter
	return newo;
}

function NthToggle::activate () 
{
	count+=1
    if (count >= count_max) {
      bool = !bool;
      count = 0;
    }
    return this;
}


local n = ARGS.len()!=0?ARGS[0].tointeger():1

local val = 1;
local toggle = Toggle.new(val);
print("new toggle is : " + toggle + " " + toggle.len() + " items\n");
//val = toggle.activate().value();
for (local i=0; i<n; i+=1) {
  val = toggle.activate().value();
  
}
print(toggle.value() ? "true\n" : "false\n");

val = 1;
local ntoggle = NthToggle.new(val, 3);
for (local i=0; i<n; i+=1) {
  val = ntoggle.activate().value();
}
print("ternery val: " +  (ntoggle.value() ? "true\n" : "false\n") + "\n");
print("actual val: " + ntoggle.value() + "\n");
return ntoggle.value();