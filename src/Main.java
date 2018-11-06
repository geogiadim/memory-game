import java.util.Scanner;

/**
 * @author Giorgos Giannios
 * This isthe main class whichh asks the player which version of the game wants to play.
 */
public class Main {

    private static int mode;
    private static Logic log;
    public static void main(String[] args)
    {
        System.out.println("There are three versions of the game.\nType 1: for the basic version.\nType 2: for the double version.\nType 3: for the triple version.");
        Scanner scanner = new Scanner(System.in);
        mode = scanner.nextInt();
        while (mode!=1 && mode!=2 && mode!=3)
        {
            System.out.println("You have to chose one of the tree versions. Try again");
            mode=scanner.nextInt();
        }
        if (mode==1)
            System.out.println("You have chosen the basic version.\nLet's play!");
        else if (mode==2)
            System.out.println("You have chosen the double version.\nLet's play!");
        else System.out.println("You have chosen the triple version.\nLet's play!");

        log = new Logic(mode);

    }


}
