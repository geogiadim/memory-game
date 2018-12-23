package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private final static int NUM_BUTTONS = 24;
    private static JFrame frame, gameFrame;
    private static int numOfFrame = 0;

    //private Logic log;
    //private Table tableOfCards;

    static JFrame getFrame() {
        return frame;
    }

    static JFrame getGameFrame() {
        return gameFrame;
    }

    static int getNumOfFrame() {
        return numOfFrame;
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

        frame4GamePlay();

        gameFrame.setResizable(false);
        gameFrame.pack();
        setFrameOnCenter(gameFrame);
        gameFrame.setVisible(true);
    }

    private static void setFrameOnCenter(JFrame frame) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        //frame.setLocationRelativeTo(null);
        int x = (d.width - frame.getWidth()) / 2;
        int y = (d.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    static void clearFrame() {
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
        TitledBorder border = BorderFactory.createTitledBorder("Players Names");
        textFieldPanel.setBorder(border);

        textFieldPanel.add(TextField.labelP1);
        textFieldPanel.add(TextField.labelP2);
        textFieldPanel.add(TextField.labelP3);
        textFieldPanel.add(TextField.labelP4);

        textFieldPanel.add(TextField.textP1);
        textFieldPanel.add(TextField.textP2);
        textFieldPanel.add(TextField.textP3);
        textFieldPanel.add(TextField.textP4);

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

    private static void frame4GamePlay() {
        numOfFrame = 4;
        Dimension dimension = new Dimension(150, 75);

        JButton[] buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(0, 4, 10, 5);
        gameFrame.setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = new JButton("Card " + (i + 1));
            buttons[i].setFocusPainted(false);
            buttons[i].setPreferredSize(dimension);
            gameFrame.add(buttons[i]);
        }
        //JPanel panel=new JPanel();
        //panel.add(gameFrame);
        //pane.add(panel);
    }

    private static void checkForTextField() {
        if (RadioButtons.p1.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(false);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p2.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p3.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p4.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(true);
        }
    }

    private static void checkForTextField2() {
        if (RadioButtons.cpu0.isSelected()) {
            TextField.textP1.setText(" ");
            TextField.textP2.setText(" ");
            TextField.textP3.setText(" ");
            TextField.textP4.setText(" ");
        }
        if (RadioButtons.cpu1.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);
        }
        if (RadioButtons.cpu2.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);

            TextField.textP2.setText("CPU 2");
            TextField.textP2.setEnabled(false);
        }
        if (RadioButtons.cpu3.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);

            TextField.textP2.setText("CPU 2");
            TextField.textP2.setEnabled(false);

            TextField.textP3.setText("CPU 3");
            TextField.textP3.setEnabled(false);
        }
    }

    private static void checkForRadioButtons() {
        if (RadioButtons.p1.isSelected()) {
            RadioButtons.cpu1.setEnabled(false);
            RadioButtons.cpu2.setEnabled(false);
            RadioButtons.cpu3.setEnabled(false);
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

    private static void createJContents() {
        Buttons.setButtonsName();

        Labels.setLabelName();

        RadioButtons.setRadioButtonName();

        TextField.setTextFields();
    }
}