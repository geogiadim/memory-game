import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.LambdaConversionException;

public class GUI implements ActionListener {

    private JFrame frame;
    private JButton basic, doubLe, triple, duel;
    private JLabel gameplay;
    private FlowLayout aLayout;
    private Logic log;
    private Table tableOfCards;

    public GUI() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Memory Game");
        aLayout = new FlowLayout();
        frame.setLayout(aLayout);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        makeButton();
        makeLabel();

        frame.add(gameplay);
        frame.add(basic);
        frame.add(doubLe);
        frame.add(triple);
        frame.add(duel);

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        setFrameOnCenter(frame);
        frame.setVisible(true);
    }

    private void makeButton() {
        basic = new JButton("Basic Game");
        basic.addActionListener(this);
        doubLe = new JButton("Double Game");
        doubLe.addActionListener(this);
        triple = new JButton("Triple Game");
        triple.addActionListener(this);
        duel = new JButton("Duel Game");
        duel.addActionListener(this);
    }

    private void makeLabel() {
        gameplay = new JLabel("Select game mode: ");
        gameplay.setFont(new Font("Sheriff", Font.BOLD, 50));
        gameplay.setForeground(Color.BLACK);
    }

    public void setFrameOnCenter(Frame frame) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        //frame.setLocationRelativeTo(null);
        int x = (d.width - frame.getWidth()) / 2;
        int y = (d.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Basic Game")) {
            removeCompontents();
            gameplay.setText("You have chosen Basic Mode!");
            frame.add(gameplay);
            frame.validate();
            log = new Logic(1);
            makeGrid();
        } else if (e.getActionCommand().equals("Double Game")) {
            gameplay.setText("Double");
        } else if (e.getActionCommand().equals("Triple Game")) {
            gameplay.setText("Triple");
        } else if (e.getActionCommand().equals("Duel Game")) {
            gameplay.setText("Duel");
        }
    }

    private void removeCompontents() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }

    private void makeGrid(){
        JButton[] cards = new JButton[tableOfCards.sizeOfTable()];
        GridLayout gridLayout = new GridLayout(tableOfCards.sizeX(),tableOfCards.sizeY());
        frame.setLayout(gridLayout);
        for (int i =0;i < tableOfCards.sizeOfTable();i++){
            cards[i] = new JButton("Button" + (i+1));
            frame.add(cards[i]);
        }
        frame.pack();
    }
}
