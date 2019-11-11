public abstract class Tile {
    private String symbol;
    private boolean passable;
    private Content content;

    public Tile(String symbol, boolean passable){
        this.symbol = symbol;
        this.passable = passable;
        content = null;
    }

    public Tile(String symbol, boolean passable, Content content){
        this.symbol = symbol;
        this.passable = passable;
        this.content = content;
    }

    public String getSymbol() {
        if(content == null)
            return symbol;
        else
            return content.getSymbol();
    }

    public boolean isPassable() {
        return passable;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void removeContent(){
        content = null;
    }
}
