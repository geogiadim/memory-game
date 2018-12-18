import javax.swing.*;

/**
 * This class creates the cards of the memory game. There are some methods that give some characteristics in each card.
 * Each card represents a letter.
 *
 * @author Giorgos Giannios
 */
public class Card
{
    private int valueOfCard;
    private boolean isOpen;
    private boolean isPaired;
   // private JButton card;
    /**
     * Creates a card and set it as closed and unpaired.
     */
    public Card(){
        isOpen=false;
        isPaired=false;
        //card=new JButton(name);
    }

    /**
     * Sets the card as opened or as closed
     * @param mode true if it is opened false if it is closed
     */
    public void setIsOpen(boolean mode){isOpen=mode;}

    /**
     * Returns true if it is opened and false if it is closed.
     * @return true if it is opened and false if it is closed.
     */
    public boolean getIsOpen(){return isOpen;}

    /**
     * Sets the letter that is represented by the card
     * @param value the letter that is represented by the card
     */
    public void setValue (int value){valueOfCard=value;}

    /**
     * Returns the letter of the card
     * @return the letter of the card
     */
    public int getValue (){return valueOfCard;}
 
    /**
     * Sets the card as paired
     */
    public void setPairedTrue() {isPaired=true;}

    /**
     * Returns true if it is paired and false if it is unpaired
     * @return true if it is paired and false if it is unpaired
     */
    public boolean getIsPaired() {return isPaired;}
}
