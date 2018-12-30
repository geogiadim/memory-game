package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;

class ChecksForJComponents {
    static void previewCheck(Table tableOfCards, boolean preview, JPanel gamePanel){
        if (preview) {
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 0; j < tableOfCards.sizeY(); j++) {
                    gamePanel.add(Buttons.openCardButtons[i][j]);
                }
            }
        } else {
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 0; j < tableOfCards.sizeY(); j++) {
                    gamePanel.add(Buttons.cardButtons[i][j]);
                }
            }
        }
    }
    static void checksForDuel (){
        if (RadioButtons.no.isSelected()){
            TextField.textP2.setEnabled(true);
            TextField.textP2.setText("Player 2");
        }
        if (RadioButtons.yes.isSelected()){
            TextField.textP2.setEnabled(false);
            TextField.textP2.setText("CPU");
        }
    }
    static void checkForTextField() {
        if (RadioButtons.p1.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(false);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p2.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p3.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(false);
        }
        if (RadioButtons.p4.isSelected()) {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(true);
        }
    }
    static void checkForTextField2() {
        if (RadioButtons.cpu0.isSelected()) {
            TextField.textP1.setText("Player 1");
            TextField.textP2.setText("Player 2");
            TextField.textP3.setText("Player 3");
            TextField.textP4.setText("Player 4");
        }
        if (RadioButtons.cpu1.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);
        }
        if (RadioButtons.cpu2.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);

            TextField.textP2.setText("CPU 2");
            TextField.textP2.setEnabled(false);
        }
        if (RadioButtons.cpu3.isSelected()) {
            TextField.textP1.setText("CPU 1");
            TextField.textP1.setEnabled(false);

            TextField.textP2.setText("CPU 2");
            TextField.textP2.setEnabled(false);

            TextField.textP3.setText("CPU 3");
            TextField.textP3.setEnabled(false);
        }
    }
    static void checkForRadioButtons() {
        if (RadioButtons.p1.isSelected()) {
            RadioButtons.cpu1.setEnabled(false);
            RadioButtons.cpu2.setEnabled(false);
            RadioButtons.cpu3.setEnabled(false);

            RadioButtons.p2.setSelected(false);
            RadioButtons.p3.setSelected(false);
            RadioButtons.p4.setSelected(false);
        }
        if (RadioButtons.cpu0.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU0();
        }
        if (RadioButtons.cpu1.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU1();
        }
        if (RadioButtons.cpu2.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU2();
        }
        if (RadioButtons.cpu3.isSelected()) {
            ActionListenerRadioButtons.setEnabledLevelCPU3();
        }
    }
}
