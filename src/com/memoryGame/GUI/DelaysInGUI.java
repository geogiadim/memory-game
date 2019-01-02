package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;

class DelaysInGUI {
    private final static int PREVIEW_DELAY = 1;

    static void delayForPreview(Table tableOfCards1, Table tableOfCards2, boolean isDuel){
        Labels.setTopMessagePreview();
        if (!isDuel) {
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                Labels.setTopMessageRules();
                Panels.removeAllCardButtons();
                Panels.addAllCardButtons(Buttons.cardButtons,tableOfCards1);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                GUI.clearFrame(GUI.getGameFrame());
                Labels.setTopMessageRules();

                GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), tableOfCards1,tableOfCards2);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    static void delayForPreview(Table tableOfCards){
        delayForPreview(tableOfCards, tableOfCards, false);
    }

    static int getCardPreviewDelay() {return PREVIEW_DELAY;}
}
