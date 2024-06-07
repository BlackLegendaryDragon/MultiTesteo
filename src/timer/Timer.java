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
        int pos_minutero_X;
        int pos_minutero_Y;
        int pos_segundero_X;
        int pos_segundero_Y;
        int angulo_minutos=90;
        int angulo_segundos=90;
        int minutero=85;
        int segundero=100;
        int segundos=0;
        int minutos=0;
        int horas=0;

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
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                update();
                repaint();
            }
        }
        public void update()
        {
            //angulo = 45;
            segundos++;
            if(segundos>=60){
                minutos++;
                segundos=0;
            }
            if(minutos>=60){
                horas++;
                minutos=0;
            }
            angulo_segundos=segundos*360/(60);
            angulo_minutos=minutos*360/(60);

            int invertido_segundos=180<angulo_segundos?1:-1;
            int invertido_minutos=180<angulo_minutos?1:-1;
            System.out.println(angulo_segundos);

            pos_segundero_X=-(int)coh(angulo_segundos,segundero)+200;
            pos_segundero_Y=invertido_segundos*(int)pitagoras(segundero,pos_segundero_X-200)+200;

            pos_minutero_X=-(int)coh(angulo_minutos,minutero)+200;
            pos_minutero_Y=invertido_minutos*(int)pitagoras(minutero,pos_minutero_X-200)+200;

            //System.out.printf("PosX %d, PosY %d\n",posX,posY);
        }

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,getWidth(),getHeight());
            g2.setColor(Color.BLACK);
            g2.drawString((horas)+"h:"+(minutos)+"m:"+segundos+"s",10,10);
            g2.drawLine(200,200,pos_minutero_X, pos_minutero_Y);
            g2.setColor(Color.BLACK);
            g2.drawOval(100,100,200,200);
            g2.setColor(Color.RED);
            g2.drawLine(200,200,pos_segundero_X, pos_segundero_Y);
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
