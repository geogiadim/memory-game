
public class Table
{
    private Card[][] tableOfCards;

    public Table (int x,int y)
    {
        tableOfCards= new Card[x][y];

    }

    public void openCard(int x,int y){
        //UI
    }
    public void closeCard(int x,int y){
        //UI
    }
    public void unableCard(int x,int y){
        tableOfCards[x][y].setPairedTrue();
    }
}
