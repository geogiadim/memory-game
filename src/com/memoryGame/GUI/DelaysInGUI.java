package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;

class DelaysInGUI {
    private final static int PREVIEW_DELAY = 5;
    private static int timesDelayed = PREVIEW_DELAY;

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

    static int getPreviewDelay() {
        return PREVIEW_DELAY;
    }

}
