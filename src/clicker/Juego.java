package clicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JPanel implements Runnable, ActionListener {

    private Tienda tienda;
    public int puntaje = 0;
    private JLabel label_puntaje = new JLabel("Puntaje: "+puntaje);
    private JButton galleta;
    private Thread thread;

    public Juego() {
        setLayout(null);
        galleta = new JButton("Boton");
        galleta.setBounds(50,50,100,30);
        tienda = new Tienda(this);
        label_puntaje.setBounds(10,10,200,20);

        for(JButton boton: tienda.getBotones())
        {
            add(boton);
            boton.addActionListener(this);
        }

        add(label_puntaje);
        add(galleta);
        galleta.addActionListener(this);
        //System.out.println("A");
    }

    public void startThread()
    {
        thread = new Thread(this);
        thread.start();
    }

    public void update()
    {
        for(int i=0;i<tienda.getBotones().length;i++)
        {
            puntaje+=tienda.getBonus()[i][1]*tienda.getBonus()[i][2];
        }

        label_puntaje.setText("Puntaje: "+puntaje);
    }

    @Override
    public void run() {
        while(thread.isAlive())
        {
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            update();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("A");
        if(e.getSource().equals(galleta))
        {
            puntaje+=1;
        }
        update();
    }
}
