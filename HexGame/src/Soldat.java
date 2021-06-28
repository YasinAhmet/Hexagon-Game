public class Soldat {
    // All properties of Soldat class
    private int x, y, size;
    private String faction;

    public void soldier(int x, int y, int size, String faction){

        this.x = x;
        this.y = y;
        this.size = size;
        this.faction = faction;

    }

    public int getX() {return x;}
    public int getY() {return y;}
    public int getS() {return size;}
    public String getF() {return faction;}

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public void setS(int size) {this.size = size;}
    public void setF(String faction) {this.faction = faction;}

}
