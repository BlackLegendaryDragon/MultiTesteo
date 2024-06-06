package programa1;

import javax.swing.*;

public class Launcher extends JFrame {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
    }

    private KeyboardListener kl = new KeyboardListener();
    private Game game;

    public Launcher(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Juego");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        game = new Game(kl);
        add(game);
        game.startGameThread();
        addKeyListener(kl);
    }
}
