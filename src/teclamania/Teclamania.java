package teclamania;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclamania extends JPanel implements KeyListener {

    private String[] tecla =
    {
        "q","w","e","r","t","y","u","i","o",
        "a","s","d","f","g","h","j","k","l",
        "z","x","c","v","b","n","m"
    };

    public Teclamania()
    {

    }

    public void crearTeclas(String[] tipoTeclado, int corte){
        int x=0;
        int y=0;
        for (String s : tipoTeclado) {
            new Tecla(s, x, y);
            x++;
            if (x % corte == 0) {
                x = 0;
                y++;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
