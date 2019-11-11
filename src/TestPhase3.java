
public class TestPhase3 {

	public static void main(String[] args) {

		Tile[][] board = {
				{new Wall(), new  Wall(), new Wall(), new Wall(),  new Wall(), new Wall()},
				{new Wall(), new  OpenSpace(new Trap()),  new  OpenSpace(new Amulet()), new OpenSpace(), new OpenSpace(new Troll()), new Wall()},
				{new Wall(), new OpenSpace(new  Trap()), new OpenSpace(new HealthPotion()), new OpenSpace(new Player()), new OpenSpace(), new Wall()},
				{new Wall(), new  Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
		};

		for (Tile[] row : board) {
			for (Tile t: row) {
				System.out.print(t.getSymbol());
			}
			System.out.println();
		}
		
		Combatant playa = (Combatant) board[2][3].getContent();
		System.out.println("Player hp is:" + playa.getHP());
		Combatant baddie = (Combatant) board[1][4].getContent();
		System.out.println("Troll hp is:" + baddie.getHP());
	}

}
