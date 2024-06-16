package programa2;

public class Enemigo extends Entidad
{

    private int hit_points;

    public Enemigo(int x, int y, int speed, int hit_points) {
        super(x, y, speed);
        this.hit_points = hit_points;
    }

    public int getHit_points() {
        return hit_points;
    }
    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }
    @Override
    public void update()
    {
        setPosicion_x(speed+getPosicion_x());
    }

    public void recibir_hit(int hit)
    {
        hit_points -= hit;
        if (hit_points <= 0) {
            death();
        }
    }
    public void death()
    {
        setSpeed(0);
    }

}
