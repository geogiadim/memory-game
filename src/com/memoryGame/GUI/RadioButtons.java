package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

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

    private static ResourceBundle bundle;

    static void setLocale() {
//        Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleRadioButtons", locale);
        } catch (java.util.MissingResourceException e) {
            Locale defaultLocale = new Locale("en", "US");
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleRadioButtons", defaultLocale);
        }
    }

    static void setRadioButtons() {
        //Make 4 Player Number Radio Buttons
        player = new JRadioButton[4];
        for (int i = 0; i < player.length; i++) {
            if (i == 0) player[i] = makeRadioButton(bundle.getString("player1"));
            else player[i] = makeRadioButton((i + 1) + bundle.getString("players"));
        }
        player[0].setSelected(true);

        //Make 4 CPU Number Radio Buttons
        cpu = new JRadioButton[4];
        for (int i = 0; i < cpu.length; i++) {
            if (i == 0) cpu[i] = makeRadioButton(bundle.getString("noCPU"));
            else cpu[i] = makeRadioButton(i + bundle.getString("cpuRadioButton"));
        }
        cpu[0].setSelected(true);

        //Make CPU1 Radio Buttons
        diffCPU = new JRadioButton[3][3];
        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][0] = makeRadioButton(bundle.getString("easyRadioButton"));
            diffCPU[i][0].setSelected(true);
        }
        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][1] = makeRadioButton(bundle.getString("normalRadioButton"));
        }
        for (int i = 0; i < diffCPU.length; i++) {
            diffCPU[i][2] = makeRadioButton(bundle.getString("hardRadioButton"));
        }
    }

    static void setRadioButtonsDuel() {
        //Make yes or no Radio Buttons
        yesOrNo = new JRadioButton[2];
        yesOrNo[0] = makeRadioButton(bundle.getString("yesRadioButton"));
        yesOrNo[1] = makeRadioButton(bundle.getString("noRadioButton"));
        //Make Difficulty buttons for Duel CPU
        diffDuel = new JRadioButton[3];
        diffDuel[0] = makeRadioButton(bundle.getString("easyRadioButton"));
        diffDuel[1] = makeRadioButton(bundle.getString("normalRadioButton"));
        diffDuel[2] = makeRadioButton(bundle.getString("hardRadioButton"));
    }

    private static JRadioButton makeRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setFocusPainted(false);
        radioButton.setFont(FONT_RADIOBUTTON);
        return radioButton;
    }
}
