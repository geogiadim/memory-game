package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class Panels {
    private final static TitledBorder border = BorderFactory.createTitledBorder("");
    static JPanel backNextPanel;

    static void makeNextBackPanel() {
        backNextPanel = new JPanel();
        backNextPanel.setBorder(border);
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);
    }

    static void removeAllCardButtons() {
        GUI.getGamePanel().removeAll();
        GUI.getGamePanel().validate();
    }

    static void removeAllCardButtons(boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).removeAll();
        GUI.getGamePanelDuel(isFirst).validate();
    }

    static void removeCardButton(JButton[][] button, int i, int j) {
        GUI.getGamePanel().remove(button[i][j]);
        GUI.getGamePanel().validate();
    }

    static void removeCardButton(JButton[][] button, int i, int j, boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).remove(button[i][j]);
        GUI.getGamePanelDuel(isFirst).validate();
    }

    static void addCardButton(JButton[][] button, int x, int y, Table table) {
        GUI.getGamePanel().add(button[x][y], x * table.sizeY() + y);
        GUI.getGamePanel().validate();
        GUI.getGamePanel().repaint();
    }

    static void addCardButton(JButton[][] button, int x, int y, Table table, boolean isFirst) {
        GUI.getGamePanelDuel(isFirst).add(button[x][y], x * table.sizeY() + y);
        GUI.getGamePanelDuel(isFirst).validate();
        GUI.getGamePanelDuel(isFirst).repaint();
    }

    static void addAllCardButtons(JButton[][] button, Table table) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                GUI.getGamePanel().add(button[i][j], i * table.sizeY() + j);
            }
        }
        GUI.getGamePanel().validate();
        GUI.getGamePanel().repaint();
    }

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
