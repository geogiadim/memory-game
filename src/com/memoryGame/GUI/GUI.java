package com.memoryGame.GUI;
import com.memoryGame.Logic;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private static JFrame frame, gameFrame;
    private static Logic logic;
    private static int numOfFrame = 0,numOfDuelFrame = 0;

    private static void createJContents() {
        Buttons.setButtonsName();
        ActionListenerButtons.addButtonsActList();
        Labels.setLabelName();
        RadioButtons.setRadioButtonName();
        ActionListenerRadioButtons.addRadButActList();
        TextField.makeTextField();
        Panels.makePanels();
    }

    static JFrame getFrame() {return frame;}
    static JFrame getGameFrame() {return gameFrame;}
    static int getNumOfFrame() {return numOfFrame;}
    static int getNumOfDuelFrame() {return  numOfDuelFrame;}
    static Logic getLogic(){return logic;}

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
    static void clearPanel (JPanel panel){
        panel.removeAll();
        panel.repaint();
    }

    static void frame1GameMode(Container pane) {
        numOfFrame = 1;
        numOfDuelFrame=0;
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
        //Panel for Players radio buttons
        JPanel numOfPlayersPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        numOfPlayersPanel.add(RadioButtons.p1);
        numOfPlayersPanel.add(RadioButtons.p2);
        numOfPlayersPanel.add(RadioButtons.p3);
        numOfPlayersPanel.add(RadioButtons.p4);
        RadioButtons.p1.setSelected(true);

        ButtonGroup playersGroup = new ButtonGroup();
        playersGroup.add(RadioButtons.p1);
        playersGroup.add(RadioButtons.p2);
        playersGroup.add(RadioButtons.p3);
        playersGroup.add(RadioButtons.p4);

        //Panel for CPUs radio buttons
        JPanel numOfCPUsPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        numOfCPUsPanel.add(RadioButtons.cpu0);
        numOfCPUsPanel.add(RadioButtons.cpu1);
        numOfCPUsPanel.add(RadioButtons.cpu2);
        numOfCPUsPanel.add(RadioButtons.cpu3);
        RadioButtons.cpu0.setSelected(true);

        ButtonGroup cpuGroup = new ButtonGroup();
        cpuGroup.add(RadioButtons.cpu0);
        cpuGroup.add(RadioButtons.cpu1);
        cpuGroup.add(RadioButtons.cpu2);
        cpuGroup.add(RadioButtons.cpu3);

        //Panel for label of level of cpu
        JPanel labelOfLevelPanel = new JPanel();
        labelOfLevelPanel.add(Labels.levelOfCPU);

        //Panel for difficulty of CPU 1 radio buttons
        JPanel difficultyOfCPUPanel = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel.add(RadioButtons.easyCPU);
        RadioButtons.easyCPU.setSelected(true);
        difficultyOfCPUPanel.add(RadioButtons.normalCPU);
        difficultyOfCPUPanel.add(RadioButtons.difficultCPU);

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(RadioButtons.easyCPU);
        difficultyGroup.add(RadioButtons.normalCPU);
        difficultyGroup.add(RadioButtons.difficultCPU);
        //Panel for difficulty of CPU 2 radio buttons
        JPanel difficultyOfCPUPanel2 = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel2.add(RadioButtons.easyCPU2);
        RadioButtons.easyCPU2.setSelected(true);
        difficultyOfCPUPanel2.add(RadioButtons.normalCPU2);
        difficultyOfCPUPanel2.add(RadioButtons.difficultCPU2);

        ButtonGroup difficultyGroup2 = new ButtonGroup();
        difficultyGroup2.add(RadioButtons.easyCPU2);
        difficultyGroup2.add(RadioButtons.normalCPU2);
        difficultyGroup2.add(RadioButtons.difficultCPU2);
        //Panel for difficulty of CPU 3 radio buttons
        JPanel difficultyOfCPUPanel3 = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel3.add(RadioButtons.easyCPU3);
        RadioButtons.easyCPU3.setSelected(true);
        difficultyOfCPUPanel3.add(RadioButtons.normalCPU3);
        difficultyOfCPUPanel3.add(RadioButtons.difficultCPU3);

        ButtonGroup difficultyGroup3 = new ButtonGroup();
        difficultyGroup3.add(RadioButtons.easyCPU3);
        difficultyGroup3.add(RadioButtons.normalCPU3);
        difficultyGroup3.add(RadioButtons.difficultCPU3);
        //Panel for label and difficulty radio buttons of CPU 1
        JPanel panel1 = new JPanel();
        panel1.add(Labels.levelCpu1);
        panel1.add(difficultyOfCPUPanel);
        //Panel for label and difficulty radio buttons of CPU 2
        JPanel panel2 = new JPanel();
        panel2.add(Labels.levelCpu2);
        panel2.add(difficultyOfCPUPanel2);
        //Panel for label and difficulty radio buttons of CPU 3
        JPanel panel3 = new JPanel();
        panel3.add(Labels.levelCpu3);
        panel3.add(difficultyOfCPUPanel3);
        //Panel for label and choices of difficulty of all CPUs
        JPanel levelPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        levelPanel.add(labelOfLevelPanel, BorderLayout.BEFORE_FIRST_LINE);
        levelPanel.add(panel1, BorderLayout.PAGE_START);
        levelPanel.add(panel2, BorderLayout.CENTER);
        levelPanel.add(panel3, BorderLayout.PAGE_END);
        //Panel includes all previous panels
        JPanel choicePanel = new JPanel(new GridLayout(1, 3, 2, 2));
        choicePanel.add(numOfPlayersPanel);
        choicePanel.add(numOfCPUsPanel);
        choicePanel.add(levelPanel);

        //Panel for title of the frame
        Panels.selectPlayersPanel.add(Labels.chooseNumOfPlayers);

        ChecksForJComponents.checkForRadioButtons();

        pane.add(Panels.selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame2PlayerChoiceDuel(Container pane){
        numOfDuelFrame=2;
        Panels.writePlayersNamePanel.add(Labels.writeNames);

        JPanel radioButtonsPanel = new JPanel(new GridLayout(1,2,2,2));
        radioButtonsPanel.add(RadioButtons.no);
        radioButtonsPanel.add(RadioButtons.yes);
        RadioButtons.no.setSelected(true);

        ButtonGroup radioButtonsGroup = new ButtonGroup();
        radioButtonsGroup.add(RadioButtons.no);
        radioButtonsGroup.add(RadioButtons.yes);

        JPanel selectCPUPanel = new JPanel(new GridLayout(1,0,2,2));
        selectCPUPanel.add(Labels.duelCPU);
        selectCPUPanel.add(radioButtonsPanel);

        JPanel textFieldPanel = new JPanel(new GridLayout(2, 2, 2, 2));
        TitledBorder border = BorderFactory.createTitledBorder("");
        textFieldPanel.setBorder(border);

        textFieldPanel.add(TextField.labelP1);
        textFieldPanel.add(TextField.labelP2);

        textFieldPanel.add(TextField.textP1);
        textFieldPanel.add(TextField.textP2);

        JPanel CPUChoiceAndTextFieldPanel= new JPanel(new GridLayout(2,0,2,2));
        CPUChoiceAndTextFieldPanel.add(selectCPUPanel);
        CPUChoiceAndTextFieldPanel.add(textFieldPanel);

        ChecksForJComponents.checksForDuel();

        pane.add(Panels.writePlayersNamePanel,BorderLayout.PAGE_START);
        pane.add(CPUChoiceAndTextFieldPanel,BorderLayout.CENTER);
        pane.add(Panels.backNextPanel,BorderLayout.PAGE_END);
    }

    static void frame3PlayersName(Container pane) {
        numOfFrame = 3;
        //Panel for labels and text fields for players names
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 4, 2, 2));
        textFieldPanel.add(TextField.labelP1);
        textFieldPanel.add(TextField.labelP2);
        textFieldPanel.add(TextField.labelP3);
        textFieldPanel.add(TextField.labelP4);

        textFieldPanel.add(TextField.textP1);
        textFieldPanel.add(TextField.textP2);
        textFieldPanel.add(TextField.textP3);
        textFieldPanel.add(TextField.textP4);

        //Panel for Title of frame
        Panels.writePlayersNamePanel.add(Labels.writeNames);

        ChecksForJComponents.checkForTextField();
        ChecksForJComponents.checkForTextField2();

        pane.add(Panels.writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel, BorderLayout.CENTER);
        pane.add(Panels.backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame4GamePlay(Container pane, Table tableOfCards, boolean preview) {
        numOfFrame = 4;
        GridLayout layout= new GridLayout(tableOfCards.sizeX(), tableOfCards.sizeY(), 10, 5);
        Panels.gamePanel.setLayout(layout);
        TitledBorder border = BorderFactory.createTitledBorder("Table of Cards");
        Panels.gamePanel.setBorder(border);
        Buttons.setCardButtons(tableOfCards);
        ChecksForJComponents.previewCheck(tableOfCards,preview,Panels.gamePanel);

        Panels.addMessage(Panels.playerPanel,Labels.turnOfPlayer);

        pane.add(Panels.messagePanel, BorderLayout.PAGE_START);
        pane.add(Panels.gamePanel, BorderLayout.CENTER);
        pane.add(Panels.playerPanel, BorderLayout.PAGE_END);
        ActionListenerButtons.addCardButtonsActList(tableOfCards);
    }

    static void frame3GamePlayDuel(Container pane, Table tableOfCards1,Table tableOfCards2, boolean preview){
        numOfDuelFrame=3;
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
        Panels.gamePanel.setLayout(layout);
        Panels.gamePanel.add(table1Panel1);
        Panels.gamePanel.add(table1Panel2);

        Panels.addMessage(Panels.playerPanel,Labels.turnOfPlayer);

        pane.add(Panels.messagePanel, BorderLayout.PAGE_START);
        pane.add(Panels.gamePanel, BorderLayout.CENTER);
        pane.add(Panels.playerPanel, BorderLayout.PAGE_END);
        //ActionListenerButtons.addCardButtonsActList(tableOfCards2,table1Panel1,pane);
        //ActionListenerButtons.addCardButtonsActList(tableOfCards2,table1Panel2,pane);
    }

    public static void showCards(Table tableOfCards, boolean preview) {
        frame4GamePlay(gameFrame.getContentPane(), tableOfCards, preview);
        DelaysInGUI.delayForPreview(tableOfCards, tableOfCards, false);
    }

    public static void showCardsDuel(Table tableOfCards1,Table tableOfCards2, boolean preview) {
        frame3GamePlayDuel(gameFrame.getContentPane(), tableOfCards1,tableOfCards2, preview);
        DelaysInGUI.delayForPreview(tableOfCards1,tableOfCards2,true);
    }
}