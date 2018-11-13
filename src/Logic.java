import java.util.Random;

/**
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 *
 */
public class Logic {

    private Table newTable;
    private int mode;
    private Random rnd;

    public Logic(int mode){
        this.mode = mode;
        if (mode == 1)
            newTable = new Table(4,6);
        else if (mode == 2)
            newTable = new Table(6,8);
        else newTable = new Table(6,6);

        switch (mode) {
            case 1:
                basicGame();
                break;
            case 2:
                doubleGame();
                break;
            case 3:
                tripleGame();
                break;
        }
    }

    private void basicGame ()
    {
        initTablePairs();
        shuffleTable();

        UI.printTest(newTable);
        try
        {
            Thread.sleep(15*1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        UI.showClosedCards(newTable);
        UI.userChoice(newTable);
    }

    private void doubleGame ()
    {
        basicGame();
    }

    private void tripleGame ()
    {
        int value = 0;

        for (int i=0; i < newTable.sizeX(); i++){
            for (int j=2; j < newTable.sizeY(); j+=3){
                newTable.setCardValue(i,j-2,value);
                newTable.setCardValue(i,j-1,value);
                newTable.setCardValue(i,j,value++);
            }
        }

        shuffleTable();

        UI.printTest(newTable);
        UI.showClosedCards(newTable);
    }

    private void initTablePairs(){
        int value = 0;

        for (int i=0; i < newTable.sizeX(); i++){
            for (int j=1; j < newTable.sizeY(); j+=2){
                newTable.setCardValue(i,j-1,value);
                newTable.setCardValue(i,j,value++);
            }
        }
    }


    private void shuffleTable(){
        rnd = new Random();
        //Fisher Yates shuffle algorithm for 2D arrays
        for (int i = newTable.sizeX() - 1; i > 0; i--) {
            for (int j = newTable.sizeY() - 1; j > 0; j--) {
                int m = rnd.nextInt(i + 1);
                int n = rnd.nextInt(j + 1);

                int temp = newTable.getCardValue(i,j);
                newTable.setCardValue(i,j,newTable.getCardValue(m,n));
                newTable.setCardValue(m,n,temp);
            }
        }
    }
}

