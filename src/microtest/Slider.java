package microtest;

import javax.swing.*;

public class Slider extends JFrame {

    static JFrame frame;

    static JSlider barra;

    public static void main(String[] args) {
        frame = new JFrame();


        Slider slider = new Slider();
        JPanel panel = new JPanel();
        barra = new JSlider();

        panel.add(barra);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        frame.setTitle("Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        new Slider();
    }
}
