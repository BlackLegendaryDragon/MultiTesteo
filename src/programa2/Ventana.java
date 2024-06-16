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
        KeyHandler kh = new KeyHandler();
        MouseHandler mh = new MouseHandler();
        Juego juego = new Juego(kh, mh);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Test01");
        setSize(700,400);
        setResizable(false);
        setLocationRelativeTo(null);

        add(juego);
        addKeyListener(kh);
        addMouseMotionListener(mh);
        juego.startThread();

        setVisible(true);
    }
}
