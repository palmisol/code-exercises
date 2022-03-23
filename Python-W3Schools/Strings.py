s = "Hello, World!"

# String Array

print(s[1])

# Loop through a String

for ch in s:
    print(ch)

# Check String

b = "Hello" in s
b = "Hello" not in s
print(b)

# Slicing a String

print(s[2:5])  # llo
print(s[:5])  # Hello
print(s[2:])  # llo, World!
print(s[-5:-2])  # orl

# Upper and Lower case

s.upper()
s.lower()
s.strip()  # Removes any whitespaces from the beginning or end
s.replace("H", "J")
s.split(",")

t = 'I want {0} pieces of item {1} for {2} dollars.'
print(t.format(3, 567, 49.95))
