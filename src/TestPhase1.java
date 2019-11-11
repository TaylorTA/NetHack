
public class TestPhase1 {

 public static void main(String[] args) {
  
  Tile[][] board = {
    {new Wall(), new  Wall(), new Wall(), new Wall()},
    {new Wall(), new  OpenSpace(), new OpenSpace(), new Wall()},
    {new Wall(), new  OpenSpace(), new OpenSpace(), new Wall()},
    {new Wall(), new  Wall(), new Wall(), new Wall()},
  };
  
  for (Tile[] row : board) {
   for (Tile t: row) {
    System.out.print(t.getSymbol());
   }
   System.out.println();
  }

 }

}
