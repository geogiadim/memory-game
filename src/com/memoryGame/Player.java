package com.memoryGame;

class Player {
    private String name;
    private int pairs, tries;

    Player(String name) {
        this.name = name;
        pairs = 0;
        tries = 0;
    }

    void increaseNumberOfPairs() {
        pairs++;
    }

    void increaseNumOfTries() {
        tries++;
    }

    int getNumberOfPairs() {
        return pairs;
    }

    int getNumOfTries() {
        return tries;
    }

    String getName() {
        return name;
    }

    void setName(String n) {
        name = n;
    }
}