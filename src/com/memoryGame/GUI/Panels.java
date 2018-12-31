package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class Panels {
    static JPanel messagePanel,playerPanel,writePlayersNamePanel,selectPlayersPanel;
    static JPanel backNextPanel,gamePanel;
    static void makePanels(){
        TitledBorder border = BorderFactory.createTitledBorder("");
        messagePanel = new JPanel();
        playerPanel = new JPanel();

        selectPlayersPanel = new JPanel();
        selectPlayersPanel.setBorder(border);
        writePlayersNamePanel = new JPanel();
        writePlayersNamePanel.setBorder(border);

        gamePanel = new JPanel();
        backNextPanel = new JPanel();
        backNextPanel.setBorder(border);
        backNextPanel.add(Buttons.backButton);
        backNextPanel.add(Buttons.nextButton);
    }

    static void removeMessage(JPanel panel,JLabel label){
        panel.remove(label);
        GUI.getGameFrame().getContentPane().repaint();
    }
    static void addMessage(JPanel panel,JLabel label){
        panel.add(label);
        GUI.getGameFrame().getContentPane().validate();
        GUI.getGameFrame().getContentPane().repaint();
    }
    static void removeButton(JPanel panel, JButton[][] button, int i,int j){
        panel.remove(button[i][j]);
        GUI.getGameFrame().repaint();
    }
    static void addButton(JPanel panel, JButton[][] button,int x,int y, Table table){
        panel.add(button[x][y], x * table.sizeY() + y);
        GUI.getGameFrame().validate();
        GUI.getGameFrame().repaint();
    }

    //static void disableButton(JPanel panel, JButton[][] button,int x, int y){}
}
