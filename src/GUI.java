import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private static JFrame frame;
    private Buttons button;
    private Labels label;
    private RadioButtons radiobutton;
    private TextField textField;

    private int numOfFrames=0;
    private int numOfPlayers=0;

    //private Logic log;
    //private Table tableOfCards;

    private void createJContents(){
        button=new Buttons();
        button.setButtonsName();
        addButtonsActList();

        label=new Labels();
        label.setLabelName();

        radiobutton=new RadioButtons();
        radiobutton.setRadioButtonName();
        addRadButActList();

        textField=new TextField();
    }

    private void addButtonsActList(){
        button.basicButton.addActionListener(this);
        button.doubleButton.addActionListener(this);
        button.tripleButton.addActionListener(this);
        button.duelButton.addActionListener(this);

        button.backbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clearFrame();
                if (numOfFrames==2) {
                    frame1GameMode(frame.getContentPane());
                }
                else if (numOfFrames==3){
                    frame2PlayerChoice(frame.getContentPane());
                }
                frame.validate();
            }
        });

        button.nextbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFrame();
                if (numOfFrames==2) {
                    frame3PlayersName(frame.getContentPane());
                }
                frame.validate();
            }
        });
    }

    private void addRadButActList(){
        radiobutton.p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=1;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(false);
                textField.textP3.setEnabled(false);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(false);
                radiobutton.cpu2.setEnabled(false);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=2;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(false);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(false);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=3;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(true);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(true);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=4;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(true);
                textField.textP4.setEnabled(true);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(true);
                radiobutton.cpu3.setEnabled(true);
            }
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

    private static void clearFrame(){
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }

    private void frame1GameMode(Container pane) {
        numOfFrames=1;
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

    private void selectNumOfPlayers(){
        clearFrame();
        frame2PlayerChoice(frame.getContentPane());
        frame.validate();
    }

    private void frame2PlayerChoice(Container pane) {
        numOfFrames=2;
        JPanel numOfPlayersPanel = new JPanel(new GridLayout(4,0,2,2));
        numOfPlayersPanel.add(radiobutton.p1);
        numOfPlayersPanel.add(radiobutton.p2);
        numOfPlayersPanel.add(radiobutton.p3);
        numOfPlayersPanel.add(radiobutton.p4);
        radiobutton.p1.setSelected(true);

        ButtonGroup playersGroup =new ButtonGroup();
        playersGroup.add(radiobutton.p1);
        playersGroup.add(radiobutton.p2);
        playersGroup.add(radiobutton.p3);
        playersGroup.add(radiobutton.p4);

        JPanel numOfCPUsPanel = new JPanel(new GridLayout(4,0,2,2));
        numOfCPUsPanel.add(radiobutton.cpu0);
        numOfCPUsPanel.add(radiobutton.cpu1);
        numOfCPUsPanel.add(radiobutton.cpu2);
        numOfCPUsPanel.add(radiobutton.cpu3);
        radiobutton.cpu0.setSelected(true);

        ButtonGroup cpuGroup =new ButtonGroup();
        cpuGroup.add(radiobutton.cpu0);
        cpuGroup.add(radiobutton.cpu1);
        cpuGroup.add(radiobutton.cpu2);
        cpuGroup.add(radiobutton.cpu3);

        JPanel choicePanel= new JPanel();
        GridLayout layout=new GridLayout(1,2,2,2);
        choicePanel.setLayout(layout);
        choicePanel.add(numOfPlayersPanel);
        choicePanel.add(numOfCPUsPanel);

        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.add(label.chooseNumOfPlayers);

        JPanel backNextPanel= new JPanel();
        backNextPanel.add(button.backbutton);
        backNextPanel.add(button.nextbutton);

        checkForRadioButtons();

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(choicePanel,BorderLayout.CENTER);
        pane.add(backNextPanel,BorderLayout.PAGE_END);
    }

    private void frame3PlayersName(Container pane){
        numOfFrames=3;
        JPanel textFieldPanel = new JPanel();
        TitledBorder border = BorderFactory.createTitledBorder("Player's name");
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

        JPanel writePlayersnamePanel= new JPanel();
        writePlayersnamePanel.add(label.writeNames);

        JPanel backNextPanel= new JPanel();
        backNextPanel.add(button.backbutton);
        backNextPanel.add(button.nextbutton);

        checkForTextField();

        pane.add(writePlayersnamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel,BorderLayout.CENTER);
        pane.add(backNextPanel,BorderLayout.PAGE_END);
    }

    private void checkForTextField(){
        if (radiobutton.p1.isSelected()){
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(false);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (radiobutton.p2.isSelected()){
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(false);
            textField.textP4.setEnabled(false);
        }
        if (radiobutton.p3.isSelected()){
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(false);
        }
        if(radiobutton.p4.isSelected()){
            textField.textP1.setEnabled(true);
            textField.textP2.setEnabled(true);
            textField.textP3.setEnabled(true);
            textField.textP4.setEnabled(true);
        }
    }
    private void checkForTextField2(){
        if (radiobutton.cpu1.isSelected()){
            textField.textP1.setText("CPU 1");
            textField.labelP1.setText("CPU");
            textField.labelP1.
        }
        if (radiobutton.cpu2.isSelected()){
            textField.textP1.setText("CPU 1");
            textField.textP2.setText("CPU 2");
        }
    }
    private void checkForRadioButtons(){
        if (radiobutton.p1.isSelected()) {
            radiobutton.cpu1.setEnabled(false);
            radiobutton.cpu2.setEnabled(false);
            radiobutton.cpu3.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(button.basicButton.getText())){
            selectNumOfPlayers();
        } else if (e.getActionCommand().equals(button.doubleButton.getText())) {
            selectNumOfPlayers();
        } else if (e.getActionCommand().equals(button.tripleButton.getText())) {
            selectNumOfPlayers();
        } else if (e.getActionCommand().equals(button.duelButton.getText())) {
            //selectNumOfPlayers();
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