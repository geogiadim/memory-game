package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;

class DelaysInGUI {
    private final static int PREVIEW_DELAY = 5;

    static void delayForPreview(Table tableOfCards1, Table tableOfCards2, boolean isDuel, JPanel messagePanel, JPanel gamePanel){
        Labels.setTopMessagePreview();
        if (!isDuel) {
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                GUI.clearFrame(GUI.getGameFrame());
                if (GUIConnectionToLogic.getGameMode()==3){Panels.addMessage(messagePanel,Labels.ruleTriple);}
                else Panels.addMessage(messagePanel, Labels.ruleBasicDouble);
                GUI.clearPanel(gamePanel);
                GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(), tableOfCards1, false);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                GUI.clearFrame(GUI.getGameFrame());
                Panels.removeMessage(messagePanel,Labels.previewMessage);
                Panels.addMessage(messagePanel, Labels.ruleDuel);
                GUI.clearPanel(gamePanel);
                GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), tableOfCards1,tableOfCards2, false);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    static int getCardPreviewDelay() {return PREVIEW_DELAY;}
}
