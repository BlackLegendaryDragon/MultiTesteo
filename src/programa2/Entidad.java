package programa2;

public abstract class Entidad {
    int posicion_x, posicion_y;
    int velocidad;

    public Entidad(int x, int y, int velocidad) {}

    public void setPosicion_x(int x) {this.posicion_x = x;}
    public void setPosicion_y(int y) {this.posicion_y = y;}
    public void setVelocidad(int velocidad) {this.velocidad = velocidad;}
    public int getPosicion_x() {return posicion_x;}
    public int getPosicion_y() {return posicion_y;}
    public int getVelocidad() {return velocidad;}
}
