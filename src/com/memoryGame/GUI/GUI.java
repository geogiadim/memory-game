package com.memoryGame.GUI;

import com.memoryGame.Logic;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private static JFrame frame, gameFrame;
    private static TextField textField;
    static Logic logic;
    private static int numOfFrame = 0;
    private final static int PREVIEW_DELAY = 5;

    private static void createJContents() {
        Buttons.setButtonsName();
        ActionListenerButtons.addButtonsActList();

        Labels.setLabelName();

        RadioButtons.setRadioButtonName();
        ActionListenerRadioButtons.addRadButActList();

        textField = new TextField();
    }

    static TextField getTextField() {return textField;}
    static JFrame getFrame() {return frame;}
    //static JFrame getGameFrame() {return gameFrame;}
    static int getNumOfFrame() {return numOfFrame;}

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI.createJContents();
        GUI.frame1GameMode(frame.getContentPane());

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

    static void frame1GameMode(Container pane) {
        numOfFrame = 1;
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
        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.add(Labels.chooseNumOfPlayers);

        //Panel for back and next buttons
        JPanel backNextPanel = new JPanel();
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);

        checkForRadioButtons();

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel, BorderLayout.CENTER);
        pane.add(backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame3PlayersName(Container pane) {
        numOfFrame = 3;
        //Panel for labels and text fields for players names
        JPanel textFieldPanel = new JPanel(new GridLayout(2, 4, 2, 2));
        TitledBorder border = BorderFactory.createTitledBorder("");
        textFieldPanel.setBorder(border);

        textFieldPanel.add(textField.labelP1);
        textFieldPanel.add(textField.labelP2);
        textFieldPanel.add(textField.labelP3);
        textFieldPanel.add(textField.labelP4);

        textFieldPanel.add(textField.textP1);
        textFieldPanel.add(textField.textP2);
        textFieldPanel.add(textField.textP3);
        textFieldPanel.add(textField.textP4);

        //Panel for Title of frame
        JPanel writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.add(Labels.writeNames);
        //Panel for back and next buttons
        JPanel backNextPanel = new JPanel();
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);

        checkForTextField();
        checkForTextField2();

        pane.add(writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel, BorderLayout.CENTER);
        pane.add(backNextPanel, BorderLayout.PAGE_END);
    }
    public static void createCards(Table tableOfCards){Buttons.setCardButtons(tableOfCards);}

    private static void frame4GamePlay(Container pane, Table tableOfCards, boolean preview) {
        numOfFrame = 4;
        JPanel messagePanel = new JPanel();
        messagePanel.add(Labels.message);

        JPanel gamePanel = new JPanel(new GridLayout(tableOfCards.sizeX(), tableOfCards.sizeY(), 10, 5));
        TitledBorder border = BorderFactory.createTitledBorder("Table of Cards");
        gamePanel.setBorder(border);

        if (preview) {
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 0; j < tableOfCards.sizeY(); j++) {
                    gamePanel.add(Buttons.openCardButtons[i][j]);
                }
            }
        } else {
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 0; j < tableOfCards.sizeY(); j++) {
                    gamePanel.add(Buttons.cardButtons[i][j]);
                }
            }
        }

        JPanel playerPanel = new JPanel();
        TitledBorder border2 = BorderFactory.createTitledBorder("");
        playerPanel.setBorder(border2);
        playerPanel.add(Labels.turnOfPlayer);

        pane.add(messagePanel, BorderLayout.PAGE_START);
        pane.add(gamePanel, BorderLayout.CENTER);
        pane.add(playerPanel, BorderLayout.PAGE_END);
    }

    private static void checkForTextField() {
        if (RadioButtons.p1.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(false);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (RadioButtons.p2.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (RadioButtons.p3.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(false);
        }
        if (RadioButtons.p4.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(true);
        }
    }

    private static void checkForTextField2() {
        if (RadioButtons.cpu0.isSelected()) {
            textField.textP1.setText("Player 1");
            textField.textP2.setText("Player 2");
            textField.textP3.setText("Player 3");
            textField.textP4.setText("Player 4");
        }
        if (RadioButtons.cpu1.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);
        }
        if (RadioButtons.cpu2.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.textP2.setEnabled(false);
        }
        if (RadioButtons.cpu3.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.textP2.setEnabled(false);

            textField.textP3.setText("CPU 3");
            textField.textP3.setEnabled(false);
        }
    }

    private static void checkForRadioButtons() {
        if (RadioButtons.p1.isSelected()) {
            RadioButtons.cpu1.setEnabled(false);
            RadioButtons.cpu2.setEnabled(false);
            RadioButtons.cpu3.setEnabled(false);

            RadioButtons.p2.setSelected(false);
            RadioButtons.p3.setSelected(false);
            RadioButtons.p4.setSelected(false);
        }
        if (RadioButtons.cpu0.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU0();
        }
        if (RadioButtons.cpu1.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU1();
        }
        if (RadioButtons.cpu2.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU2();
        }
        if (RadioButtons.cpu3.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU3();
        }
    }

    public static void showCards(Table tableOfCards, boolean preview) {
        //clearFrame(gameFrame);
        frame4GamePlay(gameFrame.getContentPane(), tableOfCards, preview);
        //gameFrame.getContentPane().validate();
        delayForPreview(tableOfCards);
    }

    public static void delayForPreview(Table tableOfCards){
        Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
            System.out.println("Now");
            clearFrame(gameFrame);
            frame4GamePlay(gameFrame.getContentPane(), tableOfCards, false);
            gameFrame.getContentPane().validate();
        });
        timer.setRepeats(false);
        timer.start();
    }

    static int getCardPreviewDelay() {return PREVIEW_DELAY;}
}