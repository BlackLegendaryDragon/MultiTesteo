package programa2;

import java.awt.*;

public class Jugador extends Entidad{
    private MouseHandler mh;
    private final int ajuste_x = -18;
    private final int ajuste_y = -40;
    private boolean colicion = false;
    private int ammo;
    private Enemigo objetivo;
    private boolean relased = true;

    public Jugador(int posicion_x,int posicion_y,double speed,int ammo,MouseHandler mh)
    {
        super(posicion_x,posicion_y,speed);
        this.mh = mh;
        this.ammo = ammo;
    }

    public boolean isColicion() {return colicion;}
    public void setColicion(boolean col) {this.colicion = col;}
    public Enemigo getObjetivo() {return objetivo;}
    public void setObjetivo(Enemigo objetivo) {this.objetivo = objetivo;}

    //funciones personalizadas
    @Override
    public void update()
    {
        //System.out.println(kh.isW());
        //System.out.println("posX"+posicion_x+"posY"+posicion_y+"Speed"+getSpeed());
        //System.out.println(kh.a);
        setPosicion_x(mh.cursor_pos_x);
        setPosicion_y(mh.cursor_pos_y);

        if(mh.clicked){
            shoot(objetivo);
            System.out.println("Shoot to "+objetivo);
        }
        relased = !mh.clicked;

    }
    public void dibujar_hud(Graphics2D g2d)
    {
        if(colicion){
            g2d.setColor(Color.RED);
        }else
        {
            g2d.setColor(Color.GREEN);
        }
        g2d.drawOval((int) (getPosicion_x()+ajuste_x), (int) (getPosicion_y()+ajuste_y),20,20);
        g2d.drawLine((int) (getPosicion_x()-5+ajuste_x), (int) (getPosicion_y()+10+ajuste_y), (int) (getPosicion_x()+5+ajuste_x), (int) (getPosicion_y()+10+ajuste_y));
        g2d.drawLine((int) (getPosicion_x()+15+ajuste_x), (int) (getPosicion_y()+10+ajuste_y), (int) (getPosicion_x()+25+ajuste_x), (int) (getPosicion_y()+10+ajuste_y));

        g2d.drawLine((int) (getPosicion_x()+10+ajuste_x), (int) (getPosicion_y()-5+ajuste_y), (int) (getPosicion_x()+10+ajuste_x), (int) (getPosicion_y()+5+ajuste_y));
        g2d.drawLine((int) (getPosicion_x()+10+ajuste_x), (int) (getPosicion_y()+15+ajuste_y), (int) (getPosicion_x()+10+ajuste_x), (int) (getPosicion_y()+25+ajuste_y));

        g2d.setColor(Color.BLACK);
        g2d.drawString("Ammo: "+ammo,10,10);
    }
    public void shoot(Enemigo objetivo)
    {
        if(ammo>0&&objetivo!=null&&relased){
            relased = false;
            ammo--;
            objetivo.recibir_hit(1);
        }
    }

}
