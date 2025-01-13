package programa4;

import java.util.Objects;

public class Personaje
{
    private String nombre;
    private float vida;
    private String foto;
    private boolean estado;

    public Personaje(String nombre, float vida, String foto)
    {
        setNombre(nombre);
        setEstado(true);
        setVida(vida);
        setFoto(foto);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public float getVida(){
        return vida;
    }
    public void setVida(float vida){
        this.vida = vida;
    }
    public String getFoto(){
        return foto;
    }
    public void setFoto(String fotos){
        this.foto = foto;
    }
    public boolean getEstado(){
        return estado;
    }
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    public void setDead(){
        setFoto(Objects.requireNonNull(getClass().getResource("dead.png")).getFile());
    }
}
