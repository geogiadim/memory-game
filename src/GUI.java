import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private static JFrame frame;
    private Buttons button;
    private Labels label;
    private RadioButtons radiobutton;

    private Logic log;
    private Table tableOfCards;

    private void craeateJcontents(){
        button=new Buttons();
        button.setButtonsName();
        addButtonsActList();
        label=new Labels();
        label.setLabelName();
        radiobutton=new RadioButtons();
        radiobutton.setRadioButtonName();
        addRadButActList();
    }

    private void addButtonsActList(){
        button.basicButton.addActionListener(this);
        button.doubleButton.addActionListener(this);
        button.tripleButton.addActionListener(this);
        button.duelButton.addActionListener(this);
    }

    private void addRadButActList(){
        radiobutton.p1.addActionListener(this);
        radiobutton.p2.addActionListener(this);
        radiobutton.p3.addActionListener(this);
        radiobutton.p4.addActionListener(this);
    }

    public static void createGUI() {
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GUI gui = new GUI();
        gui.addContent(frame.getContentPane());

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

    private void addContent(Container pane) {
        craeateJcontents();

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
        makeNumPlayersRadioButtons(frame.getContentPane());
        frame.validate();
    }

    private void clearFrame(){
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
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
            selectNumOfPlayers();
        }
    }

    private void makeGrid(Container pane) {
        JButton[] cards = new JButton[24/*tableOfCards.sizeOfTable()*/];
        GridLayout gridLayout = new GridLayout(4, 6/*tableOfCards.sizeX(),tableOfCards.sizeY()*/);
        pane.setLayout(gridLayout);
        for (int i = 0; i < tableOfCards.sizeOfTable(); i++) {
            cards[i] = new JButton("Button" + (i + 1));
            pane.add(cards[i]);
        }
    }

    private void makeNumPlayersRadioButtons(Container pane) {
        JPanel numPlayersButtonsPanel = new JPanel(/*new GridLayout(1,0)*/);
        numPlayersButtonsPanel.add(radiobutton.p1);
        numPlayersButtonsPanel.add(radiobutton.p2);
        numPlayersButtonsPanel.add(radiobutton.p3);
        numPlayersButtonsPanel.add(radiobutton.p4);
        radiobutton.p1.setSelected(true);

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(radiobutton.p1);
        radioButtons.add(radiobutton.p2);
        radioButtons.add(radiobutton.p3);
        radioButtons.add(radiobutton.p4);

        JPanel selectPlayersPanel = new JPanel();
        selectPlayersPanel.add(label.chooseNumOfPlayers);

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(numPlayersButtonsPanel,BorderLayout.CENTER);
    }
}