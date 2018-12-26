package com.memoryGame.GUI;

import com.memoryGame.Logic;

class ActionListenerButtons {
    ActionListenerButtons(){
        addButtonsActList();
    }
    private void addButtonsActList() {
        GUI.getButton().basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            GUI.getButton().basicButton.setSelected(true);
        });
        GUI.getButton().doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            GUI.getButton().doubleButton.setSelected(true);
        });
        GUI.getButton().tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            GUI.getButton().tripleButton.setSelected(true);
        });
        GUI.getButton().duelButton.addActionListener(actionEvent -> {
            // selectNumOfPlayers();
        });

        GUI.getButton().backButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame()== 2) {
                GUI.getButton().basicButton.setSelected(false);
                GUI.getButton().doubleButton.setSelected(false);
                GUI.getButton().tripleButton.setSelected(false);
                GUI.getButton().duelButton.setSelected(false);
                GUI.frame1GameMode(GUI.getFrame().getContentPane());
            }
            else if (GUI.getNumOfFrame() == 3) {
                GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });

        GUI.getButton().nextButton.addActionListener(actionEvent -> {
            GUI.clearFrame(GUI.getFrame());
            if (GUI.getNumOfFrame()== 2) {
                GUI.frame3PlayersName(GUI.getFrame().getContentPane());
            }
            else if (GUI.getNumOfFrame()==3){
                GUI.getFrame().setVisible(false);
                Logic l=new Logic();
            }
            GUI.getFrame().validate();
        });
    }

    private void selectNumOfPlayers() {
        GUI.clearFrame(GUI.getFrame());
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}
