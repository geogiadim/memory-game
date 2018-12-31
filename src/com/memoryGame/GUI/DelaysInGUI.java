package com.memoryGame.GUI;
import com.memoryGame.Table;

import javax.swing.*;

class DelaysInGUI {
    private final static int PREVIEW_DELAY = 5;

    static void delayForPreview(Table tableOfCards1, Table tableOfCards2, boolean isDuel){
        Panels.addMessage(Panels.messagePanel, Labels.previwMessage);
        if (!isDuel) {
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                GUI.clearFrame(GUI.getGameFrame());
                Panels.removeMessage(Panels.messagePanel, Labels.previwMessage);
                if (GUIConnectionToLogic.getGameMode()==3){Panels.addMessage(Panels.messagePanel,Labels.ruleTriple);}
                else Panels.addMessage(Panels.messagePanel, Labels.ruleBasicDouble);
                GUI.clearPanel(Panels.gamePanel);
                GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(), tableOfCards1, false);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
        else{
            Timer timer = new Timer(PREVIEW_DELAY * 1000, actionEvent -> {
                GUI.clearFrame(GUI.getGameFrame());
                Panels.removeMessage(Panels.messagePanel,Labels.previwMessage);
                Panels.addMessage(Panels.messagePanel, Labels.ruleDuel);
                GUI.clearPanel(Panels.gamePanel);
                GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), tableOfCards1,tableOfCards2, false);
                GUI.getGameFrame().getContentPane().validate();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    static int getCardPreviewDelay() {return PREVIEW_DELAY;}

}
