package programa2;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel implements Runnable
{
    private Thread thread;
    private int velocidad = 100;
    private KeyHandler kh;
    private MouseHandler mh;
    private Entidad[] entity_list = new Entidad[2];

    private Jugador player;
    private Enemigo enemigo;
    private Enemigo enemigo2;
    public Juego(KeyHandler kh, MouseHandler mh)
    {
        setLayout(null);
        setBackground(Color.BLUE);
        this.kh = kh;
        this.mh = mh;
        player = new Jugador(10,10,10,mh);
        enemigo = new Enemigo(20,20, 2,3);
        enemigo2 = new Enemigo(20,20, 1,5);

        entity_list[0]=enemigo2;
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
        player.update();
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
        player.dibujar_mirilla(g2);
        for(Entidad e: lista)
        {
            g2.setColor(Color.BLACK);
            g2.fillRect(e.getPosicion_x(),e.getPosicion_y(),10,10);
        }
    }
}
