package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Creates static JRadioButton Objects for use in GUI Frames.
 *
 * @author George Giannios
 */
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


    /**
     * Sets the Locale as the default OS Locale and if the corresponding Resource Bundle exists it is set accordingly
     * else, the Locale is set to en_US and the Resource Bundle to the en_US one.
     */
    static void setLocale() {
        //Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleRadioButtons", locale);
        } catch (java.util.MissingResourceException e) {
            Locale defaultLocale = new Locale("en", "US");
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleRadioButtons", defaultLocale);
        }
    }


    /**
     * Creates Player number, CPU number and CPU difficulty Radio Buttons.
     */
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

    /**
     * Creates yes/no Radio Button for Duel Game Mode CPU selection.
     */
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


    /**
     * Creates a JRadioButton Object with specific properties from given parameters.
     *
     * @param name The RadioButton text
     * @return a JRadioButton object
     */
    private static JRadioButton makeRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setFocusPainted(false);
        radioButton.setFont(FONT_RADIOBUTTON);
        return radioButton;
    }
}
