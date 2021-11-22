import math
import re

#Q1
def previousNumbers(num):
    n = 0
    while n < num:
        print(n, end= ' ')
        n += 1

print("\nPrevious Numbers:")
previousNumbers(10)

#Q2 Lucas Numbers
# a)
def lucasNumbers(num):
    if num < 0:
        return -1

    n1, n2 = 2, 1
    count = 0
    l = []
    while count < num:
        l.append(n1)
        n1, n2 = n2, n1 + n2
        count += 1
    
    return l

print("\n\nLoop Lucas:")
lucasList = lucasNumbers(10)
for x in lucasList:
    print(x, end= ' ')

# b)
def genLucasNumbers(num):
    if num < 0:
        return -1

    n1, n2 = 2, 1
    count = 0
    while count < num:
        yield n1
        n1, n2 = n2, n1 + n2
        count += 1



print("\n\nGenerator Lucas:")
for n in genLucasNumbers(10):
    print(n, end= ' ')


#Q3

def listSetCreator(sequence):
    l1 = list(sequence)
    l2 = []
    for d in l1:
        if d not in l2:
            l2.append(d)

    return l2

def setCreator(sequence):
    s = { sequence[0] }
    l = list(sequence)
    for n in l:
        s.add(n)

    return s

print("\n\nSet Creator:")
print(setCreator([1, 2, 3, 4, 6, 2, 3, 1, 4, 7]))
print(listSetCreator([1, 2, 3, 4, 6, 2, 3, 1, 4, 7]))

#Q4

class Multiset:
    def __init__(self):
        self.set = []

    def __add__(self, other):
        return self.set.append(other)
    
    def __truediv__(self, other):
        return self.set.remove(other)

    def m(set, repNum):
        counter = 0
        for n in set.set:
            if n == repNum:
                counter += 1
        
        return counter

    def union(self, other):
        newSet = self.set
        for n in other:
            if n not in newSet:
                newSet.append(n)
        return newSet
    
    def Inter(self, other):
        return 1

    def __sub__(self, other):
        for n in other:
            if n in self.set:
                self.set.remove(n)



multiset = Multiset()
multiset.set = [ 2, 5, 5, 5, 8, 9, 9, 7 ]
multiset + 3
print(multiset.set)
print(Multiset.m(multiset, 5))
unionset = Multiset()
unionset.set = [ 1, 2 ]
print(unionset.union([2, 2, 3]))
multiset - [2, 5, 8, 7]
print(multiset.set)

#Q5

class Shape:
    _id = 1
    def __init__(self):
        self.id = Shape._id
        Shape._id += 1
        #self.perimeter = 0
        #self.area = 0

    def print(self):
        print("> ID: " +  str(self.id) + " - name: " + type(self).__name__ + " | perimeter: " + str(self.perimeter()) + " Area: ", str(self.area()))

    def perimeter(self):
        return None 

    def area(self):
        return None

class Circle(Shape):
    def __init__(self, radius):
        super(Circle, self).__init__()
        self.radius = radius

    def perimeter(self):
        return 2 * math.pi * self.radius
    
    def area(self):
        return math.pi * self.radius ** 2

class Elipse(Shape):
    def __init__(self, a, b):
        super(Elipse, self).__init__()
        if a > b:
            self.semimajor = a
            self.semiminor = b
        else:
            self.semimajor = b
            self.semiminor = a

    def area(self):
        return math.pi * self.semimajor * self.semiminor

    def eccentricity(self):
        try:
             math.sqrt(self.semimajor ** 2 - self.semiminor ** 2)
        except:
            return None
        else:
            return math.sqrt(self.semimajor ** 2 - self.semiminor ** 2)

class Rhombus(Shape):
    def __init__(self, p, q):
        super(Rhombus, self).__init__()
        self.p = p
        self.q = q   

    def perimeter(self):
        return 4 * (math.sqrt(self.p ** 2 + self.q ** 2))

    def area(self):
        return (self.p * self.q) / 2

    def inradius(self):
        try:
            self.p * self.q / (2 * math.sqrt(self.p ** 2 + self.q ** 2))
        except:
            return None
        else:
            return self.p * self.q / (2 * math.sqrt(self.p ** 2 + self.q ** 2))


#rombus = Rhombus(4, 5)
#circle = Circle(3)
#ellipse = Elipse(5, 6)

#circle.print()
#ellipse.print()
#rombus.print()

#Q6

file = open("Shapes.txt", "r")

for l in file.readlines():
    line = l.split()
    
    if re.search("shape", l):
        shape = Shape()
        shape.print()
    elif re.search("circle", l):
        circle = Circle(int(line[1]))
        circle.print()
    elif re.search("ellipse", l):
        numA = int(line[1])
        numB = int(line[2])
        if numA > 0 or numB > 0:
            elipse = Elipse(numA, numB)
            elipse.print()
            print("linear eccentricity: " + str(elipse.eccentricity()))
        else:
            print("Invalid ellispe")
    elif re.search("rhombus", l):
        if int(line[1]) > 0 or int(line[2]) > 0:
            rhombus = Rhombus(int(line[1]), int(line[2]))
            rhombus.print()
            print("in-radius: " + str(rhombus.inradius()))
        else:
            print("Invalid Rhombus")
            
file.close()

#Q7