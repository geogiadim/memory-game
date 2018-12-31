package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class Labels {
    //Different Font sizes
    private static final int FONT_SIZE_HUGE = 60;
    private static final int FONT_SIZE_LARGE = 30;
    private static final int FONT_SIZE_MEDIUM = 18;
    private static final int FONT_SIZE_SMALL = 12;
    static JLabel chooseGameMode, chooseNumOfPlayers;
    static JLabel writeNames, levelOfCPU, duelCPU;
    static JLabel levelCpu1, levelCpu2, levelCpu3;
    static JLabel message,correct,wrong,rule1,rule2,rule3, turnOfPlayer;

    static void setLabelName() {
        chooseGameMode = makeLabel("Select Game mode", FONT_SIZE_HUGE);
        chooseNumOfPlayers = makeLabel("Select Number of Players", FONT_SIZE_LARGE);
        writeNames = makeLabel("Write the names of the players", FONT_SIZE_LARGE);

        levelOfCPU = makeLabel("Choose the level of CPU", FONT_SIZE_MEDIUM);
        levelCpu1 = makeLabel("CPU 1: ", FONT_SIZE_SMALL);
        levelCpu2 = makeLabel("CPU 2: ", FONT_SIZE_SMALL);
        levelCpu3 = makeLabel("CPU 3: ", FONT_SIZE_SMALL);

        duelCPU = makeLabel("Do you want to play against CPU ?",FONT_SIZE_MEDIUM);

        message = makeLabel("Showing Cards for " + DelaysInGUI.getCardPreviewDelay() + " seconds. Try to remember as many as you can.", FONT_SIZE_MEDIUM);
        correct = makeLabel("Correct choice!!!",FONT_SIZE_MEDIUM);
        wrong = makeLabel("Wrong choice!!!",FONT_SIZE_MEDIUM);
        rule1 = makeLabel("You have to choose two cards in each round.",FONT_SIZE_MEDIUM);
        rule2 = makeLabel("You have to choose three cards in each round.", FONT_SIZE_MEDIUM);
        rule3 = makeLabel("You have to chose only one card of your table in each round.",FONT_SIZE_MEDIUM);
        turnOfPlayer = makeLabel("It is the turn of player: ", FONT_SIZE_MEDIUM);
    }

    private static JLabel makeLabel(String name, int font_size) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, font_size));
        label.setForeground(Color.blue);
        return label;
    }
}