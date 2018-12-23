//package GUI;
//
//import javax.swing.*;
//import java.awt.*;
//
//class LayoutGrid {
//
//    private static JButton[] buttons;
//    private static JFrame frame;
//
//    static void setLayoutGrid() {
//        Dimension dimension = new Dimension(150, 75);
//        frame.setTitle("Memory Game");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//        final int NUM_BUTTONS = 24;
//        buttons = new JButton[NUM_BUTTONS];
//        GridLayout grid = new GridLayout(0, 4, 10, 5);
//        frame.setLayout(grid);
//        for (int i = 0; i < NUM_BUTTONS; i++) {
//            buttons[i] = new JButton("Card " + (i + 1));
//            buttons[i].setFocusPainted(false);
//            buttons[i].setzPreferredSize(dimension);
//            frame.add(buttons[i]);
//        }
//        frame.pack();
//        GUI.setFrameOnCenter(this);
//        frame.setVisible(true);
//    }
//
//    public static void main(String[] args) {
//        LayoutGrid l = new LayoutGrid();
//    }
//}
