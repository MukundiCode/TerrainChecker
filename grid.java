import java.util.*;
/* The grid class containts one grid box
*/
public class grid {
   public double height;
   public position p;
   public ArrayList<position> neighbors;
   
   public grid(double height ,int r,int c){
      this.height = height;
      this.p = new position(r,c);
      this.neighbors = new ArrayList<position>();
      }
      
   public void addNeighbor(position n){
      neighbors.add(n);
      }
   public String toString(){
      return p.toString();
      }
}