package com.memoryGame;

import com.memoryGame.GUI.GUI;

import javax.swing.*;

/**
 * This is the main Class of the project, initialising the GUI.
 *
 * @author Giorgos Christidis
 */

public class Main {
    /**
     * Sets Look and Feel for the GUI to system default and calls GUI Class to initialise the first GUI Frame
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
