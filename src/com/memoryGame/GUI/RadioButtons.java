package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class RadioButtons {
    //Font for Radio Buttons
    private final static Font FONT_RADIOBUTTON = new Font(Font.SANS_SERIF, Font.PLAIN, 16);
    //Player Number Radio Buttons
    static JRadioButton[] player;
    //CPU Number Radio Buttons
    static JRadioButton[] cpu;
    static JRadioButton[] yesOrNo;
    //CPU Difficulty Radio Buttons
    static JRadioButton[][] diffCPU;
    static JRadioButton[] diffDuel;

    static void setRadioButtons() {

        //Make 4 Player Number Radio Buttons
        player = new JRadioButton[4];
        for (int i = 0; i < player.length; i++) {
            if (i == 0) player[i] = makeRadioButton("1 Player");
            else player[i] = makeRadioButton((i + 1) + " Players");
        }
        player[0].setSelected(true);

        //Make 4 CPU Number Radio Buttons
        cpu = new JRadioButton[4];
        for (int i = 0; i < cpu.length; i++) {
            if (i == 0) cpu[i] = makeRadioButton("NO CPU");
            else cpu[i] = makeRadioButton(i + " CPU");
        }
        cpu[0].setSelected(true);

        //Make CPU1 Radio Buttons
        diffCPU = new JRadioButton[3][3];
        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][0] = makeRadioButton("Easy");
            diffCPU[i][0].setSelected(true);
        }

        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][1] = makeRadioButton("Normal");
        }

        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][2] = makeRadioButton("Hard");
        }
    }

    static void setRadioButtonsDuel() {
        //Make yes or no Radio Buttons
        yesOrNo = new JRadioButton[2];
        yesOrNo[0] = makeRadioButton("Yes");
        yesOrNo[1] = makeRadioButton("No");
        //Make Difficulty buttons for Duel CPU
        diffDuel = new JRadioButton[3];
        diffDuel[0] = makeRadioButton("Easy");
        diffDuel[1] = makeRadioButton("Normal");
        diffDuel[2] = makeRadioButton("Hard");
    }

    private static JRadioButton makeRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setFocusPainted(false);
        radioButton.setFont(FONT_RADIOBUTTON);
        return radioButton;
    }
}
