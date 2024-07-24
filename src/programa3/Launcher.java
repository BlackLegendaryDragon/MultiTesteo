package programa3;

import javax.swing.*;

public class Launcher extends JFrame {

    public static void main(String[] args) {
        new Launcher();
    }

    public Launcher()
    {
        setTitle("Folowtrix");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        Programa p = new Programa();
        add(p);
    }
}
