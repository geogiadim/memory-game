/**
 * @author Giorgos Giannios
 * This class create the cards of the memory game. Thera are some methods that give some charechteristics in each card.
 * Each card represents a letter.
 */
public class Card
{
    private char valueOfCard;
    private boolean isOpen;
    private boolean isPaired;

    /**
     * Creates a card and set it as closed and unpaired.
     */
    public Card(){
        isOpen=false;
        isPaired=false;
    }

    /**
     * Set the card as opened or as closed
     * @param mode true if it is opened false if it is closed
     */
    public void setIsOpen(boolean mode){isOpen=mode;}

    /**
     * Returns true if it is opened and false if it is closed.
     * @return true if it is opened and false if it is closed.
     */
    public boolean getIsOpen(){return isOpen;}

    /**
     * Set the letter that is represented by the card
     * @param value the letter that is represented by the card
     */
    public void setValue (char value){valueOfCard=value;}

    /**
     * Returns the letter of the card
     * @return the letter of the card
     */
    public char getValue (){return valueOfCard;}

    /**
     * Set the card as paired
     */
    public void setPairedTrue() {isPaired=true;}
}
