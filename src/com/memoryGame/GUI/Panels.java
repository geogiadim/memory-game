package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Creates static Panels for back and next Buttons.
 * Handles Card/Button displaying by adding/removing appropriate Card/Buttons.
 *
 * @author George Giannios
 */
class Panels {
    private final static TitledBorder border = BorderFactory.createTitledBorder("");
    static JPanel backNextPanel;

    /**
     * Creates a JPanel to host the back and next Buttons.
     */
    static void makeNextBackPanel() {
        backNextPanel = new JPanel();
        backNextPanel.setBorder(border);
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);
    }


    /**
     * Removes all Card/Buttons from the gameplay Panel.
     */
    static void removeAllCardButtons() {
        GUI.getGamePanel().removeAll();
        GUI.getGamePanel().validate();
    }

    /**
     * In Duel, removes all Card/Buttons from the first gameplay Panel if isFirst true
     * or the second gameplay Panel if isFirst is false.
     *
     * @param isFirst If true remove from the first Panel, else remove from the second Panel
     */
    static void removeAllCardButtons(boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).removeAll();
        GUI.getGamePanelDuel(isFirst).validate();
    }

    /**
     * Removes a specific Card/Button from the gameplay Panel.
     *
     * @param button The 2D array of Card/Buttons
     * @param i      The x coordinate of the Card/Button to remove
     * @param j      The y coordinate of the Card/Button to remove
     */
    static void removeCardButton(JButton[][] button, int i, int j) {
        GUI.getGamePanel().remove(button[i][j]);
        GUI.getGamePanel().validate();
    }

    /**
     * In Duel, removes a specific card button from the first gameplay Panel if isFirst true
     * or the second gameplay Panel if isFirst is false.
     *
     * @param button  The 2D array of Card/Buttons
     * @param i       The x coordinate of the Card/Button to remove
     * @param j       The y coordinate of the Card/Button to remove
     * @param isFirst If true remove from the first Panel, else remove from the second Panel
     */
    static void removeCardButton(JButton[][] button, int i, int j, boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).remove(button[i][j]);
        GUI.getGamePanelDuel(isFirst).validate();
    }

    /**
     * Adds a specific card button to the gameplay Panel.
     *
     * @param button The 2D array of Card/Buttons
     * @param x      The x coordinate of the Card/Button to add
     * @param y      The y coordinate of the Card/Button to add
     * @param table  The Table of Card Objects to determine the size of the Panel grid
     *               and the position of the Card/Button in the Panel grid
     */
    static void addCardButton(JButton[][] button, int x, int y, Table table) {
        GUI.getGamePanel().add(button[x][y], x * table.sizeY() + y);
        GUI.getGamePanel().validate();
        GUI.getGamePanel().repaint();
    }

    /**
     * In Duel, adds a specific card button to the first gameplay Panel if isFirst true
     * or the second gameplay Panel if isFirst is false.
     *
     * @param button  The 2D array of Card/Buttons
     * @param x       The x coordinate of the Card/Button to add
     * @param y       The y coordinate of the Card/Button to add
     * @param table   The Table of Card Objects to determine the size of the Panel grid
     *                and the position of the Card/Button in the Panel grid
     * @param isFirst If true add to the first Panel, else add to the second Panel
     */
    static void addCardButton(JButton[][] button, int x, int y, Table table, boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).add(button[x][y], x * table.sizeY() + y);
        GUI.getGamePanelDuel(isFirst).validate();
        GUI.getGamePanelDuel(isFirst).repaint();
    }

    /**
     * Adds all Card/Buttons to the gameplay Panel.
     *
     * @param button The 2D array of Card/Buttons
     * @param table  The Table of Card Objects to determine the size of the Panel grid
     *               and the position of the Card/Button in the Panel grid
     */
    static void addAllCardButtons(JButton[][] button, Table table) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                GUI.getGamePanel().add(button[i][j], i * table.sizeY() + j);
            }
        }
        GUI.getGamePanel().validate();
        GUI.getGamePanel().repaint();
    }

    /**
     * In Duel, adds all Card/Buttons to the first gameplay Panel if isFirst true
     * or the second gameplay Panel if isFirst is false.
     *
     * @param button  The 2D array of Card/Buttons
     * @param table   The Table of Card Objects to determine the size of the Panel grid
     *                and the position of the Card/Button in the Panel grid
     * @param isFirst If true add to the first Panel, else add to the second Panel
     */
    static void addAllCardButtons(JButton[][] button, Table table, boolean isFirst) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                GUI.getGamePanelDuel(isFirst).add(button[i][j], i * table.sizeY() + j);
            }
        }
        GUI.getGamePanelDuel(isFirst).validate();
        GUI.getGamePanelDuel(isFirst).repaint();
    }
}
