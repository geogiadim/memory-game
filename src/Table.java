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

    public void fillTable (int x, int y)
    {
        char[] letters= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X'};
        int counter=0;
        if (y==8)
        {
            for (int i=0; i<x; i++)
            {
                for (int j=0; j<y;j++)
                {
                    tableOfCards[i][j].setValue(letters[counter]);
                    counter++;
                    if (counter==24)
                    {
                        counter=0;
                    }
                }
            }
        }
        else {
            for (int i=0; i<x; i++)
            {
                for (int j=0; j<y;j++)
                {
                    tableOfCards[i][j].setValue(letters[counter]);
                    counter++;
                    if (counter==12)
                    {
                        counter=0;
                    }
                }
            }
        }
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
