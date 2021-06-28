import javax.swing.*;

public class Frame extends JFrame {
    // Frame class to show screen
    public void Frame() {
        Frame f = new Frame();
        Panel p = new Panel();
        p.Panel();


        f.setSize(700,400);
        f.add(p);
        f.setVisible(true);
        f.setResizable(false);
        f.addKeyListener(p.k);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
