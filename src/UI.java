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
    // Coordinates of cards.
    private static int x1,x2,y1,y2,x3,y3;

    //Boolean to handle Card values appearing for preview before actual game play.
    private static boolean previewMode;

    //Times for delays.
    private final static int MESSAGE_DELAY = 5;
    private final static int PREVIEW_TIME = 10;

    //ANSI codes for linux based systems to clear screen.
    private final static String ANSI_CLS = "\u001b[2J";
    private final static String ANSI_HOME = "\u001b[H";

    //Strings in place of spaces in print commands.
    private final static String TAB = "    "; //4 Spaces
    private final static String EMPTY_LINE = "       "; //7 Spaces

    private static int mode;
    /**
     * Handles mode selection. Checks for proper mode and prepares game for next
     *
     * @return mode Returns given mode.
     */
    public static int getMode(){
        previewMode = true;
        Scanner sc = new Scanner(System.in);

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
     * @param m The game mode given by the player.
     */
    public static void consoleArgsIntro(int m){
        intro();
        previewMode = true;
        mode=m;
        chosenMode(m);
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
    public static void showCards(Table newTable){
        //Preview Mode for first time.
        if (previewMode){
            System.out.println(TAB + "Cards will be revealed for " + PREVIEW_TIME + " seconds. Try to remember as many as you can.");
            delay(MESSAGE_DELAY);
        }
        //Preview Mode delay.
        if (previewMode){
            try{
                previewMode = false;
                Thread.sleep(PREVIEW_TIME * 1000);
                clearScreen();
                intro();
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    /*public static void printTest(Table newTable){
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
    }*/

    /**
     * Handles the player's choices for the cards which wants to open and prints the appropriate messages
     *
     * @param newTable object of the class Table
     */
    public static void userChoice(Table newTable)
    {
        int tries=0;
        int numberOfPairedCards=0;
        boolean wrongXY,same;
        Scanner sc= new Scanner(System.in);
        showCards(newTable);
        if (mode==3)
            System.out.println("\n" + TAB + "In order to chose a card you have to type its coordinates as you see them in the cards.\n" + TAB + "You have to chose three cards in each round. You can choose the third card only when the first two cards are same");
        else
            System.out.println("\n" + TAB + "In order to chose a card you have to type its coordinates as you see them in the cards.\n" + TAB + "You have to chose two cards in each round.");

        do {
            //check out for the first card
            do {
                wrongXY=false;
                System.out.println("\n" + TAB + "Give the coordinates for the first card: ");
                checkCharReturnInt(1);

                if (x1>newTable.sizeX()-1 || x1<0 || y1>newTable.sizeY()-1 || y1<0)
                {
                    System.out.println(TAB + "Invalid coordinates.\n" + TAB + "X must be in range of [1,"+newTable.sizeX()+"]\n" + TAB+ "Y must be in range of [1,"+newTable.sizeY()+"]\n"+ TAB +"Try again!");
                    wrongXY=true;
                }
                if (!wrongXY) {
                    if (newTable.isCardPaired(x1, y1)) {
                        System.out.println(TAB + "This card is already paired. Try again!");
                    }
                }
            }while (wrongXY || newTable.isCardPaired(x1,y1));

            newTable.openCard(x1, y1);
            clearScreen();
            intro();
            showCards(newTable);

            //check out for the second card
            do{
                same=false;
                wrongXY=false;
                System.out.println("\n" + TAB + "Give the coordinates for the second card: ");
                checkCharReturnInt(2);

                if (x2>newTable.sizeX()-1 || x2<0 || y2>newTable.sizeY()-1 || y2<0)
                {
                    System.out.println(TAB + "Invalid coordinates.\n" + TAB + "X must be in range of [1,"+newTable.sizeX()+"]\n" + TAB + "Y must be in range of [1,"+newTable.sizeY()+"]\n" + TAB + "Try again!");
                    wrongXY=true;
                }
                if (!wrongXY) {
                    if (x1 == x2 && y1 == y2 ) {
                        same = true;
                        System.out.println(TAB + "This is your first choice. Chose again a different card: ");
                    }
                }
                if (!wrongXY && !same && newTable.isCardPaired(x2,y2))
                {
                    System.out.println(TAB + "This card is already paired. Try again!");
                }
            }while (same || wrongXY || newTable.isCardPaired(x2,y2));

            newTable.openCard(x2, y2);
            clearScreen();
            intro();
            showCards(newTable);

            if (mode == 3) {
                //check if the first two cards are same
                if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)) {
                    //check out for the third card
                    do {
                        same = false;
                        wrongXY = false;
                        System.out.println("\n" + TAB + "Give the coordinates for the third card: ");
                        checkCharReturnInt(3);

                        if (x3 > newTable.sizeX() - 1 || x3 < 0 || y3 > newTable.sizeY() - 1 || y3 < 0) {
                            System.out.println(TAB + "Invalid coordinates.\n" + TAB + "X must be in range of [1," + newTable.sizeX() + "]\n" + TAB + "Y must be in range of [1," + newTable.sizeY() + "]\n" + TAB + "Try again!");
                            wrongXY = true;
                        }
                        if (!wrongXY) {
                            if (x3 == x1 && y3 == y1) {
                                same = true;
                                System.out.println(TAB + "This is your first choice. Chose again a different card: ");
                            } else if (x3 == x2 && y3 == y2) {
                                same = true;
                                System.out.println(TAB + "This is your second choice. Chose again a different card: ");
                            }
                        }
                        if (!wrongXY && !same && newTable.isCardPaired(x3, y3)) {
                            System.out.println(TAB + "This card is already paired. Try again!");
                        }
                    } while (same || wrongXY || newTable.isCardPaired(x3, y3));

                    newTable.openCard(x3, y3);
                    clearScreen();
                    intro();
                    showCards(newTable);

                    if (newTable.getCardValue(x2, y2) == newTable.getCardValue(x3, y3)) {
                        newTable.unableCard(x1, y1);
                        newTable.unableCard(x2, y2);
                        newTable.unableCard(x3, y3);
                        System.out.println("\n" + TAB + "Correct!!");
                        numberOfPairedCards += 3;
                        tries++;
                        delay(MESSAGE_DELAY);
                    }
                    else {
                        System.out.println("\n" + TAB + "Wrong!!");
                        delay(MESSAGE_DELAY);
                        tries++;
                        newTable.closeCard(x1, y1);
                        newTable.closeCard(x2, y2);
                        newTable.closeCard(x3, y3);
                    }
                    clearScreen();
                    intro();
                    showCards(newTable);
                }
                else
                {
                    System.out.println("\n" + TAB + "Wrong!!. You can not choose the third card.");
                    delay(MESSAGE_DELAY);
                    tries++;
                    newTable.closeCard(x1, y1);
                    newTable.closeCard(x2, y2);
                }

            }
            else
            {
                if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)) {
                    newTable.unableCard(x1, y1);
                    newTable.unableCard(x2, y2);

                    System.out.println("\n" + TAB + "Correct!!");
                    numberOfPairedCards += 2;
                    tries++;
                    delay(MESSAGE_DELAY);
                }
                else {
                    System.out.println("\n" + TAB + "Wrong!!");
                    delay(MESSAGE_DELAY);
                    tries++;
                    newTable.closeCard(x1, y1);
                    newTable.closeCard(x2, y2);
                }
            }
            clearScreen();
            intro();
            showCards(newTable);

        } while (numberOfPairedCards<newTable.sizeOfTable());
        clearScreen();
        intro();
        System.out.println("\n"+ TAB + "Congratulations, you matched all the cards in "+ tries +" tries.");
    }

    /**
     * Checks if coordinates of a card are not chars. Takes the Card number and scans the coordinates.
     * @param cardNo The Card number to scan for.
     */
    private static void checkCharReturnInt(int cardNo){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                switch (cardNo){
                    case 1:{
                        x1=sc.nextInt()-1;
                        y1=sc.nextInt()-1;
                        sc.nextLine();
                        break;
                    }
                    case 2:{
                        x2=sc.nextInt()-1;
                        y2=sc.nextInt()-1;
                        sc.nextLine();
                        break;
                    }
                    case 3:{
                        x3=sc.nextInt()-1;
                        y3=sc.nextInt()-1;
                        sc.nextLine();
                        break;
                    }
                }
                break;
            } catch (InputMismatchException ime){
                sc.nextLine();
                System.out.println(TAB + "You must type only numbers");
                System.out.println(TAB + "Try again:");
            }
        }
    }


    /**
     * Stops the program for given seconds.
     *
     * @param seconds Delay in seconds.
     */
    private static void delay (int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}