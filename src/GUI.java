import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class GUI implements ActionListener {

    private static JFrame frame;
    private JButton basicButton, doubleButton, tripleButton, duelButton;
    private JRadioButton p1, p2, p3, p4;
    private JLabel chooseGameMode;

    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    private Logic log;
    private Table tableOfCards;

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
        JPanel gmLabel = new JPanel();
        makeGameModeLabel();
        gmLabel.add(chooseGameMode);

        JPanel gmButtons = new JPanel();
        makeGMButtons();
        gmButtons.add(basicButton);
        gmButtons.add(basicButton);
        gmButtons.add(doubleButton);
        gmButtons.add(tripleButton);
        gmButtons.add(duelButton);

        pane.add(gmLabel, BorderLayout.PAGE_START);
        pane.add(gmButtons, BorderLayout.CENTER);
    }

    private void makeGMButtons() {
        Dimension dimension = new Dimension(180,90);

        basicButton = new JButton("Basic Game");
        basicButton.addActionListener(this);
        basicButton.setFocusPainted(false);
        basicButton.setMnemonic(KeyEvent.VK_B);
        basicButton.setPreferredSize(dimension);
        basicButton.setFont(buttonFont);

        doubleButton = new JButton("Double Game");
        doubleButton.addActionListener(this);
        doubleButton.setFocusPainted(false);
        doubleButton.setMnemonic(KeyEvent.VK_D);
        doubleButton.setPreferredSize(dimension);
        doubleButton.setFont(buttonFont);

        tripleButton = new JButton("Triple Game");
        tripleButton.addActionListener(this);
        tripleButton.setFocusPainted(false);
        tripleButton.setMnemonic(KeyEvent.VK_T);
        tripleButton.setPreferredSize(dimension);
        tripleButton.setFont(buttonFont);

        duelButton = new JButton("Duel Game");
        duelButton.addActionListener(this);
        duelButton.setFocusPainted(false);
        duelButton.setMnemonic(KeyEvent.VK_U);
        duelButton.setPreferredSize(dimension);
        duelButton.setFont(buttonFont);
    }

    private void makeGameModeLabel() {
        chooseGameMode = new JLabel("Select game mode");
        chooseGameMode.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 52));
        chooseGameMode.setForeground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(basicButton.getText())) {
            chooseGameMode.setText("Basic Mode");
        } else if (e.getActionCommand().equals(doubleButton.getText())) {
            chooseGameMode.setText("Double Mode");
        } else if (e.getActionCommand().equals(tripleButton.getText())) {
            chooseGameMode.setText("Triple Mode");
        } else if (e.getActionCommand().equals(duelButton.getText())) {
            chooseGameMode.setText("Duel Mode");
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

    private void makeNumPlayersRadioButtons() {
        JRadioButton p1 = new JRadioButton("1");
        JRadioButton p2 = new JRadioButton("2");
        JRadioButton p3 = new JRadioButton("3");
        JRadioButton p4 = new JRadioButton("4");

        ButtonGroup radioButtons = new ButtonGroup();
        radioButtons.add(p1);
        radioButtons.add(p2);
        radioButtons.add(p3);
        radioButtons.add(p4);

        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);
        p4.addActionListener(this);
    }
}
