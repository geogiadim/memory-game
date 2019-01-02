package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class TextField {
    //Font for Text Field Labels
    private final static Font FONT_TEXTFIELD_LABEL = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
    //Player Name Text Fields
    static JTextField[] textPlayerNames;
    //Labels for Text Fields
    static JLabel[] labelPlayerNames;

    static void makeTextField(boolean duel){
        if (duel){
            textPlayerNames = new JTextField[2];
            labelPlayerNames = new JLabel[2];
        } else {
            textPlayerNames = new JTextField[4];
            labelPlayerNames = new JLabel[4];
        }

        for (int i = 0; i< textPlayerNames.length; i++){
            labelPlayerNames[i] = new JLabel();
            labelPlayerNames[i].setFont(FONT_TEXTFIELD_LABEL);
            textPlayerNames[i] = new JTextField("Player " + (i+1));
        }

        labelPlayerNames[0].setText("1st Player");
        labelPlayerNames[1].setText("2nd Player");
        if (!duel){
            labelPlayerNames[2].setText("3rd Player");
            labelPlayerNames[3].setText("4th Player");
        }
    }
}
