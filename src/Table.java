public class Table
{
    private Card[][] tableOfCards;

    public Table (int x,int y){
        tableOfCards = new Card[x][y];
    }

    public openCard(int x,int y){
        //send openCard to UI;
    }

    public closeCard(int x,int y){
        //send closeCard to UI;
    }

    public void unableCard(int x,int y){
        tableOfCards[x][y].setPairedTrue();
    }
}
