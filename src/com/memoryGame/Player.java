package com.memoryGame;

/**
 * Used to store all Player data such as their name and if the are a CPU.
 *
 * @author George Christidis
 */
class Player {
    private String name;
    private int pairs, tries, diff;

    /**
     * Creates a Player objects and stores their data.
     * Used for non CPU Players.
     *
     * @param name The name of the Player
     */
    Player(String name) {
        this.name = name;
        this.diff= -1;
        pairs = 0;
        tries = 0;
    }

    /**
     * Creates a Player objects and stores their data. It also stores their CPU difficulty.
     * Used for CPU Players.
     *
     * @param name The name of the Player/CPU
     */
    Player(String name, int diff){
        this.name = name;
        this.diff = diff;
        pairs = 0;
        tries = 0;
    }


    /**
     * Increases the number of paired Cards.
     */
    void increaseNumberOfPairs() {pairs++;}


    /**
     * Increases the number of tries.
     */
    void increaseNumOfTries() {tries++;}

    /**
     * Returns the number of paired Cards.
     *
     * @return The number of paired Cards
     */
    int getNumberOfPairs() {return pairs;}

    /**
     * Returns the number of tries.
     *
     * @return The number of tries
     */
    int getNumOfTries() {return tries;}

    /**
     * Returns the Player's name.
     *
     * @return The Player's name
     */
    String getName() {return name;}

    /**
     * Sets the Player's name.
     *
     * @param n The name to give the specific Player
     */
    void setName(String n) {name = n;}

    /**
     * Returns the Player/CPY difficulty.
     *
     * @return The Player/CPY difficulty.
     */
    int getDiff() {return diff;}
}