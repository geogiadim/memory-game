package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

class Labels {
    //Different Font sizes
    private static final int FONT_SIZE_HUGE = 60;
    private static final int FONT_SIZE_LARGE = 30;
    private static final int FONT_SIZE_MEDIUM = 18;
    private static final int FONT_SIZE_SMALL = 12;
    static JLabel chooseGameMode, chooseNumOfPlayers, gameOverLabel,highScores;
    static JLabel soloResults, winnerResults, drawResults;
    static JLabel writeNames, levelOfCPU, duelCPU;
    static JLabel[] cpuLevels;
    static JLabel topMessage, bottomMessage;

    private static ResourceBundle bundle;

    static void setLocale() {
        //Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleLabels", locale);
        } catch (java.util.MissingResourceException e) {
            Locale defaultLocale = new Locale("en", "US");
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleLabels", defaultLocale);
        }
    }

    static void setModeLabel() {chooseGameMode = makeLabel(bundle.getString("selectGM"), FONT_SIZE_HUGE);}

    static void setPlayerChoiceLabels() {
        chooseNumOfPlayers = makeLabel(bundle.getString("selectNumPlayers"), FONT_SIZE_LARGE);
        levelOfCPU = makeLabel(bundle.getString("selectCPULevel"), FONT_SIZE_MEDIUM);
        cpuLevels = new JLabel[3];
        for (int i = 0; i < cpuLevels.length; i++) {
            cpuLevels[i] = makeLabel(bundle.getString("cpuLabel") + (i + 1) + ": ", FONT_SIZE_SMALL);
        }
    }

    static void setMessageLabel() {
        topMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
        bottomMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
    }

    static void setPlayerNamesLabel() {writeNames = makeLabel(bundle.getString("writeNames"), FONT_SIZE_LARGE);}

    static void setPlayerChoiceDuelLabels() {
        writeNames = makeLabel(bundle.getString("writeNames"), FONT_SIZE_LARGE);
        duelCPU = makeLabel(bundle.getString("duelCPU"), FONT_SIZE_MEDIUM);
        levelOfCPU= makeLabel(bundle.getString("selectCPULevel"),FONT_SIZE_MEDIUM);
    }

    static void setGameOverLabel() {
        gameOverLabel = makeLabel(bundle.getString("gameOver"), FONT_SIZE_HUGE);
        highScores = makeLabel(bundle.getString("highScoresLabel"), FONT_SIZE_MEDIUM);
        highScores.setForeground(Color.BLACK);
    }

    static void setResultsLabel(int steps, String name){
        soloResults = makeLabel(bundle.getString("soloResults1" + steps + "soloResults2"),FONT_SIZE_LARGE);
        soloResults.setForeground(Color.RED);
        winnerResults = makeLabel(bundle.getString("winnerResults" + name),FONT_SIZE_LARGE);
        winnerResults.setForeground(Color.RED);
        drawResults = makeLabel(bundle.getString("drawResults"),FONT_SIZE_LARGE);
        drawResults.setForeground(Color.RED);
    }

    private static JLabel makeLabel(String name, int font_size) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, font_size));
        label.setForeground(Color.blue);
        return label;
    }

    static void setTopMessagePreview() {
        topMessage.setText(bundle.getString("topMessagePreview1") + DelaysInGUI.getPreviewDelay() + bundle.getString("topMessagePreview2"));
    }

    static void setTopMessageRules() {
        int mode = GUIConnectionToLogic.getGameMode();
        if (mode == 3)
            topMessage.setText(bundle.getString("topRuleTriple"));
        else if (mode == 4)
            topMessage.setText(bundle.getString("topRuleDuel"));
        else topMessage.setText(bundle.getString("topRuleBasicDouble"));
        GUI.repaintMessagePanel();
    }

    static void setTopMessageWrong() {
        topMessage.setText(bundle.getString("topWrong"));
        GUI.repaintMessagePanel();
    }

    static void setTopMessageCorrect() {
        topMessage.setText(bundle.getString("topCorrect"));
        GUI.repaintMessagePanel();
    }

    static void setBottomMessageCountdown(int i) {
        bottomMessage.setText(i + "");
        GUI.repaintMessagePanel();
    }

    static void setBottomMessagePlayerTurn(int i) {
        bottomMessage.setText(bundle.getString("bottomPlayerTurn") + GUIConnectionToLogic.getNameOfPlayer(i));
    }
}