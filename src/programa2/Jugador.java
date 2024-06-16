package programa2;

public class Jugador extends Entidad{
    KeyHandler kh;

    public Jugador(int posicion_x,int posicion_y,int speed,KeyHandler kh)
    {
        super(posicion_x,posicion_y,speed);
        this.kh = kh;
    }

    //funciones personalizadas
    @Override
    public void update()
    {
        //System.out.println(kh.isW());
        System.out.println("posX"+posicion_x+"posY"+posicion_y+"Speed"+getSpeed());
        //System.out.println(kh.a);

        if(kh.a){posicion_x+=-speed;}
        if(kh.d){posicion_x+=speed;}
        if(kh.w){posicion_y+=-speed;}
        if(kh.s){posicion_y+=speed;}

    }

}
