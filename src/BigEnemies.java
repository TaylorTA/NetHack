public class BigEnemies extends Enemies{
    public BigEnemies(){
        super();
        this.symbol = "E";
    }

    @Override
    public int doAttack() {
        return super.doAttack()*2;
    }

    @Override
    public void changeHP(int amount) {
        super.changeHP(amount*2);
    }

    @Override
    public String toString() {
        return "BigEnemies";
    }
}
