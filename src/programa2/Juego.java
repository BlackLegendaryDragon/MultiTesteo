package programa2;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel implements Runnable
{
    private Thread thread;
    private int velocidad = 100;
    private KeyHandler kh;
    private Entidad[] entity_list = new Entidad[2];

    private Jugador player;
    private Enemigo enemigo;
    public Juego(KeyHandler kh)
    {
        setLayout(null);
        setBackground(Color.BLUE);
        this.kh = kh;
        player = new Jugador(10,10,10,kh);
        enemigo = new Enemigo(20,20, 2,3);

        entity_list[0]=player;
        entity_list[1]=enemigo;
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
        for(Entidad e: entity_list)
        {
            e.update();
        }
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.BLACK);
        //g2d.fillRect(player.getPosicion_x(),player.getPosicion_y(),10,10);
        dibujarlista(g2d, entity_list);
    }
    public void dibujarlista(Graphics2D g2,Entidad[] lista)
    {
        for(Entidad e: lista)
        {
            g2.setColor(Color.BLACK);
            g2.fillRect(e.getPosicion_x(),e.getPosicion_y(),10,10);
        }
    }
}
