public abstract class Item extends Content {
    public Item(String symbol){
        super(symbol);
    }

    int getEffect(){
        return 0;
    }
}
