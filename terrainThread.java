import java.util.*;
public class terrainThread extends java.lang.Thread{
   
   static int SEQUENTIAL_CUTOFF = 600;
   public static int NUM_OF_THREADS = 0;
   public static ArrayList<grid> results;
   public static int COUNTER = 0;
   public int start;
   public int end;
   public int numCol;
   public grid[][] terrain;
   
   public terrainThread(grid[][] g, int start, int end, int numCol){
      this.terrain = g;
      this.start = start;
      this.end = end;
      this.numCol = numCol;
      results = new ArrayList<grid>();
      NUM_OF_THREADS++;
      //System.out.println("Thread number: "+NUM_OF_THREADS+"created");
   }
   //overiding run
   public void run(){
      //Stopping condition for divide and conquer 
      if(end-start < SEQUENTIAL_CUTOFF){
         for (int z=this.start+1;z< end-1;z++){
            for(int b =1;b< numCol -1;b++){
               //System.out.println("Checking for grid "+terrain[z][b]);
               if(terrainMinima.isMinima(terrain[z][b], terrain) == true){
                  this.COUNTER++;
                  results.add(terrain[z][b]);
               }
            }
         }
      }
      else{
         try{
            terrainThread top = new terrainThread(terrain,start,(start+end)/2,numCol);
            terrainThread bottom = new terrainThread(terrain,(start+end)/2,end,numCol);
            top.start();
            bottom.run();
            top.join();
         }
         catch (InterruptedException e) {
			   e.printStackTrace();
		   }

      }
   }
   
}
   