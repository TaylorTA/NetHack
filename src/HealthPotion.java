public class HealthPotion extends Item {
    public HealthPotion(){
        super("h");
    }

    @Override
    int getEffect() {
        System.out.println("You picked up a health potion!");
        return 5;
    }
}
