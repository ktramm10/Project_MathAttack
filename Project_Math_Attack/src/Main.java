import java.util.Random;

/**
 * Main class of the application.
 * @author Keith Tramm
 */
public class Main {

    /**
     * Main method of the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Game game = new Game("Keith", EDifficulty.EASY);
        GameWindow window = new GameWindow(game);
        game.setWindow(window);
        game.run();

    }
}
