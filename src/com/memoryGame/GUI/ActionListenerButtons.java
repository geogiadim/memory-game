package com.memoryGame.GUI;

class ActionListenerButtons {

    static void addButtonsActList() {
        Buttons.basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("1");
        });
        Buttons.doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("2");
        });
        Buttons.tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("3");
        });
        Buttons.duelButton.addActionListener(actionEvent -> {
            // selectNumOfPlayers();
        });

        Buttons.backButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrame() == 2) {
                GUI.frame1GameMode(GUI.getFrame().getContentPane());
            } else if (GUI.getNumOfFrame() == 3) {
                GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });

        Buttons.nextButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrame() == 2) {
                GUI.frame3PlayersName(GUI.getFrame().getContentPane());
            } else if (GUI.getNumOfFrame() == 3) {
                GUI.getFrame().setVisible(false);
                GUI.createFrame2();
            }
            GUI.getFrame().validate();
        });
    }

    private static void selectNumOfPlayers() {
        GUI.clearFrame();
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}
