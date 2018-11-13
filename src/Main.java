/**
 * @author Giorgos Christidis
 */

public class Main {

    public static void main(String[] args)
    {
        Logic log;
        int mode;
        if (args.length > 0){
            mode = Integer.parseInt(args[0]);
            if (mode == 1 || mode == 2 || mode == 3){
                UI.consoleArgsIntro(mode);
                log = new Logic(mode);
            }
        }
        else {
            log = new Logic(UI.getMode());
        }
        //System.out.println("EXIT");
        System.exit(0);
    }
}
