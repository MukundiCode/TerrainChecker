import os
files = ["small_in.txt","med_in.txt","large_in.txt"]
java = "terrainMinima"
testResults = open("testResultsSeriel.txt","w")
for file in files:
    testResults.write(file + "\n")
    print(file+"\n")
    total = 0
    for x in range(20):
        os.system("java "+java+" "+file+" >> TestOutputForkJoin")
        #getting the average for this sequental cutoff out of 20 runs
    f = open("TestOutputForkJoin","r")
    for lines in f:
        items = lines.split(",")
        total = total +  int(items[0])
    average = total/20
    #clearing the current file
    f.close()
    ff = open("TestOutputForkJoin","w")
    #creating file to write items
    testResults.write(str(average)+"\n")
    print(str(average))
testResults.close()