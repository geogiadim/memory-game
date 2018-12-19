import javax.swing.*;

/**
 * This is the main Class of the project.
 *
 * @author Giorgos Christidis
 */

public class Main {
    /**
     * Passes the game mode to Logic class, either from cmd args or from player interaction with UI class.
     * Finally, when the game is over exits the game.
     *
     * @param args the command line arguments as an array of String objects
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        GUI.createGUI();
    }
}
