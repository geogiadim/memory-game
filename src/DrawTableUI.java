/**
 * This class draws the cards in the table either opened or closed.
 *
 * @author Giorgos Christidis
 */
public class DrawTableUI {

    //Char list for Card Value.
    private final static char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};

    //Strings in place of spaces in print commands.
    private final static String TAB = "    "; //4 Spaces
    private final static String EMPTY_LINE = "       "; //7 Spaces

    /**
     * Handles graphical Card printing and showing first time Card values.
     * Draws Card-like shapes in console and shows Card Values.
     * Handles empty spaces by paired Cards.
     *
     * @param newTable    the table with the cards
     * @param previewMode true if cards have to be opened and false if have to be closed
     */
    public static void showTable(Table newTable, boolean previewMode) {
        //Card Drawing.
        for (int i = 0; i < newTable.sizeX(); i++) {
            for (int lines = 0; lines < 4; lines++) {
                System.out.println();
                for (int j = 0; j < newTable.sizeY(); j++) {
                    if (j == 0)
                        System.out.print(TAB);
                    switch (lines) {
                        //First Line.
                        case 0: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j) || previewMode) {
                                System.out.print("  _ _  ");
                            } else {
                                System.out.print("  _ _  ");
                            }
                            break;
                        }
                        //Second Line.
                        case 1: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j) || previewMode) {
                                System.out.print(" |   | ");
                            } else {
                                System.out.print(" |" + (i + 1) + "  | ");
                            }
                            break;
                        }
                        //Third Line.
                        case 2: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j) || previewMode) {
                                System.out.print(" | " + LETTERS[newTable.getCardValue(i, j)] + " | ");
                            } else {
                                System.out.print(" |  " + (j + 1) + "| ");
                            }
                            break;
                        }
                        //Fourth Line.
                        case 3: {
                            if (newTable.isCardPaired(i, j)) {
                                System.out.print(EMPTY_LINE);
                            } else if (newTable.isCardOpen(i, j) || previewMode) {
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
}