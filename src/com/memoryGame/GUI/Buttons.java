package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;

class Buttons {
    //Letters for Card Values (TEMP)
    private final static char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
    //Width, Height, Font size of Mode Buttons
    private final static int WIDTH_MODE = 250;
    private final static int HEIGHT_MODE = 150;
    private final static int FONT_SIZE_MODE = 30;
    //Width, Height, Font size of Secondary Buttons
    private final static int WIDTH_SECONDARY = 90;
    private final static int HEIGHT_SECONDARY = 45;
    private final static int FONT_SIZE_GAME = 18;
    //Width, Height, Font size of Card Buttons
    private final static int WIDTH_CARD = 100;
    private final static int HEIGHT_CARD = 140;
    private final static int FONT_SIZE_CARD = 18;
    //Fonts for Mode Secondary and Card Buttons
    private final static Font FONT_MODE = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_MODE);
    private final static Font FONT_SECONDARY = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_GAME);
    private final static Font FONT_GAME = new Font(Font.SANS_SERIF, Font.PLAIN, FONT_SIZE_CARD);
    //Mode Buttons
    static JButton basicButton, doubleButton, tripleButton, duelButton;
    //Secondary Buttons
    static JButton nextButton, backButton;
    //Card Buttons
    static JButton[][] cardButtons, openCardButtons;

    private final static ImageIcon ICON_BLUE = new ImageIcon("images/closed-card-blue.png");
    private final static ImageIcon ICON_RED =  new ImageIcon("images/closed-card-red.png");
    private final static ImageIcon ICON_GREEN = new ImageIcon("images/closed-card-green.png");
    private final static ImageIcon ICON_BLACK = new ImageIcon("images/closed-card-black.png");

    static void setButtonsName() {
        //Make 4 Mode Buttons and set the second letter of Buttons text as Mnemonics
        basicButton = makeButton("Basic Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE,false);
        basicButton.setMnemonic(basicButton.getText().charAt(1));
        doubleButton = makeButton("Double Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE,false);
        doubleButton.setMnemonic(doubleButton.getText().charAt(1));
        tripleButton = makeButton("Triple Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE,false);
        tripleButton.setMnemonic(tripleButton.getText().charAt(1));
        duelButton = makeButton("Duel Game", WIDTH_MODE, HEIGHT_MODE, FONT_MODE,false);
        duelButton.setMnemonic(duelButton.getText().charAt(1));

        //Make 2 Secondary Buttons and set the first letter of Buttons text as Mnemonics
        nextButton = makeButton("Next", WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY,false);
        nextButton.setMnemonic(nextButton.getText().charAt(0));
        backButton = makeButton("Back", WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY,false);
        backButton.setMnemonic(backButton.getText().charAt(0));
    }

    static void setCardButtons(Table tableOfCards) {
        int sizeX = tableOfCards.sizeX();
        int sizeY = tableOfCards.sizeY();

        //make closed card buttons
        cardButtons = new JButton[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                cardButtons[i][j] = makeButton("", WIDTH_CARD, HEIGHT_CARD, FONT_GAME,true);
            }
        }
        //make opened card buttons
        openCardButtons = new JButton[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                openCardButtons[i][j] = makeButton(String.valueOf(LETTERS[tableOfCards.getCardValue(i, j)]), WIDTH_CARD, HEIGHT_CARD, FONT_GAME,false);
                openCardButtons[i][j].setEnabled(false);
            }
        }
    }

    private static JButton makeButton(String name, int width, int height, Font font,boolean isClosed) {
        Dimension dimension = new Dimension(width, height);
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setFocusable(false);
        if (isClosed) setCardIcon(button);
        button.setPreferredSize(dimension);
        button.setFont(font);
        return button;
    }

    private static void setCardIcon(JButton button){
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        switch (GUIConnectionToLogic.getGameMode()){
            case 1:
                button.setIcon(ICON_BLUE);
                break;
            case 2:
                button.setIcon(ICON_RED);
                break;
            case 3:
                button.setIcon(ICON_GREEN);
                break;
            case 4:
                button.setIcon(ICON_BLACK);
                break;
            default:
                break;
        }
    }
}
