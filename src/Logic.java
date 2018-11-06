/**
 * @author Giorgos Giannios
 */
public class Logic {

    private Table[][] newTable;
    private int mode;

    public void Logic(int mode)
    {
        this.mode=mode;
        if (mode==1)
            newTable= new Table [4][6];
        else if (mode==2)
            newTable= new Table [6][8];
        else newTable= new Table [6][6];
    }

    public void basicGame ()
    {
        //code
    }

    public void doubleGame ()
    {
        //code
    }

    public void tripleGame ()
    {
        //code
    }
}

