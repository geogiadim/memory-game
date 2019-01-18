package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Creates a JFrame for Game Mode selection, Player and CPU selection, Player Name selection and a JFrame for game play.
 * Modifies all JFrames for normal(not Duel) Game Modes and for Duel Game Mode.
 * Handles proper initiation of Components when they are needed.
 * <p>
 * Has setters and getters for JFrames and JPanels used in other GUI package Classes.
 *
 * @author George Christidis
 * @author George Giannios
 */
public class GUI {
    private static JFrame frame, gameFrame;
    private static JPanel tablePanel1, tablePanel2;
    private static JPanel messagePanel, gamePanel, playerPanel;
    private static int numOfFrame = 0, numOfDuelFrame = 0;

    /**
     * Returns the JFrame used in Game Mode selection, Player and CPU selection, Player Name selection.
     *
     * @return The JFrame in use
     */
    static JFrame getFrame() {return frame;}
    /**
     * Returns the game play JFrame, where Card/Buttons are.
     *
     * @return The game JFrame in use
     */
    static JFrame getGameFrame() {return gameFrame;}

    /**
     * Return the current JFrame number for normal(not Duel) Game Modes.
     *
     * @return The current jFrame number
     */
    static int getNumOfFrame() {return numOfFrame;}
    /**
     * Return the current JFrame number for Duel Game Mode.
     *
     * @return The current Duel JFrame number
     */
    static int getNumOfDuelFrame() {return numOfDuelFrame;}
    /**
     * Returns the top JPanel from game play Frame.
     *
     * @return Return the top JPanel
     */
    private static JPanel getMessagePanel() {return messagePanel;}
    /**
     * Returns the game play JPanel for normal(not Duel) Game Modes.
     *
     * @return The game play JPanel
     */
    static JPanel getGamePanel() {return gamePanel;}
    /**
     * Returns the appropriate gameplay JPanel for Duel Game Mode.
     *
     * @param isFirst If true, returns the first game play JPanel. If false, returns the second game play JPanel
     * @return The gameplay JPanel
     */
    static JPanel getGamePanelDuel(boolean isFirst){
        if (isFirst) return tablePanel1;
        else return tablePanel2;
    }

    /**
     * Calls all JComponents classed in GUI package to set Locale.
     */
    private static void setLocale() {
        Buttons.setLocale();
        Labels.setLocale();
        RadioButtons.setLocale();
        TextField.setLocale();
    }

    /**
     * sets the properties of a JFrame.
     *
     * @param frame a JFrame
     */
    private static void setFrame(JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        setFrameOnCenter(frame);
        frame.setVisible(true);
    }

    /**
     * Creates a JFrame, sets its properties, sets appropriate Locale for all JComponents
     * and loads the first JFrame with appropriate JComponents.
     */
    public static void createGUI() {
        frame = new JFrame("Memory Game");
        setLocale();
        frame1GameMode(frame.getContentPane());
        setFrame(frame);
    }

    /**
     * Creates the second frame for game play
     */
    static void createFrame2() {
        gameFrame = new JFrame("Memory Game");
        GUIConnectionToLogic.begin();
        setFrame(gameFrame);
    }

    /**
     * Creates the third frame for game over
     *
     * @param steps steps that player needed to finish the game
     * @param isThereWinner true if exists a winner and false if does not
     * @param name the name of the winner
     */
    static void createFrame3(int steps, boolean isThereWinner, String name){
        JFrame gameOverFrame = new JFrame("Memory Game");
        lastFrame(gameOverFrame.getContentPane(), steps, isThereWinner, name);
        setFrame(gameOverFrame);
    }


    /**
     * Sets JFrame in the middle of the screen.
     *
     * @param frame The JFrame to set in the middle of the screen
     */
    private static void setFrameOnCenter(JFrame frame) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width - frame.getWidth()) / 2;
        int y = (d.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    /**
     * Clears the given JFrame off JComponents and repaints it.
     *
     * @param frame The JFrame to clear
     */
    static void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }


    /**
     * Repaints and validates the top message Panel.
     */
    static void repaintMessagePanel() {
        getMessagePanel().repaint();
        getMessagePanel().validate();
    }


    /**
     * Thw first JFrame containing Game Mode selection Buttons.
     *
     * @param pane The Container to add all JPanels
     */
    static void frame1GameMode(Container pane) {
        numOfFrame = 1;
        numOfDuelFrame = 0;

        Labels.setModeLabel();
        Buttons.setModeButtons();
        ActionListenerButtons.addModeButtonsActList();

        JPanel gmLabelPanel = new JPanel();
        gmLabelPanel.add(Labels.chooseGameMode);

        JPanel gmButtonsPanel = new JPanel();
        gmButtonsPanel.add(Buttons.basicButton);
        gmButtonsPanel.add(Buttons.doubleButton);
        gmButtonsPanel.add(Buttons.tripleButton);
        gmButtonsPanel.add(Buttons.duelButton);

        pane.add(gmLabelPanel, BorderLayout.PAGE_START);
        pane.add(gmButtonsPanel, BorderLayout.CENTER);
    }


    /**
     * The second JFrame containing Player, CPU and CPU difficulty selection Radio Buttons.
     *
     * @param pane The Container to add all JPanels
     */
    static void frame2PlayerChoice(Container pane) {
        numOfFrame = 2;

        Labels.setPlayerChoiceLabels();
        RadioButtons.setRadioButtons();
        ActionListenerRadioButtons.addRadButActList();
        TextField.makeTextField(false);

        //make back and next panel
        Buttons.setNextBackButtons();
        Panels.makeNextBackPanel();
        ActionListenerButtons.addNextBackButtonsActList();

        //Panel for Players radio buttons
        JPanel numOfPlayersPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        ButtonGroup playersGroup = new ButtonGroup();

        for (int i = 0; i < RadioButtons.player.length; i++) {
            numOfPlayersPanel.add(RadioButtons.player[i]);
            playersGroup.add(RadioButtons.player[i]);
        }
        RadioButtons.player[0].doClick();

        //Panel for CPUs radio buttons
        JPanel numOfCPUsPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        ButtonGroup cpuGroup = new ButtonGroup();
        for (int i = 0; i < RadioButtons.cpu.length; i++) {
            numOfCPUsPanel.add(RadioButtons.cpu[i]);
            cpuGroup.add(RadioButtons.cpu[i]);
        }
        RadioButtons.cpu[0].doClick();

        //Panel for label of level of cpu
        JPanel labelOfLevelPanel = new JPanel();
        labelOfLevelPanel.add(Labels.levelOfCPU);

        //Panel for difficulty of CPUs radio buttons
        JPanel[] difficultyOfCPUPanel = new JPanel[3];
        ButtonGroup[] diffButtonGroup = new ButtonGroup[3];
        GridLayout gridLayout = new GridLayout(1, 0, 2, 2);

        for (int i = 0; i < difficultyOfCPUPanel.length; i++) {
            difficultyOfCPUPanel[i] = new JPanel(gridLayout);
            diffButtonGroup[i] = new ButtonGroup();
            for (int j = 0; j < RadioButtons.diffCPU[i].length; j++) {
                difficultyOfCPUPanel[i].add(RadioButtons.diffCPU[i][j]);
                diffButtonGroup[i].add(RadioButtons.diffCPU[i][j]);
            }
            RadioButtons.diffCPU[i][0].setSelected(true);
        }

        //Panel for label and difficulty radio buttons of all CPUs
        JPanel[] panelLevel = new JPanel[3];
        for (int i = 0; i < panelLevel.length; i++) {
            panelLevel[i] = new JPanel();
            panelLevel[i].add(Labels.cpuLevels[i]);
            panelLevel[i].add(difficultyOfCPUPanel[i]);
        }

        //Panel for label and choices of difficulty of all CPUs
        JPanel levelPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        levelPanel.add(labelOfLevelPanel, BorderLayout.BEFORE_FIRST_LINE);
        levelPanel.add(panelLevel[0], BorderLayout.PAGE_START);
        levelPanel.add(panelLevel[1], BorderLayout.CENTER);
        levelPanel.add(panelLevel[2], BorderLayout.PAGE_END);

        //Panel includes all previous panels
        JPanel choicePanel = new JPanel(new GridLayout(1, 3, 2, 2));
        choicePanel.add(numOfPlayersPanel);
        choicePanel.add(numOfCPUsPanel);
        choicePanel.add(levelPanel);

        //Panel for title of the frame
        TitledBorder border = BorderFactory.createTitledBorder("");
        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.setBorder(border);
        selectPlayersPanel.add(Labels.chooseNumOfPlayers);

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    /**
     * The second JFrame, used in Duel Game Mode, to select Player names, CPU and CPU difficulty.
     *
     * @param pane The Container to add all JPanels
     */
    static void frame2PlayerChoiceDuel(Container pane) {
        numOfDuelFrame = 2;

        Labels.setPlayerChoiceDuelLabels();

        //make back and next panel
        Buttons.setNextBackButtons();
        ActionListenerButtons.addNextBackButtonsActList();
        Panels.makeNextBackPanel();

        RadioButtons.setRadioButtonsDuel();
        ActionListenerRadioButtons.addRadButActListDuel();

        TextField.makeTextField(true);

        JPanel writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.add(Labels.writeNames);

        JPanel radioButtonsPanel = new JPanel(new GridLayout(1, 2, 2, 2));
        radioButtonsPanel.add(RadioButtons.yesOrNo[1]);
        radioButtonsPanel.add(RadioButtons.yesOrNo[0]);

        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(RadioButtons.yesOrNo[1]);
        radioButtonsGroup.add(RadioButtons.yesOrNo[0]);
        RadioButtons.yesOrNo[1].setSelected(true);

        JPanel selectCPUPanel = new JPanel(new GridLayout(1, 0, 2, 2));
        selectCPUPanel.add(Labels.duelCPU);
        selectCPUPanel.add(radioButtonsPanel);

        JPanel selectCPUDiff = new JPanel(new GridLayout(1, 0, 2, 2));
        ButtonGroup cpuDiffButtonGroup = new ButtonGroup();
        selectCPUDiff.add(Labels.levelOfCPU);
        for (int i = 0; i < RadioButtons.diffDuel.length; i++) {
            selectCPUDiff.add(RadioButtons.diffDuel[i]);
            cpuDiffButtonGroup.add(RadioButtons.diffDuel[i]);
            RadioButtons.diffDuel[i].setEnabled(false);
        }

        JPanel textFieldPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        TitledBorder border = BorderFactory.createTitledBorder("");
        textFieldPanel.setBorder(border);

        textFieldPanel.add(TextField.labelPlayerNames[0]);
        textFieldPanel.add(TextField.labelPlayerNames[1]);

        textFieldPanel.add(TextField.textPlayerNames[0]);
        textFieldPanel.add(TextField.textPlayerNames[1]);

        JPanel CPUChoiceAndTextFieldPanel = new JPanel(new GridLayout(3, 0, 2, 2));
        CPUChoiceAndTextFieldPanel.add(selectCPUPanel);
        CPUChoiceAndTextFieldPanel.add(selectCPUDiff);
        CPUChoiceAndTextFieldPanel.add(textFieldPanel);

        pane.add(writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(CPUChoiceAndTextFieldPanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    /**
     * The third JFrame containing Player name TextFields.
     *
     * @param pane The Container to add all JPanels
     */
    static void frame3PlayersName(Container pane) {
        numOfFrame = 3;
        ChecksForJComponents.checkForTextField();
        ChecksForJComponents.checkForTextField2();

        Labels.setPlayerNamesLabel();

        //Panel for Title of frame
        JPanel writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.add(Labels.writeNames);
        final TitledBorder border = BorderFactory.createTitledBorder("");
        writePlayersNamePanel.setBorder(border);

        //Panel for labels and text fields for players names
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 4, 2, 2));
        for (int i = 0; i < TextField.labelPlayerNames.length; i++) {
            textFieldPanel.add(TextField.labelPlayerNames[i]);
        }

        for (int i = 0; i < TextField.textPlayerNames.length; i++) {
            textFieldPanel.add(TextField.textPlayerNames[i]);
        }

        pane.add(writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    /**
     * The game play JFrame containing the Card/Buttons in a grid, top and bottom messages.
     *
     * @param pane         The Container to add all JPanels
     * @param tableOfCards The Table of Card Object corresponding to the Card/Buttons used
     */
    static void frame4GamePlay(Container pane, Table tableOfCards) {
        numOfFrame = 4;

        Labels.setMessageLabel();
        makeGamePlayPanels();
        messagePanel.add(Labels.topMessage);

        GridLayout cardButtonsLayout = new GridLayout(tableOfCards.sizeX(), tableOfCards.sizeY(), 10, 5);
        gamePanel.setLayout(cardButtonsLayout);
        TitledBorder border = BorderFactory.createTitledBorder("Table of Cards");
        gamePanel.setBorder(border);
        Buttons.setCardButtons(tableOfCards);
        Panels.addAllCardButtons(Buttons.openCardButtons, tableOfCards);

        playerPanel.add(Labels.bottomMessage);

        setGamePlayPanes(pane);
        ActionListenerButtons.addCardButtonsActList(tableOfCards);
    }


    /**
     * The game play Duel JFrame containing the two Card/Button groups in two grids, top and bottom messages.
     *
     * @param pane          The Container to add all JPanels
     * @param tableOfCards1 The first Table of Card Object corresponding to the right group of Card/Buttons used
     * @param tableOfCards2 The second Table of Card Object corresponding to the left group of Card/Buttons used
     */
    static void frame3GamePlayDuel(Container pane, Table tableOfCards1, Table tableOfCards2) {
        numOfDuelFrame = 3;

        Labels.setMessageLabel();
        makeGamePlayPanels();
        Buttons.setCardButtonsDuel(tableOfCards1, tableOfCards2);

        messagePanel.add(Labels.topMessage);

        GridLayout cardButtonsLayout = new GridLayout(tableOfCards1.sizeX(), tableOfCards1.sizeY(), 10, 5);
        tablePanel1 = new JPanel(cardButtonsLayout);
        TitledBorder border = BorderFactory.createTitledBorder("Table 1");
        tablePanel1.setBorder(border);
        Panels.addAllCardButtons(Buttons.openCardButtonsDuelOne, tableOfCards1, true);

        tablePanel2 = new JPanel(cardButtonsLayout);
        TitledBorder border2 = BorderFactory.createTitledBorder("Table 2");
        tablePanel2.setBorder(border2);
        Panels.addAllCardButtons(Buttons.openCardButtonsDuelTwo, tableOfCards1, false);

        GridLayout layout = new GridLayout(1, 0, 10, 10);
        gamePanel.setLayout(layout);
        gamePanel.add(tablePanel1);
        gamePanel.add(tablePanel2);

        playerPanel.add(Labels.bottomMessage);

        setGamePlayPanes(pane);
        ActionListenerButtons.addCardButtonsActListDuel(tableOfCards1, tableOfCards2);
    }

    /**
     * This is the last frame for game over and results of the game
     *
     * @param pane The Container to add all JPanels
     * @param steps steps that player needed to finish the game
     * @param isThereWinner true if exists a winner and false if does not
     * @param name the name of the player
     */
    private static void lastFrame(Container pane,int steps,boolean isThereWinner, String name){
        numOfFrame=5;
        Labels.setGameOverLabel();
        JPanel gameOverPanel= new JPanel();
        gameOverPanel.add(Labels.gameOverLabel);

        JPanel resultsPanel = new JPanel();
        setResultsPanel(resultsPanel, steps, isThereWinner, name);

        JPanel highScoresPanel = new JPanel();
        highScoresPanel.add(Labels.highScores);

        pane.add(gameOverPanel, BorderLayout.PAGE_START);
        pane.add(resultsPanel,BorderLayout.CENTER);
        pane.add(highScoresPanel,BorderLayout.PAGE_END);
    }

    /**
     * Sets the panel in which locates the results of the game
     *
     * @param panel The Container to add all JPanels
     * @param steps steps that player needed to finish the game
     * @param isThereWinner true if winner exists and false if does not
     * @param name the name of the player/winner
     */
    private static void setResultsPanel(JPanel panel, int steps, boolean isThereWinner, String name){
        Labels.setResultsLabel(steps,name);
        if (GUIConnectionToLogic.getNumOfPlayers()==1){
            panel.add(Labels.soloResults);
        }else {
            if (isThereWinner){
                panel.add(Labels.winnerResults);
            } else panel.add(Labels.drawResults);
        }
    }

    /**
     * Creates the game play JPanel, the top and bottom message JPanels.
     */
    private static void makeGamePlayPanels() {
        messagePanel = new JPanel();
        gamePanel = new JPanel();
        playerPanel = new JPanel();
    }

    /**
     * Adds the game play JPanel, the top and bottom message JPanels to the given Container.
     *
     * @param pane The Container to add all JPanels
     */
    private static void setGamePlayPanes(Container pane) {
        pane.add(messagePanel, BorderLayout.PAGE_START);
        pane.add(gamePanel, BorderLayout.CENTER);
        pane.add(playerPanel, BorderLayout.PAGE_END);
    }
}