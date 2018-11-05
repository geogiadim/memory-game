import java.io.IOException;
import java.util.Scanner;

public class UI {

    final static String ANSI_CLS = "\u001b[2J";
    final static String ANSI_HOME = "\u001b[H";

    public static int getMode(){
        intro();
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        return mode;
    }

    private static void intro(){
        clearScreen();
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

    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}