"""
Text Type:	str
Numeric Types:	int, float, complex
Sequence Types:	list, tuple, range
Mapping Type:	dict
Set Types:	set, frozenset
Boolean Type:	bool
Binary Types:	bytes, bytearray, memoryview
"""

x = ["apple", "banana", "cherry"] #List
x = ("apple", "banana", "cherry") #Tuple -> you cannot change, add or remove items. It also allows duplicates 
x = range(3,20,2) #Range -> Start index included, last index not included, step

x = {"name" : "Jhon", "age" : 36} #Dic -> Key value type of storing 
x = {"apple", "banana", "cherry"} #Set -> Multiple variables in a single variable. Unordered, Unchangable, unindexed, no duplicates
x = frozenset({"apple", "banana", "cherry"}) #Frozenset

