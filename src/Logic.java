/**
 * @author Giorgos Giannios
 *
 */
public class Logic {

    private Table[][] newTable;
    private int mode;

    public Logic(int mode){
        this.mode = mode;
        if (mode == 1)
            newTable = new Table[4][6];
        else if (mode == 2)
            newTable = new Table[6][8];
        else newTable = new Table[6][6];

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
        //codeαα
    }

    private void doubleGame ()
    {
        //codeαα
    }

    private void tripleGame ()
    {
        //code
    }

}

