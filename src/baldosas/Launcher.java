package baldosas;

import javax.swing.*;

public class Launcher extends JFrame {
    public static void main(String[] args) {
        new Launcher();
    }
    public Launcher() {
        Game game = new Game();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        add(game);
        game.startThread();
    }
}
