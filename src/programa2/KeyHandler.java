package programa2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean w,a,s,d;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getKeyChar());
        w=e.getKeyCode()==KeyEvent.VK_W;
        a=e.getKeyCode()==KeyEvent.VK_A;
        s=e.getKeyCode()==KeyEvent.VK_S;
        d=e.getKeyCode()==KeyEvent.VK_D;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        w=false;
        a=false;
        s=false;
        d=false;
    }
}
