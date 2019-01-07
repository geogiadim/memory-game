package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

class TextField {
    //Font for Text Field Labels
    private final static Font FONT_TEXTFIELD_LABEL = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
    //Player Name Text Fields
    static JTextField[] textPlayerNames;
    //Labels for Text Fields
    static JLabel[] labelPlayerNames;

    private static ResourceBundle bundle;

    static void setLocale() {
//        Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleTextField", locale);
        } catch (java.util.MissingResourceException e) {
            Locale defaultLocale = new Locale("en", "US");
            bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleTextField", defaultLocale);
        }
    }

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

    static void cpuLabel(int i) {
        textPlayerNames[i].setText("CPU " + (i + 1));
        textPlayerNames[i].setEnabled(false);
    }

    static void playerLabel(int i) {
        textPlayerNames[i].setText(bundle.getString("playerTextField") + (i + 1));
    }
}
