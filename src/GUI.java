import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

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
            }
        });
        radiobutton.p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {numOfPlayers=2; }
        });
        radiobutton.p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {numOfPlayers=3; }
        });
        radiobutton.p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {numOfPlayers=4; }
        });
    }

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI gui = new GUI();
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
        createJContents();

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

        JPanel numPlayersButtonsPanel = new JPanel(/*new GridLayout(1,0)*/);
        GridLayout layout = new GridLayout(1, 0, 2, 2);
        numPlayersButtonsPanel.setLayout(layout);
        numPlayersButtonsPanel.add(radiobutton.p1);
        radiobutton.p1.setSelected(true);

        JPanel numPlayersButtonsPanel2 = new JPanel(/*new GridLayout(1,0)*/);
        numPlayersButtonsPanel2.add(radiobutton.p2);
        numPlayersButtonsPanel.add(radiobutton.cpu1);

        JPanel numPlayersButtonsPanel3 = new JPanel(/*new GridLayout(1,0)*/);
        numPlayersButtonsPanel.add(radiobutton.p3);
        numPlayersButtonsPanel.add(radiobutton.cpu2);

        JPanel numPlayersButtonsPanel4 = new JPanel(/*new GridLayout(1,0)*/);
        numPlayersButtonsPanel.add(radiobutton.p4);
        numPlayersButtonsPanel.add(radiobutton.cpu3);

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(radiobutton.p2);
        radioButtons.add(radiobutton.cpu1);

        ButtonGroup radioButtons2 = new ButtonGroup();
        radioButtons2.add(radiobutton.p3);
        radioButtons2.add(radiobutton.cpu2);

        ButtonGroup radioButtons3 = new ButtonGroup();
        radioButtons3.add(radiobutton.p4);
        radioButtons3.add(radiobutton.cpu3);

        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.add(label.chooseNumOfPlayers);

        JPanel backNextPanel= new JPanel();
        backNextPanel.add(button.backbutton);
        backNextPanel.add(button.nextbutton);

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(numPlayersButtonsPanel,BorderLayout.CENTER);
        pane.add(numPlayersButtonsPanel2,BorderLayout.AFTER_LAST_LINE);
        pane.add(numPlayersButtonsPanel3,BorderLayout.AFTER_LAST_LINE);
        pane.add(numPlayersButtonsPanel4,BorderLayout.AFTER_LAST_LINE);
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

        pane.add(writePlayersnamePanel, BorderLayout.PAGE_START);
        pane.add(textFieldPanel,BorderLayout.CENTER);
        pane.add(backNextPanel,BorderLayout.PAGE_END);
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