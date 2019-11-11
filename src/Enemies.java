public class Enemies extends Combatant{
    public Enemies(){
        super("e", 50, 1,5);
    }

    @Override
    public int doAttack() {
        return -3;
    }

    @Override
    public String toString() {
        return "Enemies";
    }
}
