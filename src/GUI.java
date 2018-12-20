import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI implements ActionListener {

    private static JFrame frame;
    private Buttons button;

    //private JButton basicButton, doubleButton, tripleButton, duelButton;
    //private JButton button;
    private JRadioButton p1, p2, p3, p4;
    private JRadioButton radioButton;
    private JLabel chooseGameMode, chooseNumOfPlayers;
    private JLabel label;

    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    private Logic log;
    private Table tableOfCards;

    private void craeateJconents(){
        button=new Buttons();
        addActList();
    }

    private void addActList(){
        button.basicButton.addActionListener(this);
        button.doubleButton.addActionListener(this);
        button.tripleButton.addActionListener(this);
        button.duelButton.addActionListener(this);
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
    /*private void setButtonsName(){
        basicButton=makeButton("Basic Game");
        doubleButton=makeButton("Double Game");
        tripleButton=makeButton("Triple Game");
        duelButton=makeButton("Duel Game");
    }*/

    private void setLabelName(){
        chooseGameMode=makeLabel("Select Game mode");
        chooseNumOfPlayers=makeLabel("Select Number of Players");
    }

    private void setRadioButtonName(){
        p1=makeRadioButton("1 Player");
        p2=makeRadioButton("2 Players");
        p3=makeRadioButton("3 Players");
        p4=makeRadioButton("4 Players");
    }

    private void addContent(Container pane) {
        craeateJconents();
        JPanel gmLabelPanel = new JPanel();
        setLabelName();
        gmLabelPanel.add(chooseGameMode);

        JPanel gmButtonsPanel = new JPanel();
        button.setButtonsName();
        gmButtonsPanel.add(button.basicButton);
        gmButtonsPanel.add(button.doubleButton);
        gmButtonsPanel.add(button.tripleButton);
        gmButtonsPanel.add(button.duelButton);

        pane.add(gmLabelPanel, BorderLayout.PAGE_START);
        pane.add(gmButtonsPanel, BorderLayout.CENTER);
    }

    /*private JButton makeButton(String name){
        Dimension dimension = new Dimension(180,90);

        button = new JButton(name);
        button.addActionListener(this);
        button.setFocusPainted(false);
        //button.setMnemonic(KeyEvent.VK_B);
        button.setPreferredSize(dimension);
        button.setFont(buttonFont);

        return button;
    }*/

    private JLabel makeLabel(String name){
        label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 52));
        label.setForeground(Color.BLUE);

        return label;
    }

    private JRadioButton makeRadioButton(String name){
        radioButton=new JRadioButton(name);

        return radioButton;
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
        JPanel numPlayersButtonsPanel = new JPanel(new GridLayout(1,0));
        setRadioButtonName();
        p1.setSelected(true);

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(p1);
        radioButtons.add(p2);
        radioButtons.add(p3);
        radioButtons.add(p4);

        numPlayersButtonsPanel.add(p1);
        numPlayersButtonsPanel.add(p2);
        numPlayersButtonsPanel.add(p3);
        numPlayersButtonsPanel.add(p4);

        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);
        p4.addActionListener(this);

        JPanel selectPlayersPanel = new JPanel(new GridLayout(2,0));
        selectPlayersPanel.add(chooseNumOfPlayers);

        pane.add(selectPlayersPanel, BorderLayout.PAGE_START);
        pane.add(numPlayersButtonsPanel,BorderLayout.CENTER);
    }
}
