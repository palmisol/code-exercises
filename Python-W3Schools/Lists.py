myList = ["item1", "item2", "item3"]
myList2 = list(("item4", "item5", "item6"))
len(myList)
type(myList)
myList.append("newItem")  # add an item to the tale
myList.insert(1, "newItem")  # Insert an item
myList.extend(myList2)
myList.remove("item2")
myList.pop(1)  # Removes the item if an index is specified or the last item
del myList  # Deletes the whole list
# myList.clear()  # Clears the whole list

# Loop through a list
for item in myList:  # loop through each item
    print(item)
for i in range(len(myList)):  # loop using indexes
    print(myList[i])
j = 0
while j < len(myList):
    print(myList[j])
    j = j + 1

[print(x) for x in myList]  # shortcut for printing all the items in a list

fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
newList = []

for fruit in fruits:
    if 'a' in fruit:
        newList.append(fruit)
# OR

newList = [fruit for fruit in fruits if 'a' in fruit]  # Add fruits containing letter a
newList = [fruit for fruit in fruits if fruit != 'apple']  # Add only fruits containing apple
newList = [fruit for fruit in fruits]  # Add all fruits

# ITERABLE

newIterableList = [item for item in range(10)]  # 1,2,3,4,5,6,7,8,9
print(newIterableList)

newIterableList = [item for item in range(10) if item < 5]

# Expressions
fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
newList = [item.upper() for item in fruits]

fruits = ["apple", "banana", "cherry", "kiwi", "mango"]
newList = [item
           if item != "banana" else "orange"
           for item in fruits]

# SORTING

fruits.sort()
fruits.sort(reverse=True)


def my_function(n):
    return abs(n - 50)


this_list = [100, 50, 65, 82, 23]
this_list.sort(key=my_function)

thislist = ["banana", "Orange", "Kiwi", "cherry"]
thislist.sort(key=str.lower)

thislist.reverse()

# COPY lists to create an instance of a list instead of a reference

new_list = this_list.copy()

