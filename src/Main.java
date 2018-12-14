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
    public static void main(String[] args)
    {
        Logic log;
        GUI g;
        int version;

        if (args.length > 0) {
            version = Integer.parseInt(args[0]);
            if (version == 1) {
                //UI.consoleArgsIntro(version);
                log = new Logic(UI.getMode());
            }
            else if (version==2) {
                g=new GUI();
            }
        }
        else {
            version = UI.getVersion();
            if (version == 1) {
                log = new Logic(UI.getMode());
            }
            else if (version == 2) {
                g = new GUI();
            }
        }
        //System.exit(0);
    }
}
