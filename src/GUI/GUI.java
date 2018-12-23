package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private static JFrame frame;
    private static Buttons button;
    private static Labels label;
    private static RadioButtons radiobutton;
    private static TextField textField;

    static ActionListenerRadioButtons radioButtonListener;
    static ActionListenerButtons buttonListener;

    private static int numOfFrame = 0;

    //private Logic log;
    //private Table tableOfCards;

    private void createJContents() {
        if (ActionListenerRadioButtons.getNumOfPlayers()==2){int x=1;}
        button = new Buttons();
        button.setButtonsName();
        buttonListener=new ActionListenerButtons();

        label = new Labels();
        label.setLabelName();

        radiobutton = new RadioButtons();
        radiobutton.setRadioButtonName();
        radioButtonListener=new ActionListenerRadioButtons();

        textField = new TextField();
    }

    static RadioButtons getRadioButtons() {return radiobutton;}

    static TextField getTextField() {return textField;}

    static Buttons getButton() {return button;}

    static JFrame getFrame() {return frame;}

    static int getNumOfFrame() {return numOfFrame;}

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI gui = new GUI();
        gui.createJContents();
        GUI.frame1GameMode(frame.getContentPane());

        frame.setResizable(false);
        frame.pack();
        setFrameOnCenter(frame);
        frame.setVisible(true);
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
        gmLabelPanel.add(label.chooseGameMode);

        JPanel gmButtonsPanel = new JPanel();
        gmButtonsPanel.add(button.basicButton);
        gmButtonsPanel.add(button.doubleButton);
        gmButtonsPanel.add(button.tripleButton);
        gmButtonsPanel.add(button.duelButton);

        pane.add(gmLabelPanel, BorderLayout.PAGE_START);
        pane.add(gmButtonsPanel, BorderLayout.CENTER);
    }

    static void frame2PlayerChoice(Container pane) {
        numOfFrame = 2;
        JPanel numOfPlayersPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        numOfPlayersPanel.add(radiobutton.p1);
        numOfPlayersPanel.add(radiobutton.p2);
        numOfPlayersPanel.add(radiobutton.p3);
        numOfPlayersPanel.add(radiobutton.p4);
        radiobutton.p1.setSelected(true);

        ButtonGroup playersGroup = new ButtonGroup();
        playersGroup.add(radiobutton.p1);
        playersGroup.add(radiobutton.p2);
        playersGroup.add(radiobutton.p3);
        playersGroup.add(radiobutton.p4);

        JPanel numOfCPUsPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        numOfCPUsPanel.add(radiobutton.cpu0);
        numOfCPUsPanel.add(radiobutton.cpu1);
        numOfCPUsPanel.add(radiobutton.cpu2);
        numOfCPUsPanel.add(radiobutton.cpu3);
        radiobutton.cpu0.setSelected(true);

        ButtonGroup cpuGroup = new ButtonGroup();
        cpuGroup.add(radiobutton.cpu0);
        cpuGroup.add(radiobutton.cpu1);
        cpuGroup.add(radiobutton.cpu2);
        cpuGroup.add(radiobutton.cpu3);

        JPanel labelOfLevelPanel = new JPanel();
        labelOfLevelPanel.add(label.levelOfCPU);

        JPanel difficultyOfCPUPanel = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel.add(radiobutton.easyCPU);
        radiobutton.easyCPU.setSelected(true);
        difficultyOfCPUPanel.add(radiobutton.normalCPU);
        difficultyOfCPUPanel.add(radiobutton.difficultCPU);

        ButtonGroup difficultyGroup = new ButtonGroup();
        difficultyGroup.add(radiobutton.easyCPU);
        difficultyGroup.add(radiobutton.normalCPU);
        difficultyGroup.add(radiobutton.difficultCPU);

        JPanel difficultyOfCPUPanel2 = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel2.add(radiobutton.easyCPU2);
        radiobutton.easyCPU2.setSelected(true);
        difficultyOfCPUPanel2.add(radiobutton.normalCPU2);
        difficultyOfCPUPanel2.add(radiobutton.difficultCPU2);

        ButtonGroup difficultyGroup2 = new ButtonGroup();
        difficultyGroup2.add(radiobutton.easyCPU2);
        difficultyGroup2.add(radiobutton.normalCPU2);
        difficultyGroup2.add(radiobutton.difficultCPU2);

        JPanel difficultyOfCPUPanel3 = new JPanel(new GridLayout(1, 0, 2, 2));
        difficultyOfCPUPanel3.add(radiobutton.easyCPU3);
        radiobutton.easyCPU3.setSelected(true);
        difficultyOfCPUPanel3.add(radiobutton.normalCPU3);
        difficultyOfCPUPanel3.add(radiobutton.difficultCPU3);

        ButtonGroup difficultyGroup3 = new ButtonGroup();
        difficultyGroup3.add(radiobutton.easyCPU3);
        difficultyGroup3.add(radiobutton.normalCPU3);
        difficultyGroup3.add(radiobutton.difficultCPU3);

        JPanel panel1 = new JPanel();
        panel1.add(label.levelCpu1);
        panel1.add(difficultyOfCPUPanel);

        JPanel panel2 = new JPanel();
        panel2.add(label.levelCpu2);
        panel2.add(difficultyOfCPUPanel2);

        JPanel panel3 = new JPanel();
        panel3.add(label.levelCpu3);
        panel3.add(difficultyOfCPUPanel3);

        JPanel levelPanel = new JPanel(new GridLayout(4, 0, 2, 2));
        levelPanel.add(labelOfLevelPanel, BorderLayout.BEFORE_FIRST_LINE);
        levelPanel.add(panel1, BorderLayout.PAGE_START);
        levelPanel.add(panel2, BorderLayout.CENTER);
        levelPanel.add(panel3, BorderLayout.PAGE_END);

        JPanel choicePanel = new JPanel();
        GridLayout layout = new GridLayout(1, 3, 2, 2);
        choicePanel.setLayout(layout);
        choicePanel.add(numOfPlayersPanel);
        choicePanel.add(numOfCPUsPanel);
        choicePanel.add(levelPanel);

        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.add(label.chooseNumOfPlayers);

        JPanel backNextPanel = new JPanel();
        backNextPanel.add(button.backButton);
        backNextPanel.add(button.nextButton);

        checkForRadioButtons();
        checkForRadioButtons2();

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel, BorderLayout.CENTER);
        pane.add(backNextPanel, BorderLayout.PAGE_END);
    }

    static void frame3PlayersName(Container pane) {
        numOfFrame = 3;
        JPanel textFieldPanel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Player Names");
        textFieldPanel.setBorder(border);
        GridLayout layout = new GridLayout(2, 4, 2, 2);
        textFieldPanel.setLayout(layout);

        textFieldPanel.add(textField.labelP1);
        textFieldPanel.add(textField.labelP2);
        textFieldPanel.add(textField.labelP3);
        textFieldPanel.add(textField.labelP4);

        textFieldPanel.add(textField.textP1);
        textFieldPanel.add(textField.textP2);
        textFieldPanel.add(textField.textP3);
        textFieldPanel.add(textField.textP4);

        JPanel writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.add(label.writeNames);

        JPanel backNextPanel = new JPanel();
        backNextPanel.add(button.backButton);
        backNextPanel.add(button.nextButton);

        checkForTextField();
        checkForTextField2();

        pane.add(writePlayersNamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel, BorderLayout.CENTER);
        pane.add(backNextPanel, BorderLayout.PAGE_END);
    }

    private static void checkForTextField() {
        if (radiobutton.p1.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(false);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (radiobutton.p2.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (radiobutton.p3.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(false);
        }
        if (radiobutton.p4.isSelected()) {
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(true);
        }
    }

    private static void checkForTextField2() {
        if (radiobutton.cpu0.isSelected()) {
            textField.textP1.setText(" ");
            textField.textP2.setText(" ");
            textField.textP3.setText(" ");
            textField.textP4.setText(" ");
        }
        if (radiobutton.cpu1.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);
        }
        if (radiobutton.cpu2.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.textP2.setEnabled(false);
        }
        if (radiobutton.cpu3.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.textP2.setEnabled(false);

            textField.textP3.setText("CPU 3");
            textField.textP3.setEnabled(false);
        }
    }

    private static void checkForRadioButtons() {
        if (radiobutton.p1.isSelected()) {
            radiobutton.cpu1.setEnabled(false);
            radiobutton.cpu2.setEnabled(false);
            radiobutton.cpu3.setEnabled(false);
        }
    }

    private static void checkForRadioButtons2() {
        if (radiobutton.cpu0.isSelected()) {
            setEnabledLevelCPU0();
        }
        if (radiobutton.cpu1.isSelected()) {
            setEnabledLevelCPU1();
        }
        if (radiobutton.cpu2.isSelected()) {
            setEnabledLevelCPU2();
        }
        if (radiobutton.cpu3.isSelected()) {
            setEnabledLevelCPU3();
        }
    }

    private static void setEnabledLevelCPU0 (){
        radiobutton.easyCPU.setEnabled(false);
        radiobutton.normalCPU.setEnabled(false);
        radiobutton.difficultCPU.setEnabled(false);

        radiobutton.easyCPU2.setEnabled(false);
        radiobutton.normalCPU2.setEnabled(false);
        radiobutton.difficultCPU2.setEnabled(false);

        radiobutton.easyCPU3.setEnabled(false);
        radiobutton.normalCPU3.setEnabled(false);
        radiobutton.difficultCPU3.setEnabled(false);
    }

    private static void setEnabledLevelCPU1(){
        radiobutton.easyCPU.setEnabled(true);
        radiobutton.normalCPU.setEnabled(true);
        radiobutton.difficultCPU.setEnabled(true);

        radiobutton.easyCPU2.setEnabled(false);
        radiobutton.normalCPU2.setEnabled(false);
        radiobutton.difficultCPU2.setEnabled(false);

        radiobutton.easyCPU3.setEnabled(false);
        radiobutton.normalCPU3.setEnabled(false);
        radiobutton.difficultCPU3.setEnabled(false);
    }

    private static void setEnabledLevelCPU2(){
        radiobutton.easyCPU.setEnabled(true);
        radiobutton.normalCPU.setEnabled(true);
        radiobutton.difficultCPU.setEnabled(true);

        radiobutton.easyCPU2.setEnabled(true);
        radiobutton.normalCPU2.setEnabled(true);
        radiobutton.difficultCPU2.setEnabled(true);

        radiobutton.easyCPU3.setEnabled(false);
        radiobutton.normalCPU3.setEnabled(false);
        radiobutton.difficultCPU3.setEnabled(false);
    }

    private static void setEnabledLevelCPU3(){
        radiobutton.easyCPU.setEnabled(true);
        radiobutton.normalCPU.setEnabled(true);
        radiobutton.difficultCPU.setEnabled(true);

        radiobutton.easyCPU2.setEnabled(true);
        radiobutton.normalCPU2.setEnabled(true);
        radiobutton.difficultCPU2.setEnabled(true);

        radiobutton.easyCPU3.setEnabled(true);
        radiobutton.normalCPU3.setEnabled(true);
        radiobutton.difficultCPU3.setEnabled(true);
    }

    /*private void makeGrid(Container pane) {
        JButton[] cards = new JButton[24/*tableOfCards.sizeOfTable()*//*];
        /*GridLayout gridLayout = new GridLayout(4, 6/*tableOfCards.sizeX(),tableOfCards.sizeY()*//*);
       /* pane.setLayout(gridLayout);
        for (int i = 0; i < tableOfCards.sizeOfTable(); i++) {
            cards[i] = new JButton("Button" + (i + 1));
            pane.add(cards[i]);
        }
    }*/
}