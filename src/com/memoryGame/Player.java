package com.memoryGame;

public class Player {
    private String name;
    private int pairs,tries;

    public Player(String name) {
        this.name = name;
        pairs = 0;
        tries=0;
    }

    public void increaseNumberOfPairs() {pairs++;}
    public void increaseNumOfTries() {tries++;}

    public int getNumberOfPairs() {return pairs;}
    public int getNumOfTries() {return tries;}

    public String getName() {return name;}

    public void setName(String n) {name = n;}
}