package programa2;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener, MouseListener {
    public int cursor_pos_x = 0;
    public int cursor_pos_y = 0;

    public boolean clicked = false;

    @Override
    public void mouseDragged(MouseEvent e) {
        cursor_pos_x = e.getX();
        cursor_pos_y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursor_pos_x = e.getX();
        cursor_pos_y = e.getY();
        //System.out.printf("posX %d, posY %d\n",cursor_pos_x,cursor_pos_y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
