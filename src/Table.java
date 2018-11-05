import java.util.ArrayList;

public class Table
{

    public Table (int x,int y)
    {
        public Card[][] table= new  Card[x][y];

    }

    public void openCard(int x,int y);
    public void closeCard(int x,int y);
    public void unableCard(int x,int y);
}
