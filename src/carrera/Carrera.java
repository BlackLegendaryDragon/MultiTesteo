package carrera;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Carrera extends JPanel implements Runnable{

    private int meta = 30;
    private boolean ganador = false;
    private Auto auto1 = new Auto("ROJO", 4,0,Color.RED);
    private Auto auto2 = new Auto("VERDE", 4,0,Color.GREEN);
    private Auto auto3 = new Auto("BLUE", 4, 0,Color.BLUE);
    private Auto[] autos = {auto1, auto2, auto3};
    private BufferedImage img = null;

    private Thread thread;
    public Carrera()
    {
        startThread();
        try {
            img = ImageIO.read(new File("src/carrera/carro.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void startThread()
    {
        thread = new Thread(this);
        thread.start();
    }

    public void run()
    {
        while(thread.isAlive()&&!ganador)
        {
            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            update();
            repaint();
        }
    }
    public void update()
    {
        for(Auto auto : autos)
        {
            //System.out.println();
            if(auto.avanzar()>=meta)
            {
                ganador = true;
                auto.setGanador(true);
                System.out.println("El ganador es "+auto.getNombre());
                break;
            }
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,getWidth(),getHeight());


        for(int i=0;i<autos.length;i++)
        {
            g2d.drawImage(img,10*(autos[i].getPosicion())+20,10*i+15,null);
            g2d.setColor(autos[i].getColor());
            g2d.drawLine(20,10*i+20,10*(autos[i].getPosicion())+20,10*i+20);
        }
    }
}
