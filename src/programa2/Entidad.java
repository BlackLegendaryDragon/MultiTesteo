package programa2;

public abstract class Entidad {
    int posicion_x, posicion_y;
    int speed;
    int velX, velY;

    public Entidad(int x, int y, int speed) {
        this.posicion_x=x;
        this.posicion_y=y;
        this.speed=speed;
    }

    public int getPosicion_x() {
        return posicion_x;
    }

    public int getPosicion_y() {
        return posicion_y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getVelX() {
        return velX;
    }

    public void setPosicion_x(int posicion_x) {
        this.posicion_x = posicion_x;
    }

    public void setPosicion_y(int posicion_y) {
        this.posicion_y = posicion_y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public int getVelY() {
        return velY;
    }
}
