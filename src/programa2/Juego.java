package programa2;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel implements Runnable
{
    private Thread thread;
    private int FPS = 60;
    private int velocidad = 100;
    private KeyHandler kh;
    private MouseHandler mh;
    private Entidad[] entity_list = new Entidad[2];

    private Jugador player;
    private Enemigo enemigo;
    private Enemigo enemigo2;

    private int lock_tick = 5;
    public Juego(KeyHandler kh, MouseHandler mh)
    {
        setLayout(null);
        setBackground(Color.WHITE);
        this.kh = kh;
        this.mh = mh;
        player = new Jugador(10,10,10,10,mh);
        enemigo = new Enemigo(20,20, 0.2,3);
        enemigo2 = new Enemigo(20,40, 0.2,5);

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
        double drawInterval = (double) 1_000_000_000 /FPS;
        double nextDrawInterval = System.nanoTime() - drawInterval;
        while(thread != null){

            update();
            repaint();
            try{
                double remainingTime = nextDrawInterval - System.nanoTime();
                remainingTime = remainingTime / drawInterval;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawInterval += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void update()
    {
        Enemigo objetivo;
        player.update();
        for(Entidad e: entity_list)
        {

            objetivo = colicion(player,e);
            //System.out.println(objetivo);
            player.setObjetivo(objetivo);
            e.update();
        }
    }
    public Enemigo colicion(Jugador player, Entidad e)
    {
        Enemigo objetivo = null;

        int player_pos_x = (int) (player.posicion_x-8);
        int player_pos_y = (int) (player.posicion_y-30);
        int enemigo_pos_x = (int) e.posicion_x;
        int enemigo_pos_y = (int) e.posicion_y;

        if(player_pos_x>=enemigo_pos_x&&player_pos_x<=enemigo_pos_x+10&&
                player_pos_y>=enemigo_pos_y&&player_pos_y<=enemigo_pos_y+10)
        {
            player.setColicion(true);
            lock_tick=5;
            //System.out.println(e);

            objetivo = (Enemigo) e;
        }else
        {
            lock_tick--;
        }
        if(lock_tick<=0){
            lock_tick=5;
            player.setColicion(false);
        }
        return objetivo;
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.BLACK);
        //g2d.fillRect(player.getPosicion_x(),player.getPosicion_y(),10,10);
        dibujarlista(g2d, entity_list);
    }
    public void dibujarlista(Graphics2D g2,Entidad[] lista)
    {
        player.dibujar_hud(g2);
        for(Entidad e: lista)
        {
            g2.setColor(Color.BLACK);
            g2.fillRect((int) e.getPosicion_x(), (int) e.getPosicion_y(),10,10);
        }
    }
}
