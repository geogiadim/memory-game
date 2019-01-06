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
    static JLabel[] cpuLevels;
    static JLabel topMessage, bottomMessage;

    static void setModeLabel() {
        chooseGameMode = makeLabel("Select Game mode", FONT_SIZE_HUGE);
    }

    static void setPlayerChoiceLabels() {
        chooseNumOfPlayers = makeLabel("Select Number of Players", FONT_SIZE_LARGE);
        levelOfCPU = makeLabel("Choose the level of CPU", FONT_SIZE_MEDIUM);
        cpuLevels = new JLabel[3];
        for (int i = 0; i < cpuLevels.length; i++) {
            cpuLevels[i] = makeLabel("CPU " + (i + 1) + ": ", FONT_SIZE_SMALL);
        }
    }

    static void setMessageLabel() {
        topMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
        bottomMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
    }

    static void setPlayerNamesLabel() {
        writeNames = makeLabel("Write the names of the players", FONT_SIZE_LARGE);
    }

    static void setPlayerChoiceDuelLabels() {
        writeNames = makeLabel("Write the names of the players", FONT_SIZE_LARGE);
        duelCPU = makeLabel("Do you want to play against CPU ?", FONT_SIZE_MEDIUM);
    }

    private static JLabel makeLabel(String name, int font_size) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, font_size));
        label.setForeground(Color.blue);
        return label;
    }

    static void setTopMessagePreview() {
        topMessage.setText("Showing Cards for " + DelaysInGUI.getPreviewDelay() + " seconds. Try to remember as many as you can.");
    }

    static void setTopMessageRules() {
        int mode = GUIConnectionToLogic.getGameMode();
        if (mode == 3)
            topMessage.setText("You have to choose three cards in each round.");
        else if (mode == 4)
            topMessage.setText("You have to chose only one card of your table in each round.");
        else topMessage.setText("You have to choose two cards in each round.");
        GUI.repaintMessagePanel();
    }

    static void setTopMessageWrong() {
        topMessage.setText("Wrong choice!!!");
        GUI.repaintMessagePanel();
    }

    static void setTopMessageCorrect() {
        topMessage.setText("Correct choice!!!");
        GUI.repaintMessagePanel();
    }

    static void setBottomMessageCountdown(int i) {
        bottomMessage.setText(i + "");
        GUI.repaintMessagePanel();
    }

    static void setBottomMessagePlayerTurn(int i) {
        bottomMessage.setText("It is the turn of " + GUIConnectionToLogic.getNameOfPlayer(i));
    }
}