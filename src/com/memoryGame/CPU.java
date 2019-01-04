package com.memoryGame;

class CPU extends Player{
    private int diff;

    CPU(String name, int diff){
        super(name);
        this.diff = diff;
    }

    int getDiff() {
        return diff;
    }
}
