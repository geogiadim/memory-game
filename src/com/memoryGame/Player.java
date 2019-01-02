package com.memoryGame;

public class Player {
    private String name;
    private int pairs, tries;

    Player(String name) {
        this.name = name;
        pairs = 0;
        tries = 0;
    }

    void increaseNumberOfPairs() {pairs++;}

    void increaseNumOfTries() {tries++;}

    public int getNumberOfPairs() {return pairs;}

    public int getNumOfTries() {return tries;}

    public String getName() {return name;}

    public void setName(String n) {name = n;}
}