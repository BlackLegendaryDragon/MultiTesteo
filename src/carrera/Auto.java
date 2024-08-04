package carrera;

import java.awt.*;

public class Auto{
    private String nombre;
    private int velocidad;
    private int posicion;
    private boolean ganador;
    private Color color;

    public Auto(String nombre, int velocidad, int posicion, Color color)
    {
        setNombre(nombre);
        setVelocidad(velocidad);
        setPosicion(posicion);
        setGanador(false);
        setColor(color);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int avanzar()
    {
        return posicion += (int)(Math.random()*velocidad);
    }
}
