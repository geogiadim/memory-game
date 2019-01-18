package com.memoryGame;

class Player {
    private String name;
    private int pairs, tries, diff;

    Player(String name) {
        this.name = name;
        this.diff= -1;
        pairs = 0;
        tries = 0;
    }

    Player(String name, int diff){
        this.name = name;
        this.diff = diff;
        pairs = 0;
        tries = 0;
    }

    void increaseNumberOfPairs() {pairs++;}

    void increaseNumOfTries() {tries++;}

    int getNumberOfPairs() {return pairs;}

    int getNumOfTries() {return tries;}

    String getName() {return name;}

    void setName(String n) {name = n;}

    int getDiff() {return diff;}
}