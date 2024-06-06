package programa2;

import javax.swing.*;

public class Ventana extends JFrame
{
    public static void main(String[] args)
    {
        new Ventana();
    }
    public Ventana()
    {
        Juego juego = new Juego();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test01");
        setSize(400,400);
        setResizable(false);
        setLocationRelativeTo(null);

        add(juego);
        juego.startThread();

        setVisible(true);
    }
}
