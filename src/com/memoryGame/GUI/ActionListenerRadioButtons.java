package com.memoryGame.GUI;

import javax.swing.*;

class ActionListenerRadioButtons {
    static void addRadButActList() {
        for (int i = 0; i < RadioButtons.player.length; i++){
            final int playerNo = i;
            RadioButtons.player[i].addActionListener(actionEvent -> setRadioButtonsAndTextFields(playerNo));
        }

        for (int i = 0; i < RadioButtons.cpu.length; i++) {
            final int playerNo = i;
            RadioButtons.cpu[i].addActionListener(actionEvent -> {
                for (int k = 0; k <= playerNo; k++){
                    TextField.textPlayerNames[k].setEnabled(true);
                }
                for (int k = RadioButtons.cpu.length - 1; k > playerNo; k--){
                    System.out.println("SET "+ k);
                    TextField.textPlayerNames[k].setEnabled(false);
                }
                for (int j = RadioButtons.cpu.length-1; j > playerNo; j--)
                    RadioButtons.diffCPU[j-1][0].setSelected(true);
                setEnabledLevelCPU(playerNo);
            });
        }

    }

    private static void setRadioButtonsAndTextFields(int num){
        for (int i = 0; i <= num; i++){
            TextField.textPlayerNames[i].setEnabled(true);
            RadioButtons.cpu[i].setEnabled(true);
        }
        for (int i = 3; i > num; i--){
            TextField.textPlayerNames[i].setEnabled(false);
            RadioButtons.cpu[i].setEnabled(false);
            for (JRadioButton r : RadioButtons.diffCPU[i-1]) r.setEnabled(false);
            if (RadioButtons.cpu[i].isSelected()){
                RadioButtons.cpu[i-1].setSelected(true);
                RadioButtons.diffCPU[i-1][0].setSelected(true);
            }
        }
    }

    static void addRadButActListDuel(){
        RadioButtons.yesOrNo[1].addActionListener(actionEvent ->{
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[1].setText("Player 2");
        });
        RadioButtons.yesOrNo[0].addActionListener(actionEvent ->{
            TextField.textPlayerNames[1].setEnabled(false);
            TextField.textPlayerNames[1].setText("CPU");
        });
    }

    private static void setEnabledLevelCPU(int cpuNo){
        switch (cpuNo){
            case 0:
                for (int i = 0; i < RadioButtons.diffCPU.length; i++){
                    for (int j = 0; j < RadioButtons.diffCPU[i].length; j++){
                        RadioButtons.diffCPU[i][j].setEnabled(false);
                    }
                }
                break;
            case 1:
                for (JRadioButton radioButton : RadioButtons.diffCPU[0]){
                    radioButton.setEnabled(true);
                }

                for (JRadioButton radioButton : RadioButtons.diffCPU[1]) {
                    radioButton.setEnabled(false);
                }

                for (JRadioButton radioButton : RadioButtons.diffCPU[2]) {
                    radioButton.setEnabled(false);
                }
                break;
            case 2:
                for (JRadioButton radioButton : RadioButtons.diffCPU[0]){
                    radioButton.setEnabled(true);
                }

                for (JRadioButton radioButton : RadioButtons.diffCPU[1]){
                    radioButton.setEnabled(true);
                }

                for (JRadioButton radioButton : RadioButtons.diffCPU[2]){
                    radioButton.setEnabled(false);
                }
                break;
            case 3:
                for (JRadioButton[] radioArray: RadioButtons.diffCPU){
                    for (JRadioButton radioElement: radioArray){
                        radioElement.setEnabled(true);
                    }
                }
                break;
            default:
                break;
        }
    }
}
