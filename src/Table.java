/**
 * @author Giorgos Giannios
 * This class creates a table with the cards of the game. There are some methods that handle the cards on the table.
 */
public class Table
{
    private Card[][] tableOfCards;

    /**
     * Initialize the table with the cards.
     *
     * @param x the number of rows of the table
     * @param y the number of columns of the table
     */
    public Table (int x,int y)
    {
        tableOfCards= new Card[x][y];
    }

    /**
     * Appears the card
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void openCard(int x,int y){
        //UI
    }
    /**
     * Hide the card
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void closeCard(int x,int y){
        //UI
    }
    /**
     * Set the card as paired and makes it unable to be chosen again.
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void unableCard(int x,int y){
        tableOfCards[x][y].setPairedTrue();
    }
}
