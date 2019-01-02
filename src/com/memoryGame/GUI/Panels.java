package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class Panels {
    static JPanel writePlayersNamePanel;
    static JPanel backNextPanel;

    private final static TitledBorder border = BorderFactory.createTitledBorder("");

    static void makePanels(){
        writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.setBorder(border);
    }

    static void makeNextBackPanel(){
        backNextPanel = new JPanel();
        backNextPanel.setBorder(border);
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);
    }

    static void removeAllCardButtons(){
        GUI.getGamePanel().removeAll();
    }

    static void removeCardButton(JButton[][] button, int i,int j){
        GUI.getGamePanel().remove(button[i][j]);
        GUI.getGameFrame().repaint();
    }
    static void addCardButton(JButton[][] button,int x,int y, Table table){
        GUI.getGamePanel().add(button[x][y], x * table.sizeY() + y);
        GUI.getGameFrame().validate();
        GUI.getGameFrame().repaint();
    }

    static void addAllCardButtons(JButton[][] button, Table table) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                Panels.addCardButton(Buttons.openCardButtons,i,j,table);
            }
        }
    }
}
