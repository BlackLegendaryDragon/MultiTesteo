package timer;

import javax.swing.*;
import java.awt.*;

public class Timer extends JFrame
    {
    public static void main(String[] args) {
        new Timer();
    }
    public Timer()
    {
        Reloj reloj = new Reloj();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Timer");
        setSize(400,400);
        setLocationRelativeTo(null);

        add(reloj);
        reloj.startThread();

        setVisible(true);
    }
    public class Reloj extends JPanel implements Runnable
    {

        Thread thread;
        int posX;
        int posY;
        int angulo=0;
        int largo=100;

        public Reloj()
        {
            setLayout(null);
        }

        public void startThread()
        {
            thread = new Thread(this);
            thread.start();
        }

        @Override
        public void run()
        {
            while(thread.isAlive())
            {
                try {
                    thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                update();
                repaint();
            }
        }
        public void update()
        {
            angulo++;
            //angulo = 45;
            angulo=angulo>360?0:angulo;

            posX=(int)coh(angulo,largo)+200;
            posY=(int)pitagoras(largo,posX-200)+200;

            System.out.printf("PosX %d, PosY %d\n",posX,posY);
        }

        public void paintComponent(Graphics g)
        {
            g.setColor(Color.BLACK);
            g.drawLine(200,200,posX, posY);
        }

        public double coh(double angulo, double largo)
        {
            double aRadiantes=Math.toRadians(angulo);
            return Math.cos(aRadiantes)*largo;
        }
        public double pitagoras(double hipotenusa, double largo)
        {
            return Math.sqrt(Math.pow(hipotenusa,2)-Math.pow(largo,2));
        }
    }
}
