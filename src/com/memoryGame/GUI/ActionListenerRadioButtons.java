package com.memoryGame.GUI;

import javax.swing.*;

class ActionListenerRadioButtons {
    static void addRadButActList() {
        for (int i = 0; i < RadioButtons.player.length; i++) {
            final int playerNo = i;
            RadioButtons.player[i].addActionListener(actionEvent -> setRadioButtonsAndTextFields(playerNo));
        }

        for (int i = 0; i < RadioButtons.cpu.length; i++) {
            final int cpuNo = i;
            RadioButtons.cpu[i].addActionListener(actionEvent -> {
                for (int k = 0; k <= cpuNo; k++) {
                    if (k > 0) {
                        for (int m = 0; m < RadioButtons.diffCPU[k - 1].length; m++) {
                            RadioButtons.diffCPU[k - 1][m].setEnabled(true);
                        }
                    }
                }
                for (int j = RadioButtons.cpu.length - 1; j > cpuNo; j--) {
                    RadioButtons.diffCPU[j - 1][0].setSelected(true);
                    for (int m = 0; m < RadioButtons.diffCPU[j - 1].length; m++) {
                        RadioButtons.diffCPU[j - 1][m].setEnabled(false);
                    }
                }
            });
        }
    }

    private static void setRadioButtonsAndTextFields(int num) {
        for (int i = 0; i <= num; i++) {
            RadioButtons.cpu[i].setEnabled(true);
        }
        for (int i = 3; i > num; i--) {
            RadioButtons.cpu[i].setEnabled(false);
            for (JRadioButton r : RadioButtons.diffCPU[i - 1]) r.setEnabled(false);
            if (RadioButtons.cpu[i].isSelected()) {
                RadioButtons.cpu[i - 1].setSelected(true);
                RadioButtons.diffCPU[i - 1][0].setSelected(true);
            }
        }
    }

    static void addRadButActListDuel() {
        RadioButtons.yesOrNo[1].addActionListener(actionEvent -> {
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[1].setText("Player 2");
            for (JRadioButton radioButton : RadioButtons.diffDuel) {
                radioButton.setEnabled(false);
            }
            RadioButtons.diffDuel[0].setSelected(true);
        });
        RadioButtons.yesOrNo[0].addActionListener(actionEvent -> {
            TextField.textPlayerNames[1].setEnabled(false);
            TextField.textPlayerNames[1].setText("CPU");
            for (JRadioButton radioButton : RadioButtons.diffDuel) {
                radioButton.setEnabled(true);
            }
        });
    }
}