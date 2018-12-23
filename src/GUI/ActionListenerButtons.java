package GUI;
class ActionListenerButtons {
    ActionListenerButtons(){
        addButtonsActList();
    }
    private void addButtonsActList() {
        GUI.getButton().basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
        });
        GUI.getButton().doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
        });
        GUI.getButton().tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
        });
        GUI.getButton().duelButton.addActionListener(actionEvent -> {
            // selectNumOfPlayers();
        });

        GUI.getButton().backButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrames()== 2) {
                GUI.frame1GameMode(GUI.getFrame().getContentPane());
            }
            else if (GUI.getNumOfFrames() == 3) {
                GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });

        GUI.getButton().nextButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrames()== 2) {
                GUI.frame3PlayersName(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });
    }

    private void selectNumOfPlayers() {
        GUI.clearFrame();
        GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
        GUI.getFrame().validate();
    }
}
