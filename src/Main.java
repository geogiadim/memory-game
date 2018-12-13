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
        //Test if terminal version
        if (args.length == 1) {
            if (args[0].equals("-t")) {
                askMode();
            } else if (args[0].equals("-g")) {
                initGUI();
            }
        } else if (args.length == 2) {
            if (args[0].equals("-t")) {
                int mode = Integer.parseInt(args[1]);
                if (mode == 1 || mode == 2 || mode == 3) {
                    UI.consoleArgsIntro(mode);
                    Logic log = new Logic(mode);
                } else askMode();
            } else if (args[0].equals("-g")) {
                initGUI();
            }
        } else {
            if (chooseVersionUI.getVersion() == 1) {
                askMode();
            } else {
                initGUI();
            }
        }
        System.exit(0);
    }

    private static void initGUI() {
        System.out.println("GUI");
    }

    private static void askMode() {
        Logic log = new Logic(UI.getMode());
    }
}
