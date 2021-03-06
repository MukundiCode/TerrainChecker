import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool; 
public class terrainForkJoin {
   public static grid[][] terrain;
   public static final ForkJoinPool fjPool = new ForkJoinPool();

   public static void main(String args[])throws FileNotFoundException{
      //The first step is to take in the file
      String fileName = args[0];
      forkJoinThread.SEQUENTIAL_CUTOFF = Integer.parseInt(args[1]);
      Scanner input = new Scanner(System.in);
      Scanner fileIn = new Scanner(new File(fileName));
      Scanner firstLine = new Scanner(fileIn.nextLine());
      int numRows = firstLine.nextInt();
      int numCol = firstLine.nextInt();
      terrain = new grid[numRows][numCol];
      //i have created the 2d array, now to create objects and put them in the array
      Scanner line = new Scanner(fileIn.nextLine());
      for(int x = 0;x<numRows;x++){
         for(int y = 0;y<numCol;y++){
            float height = Float.parseFloat(line.next());
            grid g = new grid(height,x,y);
            terrain[x][y] = g;
            }
         }
         long StartTime = System.currentTimeMillis();
         ForkJoinPool.commonPool().invoke(new forkJoinThread(terrain,1,numRows-1,numCol-1));
         long EndTime = System.currentTimeMillis();
         System.gc();
         //System.out.println("Time taken was: "+(EndTime - StartTime)+" milliseconds");
         System.out.println((EndTime - StartTime)+","+forkJoinThread.COUNTER);
         //System.out.println("The total number of threads is "+forkJoinThread.NUM_OF_THREADS);
         //System.out.println(forkJoinThread.COUNTER);
         System.out.println(forkJoinThread.results.size());
    //     forkJoinThread.results.forEach((n) -> System.out.println(n));
      
      }
      public static void runThreads(int numOfThreads, grid[][] g, int numRows, int numCol)throws InterruptedException{
         terrainThread[] threads = new terrainThread[numOfThreads];
         for (int i=0;i<numOfThreads;i++){
            threads[i] = new terrainThread(g,(i*numRows)/numOfThreads,((i+1)*numRows)/numOfThreads,numCol);
            threads[i].start();
            }
         for (int x=0;x<numOfThreads;x++){
            threads[x].join();
            }
      }
}