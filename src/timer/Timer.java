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
    
}
