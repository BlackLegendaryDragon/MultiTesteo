package programa2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener {
    public int cursor_pos_x = 0;
    public int cursor_pos_y = 0;

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        cursor_pos_x = e.getX()-13;
        cursor_pos_y = e.getY()-35;
        System.out.printf("posX %d, posY %d\n",cursor_pos_x,cursor_pos_y);
    }
}
