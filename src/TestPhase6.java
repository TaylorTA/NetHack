import java.util.Scanner;

public class TestPhase6 {

 public static void main(String[] args) {
  Gameboard board = new Gameboard("phase6GameBoard.txt");
  System.out.println("Welcome to NetHack, 1020 edition.");

  Scanner keyboard = new Scanner(System.in);
  String input;
  while (!board.getDone()) {
   System.out.println(board);
   System.out.println("Which way would you like to move?");
   System.out.println("Valid commands are up, down, left, right.");
   input = keyboard.nextLine();
   if (input.equals("up") || input.equals("u"))
    board.doRound(Gameboard.UP);
   if (input.equals("down") || input.equals("d"))
    board.doRound(Gameboard.DOWN);
   if (input.equals("left") || input.equals("l"))
    board.doRound(Gameboard.LEFT);
   if (input.equals("right") || input.equals("r"))
    board.doRound(Gameboard.RIGHT);
  }
  keyboard.close();
  
  if (board.getWon())
   System.out.println("You win!");
  else
   System.out.println("You were vanquished.");
 }
}
