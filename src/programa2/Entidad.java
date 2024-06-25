package programa2;

public abstract class Entidad {
    double posicion_x, posicion_y;
    double speed;
    double velX, velY;

    public Entidad(int x, int y, double speed) {
        this.posicion_x=x;
        this.posicion_y=y;
        this.speed=speed;
    }

    public double getPosicion_x() {
        return posicion_x;
    }

    public double getPosicion_y() {
        return posicion_y;
    }

    public double getSpeed() {
        return speed;
    }

    public double getVelX() {
        return velX;
    }

    public void setPosicion_x(double posicion_x) {
        this.posicion_x = posicion_x;
    }

    public void setPosicion_y(double posicion_y) {
        this.posicion_y = posicion_y;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setVelX(double velX) {
        this.velX = velX;
    }

    public void setVelY(double velY) {
        this.velY = velY;
    }

    public double getVelY() {
        return velY;
    }

    public void update() {}
}
