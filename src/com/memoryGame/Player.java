package com.memoryGame;

public class Player {
    private String name;
    private int pairs;

    public Player(String name) {
        this.name = name;
        pairs = 0;
    }

    public void increaseNumberOfPairs() {
        pairs++;
    }

    public int getNumberOfPairs() {
        return pairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}