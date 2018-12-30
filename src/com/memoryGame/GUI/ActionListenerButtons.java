package com.memoryGame.GUI;

import com.memoryGame.Table;
import javax.swing.*;
import java.awt.*;

class ActionListenerButtons {
    ActionListenerButtons() {
        addButtonsActList();
    }

    static void addButtonsActList() {
        Buttons.basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.basicButton.setSelected(true);
        });
        Buttons.doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.doubleButton.setSelected(true);
        });
        Buttons.tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.tripleButton.setSelected(true);
        });
        Buttons.duelButton.addActionListener(actionEvent -> {
            selectPlayersForDuel();
            Buttons.duelButton.setSelected(true);
        });

        Buttons.backButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame() == 2 || GUI.getNumOfDuelFrame()==2) {
                Buttons.basicButton.setSelected(false);
                Buttons.doubleButton.setSelected(false);
                Buttons.tripleButton.setSelected(false);
                Buttons.duelButton.setSelected(false);
                GUI.frame1GameMode(GUI.getFrame().getContentPane());
            } else if (GUI.getNumOfFrame() == 3) {
                GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });

        Buttons.nextButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame() == 2) {
                GUI.frame3PlayersName(GUI.getFrame().getContentPane());
            } else if (GUI.getNumOfFrame() == 3 || GUI.getNumOfDuelFrame()==2) {
                GUI.getFrame().setVisible(false);
                //Make new frame for Cards
                GUI.createFrame2();
            }
            GUI.getFrame().validate();
        });
    }
    static void addCardButtonsActList(Table table, JPanel panel, Container container) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                final int x = i;
                final int y = j;
                Buttons.cardButtons[i][j].addActionListener(actionEvent -> {
                    panel.remove(Buttons.cardButtons[x][y]);
                    container.repaint();

                    panel.add(Buttons.openCardButtons[x][y], x * table.sizeY() + y);
                    container.validate();
                    container.repaint();
                    //System.out.println("Pressed card " + (x + 1) + "-" + (y + 1));
                });
            }
        }
    }

    private static void selectPlayersForDuel(){
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoiceDuel(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }

    private static void selectNumOfPlayers() {
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}
