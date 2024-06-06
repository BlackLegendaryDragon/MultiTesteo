package programa1;

import java.util.ArrayList;
import java.util.List;

public class Serpiente {

    private List<Integer> posicionesX;
    private List<Integer> posicionesY;
    private int posInitX;
    private int posInitY;

    public Serpiente(int posInitX, int posInitY) {
        this.posInitX = posInitX;
        this.posInitY = posInitY;
    }

    //getters y setters

    //metodos
    //definir si la pieza es cabeza cuerpo o cola
    public void crearSerpiente(){
        posicionesX = new ArrayList<>();
        posicionesY = new ArrayList<>();
        posicionesX.add(posInitX);
        posicionesY.add(posInitY);
    }
}
