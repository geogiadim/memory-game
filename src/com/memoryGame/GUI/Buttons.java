package com.memoryGame.GUI;

import javax.swing.*;
import java.awt.*;

class Buttons {
    //Width, Height, Font size of Mode Buttons
    private final static int WIDTH_MODE = 250;
    private final static int HEIGHT_MODE = 150;
    private final static int FONT_SIZE_MODE = 30;
    //Width, Height, Font size of Secondary Buttons
    private final static int WIDTH_SECONDARY = 90;
    private final static int HEIGHT_SECONDARY = 45;
    private final static int FONT_SIZE_GAME = 18;
    //Fonts for Mode and Secondary Buttons
    private final static Font FONT_MODE = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_MODE);
    private final static Font FONT_SECONDARY = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_GAME);
    //Mode Buttons
    static JButton basicButton, doubleButton, tripleButton, duelButton;
    //Secondary Buttons
    static JButton nextButton, backButton;

    static void setButtonsName() {
        //Make 4 Mode Buttons and set the second letter of Buttons text as Mnemonics
        basicButton = makeButton("Basic Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        basicButton.setMnemonic(basicButton.getText().charAt(1));
        doubleButton = makeButton("Double Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        doubleButton.setMnemonic(doubleButton.getText().charAt(1));
        tripleButton = makeButton("Triple Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        tripleButton.setMnemonic(tripleButton.getText().charAt(1));
        duelButton = makeButton("Duel Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        duelButton.setMnemonic(duelButton.getText().charAt(1));

        //Make 2 Secondary Buttons and set the first letter of Buttons text as Mnemonics
        nextButton = makeButton("Next", WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY);
        nextButton.setMnemonic(nextButton.getText().charAt(0));
        backButton = makeButton("Back", WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY);
        backButton.setMnemonic(backButton.getText().charAt(0));

        //Add ActionListeners for all Buttons
        ActionListenerButtons.addButtonsActList();
    }

    private static JButton makeButton(String name, int width, int height, Font font) {
        Dimension dimension = new Dimension(width, height);
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setPreferredSize(dimension);
        button.setFont(font);

        return button;
    }
}
