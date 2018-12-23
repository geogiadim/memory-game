package GUI;

import javax.swing.*;
import java.awt.*;

class LayoutGrid extends JFrame{

    private JButton[] buttons;

    public LayoutGrid() {
        Dimension dimension = new Dimension(150, 75);
        setTitle("Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        final int NUM_BUTTONS = 24;
        buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(0, 4, 10, 5);
        setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = new JButton("Card " + (i + 1));
            buttons[i].setFocusPainted(false);
            buttons[i].setPreferredSize(dimension);
            add(buttons[i]);
        }
        pack();
        GUI.setFrameOnCenter(this);
        setVisible(true);
    }
    public static void main(String[] args) {
        LayoutGrid l=new LayoutGrid();
    }
}
