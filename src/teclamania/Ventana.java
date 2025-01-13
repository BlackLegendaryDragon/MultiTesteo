package teclamania;

import javax.swing.*;

public class Ventana extends JFrame {
    public static void main(String[] args) {
        new Ventana();
    }
    public Ventana() {
        setTitle("Tecla Mania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
