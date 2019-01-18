package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Creates static JTextField Objects for use in GUI Frames.
 *
 * @author George Giannios
 */
class TextField {
    //Font for Text Field Labels
    private final static Font FONT_TEXTFIELD_LABEL = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
    //Player Name Text Fields
    static JTextField[] textPlayerNames;
    //Labels for Text Fields
    static JLabel[] labelPlayerNames;

    private static ResourceBundle bundle;

    /**
     * Sets the Locale as the default OS Locale and if the corresponding Resource Bundle exists it is set accordingly
     * else, the Locale is set to en_US and the Resource Bundle to the en_US one.
     */
    static void setLocale() {
        //Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleTextField", locale);
        } catch (java.util.MissingResourceException e) {
            Locale defaultLocale = new Locale("en", "US");
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleTextField", defaultLocale);
        }
    }

    /**
     * Creates the JTextField Objects and appropriate JLabels, according to Game Mode.
     *
     * @param duel True if Duel Game Mode chosen
     */
    static void makeTextField(boolean duel) {
        if (duel) {
            textPlayerNames = new JTextField[2];
            labelPlayerNames = new JLabel[2];
        } else {
            textPlayerNames = new JTextField[4];
            labelPlayerNames = new JLabel[4];
        }

        for (int i = 0; i < textPlayerNames.length; i++) {
            labelPlayerNames[i] = new JLabel();
            labelPlayerNames[i].setFont(FONT_TEXTFIELD_LABEL);
            textPlayerNames[i] = new JTextField(bundle.getString("playerTextField") + (i + 1));
        }

        labelPlayerNames[0].setText(bundle.getString("player1"));
        labelPlayerNames[1].setText(bundle.getString("player2"));
        if (!duel) {
            labelPlayerNames[2].setText(bundle.getString("player3"));
            labelPlayerNames[3].setText(bundle.getString("player4"));
        }
    }

    /**
     * Sets the given parameter TextField Label to Player.
     *
     * @param i The TextField number to change
     */
    static void cpuLabel(int i) {
        textPlayerNames[i].setText("CPU " + (i+1));
        textPlayerNames[i].setEnabled(false);
    }

    /**
     * Sets the given parameter TextField Label to Player.
     *
     * @param i The TextField number to change
     */
    static void playerLabel(int i) {textPlayerNames[i].setText(bundle.getString("playerTextField") + (i + 1));}
}
