package programa2;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel implements Runnable
{
    private Thread thread;
    private int velocidad = 10;
    private KeyHandler kh;

    private Jugador player;
    public Juego()
    {
        setLayout(null);
        setBackground(Color.BLUE);
        kh=new KeyHandler();
        addKeyListener(kh);
        player = new Jugador(10,10,10,kh);
    }

    public void startThread()
    {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run()
    {
            while(thread!=null)
            {
                try {
                    Thread.sleep(velocidad);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                update();
                repaint();
            }
    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.BLACK);
        g2d.fillRect(player.getPosicion_x(),player.getPosicion_y(),10,10);
    }
}
