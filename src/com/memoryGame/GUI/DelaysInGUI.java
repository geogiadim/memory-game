package com.memoryGame.GUI;

import com.memoryGame.Table;
import javax.swing.*;

/**
 * Creates a delay to show a preview of the Card/Buttons for all Game Modes using Swing Timers.
 *
 * @author George Giannios
 * @author Giorgos Christidis
 */
class DelaysInGUI {
    private final static int PREVIEW_DELAY = 15;
    private static int timesDelayed = PREVIEW_DELAY;

    /**
     * Delay for normal(not Duel) Game Modes, after which the open Card/Buttons close.
     *
     * @param tableOfCards1 The Table of Card Objects to show.
     */
    static void delayForPreview(Table tableOfCards1) {
        Labels.setTopMessagePreview();
        Labels.setBottomMessageCountdown(PREVIEW_DELAY);

        Timer timer = new Timer(1000, actionEvent -> {
            Labels.setBottomMessageCountdown(--timesDelayed);
            if (timesDelayed == 0) {
                Labels.setTopMessageRules();
                Labels.setBottomMessagePlayerTurn(0);
                Panels.removeAllCardButtons();
                Panels.addAllCardButtons(Buttons.cardButtons, tableOfCards1);
                ((Timer) actionEvent.getSource()).stop();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    /**
     * Delay for Duel Game Mode, after which the open Card/Buttons close.
     *
     * @param tableOfCards1 The first Table of Card Objects to show.
     * @param tableOfCards2 The second Table of Card Objects to show.
     */
    static void delayForPreview(Table tableOfCards1, Table tableOfCards2) {
        Labels.setTopMessagePreview();
        Labels.setBottomMessageCountdown(PREVIEW_DELAY);
        Timer timer = new Timer(1000, actionEvent -> {
            Labels.setBottomMessageCountdown(--timesDelayed);
            if (timesDelayed == 0) {
                Labels.setTopMessageRules();
                Labels.setBottomMessagePlayerTurn(0);
                Panels.removeAllCardButtons(true);
                Panels.removeAllCardButtons(false);
                Panels.addAllCardButtons(Buttons.cardButtonsDuelOne, tableOfCards1, true);
                Panels.addAllCardButtons(Buttons.cardButtonsDuelTwo, tableOfCards2, false);
                ((Timer) actionEvent.getSource()).stop();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    /**
     * Returns the preview delay.
     *
     * @return The preview delay
     */
    static int getPreviewDelay() {return PREVIEW_DELAY;}
}