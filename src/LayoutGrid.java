import java.awt.GridLayout;
import javax.swing.*;

public class LayoutGrid extends JFrame {

    private JButton[] buttons;

    public LayoutGrid() {
        setTitle("Grid Layout");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final int NUM_BUTTONS = 24;
        buttons = new JButton[NUM_BUTTONS];
        GridLayout grid = new GridLayout(0, 4, 10, 5);
        setLayout(grid);
        for (int i = 0; i < NUM_BUTTONS; i++) {
            buttons[i] = new JButton("Card " + (i+1));
            add(buttons[i]);
        }

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        LayoutGrid frame = new LayoutGrid();
    }
}
