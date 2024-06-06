package programa2;

public class Jugador extends Entidad{
    KeyHandler kh;

    public Jugador(int posicion_x,int posicion_y,int velocidad,KeyHandler kh)
    {
        super(posicion_x,posicion_y,velocidad);
        this.kh = kh;
    }

    public KeyHandler getKh() {
        return kh;
    }
    public void setKh(KeyHandler kh) {
        this.kh = kh;
    }

    //funciones personalizadas
    public void update()
    {
        //System.out.println("posX"+getPosicion_x()+"posY"+getPosicion_y());
        System.out.println(kh.a);
        if(kh.a){setPosicion_x(getPosicion_x()-velocidad);}
        if(kh.d){setPosicion_x(getPosicion_x()+velocidad);}
        if(kh.w){setPosicion_y(getPosicion_y()-velocidad);}
        if(kh.s){setPosicion_y(getPosicion_y()+velocidad);}

    }
}
