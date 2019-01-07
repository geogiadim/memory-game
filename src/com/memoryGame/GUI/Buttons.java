package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

class Buttons {
    //Letters for Card Values (TEMP)
    private final static char[] LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
    //Width, Height, Font size of Mode Buttons
    private final static int WIDTH_MODE = 300;
    private final static int HEIGHT_MODE = 180;
    private final static int FONT_SIZE_MODE = 30;
    //Width, Height, Font size of Secondary Buttons
    private final static int WIDTH_SECONDARY = 120;
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
//    private final static int HEIGHT_LANG = 60;
    private final static String ICON_BLUE = "images/closed-card-blue.png";
    private final static String ICON_RED = "images/closed-card-red.png";
    private final static String ICON_GREEN = "images/closed-card-green.png";

    private static ResourceBundle bundle;

//    private final static String ICON_EN_LANG = "images/en-lang.png";
//    private final static String ICON_EL_LANG = "images/el-lang.png";
    //Mode Buttons
    static JButton basicButton, doubleButton, tripleButton, duelButton;
//    //Language Buttons
//    static JButton enButton, elButton;
    //Secondary Buttons
    static JButton nextButton, backButton;
    //Card Buttons
    static JButton[][] cardButtons, openCardButtons;
    static JButton[][] cardButtonsDuelOne, cardButtonsDuelTwo, openCardButtonsDuelOne, openCardButtonsDuelTwo;

    private static boolean isFirstCards = true;

    static void setLocale(){
//        Locale locale = new Locale("el", "GR");
        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("com.memoryGame.GUI.i18n.MessageListBundleButtons", locale);
    }

    static void setModeButtons() {
        //Make 4 Mode Buttons and set the second letter of Buttons text as Mnemonics
        basicButton = makeButton(bundle.getString("basicButton"), WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        basicButton.setMnemonic(basicButton.getText().charAt(1));
        doubleButton = makeButton(bundle.getString("doubleButton"), WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        doubleButton.setMnemonic(doubleButton.getText().charAt(1));
        tripleButton = makeButton(bundle.getString("tripleButton"), WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        tripleButton.setMnemonic(tripleButton.getText().charAt(1));
        duelButton = makeButton(bundle.getString("duelButton"), WIDTH_MODE, HEIGHT_MODE, FONT_MODE);
        duelButton.setMnemonic(duelButton.getText().charAt(1));

//        enButton = makeButton("", WIDTH_SECONDARY, HEIGHT_LANG, FONT_SECONDARY);
//        enButton.setIcon(new ImageIcon(ICON_EN_LANG));
//        elButton = makeButton("", WIDTH_SECONDARY, HEIGHT_LANG, FONT_SECONDARY);
//        elButton.setIcon(new ImageIcon(ICON_EL_LANG));
    }

    static void setNextBackButtons() {
        //Make 2 Secondary Buttons and set the first letter of Buttons text as Mnemonics
        nextButton = makeButton(bundle.getString("nextButton"), WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY);
        nextButton.setMnemonic(nextButton.getText().charAt(0));
        backButton = makeButton(bundle.getString("backButton"), WIDTH_SECONDARY, HEIGHT_SECONDARY, FONT_SECONDARY);
        backButton.setMnemonic(backButton.getText().charAt(0));
    }

    private static JButton[][] setCards(Table tableOfCards, boolean isClosed) {
        int sizeX = tableOfCards.sizeX();
        int sizeY = tableOfCards.sizeY();
        JButton[][] cards;

        if (isClosed) {
            //make closed card buttons
            cards = new JButton[sizeX][sizeY];
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    cards[i][j] = makeButton("", WIDTH_CARD, HEIGHT_CARD, FONT_GAME);
                    setCardIcon(cards[i][j], isFirstCards);
                }
            }
            isFirstCards = false;
        } else {
            //make open card buttons
            cards = new JButton[sizeX][sizeY];
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    cards[i][j] = makeButton(String.valueOf(LETTERS[tableOfCards.getCardValue(i, j)]), WIDTH_CARD, HEIGHT_CARD, FONT_GAME);
                    cards[i][j].setEnabled(false);
                }
            }
        }
        return cards;
    }

    private static JButton makeButton(String name, int width, int height, Font font) {
        Dimension dimension = new Dimension(width, height);
        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setPreferredSize(dimension);
        button.setFont(font);
        return button;
    }

    private static void setCardIcon(JButton button, boolean isFirst) {
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        switch (GUIConnectionToLogic.getGameMode()) {
            case 1:
                button.setIcon(new ImageIcon(ICON_BLUE));
                break;
            case 2:
                button.setIcon(new ImageIcon(ICON_RED));
                break;
            case 3:
                button.setIcon(new ImageIcon(ICON_GREEN));
                break;
            case 4:
                if (isFirst) button.setIcon(new ImageIcon(ICON_BLUE));
                else button.setIcon(new ImageIcon(ICON_RED));
                break;
            default:
                break;
        }
    }

    static void setCardButtons(Table tableOfCards) {
        cardButtons = setCards(tableOfCards, true);
        openCardButtons = setCards(tableOfCards, false);
    }

    static void setCardButtonsDuel(Table tableOfCards1, Table tableOfCards2) {
        cardButtonsDuelOne = setCards(tableOfCards1, true);
        cardButtonsDuelTwo = setCards(tableOfCards2, true);
        openCardButtonsDuelOne = setCards(tableOfCards1, false);
        openCardButtonsDuelTwo = setCards(tableOfCards2, false);
    }
}
