public class GreaterTroll extends Troll{
    public GreaterTroll(){
        super();
        this.symbol = "T";
        this.changeHP(this.getHP());
    }

    public int doAttack() {
        return super.doAttack()+super.doAttack();
    }

    @Override
    public String toString() {
        return "GreaterTroll";
    }
}
