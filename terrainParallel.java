import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class terrainParallel{
   public static grid[][] terrain;

   public static void main(String args[])throws FileNotFoundException{
      //The first step is to take in the file
      String fileName = "large_in.txt";
      Scanner input = new Scanner(System.in);
      Scanner fileIn = new Scanner(new File(fileName));
      Scanner firstLine = new Scanner(fileIn.nextLine());
      int numRows = firstLine.nextInt();
      int numCol = firstLine.nextInt();
      terrain = new grid[numRows][numCol];
      //i have created the 2d array, now to create objects and put them in the array
      for(int x = 0;x<numRows;x++){
         Scanner line = new Scanner(fileIn.nextLine());
         for(int y = 0;y<numCol;y++){
            double height = Double.parseDouble(line.next());
            grid g = new grid(height,x,y);
            terrain[x][y] = g;
            }
         }
      //creating the threads
      try{
         long StartTime = System.currentTimeMillis();
         runThreads(6,terrain,numRows,numCol);
         long EndTime = System.currentTimeMillis();
         System.out.println("Time taken was: "+(EndTime - StartTime)+" milliseconds");
         }
      catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
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