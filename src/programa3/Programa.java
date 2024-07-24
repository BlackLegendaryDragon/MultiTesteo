package programa3;

import javax.swing.*;
import java.awt.*;

public class Programa extends JPanel implements Runnable {

    Thread thread;

    public Programa()
    {
        setLayout(null);
        startThread();
    }
    public void startThread()
    {
        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.black);
        g2d.drawLine(10,10,100,100);
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
        }
    }

}
