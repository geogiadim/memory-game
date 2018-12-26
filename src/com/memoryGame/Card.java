package com.memoryGame;

/**
 * This class creates the cards of the memory game. There are some methods that give some characteristics in each card.
 * Each card represents a letter.
 *
 * @author Giorgos Giannios
 */
public class Card {
    private int valueOfCard;
    private boolean isOpen;
    private boolean isPaired;

    /**
     * Creates a card and set it as closed and unpaired.
     */
    public Card() {
        isOpen = false;
        isPaired = false;
    }

    /**
     * Returns true if it is opened and false if it is closed.
     *
     * @return true if it is opened and false if it is closed.
     */
    boolean getIsOpen() {
        return isOpen;
    }

    /**
     * Sets the card as opened or as closed
     *
     * @param mode true if it is opened false if it is closed
     */
    void setIsOpen(boolean mode) {
        isOpen = mode;
    }

    /**
     * Returns the letter of the card
     *
     * @return the letter of the card
     */
    int getValue() {
        return valueOfCard;
    }

    /**
     * Sets the letter that is represented by the card
     *
     * @param value the letter that is represented by the card
     */
    void setValue(int value) {
        valueOfCard = value;
    }

    /**
     * Sets the card as paired
     */
    void setPairedTrue() {
        isPaired = true;
    }

    /**
     * Returns true if it is paired and false if it is unpaired
     *
     * @return true if it is paired and false if it is unpaired
     */
    boolean getIsPaired() {
        return isPaired;
    }
}
