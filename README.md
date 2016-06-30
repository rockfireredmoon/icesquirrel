# icesquirrel
A Java implementation of the Squirrel scripting language.
## Summary
This is a pure Java implementation of the [Squirrel](http://www.squirrel-lang.org/) scripting language. It is NOT a binding to native Squirrel runtime and libaries. While it is relatively complete and will run many Squirrel scripts without modification, it is not the best alternative if you want performance or compliance. 

Originally written as an experiment to run a game client which was largely scripted, in the end a different approach was taken that does not rely on Squirrel scripts so heavily, although parts of Icesquirrel are still used (Squirrel tables are used to store a lot of game data, and there are some user scripting requirements).

It was also started around Java 7, before the modern JVM dynamic language support was available, so doesn't take advantage of this in any way. Scripts are run entirely interpreted, although classes may be serialized to reduce parsing time.

Development is likely to be slow, although I would one day like to see it complete. 
