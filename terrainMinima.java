import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class terrainMinima{

   public static grid[][] terrain;
   
   public static void main(String args[])throws FileNotFoundException{
      //The first step is to take in the file
      String fileName = "test.txt";
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
            float height = Float.parseFloat(line.next());
            grid g = new grid(height,x,y);
            terrain[x][y] = g;
            //System.out.print(terrain[x][y]+" ");
            }
         //System.out.println();
         }
      //checking for minimas
      int counter = 0;
      for (int z=1;z< numRows - 1;z++){
         for(int b =1;b< numCol -1;b++){
            if(isMinima(terrain[z][b], terrain) == true){
               counter++;
               System.out.println(terrain[z][b]);
            }
         }
      }
      System.out.print(counter);
   }
      
   public static boolean isMinima(grid g, grid[][] a){
      boolean minima = true;
      int r = g.p.row;
      int c = g.p.column;
      //creating a list of all neighboring items
      grid[] list = {a[r-1][c-1], a[r-1][c], a[r-1][c+1], a[r][c+1], a[r+1][c+1], a[r+1][c], a[r+1][c-1], a[r][c-1]};
      //checking if this grid is a minima
      for (int i=0; i<8 ;i++){
         if (list[i].height - g.height < 0.01){
            minima = false;
            break;
            }
         else{
            continue;
         }
         }
      return minima;
      }
      
}
            
            