package GUI;
class ActionListenerButtons {
    ActionListenerButtons(){
        addButtonsActList();
    }
    private void addButtonsActList() {
        GUI.getButton().basicButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("1");
        });
        GUI.getButton().doubleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("2");
        });
        GUI.getButton().tripleButton.addActionListener(actionEvent -> {
            selectNumOfPlayers();
            System.out.println("3");
        });
        GUI.getButton().duelButton.addActionListener(actionEvent -> {
            // selectNumOfPlayers();
        });

        GUI.getButton().backButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrame()== 2) {
                GUI.frame1GameMode(GUI.getFrame().getContentPane());
            }
            else if (GUI.getNumOfFrame() == 3) {
                GUI.frame2PlayerChoice(GUI.getFrame().getContentPane());
            }
            GUI.getFrame().validate();
        });

        GUI.getButton().nextButton.addActionListener(actionEvent -> {
            GUI.clearFrame();
            if (GUI.getNumOfFrame()== 2) {
                GUI.frame3PlayersName(GUI.getFrame().getContentPane());
            }
            else if (GUI.getNumOfFrame()==3){
                GUI.getFrame().setVisible(false);
                GUI.createFrame2();
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
