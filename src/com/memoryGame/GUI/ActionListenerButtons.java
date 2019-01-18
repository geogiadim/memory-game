package com.memoryGame.GUI;

import com.memoryGame.Table;

/**
 * Adds actionListeners to all GUI Buttons.
 *
 * @author George Giannios
 * @author Giorgos Christidis
 */
class ActionListenerButtons {

    /**
     * Adds actionListeners to Game mode Buttons.
     */
    static void addModeButtonsActList() {
        Buttons.basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.basicButton.setSelected(true);
            GUIConnectionToLogic.setMode(1);
        });
        Buttons.doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.doubleButton.setSelected(true);
            GUIConnectionToLogic.setMode(2);
        });
        Buttons.tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            Buttons.tripleButton.setSelected(true);
            GUIConnectionToLogic.setMode(3);
        });
        Buttons.duelButton.addActionListener(actionEvent -> {
            selectPlayersForDuel();
            Buttons.duelButton.setSelected(true);
            GUIConnectionToLogic.setMode(4);
        });
    }

    /**
     * Adds actionListeners to Next and Back Buttons.
     */
    static void addNextBackButtonsActList() {
        Buttons.backButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame() == 2 || GUI.getNumOfDuelFrame() == 2) {
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
            } else if (GUI.getNumOfFrame() == 3 || GUI.getNumOfDuelFrame() == 2) {
                GUI.getFrame().setVisible(false);
                GUI.getFrame().dispose();
                //Make new frame for Cards
                GUI.createFrame2();
            }
            GUI.getFrame().validate();
        });
    }

    /**
     * Adds actionListeners to the Card/Buttons of a specific Table.
     *
     * @param table The Table of Card Objects
     */
    static void addCardButtonsActList(Table table) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                final int x = i;
                final int y = j;
                Buttons.cardButtons[i][j].addActionListener(actionEvent -> {
                    if (GUIConnectionToLogic.getPlayerCanNotPlay()){
                        GUIConnectionToLogic.setCoordinates(x, y, table, Buttons.cardButtons, Buttons.openCardButtons);
                    }
                });
            }
        }
    }

    /**
     * Adds actionListeners to the Card/Buttons of the two Tables used in Duel Mode.
     *
     * @param table1 The first Table of Card Objects for Player 1
     * @param table2 The second Table of Card Objects for Player 2
     */
    static void addCardButtonsActListDuel(Table table1, Table table2) {
        for (int i = 0; i < table1.sizeX(); i++) {
            for (int j = 0; j < table1.sizeY(); j++) {
                final int x = i;
                final int y = j;
                Buttons.cardButtonsDuelOne[i][j].addActionListener(actionEvent -> {
                    if (GUIConnectionToLogic.getPlayerCanNotPlay()){
                        if (GUIConnectionToLogic.isFirstPlayingNow()) {
                            GUIConnectionToLogic.setCoordinates(x, y, table1, Buttons.cardButtonsDuelOne, Buttons.openCardButtonsDuelOne);
                        }
                    }
                });
                Buttons.cardButtonsDuelTwo[i][j].addActionListener(actionEvent -> {
                    if (GUIConnectionToLogic.getPlayerCanNotPlay()){
                        if (!GUIConnectionToLogic.isFirstPlayingNow()) {
                            GUIConnectionToLogic.setCoordinates(x, y, table2, Buttons.cardButtonsDuelTwo, Buttons.openCardButtonsDuelTwo);
                        }
                    }
                });
            }
        }
    }

    /**
     * Called after any normal(not Duel) Mode button is pressed to clear last Frame and load the next one.
     */
    private static void selectNumOfPlayers() {
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }

    /**
     * Called after Duel Mode button is pressed to clear last Frame and load the next one.
     */
    private static void selectPlayersForDuel() {
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoiceDuel(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}