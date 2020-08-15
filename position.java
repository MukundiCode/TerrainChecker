public class position{
   public int row;
   public int column;
   
   position (int row, int column){
      this.row = row;
      this.column = column;
      }
      
   public String toString(){
      return Integer.toString(this.row) + " " + Integer.toString(this.column);
      }
}