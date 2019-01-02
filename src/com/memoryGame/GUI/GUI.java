package com.memoryGame.GUI;
import com.memoryGame.Logic;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private static JFrame frame, gameFrame;
    private static Logic logic;
    private static JPanel messagePanel, gamePanel;
    private static int numOfFrame = 0,numOfDuelFrame = 0;

    private static void createJContents() {
        Panels.makePanels();
    }

    static JFrame getFrame() {return frame;}
    static JFrame getGameFrame() {return gameFrame;}
    static int getNumOfFrame() {return numOfFrame;}
    static int getNumOfDuelFrame() {return  numOfDuelFrame;}
    static Logic getLogic(){return logic;}

    private static JPanel getMessagePanel(){
        return messagePanel;
    }

    static JPanel getGamePanel(){
        return gamePanel;
    }

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createJContents();
        frame1GameMode(frame.getContentPane());

        frame.setResizable(false);
        frame.pack();
        setFrameOnCenter(frame);
        frame.setVisible(true);
    }

    static void createFrame2() {
        gameFrame = new JFrame("Memory Game");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create a Logic Object
        logic = new Logic(GUIConnectionToLogic.getGameMode());
        GUIConnectionToLogic.initArrayCoordinates();

        gameFrame.setResizable(false);
        gameFrame.pack();
        setFrameOnCenter(gameFrame);
        gameFrame.setVisible(true);
    }

    private static void setFrameOnCenter(JFrame frame) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int x = (d.width - frame.getWidth()) / 2;
        int y = (d.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    static void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }

    static void repaintMessagePanel(){
        getMessagePanel().repaint();
    }

    static void frame1GameMode(Container pane) {
        numOfFrame = 1;
        numOfDuelFrame=0;

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

    static void frame2PlayerChoice(Container pane) {
        numOfFrame = 2;

        Labels.setPlayerChoiceLabels();
        Buttons.setNextBackButtons();
        ActionListenerButtons.addNextBackButtonsActList();
        RadioButtons.setRadioButtons();
        ActionListenerRadioButtons.addRadButActList();

        //Panel for Players radio buttons
        JPanel numOfPlayersPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        ButtonGroup playersGroup = new ButtonGroup();

        for (int i=0;i<RadioButtons.player.length;i++){
            numOfPlayersPanel.add(RadioButtons.player[i]);
            playersGroup.add(RadioButtons.player[i]);
        }

        RadioButtons.player[0].setSelected(true);

        //Panel for CPUs radio buttons
        JPanel numOfCPUsPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        ButtonGroup cpuGroup = new ButtonGroup();
        for (int i=0;i<RadioButtons.cpu.length;i++){
            numOfCPUsPanel.add(RadioButtons.cpu[i]);
            cpuGroup.add(RadioButtons.cpu[i]);
        }
        RadioButtons.cpu[0].setSelected(true);

        //Panel for label of level of cpu
        JPanel labelOfLevelPanel = new JPanel();
        labelOfLevelPanel.add(Labels.levelOfCPU);

        //Panel for difficulty of CPUs radio buttons
        JPanel[] difficultyOfCPUPanel = new JPanel[3];
        ButtonGroup[] diffButtonGroup = new ButtonGroup[3];
        GridLayout gridLayout = new GridLayout(1, 0, 2, 2);

        for (int i = 0; i < difficultyOfCPUPanel.length; i++){
            difficultyOfCPUPanel[i] = new JPanel(gridLayout);
            diffButtonGroup[i] = new ButtonGroup();
            for (int j = 0; j< RadioButtons.diffCPU[i].length; j++){
                difficultyOfCPUPanel[i].add(RadioButtons.diffCPU[i][j]);
                diffButtonGroup[i].add(RadioButtons.diffCPU[i][j]);
            }
            RadioButtons.diffCPU[i][0].setSelected(true);
        }

        //Panel for label and difficulty radio buttons of all CPUs
        JPanel[] panelLevel = new JPanel[3];
        for (int i = 0; i< panelLevel.length; i++){
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

        ChecksForJComponents.checkForRadioButtons();

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel, BorderLayout.CENTER);

        Panels.makeNextBackPanel();
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame2PlayerChoiceDuel(Container pane){
        numOfDuelFrame=2;

        Labels.setPlayerChoiceDuelLabels();
        Buttons.setNextBackButtons();
        ActionListenerButtons.addNextBackButtonsActList();
        RadioButtons.setRadioButtonsDuel();
        ActionListenerRadioButtons.addRadButActListDuel();

        TextField.makeTextField(true);

        Panels.writePlayersNamePanel.add(Labels.writeNames);

        JPanel radioButtonsPanel = new JPanel(new GridLayout(1,2,2,2));
        radioButtonsPanel.add(RadioButtons.yesOrNo[1]);
        radioButtonsPanel.add(RadioButtons.yesOrNo[0]);
        RadioButtons.yesOrNo[1].setSelected(true);

        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(RadioButtons.yesOrNo[1]);
        radioButtonsGroup.add(RadioButtons.yesOrNo[0]);

        JPanel selectCPUPanel = new JPanel(new GridLayout(1,0,2,2));
        selectCPUPanel.add(Labels.duelCPU);
        selectCPUPanel.add(radioButtonsPanel);

        JPanel textFieldPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        TitledBorder border = BorderFactory.createTitledBorder("");
        textFieldPanel.setBorder(border);

        textFieldPanel.add(TextField.labelPlayerNames[0]);
        textFieldPanel.add(TextField.labelPlayerNames[1]);

        textFieldPanel.add(TextField.textPlayerNames[0]);
        textFieldPanel.add(TextField.textPlayerNames[1]);

        JPanel CPUChoiceAndTextFieldPanel= new JPanel(new GridLayout(2,0,2,2));
        CPUChoiceAndTextFieldPanel.add(selectCPUPanel);
        CPUChoiceAndTextFieldPanel.add(textFieldPanel);

        pane.add(Panels.writePlayersNamePanel,BorderLayout.PAGE_START);
        pane.add(CPUChoiceAndTextFieldPanel,BorderLayout.CENTER);
        Panels.makeNextBackPanel();
        pane.add(Panels.backNextPanel,BorderLayout.PAGE_END);
    }

    static void frame3PlayersName(Container pane) {
        numOfFrame = 3;

        Labels.setPlayerNamesLabel();
        TextField.makeTextField(false);
        //Panel for labels and text fields for players names
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 4, 2, 2));
        for (int i = 0; i< TextField.labelPlayerNames.length; i++){
            textFieldPanel.add(TextField.labelPlayerNames[i]);
        }

        for (int i = 0; i< TextField.textPlayerNames.length; i++){
            textFieldPanel.add(TextField.textPlayerNames[i]);
        }

        //Panel for Title of frame
        Panels.writePlayersNamePanel.add(Labels.writeNames);

        pane.add(Panels.writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame4GamePlay(Container pane, Table tableOfCards, boolean preview) {
        numOfFrame = 4;

        Labels.setLabelName();

        messagePanel = new JPanel();
        gamePanel = new JPanel();
        JPanel playerPanel = new JPanel();

        GridLayout layout= new GridLayout(tableOfCards.sizeX(), tableOfCards.sizeY(), 10, 5);
        gamePanel.setLayout(layout);
        TitledBorder border = BorderFactory.createTitledBorder("Table of Cards");
        gamePanel.setBorder(border);
        Buttons.setCardButtons(tableOfCards);

        ChecksForJComponents.previewCheck(tableOfCards,preview,gamePanel);

        playerPanel.add(Labels.turnOfPlayer);

        pane.add(messagePanel, BorderLayout.PAGE_START);
        pane.add(gamePanel, BorderLayout.CENTER);
        pane.add(playerPanel, BorderLayout.PAGE_END);
        ActionListenerButtons.addCardButtonsActList(tableOfCards);
        DelaysInGUI.delayForPreview(tableOfCards, tableOfCards, false, messagePanel, gamePanel);
    }

    static void frame3GamePlayDuel(Container pane, Table tableOfCards1,Table tableOfCards2, boolean preview){
        numOfDuelFrame=3;

        Labels.setLabelName();

        messagePanel = new JPanel();
        gamePanel = new JPanel();
        JPanel playerPanel = new JPanel();

        JPanel table1Panel1= new JPanel(new GridLayout(tableOfCards1.sizeX(),tableOfCards1.sizeY(),10,5));
        TitledBorder border = BorderFactory.createTitledBorder("Table 1");
        table1Panel1.setBorder(border);
        Buttons.setCardButtons(tableOfCards1);
        ChecksForJComponents.previewCheck(tableOfCards1,preview,table1Panel1);

        JPanel table1Panel2= new JPanel(new GridLayout(tableOfCards2.sizeX(),tableOfCards2.sizeY(),10,5));
        TitledBorder border2 = BorderFactory.createTitledBorder("Table 2");
        table1Panel2.setBorder(border2);
        Buttons.setCardButtons(tableOfCards2);
        ChecksForJComponents.previewCheck(tableOfCards2,preview,table1Panel2);

        GridLayout layout = new GridLayout(1, 0, 10, 10);
        gamePanel.setLayout(layout);
        gamePanel.add(table1Panel1);
        gamePanel.add(table1Panel2);

        Panels.addMessage(playerPanel,Labels.turnOfPlayer);

        pane.add(messagePanel, BorderLayout.PAGE_START);
        pane.add(gamePanel, BorderLayout.CENTER);
        pane.add(playerPanel, BorderLayout.PAGE_END);
        //ActionListenerButtons.addCardButtonsActList(tableOfCards2,table1Panel1,pane);
        //ActionListenerButtons.addCardButtonsActList(tableOfCards2,table1Panel2,pane);
        DelaysInGUI.delayForPreview(tableOfCards1, tableOfCards2, true, messagePanel, gamePanel);
    }

    public static void showCards(Table tableOfCards, boolean preview) {
        frame4GamePlay(gameFrame.getContentPane(), tableOfCards, preview);
    }

    public static void showCardsDuel(Table tableOfCards1,Table tableOfCards2, boolean preview) {
        frame3GamePlayDuel(gameFrame.getContentPane(), tableOfCards1,tableOfCards2, preview);
    }
}