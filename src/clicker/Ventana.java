package clicker;

import javax.swing.*;

public class Ventana extends JFrame {
    public static void main(String[] args) {
        new Ventana();
    }
    public Ventana() {
        Juego juego = new Juego();
        setTitle("Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        add(juego);
        juego.startThread();
    }
}
