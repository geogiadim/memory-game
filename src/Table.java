/**
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 * This class creates a table with the cards of the game. There are some methods that handle the cards on the table.
 */
public class Table
{
    private Card[][] tableOfCards;
    private int x;
    private int y;
    /**
     * Initialize the table with the cards.
     *
     * @param x the number of rows of the table
     * @param y the number of columns of the table
     */
    public Table (int x,int y)
    {
        tableOfCards= new Card[x][y];
        this.x=x;
        this.y=y;

        for (int i=0;i<sizeX();i++)
        {
            for (int j=0;j<sizeY();j++)
                tableOfCards[x][y] = new Card();
        }
    }

    public void setCardValue (int x, int y, int v){
        tableOfCards[x][y].setValue(v);
    }


    public int getCardValue(int x, int y){
        return tableOfCards[x][y].getValue();
    }

    /**
     * Appears the card
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void openCard(int x,int y){
        //UI
        tableOfCards[x][y].setIsOpen(true);
        tableOfCards[x][y].getValue();
        //return tableOfCards[x][y].getIsOpen();
    }
    /**
     * Hide the card
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void closeCard(int x,int y){
        //UI
        tableOfCards[x][y].setIsOpen(false);
    }
    /**
     * Set the card as paired and makes it unable to be chosen again.
     *
     * @param x the row on which the card is inserted
     * @param y the column on which the card is inserted
     */
    public void unableCard(int x,int y) {
        tableOfCards[x][y].setPairedTrue();
        tableOfCards[x][y].setIsOpen(true);
    }

    public boolean isCardOpen(int x, int y){ return tableOfCards[x][y].getIsOpen(); }

    public boolean isCardPaired(int x, int y){ return tableOfCards[x][y].getIsPaired(); }

    public int sizeX(){return x;}
    public int sizeY(){return y;}
    public int sizeOfTable(){return x*y;}
}
