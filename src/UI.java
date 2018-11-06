import java.io.IOException;
import java.util.Scanner;

public class UI {

    final static String ANSI_CLS = "\u001b[2J";
    final static String ANSI_HOME = "\u001b[H";

    public static int getMode(){
        intro();
        modes();

        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();

        while (mode!=1 && mode!=2 && mode!=3)
        {
            clearScreen();
            System.out.println("    You have to chose one of the three modes. Try again:\n");
            mode=scanner.nextInt();
        }

        if (mode==1){
            clearScreen();
            System.out.println("    You have chosen Basic mode.");
            System.out.println("    Let's play!");
        }
        else if (mode==2){
            clearScreen();
            System.out.println("    You have chosen Double mode.");
            System.out.println("    Let's play!");
        }
        else {
            clearScreen();
            System.out.println("    You have chosen Triple mode.");
            System.out.println("    Let's play!");
        }

        return mode;
    }

    private static void intro(){
        clearScreen();
        System.out.println("       _______________________    ");
        System.out.println("     /|                       |   ");
        System.out.println("    | |                       |   ");
        System.out.println("    | |      MEMORY  GAME     |   ");
        System.out.println("    | |                       |   ");
        System.out.println("    | |_______________________|   ");
        System.out.println("    |/_______________________/    \n");
    }

    private static void modes(){
        System.out.println("    Choose a game mode:");
        System.out.println("    >Type 1 : for Basic mode.");
        System.out.println("    >Type 2 : for Double mode.");
        System.out.println("    >Type 3 : for Triple mode.");
    }

    //Clears screen
    private static void clearScreen(){
        try {
            //System.out.println(">>>IN CLEAR SCREEN!");
            if (System.getProperty("os.name").contains("Windows")) {
                //System.out.println(">>>IN WINDOWS CLEAR SCREEN!");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.flush();
            }
            else {
                //System.out.println(">>>IN LINUX/OSX CLEAR SCREEN!");
                System.out.print(ANSI_CLS + ANSI_HOME);
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {}
    }


}