package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class Panels {
    static JPanel backNextPanel;

    private final static TitledBorder border = BorderFactory.createTitledBorder("");

    static void makeNextBackPanel(){
        backNextPanel = new JPanel();
        backNextPanel.setBorder(border);
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);
    }

    static void removeAllCardButtons(){
        GUI.getGamePanel().removeAll();
        GUI.getGamePanel().validate();
    }

    static void removeCardButton(JButton[][] button, int i,int j){
        GUI.getGamePanel().remove(button[i][j]);
        GUI.getGamePanel().validate();
    }
    static void addCardButton(JButton[][] button,int x,int y, Table table){
        GUI.getGamePanel().add(button[x][y], x * table.sizeY() + y);
        GUI.getGamePanel().validate();
        GUI.getGamePanel().repaint();
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
}
