public class Amulet extends Item {
    public Amulet(){
        super("Y");
    }

    @Override
    int getEffect() {
        System.out.println("You picked up the Amulet of Yendor!");
        return 0;
    }
}
