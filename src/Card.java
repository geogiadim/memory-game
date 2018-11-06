/**
 * @author Giorgos Giannios
 *
 */
public class Card
{
    private char valueOfCard;
    private boolean isOpen;
    private boolean isPaired;

    public Card(){
        isOpen=false;
        isPaired=false;
    }

    public void setIsOpen(boolean mode){isOpen=mode;}
    public boolean getIsOpen(){return isOpen;}

    public void setValue (char value){valueOfCard=value;}
    public char getValue (){return valueOfCard;}

    public void setPairedTrue() {isPaired=true;}
}
