import GUI.GUI;

import javax.swing.*;

/**
 * This is the main Class of the project.
 *
 * @author Giorgos Christidis
 */

public class Main {
    /**
     * Sets Look of GUI to System Default and calls the GUI creator.
     *
     * @param args the command line arguments as an array of String objects
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        GUI.createGUI();
    }
}
