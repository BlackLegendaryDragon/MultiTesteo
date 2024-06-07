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
        int angulo=90;
        int largo=100;
        int segundos=0;
        int minutos=0;

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
                segundos++;
                update();
                repaint();
            }
        }
        public void update()
        {
            //angulo = 45;
            if(segundos>=60){
                minutos++;
                segundos=0;
            }
            angulo=minutos*360/(60);
            System.out.println(angulo);
            int invertido=180<angulo?1:-1;

            posX=-(int)coh(angulo,largo)+200;
            posY=invertido*(int)pitagoras(largo,posX-200)+200;

            System.out.printf("PosX %d, PosY %d\n",posX,posY);
        }

        public void paintComponent(Graphics g)
        {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0,0,getWidth(),getHeight());
            g2.setColor(Color.BLACK);
            g2.drawString("segundos:"+segundos+" minutos:"+minutos,10,10);
            g2.drawLine(200,200,posX, posY);
            g2.drawOval(100,100,200,200);
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
