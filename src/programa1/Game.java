package programa1;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable{

    boolean encendido = false;
    char[][] mapa = new char[20][20];

    private KeyboardListener kl;
    private JPanel panel;
    private Thread gameThread;
    private int FPS = 60;

    public Game(KeyboardListener kl){
        setLayout(null);
        this.kl = kl;
        rellenarMatrix(mapa, ' ');
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        drawMatrix(g2);
    }

    public void drawMatrix(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.fillRect(10,10,430,430);
        g2.setColor(Color.BLACK);
        for(int x = 0;x<mapa.length;x++){
            for(int y = 0;y<mapa[0].length;y++){

                g2.drawRect(x*20+25,y*20+25,20,20);
                g2.drawString(mapa[x][y]+"",x*20+30,y*20+39);
            }
        }
    }

    public void rellenarMatrix(char[][] matrix, char caracter){
        for(int x = 0;x<matrix.length;x++){
            for(int y = 0;y<matrix[0].length;y++){
                matrix[x][y] = caracter;
            }
        }
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    private double posX = 10;
    private double posY = 10;
    private double velX = 0.1;
    private double velY = 0;

    private int[] lastposX = new int[3];
    private int[] lastposY = new int[3];
    private int paso = 0;
    public void update(){

        System.out.println("Actualizado");


        //lastposXY = posX;

        if(kl.w && velY==0){
            velY=-0.1;
            velX=0;
        }
        if(kl.a && velX==0){
            velY=0;
            velX=-0.1;
        }
        if(kl.s && velY==0){
            velY=0.1;
            velX=0;
        }
        if(kl.d && velX==0) {
            velY=0;
            velX=0.1;
        }

        if(posX>=mapa.length-1){
            posX = 1;
        }
        if(posX<=0){
            posX = mapa.length-1;
        }
        if(posY>=mapa[0].length-1){
            posY = 1;
        }
        if(posY<=0){
            posY = mapa[0].length-1;
        }
        //cabeza representado por un 0
        //cuerpo representado por un +
        //cola simplemente un *


        //mapa[lastposX][lastposY] = '+';
        System.out.printf("posX %d, posY %d",(int)posX,(int)posY);
        mapa[(int)(posX+=velX)][(int)(posY+=velY)]='0';
    }

    @Override
    public void run() {
        double drawInterval = (double) 1_000_000_000 /FPS;
        double nextDrawInterval = System.nanoTime() - drawInterval;

        while(gameThread != null){

            update();
            repaint();
            try{
                double remainingTime = nextDrawInterval - System.nanoTime();
                remainingTime = remainingTime / drawInterval;
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawInterval += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
