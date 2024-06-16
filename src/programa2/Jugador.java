package programa2;

import java.awt.*;

public class Jugador extends Entidad{
    private MouseHandler mh;
    private final int ajuste_x = -4;
    private final int ajuste_y = -6;

    public Jugador(int posicion_x,int posicion_y,int speed,MouseHandler mh)
    {
        super(posicion_x,posicion_y,speed);
        this.mh = mh;
    }

    //funciones personalizadas
    @Override
    public void update()
    {
        //System.out.println(kh.isW());
        //System.out.println("posX"+posicion_x+"posY"+posicion_y+"Speed"+getSpeed());
        //System.out.println(kh.a);
        setPosicion_x(mh.cursor_pos_x);
        setPosicion_y(mh.cursor_pos_y);

    }
    public void dibujar_mirilla(Graphics2D g2d)
    {
        g2d.setColor(Color.RED);
        g2d.drawOval(getPosicion_x()+ajuste_x,getPosicion_y()+ajuste_y,20,20);
        g2d.drawLine(getPosicion_x()-5+ajuste_x,getPosicion_y()+10+ajuste_y,getPosicion_x()+5+ajuste_x,getPosicion_y()+10+ajuste_y);
        g2d.drawLine(getPosicion_x()+15+ajuste_x,getPosicion_y()+10+ajuste_y,getPosicion_x()+25+ajuste_x,getPosicion_y()+10+ajuste_y);

        g2d.drawLine(getPosicion_x()+10+ajuste_x,getPosicion_y()-5+ajuste_y,getPosicion_x()+10+ajuste_x,getPosicion_y()+5+ajuste_y);
        g2d.drawLine(getPosicion_x()+10+ajuste_x,getPosicion_y()+15+ajuste_y,getPosicion_x()+10+ajuste_x,getPosicion_y()+25+ajuste_y);
    }

}
