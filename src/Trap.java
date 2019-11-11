public class Trap extends Item {
    public Trap(){
        super("^");
    }

    @Override
    int getEffect() {
        System.out.println("You set off a trap!");
        return -5;
    }
}
