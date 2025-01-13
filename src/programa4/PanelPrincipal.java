package programa4;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {
    private JLabel perfil = new JLabel("Imagen");

    public PanelPrincipal() {
        this.setBackground(Color.BLUE);
        this.setLayout(null);

        Personaje personaje = crearBandido();
        System.out.println(personaje.getNombre());
    }

    public Personaje crearBandido(){
        Personaje pj = new Personaje("maton" ,10f,null);
        return pj;
    }
}
