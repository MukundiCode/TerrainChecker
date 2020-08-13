import java.util.concurrent.ForkJoinPool; 
import java.util.concurrent.RecursiveTask;
import java.util.*;
import java.util.concurrent.RecursiveAction;
public class forkJoinThread extends RecursiveAction {

   static int SEQUENTIAL_CUTOFF = 200;
   public static int NUM_OF_THREADS = 0;
   public ArrayList<grid> results;
   public int start;
   public int end;
   public int numCol;
   public grid[][] terrain;
   
   public forkJoinThread(grid[][] g, int start, int end, int numCol){
      this.terrain = g;
      this.start = start;
      this.end = end;
      this.numCol = numCol;
      results = new ArrayList<grid>();
      NUM_OF_THREADS++;
      //System.out.println("Thread number: "+NUM_OF_THREADS+"created");
   }
   //overiding compute
   public void compute(){
      //Stopping condition for divide and conquer 
      if(end-start < SEQUENTIAL_CUTOFF){
         int counter = 0;
         for (int z=this.start+1;z< end-1;z++){
            for(int b =1;b< numCol -1;b++){
               //System.out.println("Checking for grid "+terrain[z][b]);
               if(terrainMinima.isMinima(terrain[z][b], terrain) == true){
                  counter++;
                  System.out.println(terrain[z][b]);
               }
            }
         }
      }
      else{
       //  try{
           forkJoinThread top = new forkJoinThread(terrain,start,(start+end)/2,numCol);
           forkJoinThread bottom = new forkJoinThread(terrain,(start+end)/2,end,numCol);
           top.fork();
           bottom.compute();
           top.join();
    /*     }
         catch (InterruptedException e) {
			   e.printStackTrace();
		   } */

      }
   }
}
