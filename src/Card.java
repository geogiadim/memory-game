public class Card
{
    private char valueOfCard;
    private boolean isPaired;

    public Card(){
        isPaired=false;
    }

    public void setPairedTrue(){isPaired=true;}
    public boolean getIsOpen(){return isPaired;}

    public void setValue (char v){valueOfCard=v;}
    public char getValue (){return valueOfCard;}
}
