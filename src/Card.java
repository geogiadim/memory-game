public class Card
{
    private char valueOfCard;
    private boolean isOpen;
    private boolean isPaired;

    public Card(){
        isPaired = false;
        isOpen = false;
    }

    public void setPairedTrue(){
        isPaired = true;
    }

    public boolean getIsPaired(){
        return isPaired;
    }

    //Setter and Getters for isOpen
    public void setIsOpen(boolean o){
        isOpen = o;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    //Setters and Getters for valueOfCard
    public void setValue(char v){
        valueOfCard = v;
    }

    public char getValue(){
        return valueOfCard;
    }
}
