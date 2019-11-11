import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Gameboard {
    Tile[][] board;
    private boolean gameOver;
    private boolean playerWon;
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;


    public Gameboard(String fileName){
        gameOver = false;
        playerWon = false;
        try{
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String line = input.readLine();
            String[] tokens = line.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            board = new Tile[row][col];
            for(int i=0; i<row; i++){
                line = input.readLine();
                for(int j=0; j<line.length();j++){
                    if(line.charAt(j) == '#')
                        board[i][j] = new Wall();
                    else if(line.charAt(j) == 'Y')
                        board[i][j] = new OpenSpace(new Amulet());
                    else if(line.charAt(j) == 'T')
                        board[i][j] = new OpenSpace(new GreaterTroll());
                    else if(line.charAt(j) == 'h')
                        board[i][j] = new OpenSpace(new HealthPotion());
                    else if(line.charAt(j) == '@')
                        board[i][j] = new OpenSpace(new Player());
                    else if(line.charAt(j) == '^')
                        board[i][j] = new OpenSpace(new Trap());
                    else if(line.charAt(j) == 't')
                        board[i][j] = new OpenSpace(new Troll());
                    else{
                        board[i][j] = new OpenSpace();
                    }
                }
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    void doRound(int move){
        int playerRow = -1;
        int playerCol = -1;
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getSymbol().equals("@")) {
                    playerRow = i;
                    playerCol = j;
                    break;
                }
            }
        }
        if(move == UP){
            playerRow --;
            if(!board[playerRow][playerCol].isPassable())
                playerRow++;
            else{
                if(board[playerRow][playerCol].getContent() instanceof Item){
                    Player p = (Player)board[playerRow+1][playerCol].getContent();
                    Item item = (Item) board[playerRow][playerCol].getContent();
                    if(item instanceof Amulet){
                        gameOver = true;
                        playerWon = true;
                    }
                    p.changeHP(item.getEffect());
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow+1][playerCol].removeContent();
                    System.out.println("Health: " + p.getHP());
                }else if(board[playerRow][playerCol].getContent() instanceof Combatant){
                    Player p = (Player)board[playerRow+1][playerCol].getContent();
                    Combatant enemy = (Combatant) board[playerRow][playerCol].getContent();
                    int attackPoint = p.doAttack();
                    enemy.changeHP(attackPoint);
                    System.out.println("Player attacks the " + enemy + " for " + -attackPoint);
                    if(enemy.getHP()<=0){
                        board[playerRow][playerCol].setContent(p);
                        board[playerRow+1][playerCol].removeContent();
                        System.out.println(enemy + " is vanquished!");
                    }else{
                        attackPoint = enemy.doAttack();
                        p.changeHP(attackPoint);
                        System.out.println(enemy + " attacks the Player " + " for " + -attackPoint);
                        if(p.getHP()<=0){
                            gameOver = true;
                            playerWon = false;
                        }
                    }
                    System.out.println("Player health:" + p.getHP() + " " + enemy + " health: " + enemy.getHP());
                    System.out.println("Health" + p.getHP());
                }else{
                    Player p = (Player)board[playerRow+1][playerCol].getContent();
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow+1][playerCol].removeContent();
                    System.out.println("Health: " + p.getHP());
                }
            }
        } else  if(move == DOWN){
            playerRow ++;
            if(!board[playerRow][playerCol].isPassable())
                playerRow--;
            else{
                if(board[playerRow][playerCol].getContent() instanceof Item){
                    Player p = (Player)board[playerRow-1][playerCol].getContent();
                    Item item = (Item) board[playerRow][playerCol].getContent();
                    if(item instanceof Amulet){
                        gameOver = true;
                        playerWon = true;
                    }
                    p.changeHP(item.getEffect());
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow-1][playerCol].removeContent();
                    System.out.println("Health: " + p.getHP());
                }else if(board[playerRow][playerCol].getContent() instanceof Combatant){
                    Player p = (Player)board[playerRow-1][playerCol].getContent();
                    Combatant enemy = (Combatant) board[playerRow][playerCol].getContent();
                    int attackPoint = p.doAttack();
                    enemy.changeHP(attackPoint);
                    System.out.println("Player attacks the " + enemy + " for " + -attackPoint);
                    if(enemy.getHP()<=0){
                        board[playerRow][playerCol].setContent(p);
                        board[playerRow-1][playerCol].removeContent();
                        System.out.println(enemy + " is vanquished!");
                    }else{
                        attackPoint = enemy.doAttack();
                        p.changeHP(attackPoint);
                        System.out.println(enemy + " attacks the Player " + " for " + -attackPoint);
                        if(p.getHP()<=0){
                            gameOver = true;
                            playerWon = false;
                        }
                    }
                    System.out.println("Player health:" + p.getHP() + " " + enemy + " health: " + enemy.getHP());
                    System.out.println("Health" + p.getHP());
                }else{
                    Player p = (Player)board[playerRow-1][playerCol].getContent();
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow-1][playerCol].removeContent();
                    System.out.println("Health: " + p.getHP());
                }
            }
        }else  if(move == LEFT){
            playerCol --;
            if(!board[playerRow][playerCol].isPassable())
                playerCol++;
            else{
                if(board[playerRow][playerCol].getContent() instanceof Item){
                    Player p = (Player)board[playerRow][playerCol+1].getContent();
                    Item item = (Item) board[playerRow][playerCol].getContent();
                    if(item instanceof Amulet){
                        gameOver = true;
                        playerWon = true;
                    }
                    p.changeHP(item.getEffect());
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow][playerCol+1].removeContent();
                    System.out.println("Health: " + p.getHP());
                }else if(board[playerRow][playerCol].getContent() instanceof Combatant){
                    Player p = (Player)board[playerRow][playerCol+1].getContent();
                    Combatant enemy = (Combatant) board[playerRow][playerCol].getContent();
                    int attackPoint = p.doAttack();
                    enemy.changeHP(attackPoint);
                    System.out.println("Player attacks the " + enemy + " for " + -attackPoint);
                    if(enemy.getHP()<=0){
                        board[playerRow][playerCol].setContent(p);
                        board[playerRow][playerCol+1].removeContent();
                        System.out.println(enemy + " is vanquished!");
                    }else{
                        attackPoint = enemy.doAttack();
                        p.changeHP(attackPoint);
                        System.out.println(enemy + " attacks the Player " + " for " + -attackPoint);
                        if(p.getHP()<=0){
                            gameOver = true;
                            playerWon = false;
                        }
                    }
                    System.out.println("Player health:" + p.getHP() + " " + enemy + " health: " + enemy.getHP());
                    System.out.println("Health" + p.getHP());
                }else{
                    Player p = (Player)board[playerRow][playerCol+1].getContent();
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow][playerCol+1].removeContent();
                    System.out.println("Health: " + p.getHP());
                }
            }
        }else  if(move == RIGHT){
            playerCol ++;
            if(!board[playerRow][playerCol].isPassable())
                playerCol--;
            else{
                if(board[playerRow][playerCol].getContent() instanceof Item){
                    Player p = (Player)board[playerRow][playerCol-1].getContent();
                    Item item = (Item) board[playerRow][playerCol].getContent();
                    if(item instanceof Amulet){
                        gameOver = true;
                        playerWon = true;
                    }
                    p.changeHP(item.getEffect());
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow][playerCol-1].removeContent();
                    System.out.println("Health: " + p.getHP());
                }else if(board[playerRow][playerCol].getContent() instanceof Combatant){
                    Player p = (Player)board[playerRow][playerCol-1].getContent();
                    Combatant enemy = (Combatant) board[playerRow][playerCol].getContent();
                    int attackPoint = p.doAttack();
                    enemy.changeHP(attackPoint);
                    System.out.println("Player attacks the " + enemy + " for " + -attackPoint);
                    if(enemy.getHP()<=0){
                        board[playerRow][playerCol].setContent(p);
                        board[playerRow][playerCol-1].removeContent();
                        System.out.println(enemy + " is vanquished!");
                    }else{
                        attackPoint = enemy.doAttack();
                        p.changeHP(attackPoint);
                        System.out.println(enemy + " attacks the Player " + " for " + -attackPoint);
                        if(p.getHP()<=0){
                            gameOver = true;
                            playerWon = false;
                        }
                    }
                    System.out.println("Player health:" + p.getHP() + " " + enemy + " health: " + enemy.getHP());
                    System.out.println("Health" + p.getHP());
                }else{
                    Player p = (Player)board[playerRow][playerCol-1].getContent();
                    board[playerRow][playerCol].setContent(p);
                    board[playerRow][playerCol-1].removeContent();
                    System.out.println("Health: " + p.getHP());
                }
            }
        }
    }

    public boolean getDone() {
        return gameOver;
    }

    public boolean getWon() {
        return playerWon;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length;j++)
                s+=board[i][j].getSymbol();
            s+="\n";
        }
        return s;
    }
}
