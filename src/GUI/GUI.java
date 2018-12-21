package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GUI {
    private static JFrame frame;
    private Buttons button;
    private Labels label;
    private RadioButtons radiobutton;
    private TextField textField;

    private int numOfFrames = 0;
    private int numOfPlayers = 0;

    //private Logic log;
    //private Table tableOfCards;

    private void createJContents() {
        button = new Buttons();
        button.setButtonsName();
        addButtonsActList();

        label = new Labels();
        label.setLabelName();

        radiobutton = new RadioButtons();
        radiobutton.setRadioButtonName();
        addRadButActList();

        textField = new TextField();
    }

    private void addButtonsActList() {
        button.basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("1");
        });
        button.doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("2");
        });
        button.tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("3");
        });
//        button.duelButton.addActionListener(actionEvent -> {
//                    selectNumOfPlayers();
//
//        });

        button.backButton.addActionListener(actionEvent -> {
            clearFrame();
            if (numOfFrames == 2) {
                frame1GameMode(frame.getContentPane());
            } else if (numOfFrames == 3) {
                frame2PlayerChoice(frame.getContentPane());
            }
            frame.validate();
        });

        button.nextButton.addActionListener(actionEvent -> {
            clearFrame();
            if (numOfFrames == 2) {
                frame3PlayersName(frame.getContentPane());
            }
            frame.validate();

        });
    }

    private void addRadButActList() {
        radiobutton.p1.addActionListener(actionEvent -> {

            numOfPlayers = 1;
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(false);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);

            radiobutton.cpu0.setSelected(true);
            radiobutton.cpu0.setEnabled(true);
            radiobutton.cpu1.setEnabled(false);
            radiobutton.cpu2.setEnabled(false);
            radiobutton.cpu3.setEnabled(false);

        });

        radiobutton.p2.addActionListener(actionEvent -> {

            numOfPlayers = 2;
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);

            radiobutton.cpu0.setSelected(true);
            radiobutton.cpu0.setEnabled(true);
            radiobutton.cpu1.setEnabled(true);
            radiobutton.cpu2.setEnabled(false);
            radiobutton.cpu3.setEnabled(false);
        });

        radiobutton.p3.addActionListener(actionEvent -> {

            numOfPlayers = 3;
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(false);

            radiobutton.cpu0.setSelected(true);
            radiobutton.cpu0.setEnabled(true);
            radiobutton.cpu1.setEnabled(true);
            radiobutton.cpu2.setEnabled(true);
            radiobutton.cpu3.setEnabled(false);

        });

        radiobutton.p4.addActionListener(actionEvent -> {

            numOfPlayers = 4;
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(true);

            radiobutton.cpu0.setSelected(true);
            radiobutton.cpu0.setEnabled(true);
            radiobutton.cpu1.setEnabled(true);
            radiobutton.cpu2.setEnabled(true);
            radiobutton.cpu3.setEnabled(true);
        });

        radiobutton.cpu0.addActionListener(actionEvent -> {

            radiobutton.easyCPU.setEnabled(false);
            radiobutton.normalCPU.setEnabled(false);
            radiobutton.difficultCPU.setEnabled(false);

            radiobutton.easyCPU2.setEnabled(false);
            radiobutton.normalCPU2.setEnabled(false);
            radiobutton.difficultCPU2.setEnabled(false);

            radiobutton.easyCPU3.setEnabled(false);
            radiobutton.normalCPU3.setEnabled(false);
            radiobutton.difficultCPU3.setEnabled(false);
        });

        radiobutton.cpu1.addActionListener(actionEvent -> {

            radiobutton.easyCPU.setEnabled(true);
            radiobutton.normalCPU.setEnabled(true);
            radiobutton.difficultCPU.setEnabled(true);

            radiobutton.easyCPU2.setEnabled(false);
            radiobutton.normalCPU2.setEnabled(false);
            radiobutton.difficultCPU2.setEnabled(false);

            radiobutton.easyCPU3.setEnabled(false);
            radiobutton.normalCPU3.setEnabled(false);
            radiobutton.difficultCPU3.setEnabled(false);
        });

        radiobutton.cpu2.addActionListener(actionEvent -> {

            radiobutton.easyCPU.setEnabled(true);
            radiobutton.normalCPU.setEnabled(true);
            radiobutton.difficultCPU.setEnabled(true);

            radiobutton.easyCPU2.setEnabled(true);
            radiobutton.normalCPU2.setEnabled(true);
            radiobutton.difficultCPU2.setEnabled(true);

            radiobutton.easyCPU3.setEnabled(false);
            radiobutton.normalCPU3.setEnabled(false);
            radiobutton.difficultCPU3.setEnabled(false);
        });

        radiobutton.cpu3.addActionListener(actionEvent -> {

            radiobutton.easyCPU.setEnabled(true);
            radiobutton.normalCPU.setEnabled(true);
            radiobutton.difficultCPU.setEnabled(true);

            radiobutton.easyCPU2.setEnabled(true);
            radiobutton.normalCPU2.setEnabled(true);
            radiobutton.difficultCPU2.setEnabled(true);

            radiobutton.easyCPU3.setEnabled(true);
            radiobutton.normalCPU3.setEnabled(true);
            radiobutton.difficultCPU3.setEnabled(true);
        });
    }

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI gui = new GUI();
        gui.createJContents();
        gui.frame1GameMode(frame.getContentPane());

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

    private static void clearFrame() {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }

    private void frame1GameMode(Container pane) {
        numOfFrames = 1;
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

    private void selectNumOfPlayers() {
        clearFrame();
        frame2PlayerChoice(frame.getContentPane());
        frame.validate();
    }

    private void frame2PlayerChoice(Container pane) {
        numOfFrames = 2;
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

    private void frame3PlayersName(Container pane) {
        numOfFrames = 3;
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

    private void checkForTextField() {
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

    private void checkForTextField2() {
        if (radiobutton.cpu0.isSelected()) {
            textField.labelP1.setText("1st Player");
            textField.textP1.setText(" ");
            textField.labelP2.setText("2nd Player");
            textField.textP2.setText(" ");
            textField.labelP3.setText("3rd Player");
            textField.textP3.setText(" ");
            textField.labelP4.setText("4th Player");
            textField.textP4.setText(" ");
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(true);

        }
        if (radiobutton.cpu1.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.labelP1.setText("1st CPU");
            textField.textP1.setEnabled(false);
        }
        if (radiobutton.cpu2.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.labelP1.setText("1st CPU");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.labelP2.setText("2nd CPU");
            textField.textP2.setEnabled(false);
        }
        if (radiobutton.cpu3.isSelected()) {
            textField.textP1.setText("CPU 1");
            textField.labelP1.setText("1st CPU");
            textField.textP1.setEnabled(false);

            textField.textP2.setText("CPU 2");
            textField.labelP2.setText("2nd CPU");
            textField.textP2.setEnabled(false);

            textField.textP3.setText("CPU 3");
            textField.labelP3.setText("3rd CPU");
            textField.textP3.setEnabled(false);

        }
    }

    private void checkForRadioButtons() {
        if (radiobutton.p1.isSelected()) {
            radiobutton.cpu1.setEnabled(false);
            radiobutton.cpu2.setEnabled(false);
            radiobutton.cpu3.setEnabled(false);
        }
    }

    private void checkForRadioButtons2() {
        if (radiobutton.cpu0.isSelected()) {
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
        if (radiobutton.cpu1.isSelected()) {
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
        if (radiobutton.cpu2.isSelected()) {
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
        if (radiobutton.cpu3.isSelected()) {
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