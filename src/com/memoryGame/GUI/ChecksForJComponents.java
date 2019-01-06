package com.memoryGame.GUI;

class ChecksForJComponents {
//    static void previewCheck(Table tableOfCards, JPanel gamePanel){
//        for (int i = 0; i < tableOfCards.sizeX(); i++) {
//            for (int j = 0; j < tableOfCards.sizeY(); j++) {
//                gamePanel.add(Buttons.openCardButtons[i][j]);
//            }
//        }
//    }
//    static void checksForDuel (){
//        if (RadioButtons.yesOrNo[0].isSelected()){
//            TextField.textP2.setEnabled(true);
//            TextField.textP2.setText("Player 2");
//        }
//        if (RadioButtons.yesOrNo[1].isSelected()){
//            TextField.textP2.setEnabled(false);
//            TextField.textP2.setText("CPU");
//        }
//    }
    static void checkForTextField() {
        if (RadioButtons.player[0].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(false);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[1].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[2].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[3].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(true);
        }
    }
    static void checkForTextField2() {
        if (RadioButtons.cpu[0].isSelected()) {
            TextField.textPlayerNames[0].setText("Player 1");
            TextField.textPlayerNames[1].setText("Player 2");
            TextField.textPlayerNames[2].setText("Player 3");
            TextField.textPlayerNames[3].setText("Player 4");
        }
        if (RadioButtons.cpu[1].isSelected()) {
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setText("CPU 1");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setEnabled(false);
        }
        if (RadioButtons.cpu[2].isSelected()) {
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setText("CPU 1");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setEnabled(false);

            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-2].setText("CPU 2");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-2].setEnabled(false);
        }
        if (RadioButtons.cpu[3].isSelected()) {
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setText("CPU 1");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-1].setEnabled(false);

            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-2].setText("CPU 2");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-2].setEnabled(false);

            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-3].setText("CPU 3");
            TextField.textPlayerNames[GUIConnectionToLogic.getNumOfPlayers()-3].setEnabled(false);
        }
    }

//    static void checkForRadioButtons() {
//        if (RadioButtons.player[0].isSelected()) {
//            RadioButtons.cpu[1].setEnabled(false);
//            RadioButtons.cpu[2].setEnabled(false);
//            RadioButtons.cpu[3].setEnabled(false);
//
//            RadioButtons.player[1].setSelected(false);
//            RadioButtons.player[2].setSelected(false);
//            RadioButtons.player[3].setSelected(false);
//        }
//        if (RadioButtons.cpu[0].isSelected()) {
//            ActionListenerRadioButtons.setEnabledLevelCPU(0);
//        }
//        if (RadioButtons.cpu[1].isSelected()) {
//            ActionListenerRadioButtons.setEnabledLevelCPU(1);
//        }
//        if (RadioButtons.cpu[2].isSelected()) {
//            ActionListenerRadioButtons.setEnabledLevelCPU(2);
//        }
//        if (RadioButtons.cpu[3].isSelected()) {
//            ActionListenerRadioButtons.setEnabledLevelCPU(3);
//        }
//    }
}
