import java.util.*;
public class terrainThread extends java.lang.Thread{
   
   public ArrayList<grid> results;
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
   }
   //overiding run
   public void run(){
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
      //System.out.println(counter);
   }
   
}
   