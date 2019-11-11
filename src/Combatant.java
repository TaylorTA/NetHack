public abstract class Combatant extends Content{
    private int HP;
    private int minAttack;
    private int maxAttack;

    public Combatant(String symbol, int hitPoint, int minAttack, int maxAttack){
        super(symbol);
        HP = hitPoint;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
    }

    public int getHP() {
        return HP;
    }

    public int doAttack(){
        return -(int) (Math.random() * (maxAttack-minAttack) + minAttack);
    }

    public void changeHP(int amount){
        HP += amount;
    }

    @Override
    public String toString() {
        return "Combatant";
    }
}
