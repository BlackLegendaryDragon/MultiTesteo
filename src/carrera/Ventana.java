package carrera;

import javax.swing.*;

public class Ventana extends JFrame {
    public static void main(String[] args) {
        new Ventana();
    }
    public Ventana()
    {
        JPanel carrera = new Carrera();
        setTitle("Carrera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,100);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        add(carrera);
    }
}
