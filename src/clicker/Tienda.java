package clicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda implements ActionListener {
    private int[][] bonus = new int[8][3];
    private String[] nombres = new String[8];
    private JButton[] botones = new JButton[8];
    private Juego juego;

    public Tienda(Juego juego)
    {
        bonus[0][0] = 100;bonus[0][1]=1;nombres[0]="Clicker";
        bonus[1][0] = 200;bonus[1][1]=2;nombres[1]="Aficionado";
        bonus[2][0] = 500;bonus[2][1]=10;nombres[2]="Amateur";
        bonus[3][0] = 1250;bonus[3][1]=20;nombres[3]="Profecional";
        bonus[4][0] = 15000;bonus[4][1]=100;nombres[4]="Maquina";
        bonus[5][0] = 24000;bonus[5][1]=200;nombres[5]="Algoritmo";
        bonus[6][0] = 50000;bonus[6][1]=500;nombres[6]="IAN";
        bonus[7][0] = 999999;bonus[7][1]=100000;nombres[7]="Destructor";
        this.juego = juego;

        generador_botones(nombres,botones,bonus);
    }
    public void generador_botones(String[] nombres, JButton[] jButtons, int[][] datos)
    {
        for(int i=0;i<jButtons.length;i++){
            jButtons[i] = new JButton(nombres[i]+" X: "+datos[i][0]);
            jButtons[i].setBounds(300,30*i,200,30);
            jButtons[i].setName(i+"");
            jButtons[i].addActionListener(this);
        }
    }

    public JButton[] getBotones() {
        return botones;
    }

    public int[][] getBonus() {
        return bonus;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton)e.getSource();
        int numero = Integer.parseInt(boton.getName());
        if(juego.puntaje>=bonus[numero][0])
        {
            juego.puntaje-=bonus[numero][0];
            bonus[numero][2]+=1;
            //System.out.println("Precio: "+bonus[numero][0]);
        }

        //System.out.println(Arrays.deepToString(bonus));

    }
}
