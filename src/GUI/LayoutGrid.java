package GUI;

import javax.swing.*;
import java.awt.*;

class LayoutGrid extends JFrame {

    private JButton[] buttons;

    LayoutGrid() {

        final int NUM_BUTTONS = 24;
        buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(0, 4, 10, 5);
        setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = new JButton("Card " + (i + 1));
            add(buttons[i]);
        }
    }

}
