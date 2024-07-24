package programa3;

public class NPC extends Entity
{
    private String nombre;
    private byte bando;

    public NPC(int x, int y, String nombre, byte bando)
    {
        super(x, y);
        setNombre(nombre);
        setBando(bando);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBando(byte bando) {
        this.bando = bando;
    }

    public byte getBando() {
        return bando;
    }
}
