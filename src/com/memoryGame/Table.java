package com.memoryGame;

/**
 * This class creates a table with the cards of the game. There are some methods that handle the cards on the table.
 *
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 */
public class Table {
    private Card[][] tableOfCards;
    private int x;
    private int y;

    /**
     * Initializes the table with the cards.
     *
     * @param x the number of rows of the table
     * @param y the number of columns of the table
     */
    public Table(int x, int y) {
        tableOfCards = new Card[x][y];
        this.x = x;
        this.y = y;

        for (int i = 0; i < sizeX(); i++) {
            for (int j = 0; j < sizeY(); j++)
                tableOfCards[i][j] = new Card();
        }
    }

    /**
     * Sets the value of the card
     *
     * @param x the row on which the card is inserted
     * @param y the row on which the card is inserted
     * @param v the value of the card
     */
    void setCardValue(int x, int y, int v) {tableOfCards[x][y].setValue(v);}

    /**
     * Returns the value of the card
     *
     * @param x the row on which the card is inserted
     * @param y the row on which the card is inserted
     * @return the value of the card
     */
    public int getCardValue(int x, int y) {return tableOfCards[x][y].getValue();}

    /**
     * Sets the card as paired and makes it unable to be chosen again.
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    void unableCard(int x, int y) {tableOfCards[x][y].setPairedTrue();}

    /**
     * Returns the number of rows of the table
     *
     * @return the number of rows of the table
     */
    public int sizeX() {return x;}

    /**
     * Returns the number of columns of the table
     *
     * @return the number of columns of the table
     */
    public int sizeY() {return y;}

    /**
     * Returns the size of the table / Number of Cards
     *
     * @return the size of the table
     */
    public int sizeOfTable() {return x * y;}
}
