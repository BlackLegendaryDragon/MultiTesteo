package programa4;

import javax.swing.*;

public class Launcher extends JFrame {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
    }
    public Launcher(){
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Programa 4 - Multitesteo");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.add(panelPrincipal);
    }
}
