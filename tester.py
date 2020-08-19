import os
files = ["small_in.txt","med_in.txt","large_in.txt"]
javaP = ["terrainMinima","terrainParallel","terrainForkJoin"]
for java in javaP:
    os.system("echo "+java+" >> TestOutput"
    for file in files:
        os.system("echo "+file+" >> TestOutput")
        for i in range(20):
            os.system("java "+java+" "+file+">> TestOutput")