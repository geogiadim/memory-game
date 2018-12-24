package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class RadioButtons {
    //com.memoryGame.Player Number Radio Buttons
    JRadioButton p1, p2, p3, p4;

    //com.memoryGame.CPU Number Radio Buttons
    JRadioButton cpu0, cpu1, cpu2, cpu3;

    //com.memoryGame.CPU Difficulty Radio Buttons
    JRadioButton easyCPU, normalCPU, difficultCPU;
    JRadioButton easyCPU2, normalCPU2, difficultCPU2;
    JRadioButton easyCPU3, normalCPU3, difficultCPU3;

    //Font for Radio Buttons
    private final static Font FONT_RADIOBUTTON = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

    void setRadioButtonName() {
        //Make 4 com.memoryGame.Player Number Radio Buttons
        p1 = makeRadioButton("1 Player");
        p2 = makeRadioButton("2 Players");
        p3 = makeRadioButton("3 Players");
        p4 = makeRadioButton("4 Players");

        //Make 4 com.memoryGame.CPU Number Radio Buttons
        cpu0 = makeRadioButton("NO CPU");
        cpu1 = makeRadioButton("1 CPU");
        cpu2 = makeRadioButton("2 CPUs");
        cpu3 = makeRadioButton("3 CPUs");

        //Make CPU1 Radio Buttons
        easyCPU  = makeRadioButton("Easy");
        normalCPU = makeRadioButton("Normal");
        difficultCPU = makeRadioButton("Difficult");

        //Make CPU2 Radio Buttons
        easyCPU2 = makeRadioButton("Easy");
        normalCPU2 = makeRadioButton("Normal");
        difficultCPU2 = makeRadioButton("Difficult");

        //Make CPU3 Radio Buttons
        easyCPU3 = makeRadioButton("Easy");
        normalCPU3 = makeRadioButton("Normal");
        difficultCPU3 = makeRadioButton("Difficult");
    }

    private JRadioButton makeRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setFocusPainted(false);
        radioButton.setFont(FONT_RADIOBUTTON);
        return radioButton;
    }
}
