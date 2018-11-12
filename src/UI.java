import java.io.IOException;
import java.util.Scanner;

/**
 * @author Giorgos Christidis
 * @author Giorgos Giannios
 *
 * UI Class handles all interactions with the Screen and the Player using static classes.
 * This Class clears the console screen, prints graphics for Cards and handles user's inputs.
 */
public class UI {
    //Boolean to handle Card values appearing for preview before actual game play.
    private static boolean previewMode;

    //Times for delays.
    private final static int MESSAGE_DELAY = 5;
    private final static int PREVIEW_TIME = 15;

    //Char list for Card Value.
    private final static char[] LETTERS = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};

    //ANSI codes for linux based systems to clear screen.
    private final static String ANSI_CLS = "\u001b[2J";
    private final static String ANSI_HOME = "\u001b[H";

    //Strings in place of spaces in print commands.
    private final static String TAB = "    "; //4 Spaces
    private final static String EMPTY_LINE = "       "; //7 Spaces

    /**
     * Handles mode selection. Checks for proper mode and prepares game for next
     *
     * @return mode Returns given mode.
     */
    public static int getMode(){
        previewMode = true;
        Scanner sc = new Scanner(System.in);
        int mode;

        intro();
        modes();

        while (true){
            try {
                mode = Integer.parseInt(sc.nextLine());
                if (mode!=1 && mode!=2 && mode!=3){
                    clearScreen();
                    intro();
                    System.out.println(TAB + "You have to chose one of the three modes.");
                    System.out.println(TAB + "Try again:\n");
                    continue;
                }
                break;
            } catch (NumberFormatException nfe) {
                clearScreen();
                intro();
                System.out.println(TAB + "You have to chose one of the three modes.");
                System.out.println(TAB + "Try again:\n");
            }
        }

        chosenMode(mode);
        return mode;
    }

    /**
     * Graphics related method to print game name.
     */
    private static void intro(){
        clearScreen();
        System.out.println(TAB + "   _______________________");
        System.out.println(TAB + " /|                       |");
        System.out.println(TAB + "| |                       |");
        System.out.println(TAB + "| |      MEMORY  GAME     |");
        System.out.println(TAB + "| |                       |");
        System.out.println(TAB + "| |_______________________|");
        System.out.println(TAB + "|/________________________/\n");
    }

    /**
     * Prints mode types to screen.
     */
    private static void modes(){
        System.out.println(TAB + "Choose a game mode:");
        System.out.println(TAB + ">Type 1 : for Basic mode.");
        System.out.println(TAB + ">Type 2 : for Double mode.");
        System.out.println(TAB + ">Type 3 : for Triple mode.");
    }

    /**
     * Prints proper message for given game mode.
     *
     * @param mode The game mode given by the player.
     */
    private static void chosenMode(int mode){
        if (mode==1){
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Basic mode.");
            System.out.println(TAB + "Let's play!\n");
        }
        else if (mode==2){
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Double mode.");
            System.out.println(TAB + "Let's play!\n");
        }
        else if (mode == 3){
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Triple mode.");
            System.out.println(TAB + "Let's play!\n");
        }
    }

    /**
     * Handles console argument input.
     *
     * @param mode The game mode given by the player.
     */
    public static void consoleArgsIntro(int mode){
        intro();
        chosenMode(mode);
    }

    /**
     * Clears screen. Works for both Windows and Linux based OS.
     * */
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

    /**
     * Handles graphical Card printing and showing first time Card values.
     * Draws Card-like shapes in console and shows Card Values.
     * Handles empty space left by paired Cards.
     *
     * @param newTable The 2D Table of Cards.
     */
    public static void showClosedCards (Table newTable) {
        try
        {
            Thread.sleep(PREVIEW_TIME*1000);
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


    public static void printTest(Table newTable){
        System.out.println(" Cards will be revealed for 15 seconds. Try to remember as many as you can.\n");
        try
        {
            Thread.sleep(MESSAGE_DELAY *1000);
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

    public static void userChoice(Table newTable)
    {
        int x1,x2,y1,y2;
        int numberOfPairedCards=0;
        boolean wrongXY,same;
        Scanner sc= new Scanner(System.in);
        System.out.println("In order to chose a card you have to type its coordinates as you see them in the cards.\nYou have to chose two cards in each round.");

        do {
            //check out for the first card
            do {
                wrongXY=false;
                System.out.println("Give the coordinates for the first card: ");
                x1 = sc.nextInt() - 1;
                y1 = sc.nextInt() - 1;
                if (x1>newTable.sizeX() || x1<0 || y1>newTable.sizeY() || y1<0)
                {
                    System.out.println("Invalid coordinates.\nX must be in range of [1,"+newTable.sizeX()+"]\nY must be in range of [1,"+newTable.sizeY()+"]\nTry again!");
                    wrongXY=true;
                }
                if (newTable.isCardPaired(x1,y1) && !wrongXY)
                {
                    System.out.println("This card is already paired. Try again!");
                }
            }while (wrongXY || newTable.isCardPaired(x1,y1));
            //check out for the second card
            do{
                same=false;
                wrongXY=false;
                System.out.println("Give the coordinates for the second card: ");
                x2 = sc.nextInt()-1;
                y2 = sc.nextInt()-1;
                if (x2>newTable.sizeX() || x2<0 || y2>newTable.sizeY() || y2<0)
                {
                    System.out.println("Invalid coordinates.\nX must be in range of [1,"+newTable.sizeX()+"]\nY must be in range of [1,"+newTable.sizeY()+"]\nTry again!");
                    wrongXY=true;
                }
                if (x1==x2 && y1==y2 && !wrongXY)
                {
                    same=true;
                    System.out.println("This is your first choice. Chose again a different card: ");
                }
                if (newTable.isCardPaired(x2,y2) && !same && !wrongXY)
                {
                    System.out.println("This card is already paired. Try again!");
                }
            }while (same || wrongXY || newTable.isCardPaired(x2,y2));
            newTable.openCard(x1, y1);
            newTable.openCard(x2, y2);


            if (newTable.getCardValue(x1,y1)  == newTable.getCardValue(x2,y2)) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                System.out.println("Correct!!");
                numberOfPairedCards+=2;
            }
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);
            }
            clearScreen();
            intro();
            showClosedCards(newTable);
        } while (numberOfPairedCards<newTable.sizeOfTable());
        System.out.println("Congratulations, you matched all the cards!");
    }

}