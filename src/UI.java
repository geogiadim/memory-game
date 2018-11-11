import java.io.IOException;
import java.util.Scanner;

/**
 * @author Giorgos Christidis
 * @author Giorgos Giannios
 */
public class UI {

    private final static String ANSI_CLS = "\u001b[2J";
    private final static String ANSI_HOME = "\u001b[H";

    private final static char[] LETTERS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};

    private static int sizeX;
    private static int sizeY;

    private final static String TAB = "    "; //4 Spaces
    private final static String EMPTY_LINE = "       "; //7 Spaces

    public static int getMode(){
        intro();
        modes();
        int mode;

        Scanner sc = new Scanner(System.in);

        while (true){
            try {
                mode = Integer.parseInt(sc.nextLine());
                if (mode!=1 && mode!=2 && mode!=3){
                    clearScreen();
                    intro();
                    System.out.println("    You have to chose one of the three modes.");
                    System.out.println("    Try again:\n");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                clearScreen();
                intro();
                System.out.println("    You have to chose one of the three modes.");
                System.out.println("    Try again:\n");
            }
        }

        chosenMode(mode);
        sc.close();

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
        System.out.println("    |/________________________/    \n");
    }

    private static void modes(){
        System.out.println("    Choose a game mode:");
        System.out.println("    >Type 1 : for Basic mode.");
        System.out.println("    >Type 2 : for Double mode.");
        System.out.println("    >Type 3 : for Triple mode.");
    }

    private static void chosenMode(int mode){
        if (mode==1){
            clearScreen();
            intro();
            sizeX = 4;
            sizeY = 6;
            System.out.println("    You have chosen Basic mode.");
            System.out.println("    Let's play!\n");
        }
        else if (mode==2){
            clearScreen();
            intro();
            sizeX = 6;
            sizeY = 8;
            System.out.println("    You have chosen Double mode.");
            System.out.println("    Let's play!\n");
        }
        else if (mode == 3){
            clearScreen();
            intro();
            sizeX = sizeY = 6;
            System.out.println("    You have chosen Triple mode.");
            System.out.println("    Let's play!\n");
        }
    }

    public static void consoleArgsIntro(int mode){
        intro();
        chosenMode(mode);
    }

    //Clears screen

    public static void showClosedCards (Table newTable) {
        try
        {
            Thread.sleep(15000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        clearScreen();
        intro();
        System.out.print("\b");
        for (int i = 0; i < newTable.sizeX(); i++) {
            for (int lines = 0; lines < 4; lines++) {
                System.out.println();
                for (int j = 0; j < newTable.sizeY(); j++) {
                    switch (lines){
                        case 0: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j)) {
                                System.out.print("  _ _  ");
                            } else {
                                System.out.print("  _ _  ");
                            }
                            break;
                        }
                        case 1: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j)) {
                                System.out.print(" |   | ");
                            } else {
                                System.out.print(" |" + (i+1) + "  | ");
                            }
                            break;
                        }
                        case 2: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j)) {
                                System.out.print(" | " + newTable.getCardValue(i,j) + " | ");
                            } else {
                                System.out.print(" |  " + (j+1) + "| ");
                            }
                            break;
                        }
                        case 3: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j)) {
                                System.out.print(" |_ _| ");
                            } else {
                                System.out.print(" |_ _| ");
                            }
                            break;
                        }
                    }
                }
            }
        }
        System.out.println();
    }
    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                //System.out.println(">>>IN WINDOWS CLEAR SCREEN!");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.flush();
            }
            else {
                //System.out.println(">>>IN LINUX CLEAR SCREEN!");
                System.out.print(ANSI_CLS + ANSI_HOME);
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.print("Could not identify OS!");
        }
    }

    public static void printTest(Table newTable){
        System.out.println(" Cards will be revealed for 15 seconds. Try to remember as many as you can.\n");
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        for (int i=0; i < newTable.sizeX(); i++)
        {
            for (int j=0; j < newTable.sizeY(); j++)
                System.out.print("  "+LETTERS[newTable.getCardValue(i,j)] + "  ");
            System.out.println("\n");
        }
    }

   /* public void userChoice(Table newTable)
    {
        int x1,x2,y1,y2;
        int numberOfPairedCards=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("In order to chose a card you have to type its coordinates as you see them in the cards.\nYou have to chose two cards in each round.");

        System.out.println("Give the coordinates for the first card: ");
        x1= sc.nextInt();
        y1= sc.nextInt();
        newTable.openCard(x1,y1);

        System.out.println("Give the coordinates for the second card: ");
        x2= sc.nextInt();
        y2= sc.nextInt();
        newTable.openCard(x2,y2);
        while (numberOfPairedCards<newTable.sizeOfTable()) {

            if (karta1==karta2) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                numberOfPairedCards+=2;

                System.out.println("Give the coordinates for the first card: ");
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                newTable.openCard(x1, y1);

                System.out.println("Give the coordinates for the second card: ");
                x2 = sc.nextInt();
                y2 = sc.nextInt();
                newTable.openCard(x2, y2);
            }
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);

                System.out.println("Give the coordinates for the first card: ");
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                newTable.openCard(x1, y1);

                System.out.println("Give the coordinates for the second card: ");
                x2 = sc.nextInt();
                y2 = sc.nextInt();
                newTable.openCard(x2, y2);
            }
        }
    }*/
}