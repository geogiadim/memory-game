package com.memoryGame.GUI;

import com.memoryGame.Table;

class ActionListenerButtons {

    static void addModeButtonsActList() {
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
    }

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

    static void addCardButtonsActList(Table table) {
        for (int i = 0; i < table.sizeX(); i++) {
            for (int j = 0; j < table.sizeY(); j++) {
                final int x = i;
                final int y = j;
                Buttons.cardButtons[i][j].addActionListener(actionEvent -> {
                    if (GUIConnectionToLogic.notInDelay())
                        GUIConnectionToLogic.setCoordinates(x, y, table, Buttons.cardButtons, Buttons.openCardButtons);
                });
            }
        }
    }

    static void addCardButtonsActListDuel(Table table1, Table table2) {
        for (int i = 0; i < table1.sizeX(); i++) {
            for (int j = 0; j < table1.sizeY(); j++) {
                final int x = i;
                final int y = j;
                Buttons.cardButtonsDuelOne[i][j].addActionListener(actionEvent -> {
                    if (GUIConnectionToLogic.isFirstPlayingNow()) {
                        if (GUIConnectionToLogic.notInDelay()) {
                            System.out.println("set coo for 1");
                            GUIConnectionToLogic.setCoordinates(x, y, table1, Buttons.cardButtonsDuelOne, Buttons.openCardButtonsDuelOne);
                        }
                    }
                });
                Buttons.cardButtonsDuelTwo[i][j].addActionListener(actionEvent -> {
                    if (!GUIConnectionToLogic.isFirstPlayingNow()) {
                        if (GUIConnectionToLogic.notInDelay()) {
                            System.out.println("set coo for 2");
                            GUIConnectionToLogic.setCoordinates(x, y, table2, Buttons.cardButtonsDuelTwo, Buttons.openCardButtonsDuelTwo);
                        }
                    }
                });
            }
        }
    }

    private static void selectPlayersForDuel() {
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
