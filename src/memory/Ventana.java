package memory;

import javax.swing.*;

public class Ventana extends JFrame {
    public static void main(String[] args)
    {
        new Ventana();
    }
    public Ventana()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
