import random
#program takes in a a number, for size, and a file name and creates a file like the one for assignment
size = input("Enter the size of the matrix: ")
#fileName = input("enter the name of the file: ")
fileName = "gridTest.txt"
#creating the file 
file = open(fileName, "w")
file.write(str(size)+" "+str(size)+"\n")
for i in range(int(size)**2):
    file.write(str(round(random.random(),2) + random.randint(100,1800))+" ")
print("Done")