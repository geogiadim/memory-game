package com.memoryGame.GUI;

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
            // selectNumOfPlayers();
        });

        Buttons.backButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame() == 2) {
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
            } else if (GUI.getNumOfFrame() == 3) {
                GUI.getFrame().setVisible(false);
                //Make new frame for Cards
                GUI.createFrame2();
            }
            GUI.getFrame().validate();
        });
    }

    private static void selectNumOfPlayers() {
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}
