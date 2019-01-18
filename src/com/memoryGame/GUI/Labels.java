package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Creates static JLabel Objects for use in GUI Frames and game play.
 *
 * @author George Giannios
 */
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

    /**
     * Sets the Locale as the default OS Locale and if the corresponding Resource Bundle exists it is set accordingly
     * else, the Locale is set to en_US and the Resource Bundle to the en_US one.
     */
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

    /**
     * Creates the chooseGameMode Label.
     */
    static void setModeLabel() {chooseGameMode = makeLabel(bundle.getString("selectGM"), FONT_SIZE_HUGE);}

    /**
     * Creates the Labels for the number of Players, the number of CPUs and the difficulty Levels.
     */
    static void setPlayerChoiceLabels() {
        chooseNumOfPlayers = makeLabel(bundle.getString("selectNumPlayers"), FONT_SIZE_LARGE);
        levelOfCPU = makeLabel(bundle.getString("selectCPULevel"), FONT_SIZE_MEDIUM);
        cpuLevels = new JLabel[3];
        for (int i = 0; i < cpuLevels.length; i++) {
            cpuLevels[i] = makeLabel(bundle.getString("cpuLabel") + (i + 1) + ": ", FONT_SIZE_SMALL);
        }
    }

    /**
     * Creates the top and bottom messages in gameplay Frame.
     */
    static void setMessageLabel() {
        topMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
        bottomMessage = makeLabel(" ", FONT_SIZE_MEDIUM);
    }

    /**
     * Creates the TextField Frame Label.
     */
    static void setPlayerNamesLabel() {writeNames = makeLabel(bundle.getString("writeNames"), FONT_SIZE_LARGE);}

    /**
     * Creates the Labels for Duel Game Mode options Frame.
     */
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
        soloResults = makeLabel(bundle.getString("soloResults1") + steps + bundle.getString("soloResults2"),FONT_SIZE_LARGE);
        soloResults.setForeground(Color.RED);
        winnerResults = makeLabel(bundle.getString("winnerResults") + name,FONT_SIZE_LARGE);
        winnerResults.setForeground(Color.RED);
        drawResults = makeLabel(bundle.getString("drawResults"),FONT_SIZE_LARGE);
        drawResults.setForeground(Color.RED);
    }

    /**
     * Creates a JLabel Object with specific properties from given parameters.
     *
     * @param name      The Label text
     * @param font_size The font of the Label text
     * @return α JLabel Object
     */
    private static JLabel makeLabel(String name, int font_size) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, font_size));
        label.setForeground(Color.blue);
        return label;
    }


    /**
     * Sets the top gameplay Label to the preview message.
     */
    static void setTopMessagePreview() {
        topMessage.setText(bundle.getString("topMessagePreview1") + DelaysInGUI.getPreviewDelay() + bundle.getString("topMessagePreview2"));
    }

    /**
     * Sets the top gameplay Label to the rules message, according to the chosen Game Mode.
     */
    static void setTopMessageRules() {
        int mode = GUIConnectionToLogic.getGameMode();
        if (mode == 3)
            topMessage.setText(bundle.getString("topRuleTriple"));
        else if (mode == 4)
            topMessage.setText(bundle.getString("topRuleDuel"));
        else topMessage.setText(bundle.getString("topRuleBasicDouble"));
        GUI.repaintMessagePanel();
    }


    /**
     * Sets the top gameplay Label to the wrong Label message.
     */
    static void setTopMessageWrong() {
        topMessage.setText(bundle.getString("topWrong"));
        GUI.repaintMessagePanel();
    }

    /**
     * Sets the top gameplay Label to the correct Label message.
     */
    static void setTopMessageCorrect() {
        topMessage.setText(bundle.getString("topCorrect"));
        GUI.repaintMessagePanel();
    }

    /**
     * Sets the bottom gameplay Label to the seconds remaining until cards preview is over.
     *
     * @param i is a second
     */
    static void setBottomMessageCountdown(int i) {
        bottomMessage.setText(i + "");
        GUI.repaintMessagePanel();
    }

    /**
     * Sets the bottom gameplay Label to the person playing.
     *
     * @param i The Player number to display the name of.
     */
    static void setBottomMessagePlayerTurn(int i) {
        bottomMessage.setText(bundle.getString("bottomPlayerTurn") + GUIConnectionToLogic.getNameOfPlayer(i));
    }

    static void setTopMessageCPUPlaying(){
        topMessage.setText("It is the CPU's turn");
    }
}