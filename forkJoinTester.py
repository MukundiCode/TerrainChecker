import os
files = ["small_in.txt","med_in.txt","large_in.txt"]
#javaP = ["terrainMinima","terrainParallel","terrainForkJoin"]
java = "terrainForkJoin"
testResults = open("testResults.txt","w")
for file in files:
    testResults.write(file + "\n")
    print(file+"\n")
    #os.system("echo "+file+" >> TestOutputForkJoin")
    for i in range(1,13):
        sequentialCutoff = i*50
        #testResults.write("SequentialC,"+str(sequentialCutoff)+"\n")
        print("SequentialC,"+str(sequentialCutoff))
        total = 0;
        for x in range(20):
            os.system("java "+java+" "+file+" "+str(sequentialCutoff)+" "+">> TestOutputForkJoin")
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
        testResults.write(str(sequentialCutoff)+","+str(average)+"\n")
        print(str(sequentialCutoff)+","+str(average))
testResults.close()
            
            
            
            