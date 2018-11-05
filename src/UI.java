import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class UI {

    public static int getMode(){
        intro();
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        return mode;
    }

    private static void intro(){
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        System.out.println("       ________________________    ");
        System.out.println("      /|                       |   ");
        System.out.println("     | |                       |   ");
        System.out.println("     | |      MEMORY  GAME     |   ");
        System.out.println("     | |                       |   ");
        System.out.println("     | |_______________________|   ");
        System.out.println("     |/_______________________/    ");
        System.out.print("\nChoose Mode: ");
    }
}
