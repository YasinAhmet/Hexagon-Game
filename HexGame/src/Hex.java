import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Hex {
    // All properties of Hex class, also hexagons will have a amount of soldier

    private int b = 75, c = 100, colm = 0;
    private int x[] = { b-50, b, b+25, b, b-50, b-75, b-50},
            y[] = { c-50, c-50, c, c+50, c+50, c, c-50},
            total = 7;
    private Color Col;
    private Soldat soldat;

    public void hexagon(int x[], int y[], int total, int b, int c, Color Col, Soldat soldat, int colm) {
        this.x = x;
        this.y = y;
        this.b = b;
        this.c = c;
        this.total = total;
        this.Col = Col;
        this.colm = colm;
        this.soldat = soldat;



    }

    public int[] getX() { return x; }
    public int[] getY() {
        return y;
    }
    public int gettotal() {
        return total;
    }

    public int getB() {
        return b;
    }
    public int getC() {
        return c;
    }
    public Color getCol() {return Col;}
    public Soldat getSoldat() {return soldat;}
    public int getColm() {return colm;}


    public void setX(int x[], int b) { this.x = new int[]{b-50, b, b+25, b, b-50, b-75, b-50};}
    public void setY(int y[], int c) {
        this.y = new int[]{ c-50, c-50, c, c+50, c+50, c, c-50};
    }
    public void setB(int b) {
        this.b = b; setX(getX(), 0);
    }
    public void setS(Soldat soldat) {this.soldat = soldat;}
    public void setColm(int colm) {this.colm = colm;}
    public void setC(int c) {
        this.c = c; setY(getY(), 0);

    }
    public void setCol(Color Col) {
        this.Col = Col;
    }
    public boolean hasSoldat() {if (getSoldat().getS() >= 1 )
        return true;
    else
        return false ;}



}
