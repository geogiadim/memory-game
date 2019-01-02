package com.memoryGame.GUI;

import javax.swing.*;

class ActionListenerRadioButtons {
    static void addRadButActList() {
        RadioButtons.player[0].addActionListener(actionEvent -> {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(false);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);

            RadioButtons.cpu[0].setSelected(true);
            RadioButtons.cpu[0].setEnabled(true);
            RadioButtons.cpu[1].setEnabled(false);
            RadioButtons.cpu[2].setEnabled(false);
            RadioButtons.cpu[3].setEnabled(false);
        });

        RadioButtons.player[1].addActionListener(actionEvent -> {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);

            RadioButtons.cpu[0].setSelected(true);
            RadioButtons.cpu[0].setEnabled(true);
            RadioButtons.cpu[1].setEnabled(true);
            RadioButtons.cpu[2].setEnabled(false);
            RadioButtons.cpu[3].setEnabled(false);
        });

        RadioButtons.player[2].addActionListener(actionEvent -> {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(false);

            RadioButtons.cpu[0].setSelected(true);
            RadioButtons.cpu[0].setEnabled(true);
            RadioButtons.cpu[1].setEnabled(true);
            RadioButtons.cpu[2].setEnabled(true);
            RadioButtons.cpu[3].setEnabled(false);
        });

        RadioButtons.player[3].addActionListener(actionEvent -> {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(true);

            for (JRadioButton radioButton : RadioButtons.cpu) {
                radioButton.setEnabled(true);
            }
            RadioButtons.cpu[0].setSelected(true);
        });

        for (int i = 0; i < RadioButtons.cpu.length; i++) {
            final int x = i;
            RadioButtons.cpu[i].addActionListener(actionEvent -> setEnabledLevelCPU(x));
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

    static void setEnabledLevelCPU(int cpuNo){
        switch (cpuNo){
            case 0:
                for (JRadioButton[] radioArray: RadioButtons.diffCPU){
                    for (JRadioButton radioElement: radioArray){
                        radioElement.setEnabled(false);
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
