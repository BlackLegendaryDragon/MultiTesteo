package clicker;

import javax.swing.*;

public class Juego extends JPanel implements Runnable{

    private MouseHandler mh;
    private Tienda tienda;
    public int puntaje = 0;
    private int agregado = 0;
    private JLabel label_puntaje = new JLabel("Puntaje: "+puntaje);

    private Thread thread;

    public Juego(MouseHandler mh) {
        setLayout(null);
        this.mh = mh;
        tienda = new Tienda(this);
        label_puntaje.setBounds(10,10,200,20);

        for(JButton boton: tienda.getBotones())
        {
            add(boton);
        }

        add(label_puntaje);
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
        puntaje=mh.click?puntaje+1:puntaje;
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
}
