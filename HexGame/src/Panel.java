import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    // Panel class is main class to control all mechanics
    static int loop = 1;
     ArrayList<Hex> ar = new ArrayList<>();
     ArrayList<Hex> ara = new ArrayList<>();
    static int g = 100;
    static int tot = 100;
    static boolean select = false;
    static int selectnumb = 0;
    static String actmod = "add";
    static int alcolm = 1;

    MouseListener m = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            //LeftClick
            //Add hexagon
            if (actmod.equals("add")) { AddHex(3); }

            //Add soldiers
            else if (actmod.equals("sold")) {
                for (int i = 0; i < ara.size(); i++) {
                    if ((ara.get(i).getB() >= e.getX() && ara.get(i).getB() <= e.getX()+75) &&
                    (ara.get(i).getC() >= e.getY() && ara.get(i).getC() <= e.getY()+75) && !ara.get(i).hasSoldat()) {

                Soldat s = new Soldat();

                if (ara.get(i).getCol() == Color.blue)
                    s.soldier(ara.get(i).getB()-35, ara.get(i).getC()-10, 10, "blues");
                else if (ara.get(i).getCol() == Color.green)
                    s.soldier(ara.get(i).getB()-35, ara.get(i).getC()-10, 10, "greens");

                ara.get(i).setS(s);
            }
                    else if ((ara.get(i).getB() >= e.getX() && ara.get(i).getB() <= e.getX()+75) &&
                            (ara.get(i).getC() >= e.getY() && ara.get(i).getC() <= e.getY()+75) ) {

                        if (e.getButton() == 1 && ara.get(i).getSoldat().getS() < 50)
                            ara.get(i).getSoldat().setS(ara.get(i).getSoldat().getS()+10);
                        else if (e.getButton() == 3 && ara.get(i).getSoldat().getS() >= 11){
                            ara.get(i).getSoldat().setS(ara.get(i).getSoldat().getS()-10);

                        }

                    }
                }
            }

            // Painting
            else if (actmod.equals("paint")) {
                for (int i = 0; i < ar.size(); i++) {
                    if ((ar.get(i).getB() >= e.getX() && ar.get(i).getB() <= e.getX()+75) &&
                    (ar.get(i).getC() >= e.getY() && ar.get(i).getC() <= e.getY()+75))
            {
                ar.get(i).setCol(Color.blue);
                ara.add(ar.get(i));
                ar.remove(ar.get(i));
            }
                } for (int i = 0; i < ara.size(); i++) {
                if ((ara.get(i).getB() >= e.getX() && ara.get(i).getB() <= e.getX()+75) &&
                        (ara.get(i).getC() >= e.getY() && ara.get(i).getC() <= e.getY()+75)) {
                    if (ara.get(i).getCol() == Color.green) {
                        ara.get(i).setCol(Color.blue); ara.get(i).getSoldat().setF("blues");
                    }
                    else if (ara.get(i).getCol() == Color.blue) {
                        ara.get(i).setCol(Color.green); ara.get(i).getSoldat().setF("greens");
                    }
                    else if (ara.get(i).getCol() == Color.white) {
                        ara.get(i).setCol(Color.blue); ara.get(i).getSoldat().setF("blues");
                    }
                    }
                }
            }

            // Move Soldiers
            else if (actmod == "move") {

                if (select) {

                    for (int i = 0; i < ara.size(); i++) {

                        if ((ara.get(i).getB() >= e.getX() && ara.get(i).getB() <= e.getX() + 75) &&
                                (ara.get(i).getC() >= e.getY() && ara.get(i).getC() <= e.getY() + 75)) {

                            if (ara.get(i).getCol() != ara.get(selectnumb).getCol() && ara.get(i).getSoldat().getF() != ara.get(selectnumb).getSoldat().getF()) {
                                if ((ara.get(i).getSoldat().getS()+10 <= ara.get(selectnumb).getSoldat().getS())) {
                                    ara.get(i).setCol(ara.get(selectnumb).getCol());
                                    ara.get(i).getSoldat().setF(ara.get(selectnumb).getSoldat().getF());
                                    ara.get(i).getSoldat().setS(ara.get(selectnumb).getSoldat().getS() - ara.get(i).getSoldat().getS());
                                    ara.get(selectnumb).getSoldat().setS(1);
                                }

                            }
                            else if (i == selectnumb) {
                                selectnumb = 0;
                                select = false;
                                return;
                            }

                            else if (ara.get(i).getCol() == ara.get(selectnumb).getCol() && ara.get(i).getSoldat().getF() == ara.get(selectnumb).getSoldat().getF()) {
                                ara.get(i).getSoldat().setS(ara.get(selectnumb).getSoldat().getS() + ara.get(i).getSoldat().getS());
                                ara.get(selectnumb).getSoldat().setS(0);
                            }
                            select = false;
                            selectnumb = 0;

                        }

                    }
                }
                else if (!select) {

                    for (int i = 0; i < ara.size(); i++) {

                        if ((ara.get(i).getB() >= e.getX() && ara.get(i).getB() <= e.getX()+75) &&
                                (ara.get(i).getC() >= e.getY() && ara.get(i).getC() <= e.getY()+75)) {

                            selectnumb = i;
                            select = true;
                        }

                    }

                }

            }


        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    KeyListener k = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {


        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 'a') {actmod = "add"; }
            else if (e.getKeyChar() == 's') {actmod = "sold"; }
            else if (e.getKeyChar() == 'p') {actmod = "paint"; }
            else if (e.getKeyChar() == 'm') {actmod = "move";}
            System.out.println(actmod);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    public void Panel() {
        Timer timer = new Timer(17, this::TimeFlow);

        setSize(600,400);
        setBackground(Color.gray);
        addMouseListener(m);




        timer.start();
    }





    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


         for (int i = 0; i < ar.size(); i++) {

             g.setColor(Color.white);
             g.fillPolygon(ar.get(i).getX(), ar.get(i).getY(), ar.get(i).gettotal());
             g.setColor(Color.gray);
             g.drawPolygon(ar.get(i).getX(), ar.get(i).getY(), ar.get(i).gettotal());

         }

         for (int i = 0; i < ara.size(); i++) {
             g.setColor(ara.get(i).getCol());
             g.fillPolygon(ara.get(i).getX(), ara.get(i).getY(), ara.get(i).gettotal());
             g.setColor(Color.gray);
             g.drawPolygon(ara.get(i).getX(), ara.get(i).getY(), ara.get(i).gettotal());

             if (ara.get(i).hasSoldat()) {
                 if (ara.get(i).getSoldat().getF().equals("blues"))
                     g.setColor(Color.yellow);
                 else if (ara.get(i).getSoldat().getF().equals("greens"))
                     g.setColor(Color.red);

                 g.fillOval(ara.get(i).getSoldat().getX() - ara.get(i).getSoldat().getS() / 3, ara.get(i).getSoldat().getY() - ara.get(i).getSoldat().getS() / 3, ara.get(i).getSoldat().getS(), ara.get(i).getSoldat().getS());
             }
         }

        }

        public void TimeFlow(ActionEvent e) {

        repaint();
        }

        public void AddHex(int e) {
        if (actmod.equals("add")) {
            for (int i = 0; i < e; i++) {
                Hex hex = new Hex();
                if (loop == 1) {
                    hex.setX(hex.getX(), g);
                    hex.setY(hex.getY(), tot);
                    hex.hexagon(hex.getX(), hex.getY(), hex.gettotal(), g, tot, hex.getCol(), new Soldat(), alcolm);
                    ar.add(hex);
                    g = g + 75;
                    tot = tot - 50;
                    loop = 2;
                    alcolm++;
                } else if (loop == 2 && tot <= 100) {
                    hex.setX(hex.getX(), g);
                    hex.setY(hex.getY(), tot);
                    hex.hexagon(hex.getX(), hex.getY(), hex.gettotal(), g, tot, hex.getCol(), new Soldat(), alcolm);
                    ar.add(hex);
                    loop++;
                } else if (loop == 3) {
                    tot = tot + 100;
                    hex.setX(hex.getX(), g);
                    hex.setY(hex.getY(), tot);
                    hex.hexagon(hex.getX(), hex.getY(), hex.gettotal(), g, tot, hex.getCol(), new Soldat(), alcolm);
                    ar.add(hex);
                    tot = tot - 50;
                    g = g + 75;
                    loop = 1;
                } else
                    loop++;

                if (g >= 500) {

                    tot = tot + 100;
                    g = 100;

                }

                System.out.println(ar.size());

            }
        }

        }

    }