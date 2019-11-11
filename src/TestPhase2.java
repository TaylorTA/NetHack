
public class TestPhase2 {

 public static void main(String[] args) {
  
  Tile[][] board = {
    {new Wall(), new  Wall(), new Wall(), new Wall()},
    {new Wall(), new  OpenSpace(new Trap()),  new  OpenSpace(new Amulet()), new Wall()},
    {new Wall(), new OpenSpace(new  Trap()), new OpenSpace(new HealthPotion()), new Wall()},
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
