package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class Buttons {
    //Mode Buttons
    JButton basicButton, doubleButton, tripleButton, duelButton;
    //Secondary Buttons
    JButton nextButton, backButton;
    //Card Buttons
    JButton[] cardButtons;
    private final static int NUM_BUTTONS=24;

    //Width, Height, Font size of Mode Buttons
    private final static int WIDTH_MODE=250;
    private final static int HEIGHT_MODE=150;
    private final static int FONT_SIZE_MODE=30;

    //Width, Height, Font size of Secondary Buttons
    private final static int WIDTH_SECONDARY = 90;
    private final static int HEIGHT_SECONDARY = 45;
    private final static int FONT_SIZE_GAME=18;

    //Width, Height, Font size of Card Buttons
    private final static int WIDTH_CARD = 140;
    private final static int HEIGHT_CARD = 100;
    private final static int FONT_SIZE_CARD=18;

    //Fonts for Mode Secondary and Card Buttons
    private final Font FONT_MODE = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_MODE);
    private final Font FONT_SECONDARY = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_GAME);
    private final Font FONT_GAME= new Font(Font.SANS_SERIF,Font.PLAIN,FONT_SIZE_CARD);

    void setButtonsName() {
        //Make 4 Mode Buttons and set the second letter of Buttons text as Mnemonics
        basicButton = makeButton("Basic Game",WIDTH_MODE,HEIGHT_MODE,FONT_MODE);
        basicButton.setMnemonic(basicButton.getText().charAt(1));
        doubleButton = makeButton("Double Game",WIDTH_MODE,HEIGHT_MODE,FONT_MODE);
        doubleButton.setMnemonic(doubleButton.getText().charAt(1));
        tripleButton = makeButton("Triple Game",WIDTH_MODE,HEIGHT_MODE,FONT_MODE);
        tripleButton.setMnemonic(tripleButton.getText().charAt(1));
        duelButton = makeButton("Duel Game",WIDTH_MODE,HEIGHT_MODE,FONT_MODE);
        duelButton.setMnemonic(duelButton.getText().charAt(1));

        //Make 2 Secondary Buttons and set the first letter of Buttons text as Mnemonics
        nextButton = makeButton("Next",WIDTH_SECONDARY,HEIGHT_SECONDARY,FONT_SECONDARY);
        nextButton.setMnemonic(nextButton.getText().charAt(0));
        backButton = makeButton("Back",WIDTH_SECONDARY,HEIGHT_SECONDARY,FONT_SECONDARY);
        backButton.setMnemonic(backButton.getText().charAt(0));

        //make card buttons
        cardButtons=new JButton[NUM_BUTTONS];
        for (int i=0;i<NUM_BUTTONS;i++){
            cardButtons[i]= makeButton("Card "+(i+1),WIDTH_CARD,HEIGHT_CARD,FONT_GAME);

        }
    }

    private JButton makeButton(String name, int width, int height, Font font) {
        Dimension dimension = new Dimension(width, height);
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setPreferredSize(dimension);
        button.setFont(font);
        return button;
    }
}
