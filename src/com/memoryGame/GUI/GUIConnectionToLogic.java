package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;

public class GUIConnectionToLogic {
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static int x1, y1;
    private static int[] arrayCoordinatesX;
    private static int[] arrayCoordinatesY;
    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean inDelay = false;
    private static final int MESSAGE_DELAY=2;

    static int getGameMode() {
        if (Buttons.basicButton.isSelected()) {
            maxCardNo = 2;
            mode = 1;
        } else if (Buttons.doubleButton.isSelected()) {
            maxCardNo = 2;
            mode = 2;
        } else if (Buttons.tripleButton.isSelected()) {
            maxCardNo = 3;
            mode = 3;
        } else if (Buttons.duelButton.isSelected()) {
            //maxCardNo = ;
            mode = 4;
        }
        return mode;
    }

    public static int getNumOfPlayers() {
        if (RadioButtons.player[0].isSelected()) {
            numOfPlayers = 1;
        } else if (RadioButtons.player[1].isSelected()) {
            numOfPlayers = 2;
        } else if (RadioButtons.player[2].isSelected()) {
            numOfPlayers = 3;
        } else if (RadioButtons.player[3].isSelected()) {
            numOfPlayers = 4;
        }
        return numOfPlayers;
    }

    public static String getNameOfPlayer(int i) {
        return TextField.textPlayerNames[i].getText();
    }

    static void initArrayCoordinates() {
        arrayCoordinatesX = new int[maxCardNo];
        arrayCoordinatesY = new int[maxCardNo];
    }

    static void setCoordinates(int x, int y, Table table) {
        arrayCoordinatesX[cardNo] = x;
        arrayCoordinatesY[cardNo] = y;
        Panels.removeCardButton(Buttons.cardButtons,x,y);
        Panels.addCardButton(Buttons.openCardButtons,x,y, table);

        if (cardNo == maxCardNo - 1){
            if (GUIConnectionToLogic.checkCardsMatch()){
                numOfPairedCards++;
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    GUI.clearPanel(Panels.messagePanel);
                    Labels.setTopMessageRules();
                    inDelay = false;
                });
                Panels.addMessage(Panels.messagePanel,Labels.correct);
                Labels.
                timer.setRepeats(false);
                timer.start();
            } else {
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    for (int i = 0;i < maxCardNo; i++) {
                        Panels.removeCardButton(Panels.gamePanel, Buttons.openCardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i]);
                        //System.out.println("removed " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        Panels.addCardButton(Panels.gamePanel, Buttons.cardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i], table);
                        //System.out.println("added " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        Labels.setTopMessageRules();
                        inDelay = false;
                    }
                });
                GUI.clearPanel(Panels.messagePanel);
                Panels.addMessage(Panels.messagePanel,Labels.wrong);
                timer.setRepeats(false);
                timer.start();
            }
            cardNo = 0;
        } else cardNo++;
    }

    private static boolean checkCardsMatch() {return GUI.getLogic().checkCards(arrayCoordinatesX, arrayCoordinatesY);}

    static boolean inDelay() {return inDelay;}
}
