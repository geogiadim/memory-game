import java.util.Random;

/**
 * This class represents the logic of the game. Creates the table with the cards and separates the game in the three different types.
 * This class is connected to Ui in order to make the game interactive to the player.
 *
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 */
public class Logic {

    private Table newTable;

    private int x1 = 0;
    private int y1 = 0;
    private int x2 = 0;
    private int y2 = 0;
    private int x3 = 0;
    private int y3 = 0;

    /**
     * Initializes the appropriate table and chooses the correct version to start the game.
     *
     * @param mode the type of the game.
     */
    public Logic(int mode) {

        if (mode == 1) {
            newTable = new Table(4, 6);
            basicDoubleGame();
        }
        else if (mode == 2) {
            newTable = new Table(6, 8);
            basicDoubleGame();
        }
        else if (mode == 3) {
            newTable = new Table(6, 6);
            tripleGame();
        }
        else if (mode == 4){
            newTable= new Table(6, 4);
            duelGame();
        }
    }

    /**
     * This is the logic for the Basic and Double game.
     */
    private void basicDoubleGame() {
        initTablePairs(1);
        shuffleTable();

        int tries = 0;
        int numberOfPairedCards = 0;

        UI.showCardsPreview(newTable);

        do {
            checkAllCardConditions(2);
            //If Cards are same!
            if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                numberOfPairedCards += 2;
                tries++;
                UI.showCorrectOrNot(true);
            } //else Cards are not same!
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);
                tries++;
                UI.showCorrectOrNot(false);
            }
        } while (numberOfPairedCards < newTable.sizeOfTable());
        UI.congrats(tries);
    }

    /**
     * This is the logic for the triple game.
     */
    private void tripleGame() {
        initTablePairs(3);
        shuffleTable();

        int tries = 0;
        int numberOfPairedCards = 0;

        UI.showCardsPreview(newTable);

        do {
            checkAllCardConditions(3);
            //If Cards are same!
            if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)
                    && newTable.getCardValue(x1, y1) == newTable.getCardValue(x3, y3)) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                newTable.unableCard(x3, y3);
                numberOfPairedCards += 3;
                tries++;
                UI.showCorrectOrNot(true);
            } //else Cards are not same!
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);
                newTable.closeCard(x3, y3);
                tries++;
                UI.showCorrectOrNot(false);
            }
        } while (numberOfPairedCards < newTable.sizeOfTable());
        UI.congrats(tries);
    }

    private void duelGame(){

    }

    /**
     * Asks through the class Ui the player the coordinates of his/her choice card and
     * checks all the possible conditions in order given coordinates to be valid.
     *
     * @param maxCards how many times have to be appeared each card in the table.
     */
    private void checkAllCardConditions(int maxCards) {
        boolean wrongXY;

        for (int cardNo = 0; cardNo < maxCards; cardNo++) {
            do { //False Card Checking!
                wrongXY = false;
                UI.clsIntroShowCards(newTable);
                UI.userChoice(cardNo);
                //Out Of Bounds!
                if (UI.getX(cardNo) > newTable.sizeX() - 1 || UI.getX(cardNo) < 0
                        || UI.getY(cardNo) > newTable.sizeY() - 1 || UI.getY(cardNo) < 0) {
                    UI.choiceOutOfBounds(newTable);
                    wrongXY = true;
                } //Choice is Open!
                else if (newTable.isCardOpen(UI.getX(cardNo), UI.getY(cardNo))) {
                    UI.choiceIsOpen();
                    wrongXY = true;
                } //Choice is Paired!
                else if (newTable.isCardPaired(UI.getX(cardNo), UI.getY(cardNo))) {
                    UI.choiceIsPaired();
                    wrongXY = true;
                }
            } while (wrongXY);

            if (cardNo == 0) {
                x1 = UI.getX(cardNo);
                y1 = UI.getY(cardNo);
                newTable.openCard(x1, y1);
            }
            else if (cardNo == 1) {
                x2 = UI.getX(cardNo);
                y2 = UI.getY(cardNo);
                newTable.openCard(x2, y2);
            }
            else if (cardNo == 2) {
                x3 = UI.getX(cardNo);
                y3 = UI.getY(cardNo);
                newTable.openCard(x3, y3);
            }
            UI.clsIntroShowCards(newTable);
        }
    }

    /**
     * Fills the table with different cards
     */
    private void initTablePairs(int mode) {
        int value = 0;

        if (mode == 1 || mode == 2) {
            //Fills the table with different cards, each card two times
            for (int i = 0; i < newTable.sizeX(); i++) {
                for (int j = 1; j < newTable.sizeY(); j += 2) {
                    newTable.setCardValue(i, j - 1, value);
                    newTable.setCardValue(i, j, value++);
                }
            }
        }
        //Fills the table with different cards, each card three times
        else
        {
            for (int i = 0; i < newTable.sizeX(); i++) {
                for (int j = 2; j < newTable.sizeY(); j += 3) {
                    newTable.setCardValue(i, j - 2, value);
                    newTable.setCardValue(i, j - 1, value);
                    newTable.setCardValue(i, j, value++);
                }
            }
        }
    }

    /**
     * Shuffles the table with the cards
     */
    private void shuffleTable() {
        Random rnd;
        rnd = new Random();
        //Fisher Yates shuffle algorithm for 2D arrays
        for (int i = newTable.sizeX() - 1; i > 0; i--) {
            for (int j = newTable.sizeY() - 1; j > 0; j--) {
                int m = rnd.nextInt(i + 1);
                int n = rnd.nextInt(j + 1);

                int temp = newTable.getCardValue(i, j);
                newTable.setCardValue(i, j, newTable.getCardValue(m, n));
                newTable.setCardValue(m, n, temp);
            }
        }
    }
}
