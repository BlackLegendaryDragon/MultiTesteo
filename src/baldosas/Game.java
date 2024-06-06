package baldosas;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable{

    private boolean [][] matriz16 = new boolean[16][16];

    private Thread thread;

    public void intercalar(boolean[][] matriz){
        int extender = 0;
        for(int x = 0; x < matriz[0].length;x++){
            for(int y = 0; y < matriz.length; y++){
                if(x%2==0 && x<matriz[0].length-1){
                    matriz[x+extender][y]=true;
                }
                extender = y%2==0?1:0;
            }
        }
    }
    public boolean[][] array_to_matrix16(boolean[] arreglo){
        boolean[][] matriz = new boolean[16][16];
        int lugar = 0;
        for(int x = 0; x < matriz.length; x++){
            for(int y = 0; y < matriz.length; y++){
                matriz[x][y]=arreglo[lugar];
                lugar++;
            }
        }
        return matriz;
    }

    //Inicializa el juego de la vida binario en un arreglo
    public boolean[] binari_life(boolean[] arreglo){
        for(int i = 0; i<arreglo.length; i++){
            if(i==0){
                arreglo[0]=!arreglo[0];
            }
        }
        return arreglo;
    }

    public void paint(Graphics g){
        System.out.println("Pintar");
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        //intercalar(matriz16);
        //dibujarMatriz(g2d, array_to_matrix16());

    }
    public void dibujarMatriz(Graphics2D g2d, boolean[][] matriz){
        for(int x = 0; x < matriz[0].length;x++){
            for(int y = 0; y < matriz.length; y++){
                if(matriz[x][y]){
                    g2d.setColor(Color.BLACK);
                }else{
                    g2d.setColor(Color.WHITE);
                }
                g2d.fillRect((x*10)+20,(y*10)+20,10,10);
            }
        }
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    public void update(){
        System.out.println("Actualizar");
    }
    @Override
    public void run() {
        while(thread.isAlive()){
            try{
                thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
            update();
            repaint();
        }
    }

}
