import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * UI Class handles all interactions with the Screen and the Player using static classes.
 * This Class clears the console screen, prints graphics for Cards and handles user's inputs.
 *
 * @author Giorgos Christidis
 * @author Giorgos Giannios
 */
public class UI {
    //Times in secs for delays.
    private final static int MESSAGE_DELAY = 5;
    private final static int RULES_DELAY = 8;
    private final static int PREVIEW_TIME = 10;
    //Card Numbers to strings of numerical order.
    private final static String[] CARD_NO_LETTERS = {"first", "second", "third"};
    //ANSI codes for linux based systems to clear screen.
    private final static String ANSI_CLS = "\u001b[2J";
    private final static String ANSI_HOME = "\u001b[H";
    //Strings in place of spaces in print commands.
    private final static String TAB = "    "; //4 Spaces
    // Coordinates of cards.
    private static int x1, x2, y1, y2, x3, y3;
    //Boolean to handle Card values appearing for preview before actual game play.
    private static boolean previewMode;
    private static int mode = 0;

    /**
     * Handles mode selection. Checks for proper mode and prepares game for next
     *
     * @return mode Returns given mode.
     */
    public static int getMode() {
        previewMode = true;
        Scanner sc = new Scanner(System.in);

        intro();
        modes();

        while (sc.hasNextInt()) {
            if (!sc.hasNextInt() && (mode < 1 || mode > 3)) {
                clearScreen();
                intro();
                System.out.println(TAB + "You have to chose one of the three modes.");
                System.out.println(TAB + "Try again:\n");
                continue;
            }
            mode = sc.nextInt();
            break;
        }

        chosenMode(mode);
        return mode;
    }

    /**
     * Graphics related method to print game name.
     */
    private static void intro() {
        clearScreen();
        System.out.println(TAB + "   _______________________ ");
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
    private static void modes() {
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
    private static void chosenMode(int mode) {
        if (mode == 1) {
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Basic mode.");
            System.out.println(TAB + "Let's play!\n");
        } else if (mode == 2) {
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Double mode.");
            System.out.println(TAB + "Let's play!\n");
        } else if (mode == 3) {
            clearScreen();
            intro();
            System.out.println(TAB + "You have chosen Triple mode.");
            System.out.println(TAB + "Let's play!\n");
        }
    }

    /**
     * Handles console argument input.
     *
     * @param m The game mode given by the player.
     */
    public static void consoleArgsIntro(int m) {
        intro();
        previewMode = true;
        chosenMode(m);
    }

    /**
     * Clears screen. Works for both Windows and Linux based OS.
     */
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                //System.out.println(">>>IN WINDOWS CLEAR SCREEN!");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.flush();
            } else {
                //System.out.println(">>>IN LINUX CLEAR SCREEN!");
                System.out.print(ANSI_CLS + ANSI_HOME);
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.err.print("Could not identify OS!");
        }
    }

    public static void showCardsPreview(Table newTable) {
        System.out.println(TAB + "Cards will be revealed for " + PREVIEW_TIME + " seconds. Try to remember as many as you can.");
        delay(MESSAGE_DELAY);
        showCards(newTable);

        previewMode = false;
        delay(PREVIEW_TIME);

        clearScreen();
        intro();
        rules(mode);
    }

    /**
     * Handles graphical Card printing and showing first time Card values.
     * Draws Card-like shapes in console and shows Card Values.
     * Handles empty space left by paired Cards.
     *
     * @param newTable The 2D Table of Cards.
     */

    public static void showCards(Table newTable) {
        DrawTableUI.showTable(newTable, previewMode);
    }

    public static void rules(int gameMode) {
        System.out.println();
        if (gameMode == 3) {
            System.out.println(TAB + "In order to choose a card you have to type its coordinates as you see them in the cards.");
            System.out.println(TAB + "You have to choose three cards in each round.");
        } else {
            System.out.println(TAB + "In order to choose a card you have to type its coordinates as you see them in the cards.");
            System.out.println(TAB + "You have to choose two cards in each round.");
        }
        delay(RULES_DELAY);
    }

    public static int getX(int cardNo) {
        switch (cardNo) {
            case 0:
                return x1;
            case 1:
                return x2;
            case 2:
                return x3;
            default:
                //Fix this!
                return -2;
        }
    }

    public static int getY(int cardNo) {
        switch (cardNo) {
            case 0:
                return y1;
            case 1:
                return y2;
            case 2:
                return y3;
            default:
                //Fix this too!
                return -1;
        }
    }

    public static void choiceOutOfBounds(Table newTable) {
        System.out.println(TAB + "Invalid coordinates!");
        System.out.println(TAB + "X must be in range of [1," + newTable.sizeX() + "]");
        System.out.println(TAB + "Y must be in range of [1," + newTable.sizeY() + "]");
        System.out.println(TAB + "Try again!");
        delay(MESSAGE_DELAY);
    }

    public static void choiceIsOpen() {
        System.out.println(TAB + "You have chosen an already open card. Try again!");
        delay(MESSAGE_DELAY);
    }

    public static void choiceIsPaired() {
        System.out.println(TAB + "This card is already paired. Try again!");
        delay(MESSAGE_DELAY);
    }

    public static void showCorrectOrNot(boolean correct) {
        System.out.println();
        if (correct) System.out.println(TAB + "Correct Choice!!!");
        else System.out.println(TAB + "Wrong Choice!!!");
        delay(MESSAGE_DELAY);
    }

    public static void congrats(int tries) {
        clearScreen();
        intro();
        System.out.println();
        System.out.println(TAB + "Congratulations, you matched all the cards in " + tries + " tries.");
    }

    public static void clsIntroShowCards(Table newTable) {
        clearScreen();
        intro();
        showCards(newTable);
    }

    public static void userChoice(int cardNo) {
        System.out.println();
        System.out.println(TAB + "Give the coordinates for the " + CARD_NO_LETTERS[cardNo] + " card: ");
        checkCharStoreInt(cardNo);
    }

    /**
     * Checks if coordinates of a card are not chars. Takes the Card number and scans the coordinates.
     *
     * @param cardNo The Card number to scan for.
     */
    private static void checkCharStoreInt(int cardNo) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                switch (cardNo) {
                    case 0: {
                        x1 = sc.nextInt() - 1;
                        y1 = sc.nextInt() - 1;
                        sc.nextLine();
                        break;
                    }
                    case 1: {
                        x2 = sc.nextInt() - 1;
                        y2 = sc.nextInt() - 1;
                        sc.nextLine();
                        break;
                    }
                    case 2: {
                        x3 = sc.nextInt() - 1;
                        y3 = sc.nextInt() - 1;
                        sc.nextLine();
                        break;
                    }
                }
                break;
            } catch (InputMismatchException ime) {
                sc.nextLine();
                System.out.println(TAB + "You must type only numbers");
                System.out.println(TAB + "Try again:");
            }
        }
    }

    /**
     * Pauses the program for given seconds.
     *
     * @param seconds Delay in seconds.
     */
    private static void delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}