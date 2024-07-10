package clicker;

import javax.swing.*;

public class Ventana extends JFrame {
    public static void main(String[] args) {
        new Ventana();
    }
    public Ventana() {
        MouseHandler mh = new MouseHandler();
        Juego juego = new Juego(mh);
        setTitle("Ventana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        add(juego);
        addMouseListener(mh);
        juego.startThread();
    }
}
