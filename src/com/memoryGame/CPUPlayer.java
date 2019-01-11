package com.memoryGame;

class CPUPlayer extends Player {
    private int diff;

    CPUPlayer(String name, int diff) {
        super(name);
        this.diff = diff;
    }

    int getDiff() {
        return diff;
    }
}