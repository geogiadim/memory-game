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
        Logic log;

        if (version == 1) {
            int mode;
            if (args.length > 0) {
                mode = Integer.parseInt(args[0]);
                if (mode == 1 || mode == 2 || mode == 3) {
                    UI.consoleArgsIntro(mode);
                    log = new Logic(mode);
                }
            } else {
                log = new Logic(UI.getMode());
            }
        } else if (version == 2) {

        }
        System.exit(0);
    }
}
