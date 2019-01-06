package com.memoryGame.GUI;

import com.memoryGame.Logic;
import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;

public class GUIConnectionToLogic {
    private static final int MESSAGE_DELAY = 2;
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static int[] arrayCoordinatesX;
    private static int[] arrayCoordinatesY;
    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean inDelay = false;
    private static Logic logic;
    private static int playingNow = 0;
    private static Table tempTable;

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
            maxCardNo = 2;
            mode = 4;
        }
        return mode;
    }

    public static int getNumOfPlayers() {
        if (mode == 4) return 2;
        else {
            for (int i = 0; i < RadioButtons.player.length; i++){
                if (RadioButtons.player[i].isSelected()) numOfPlayers = i+1;
            }
            return numOfPlayers;
        }
    }

    public static boolean isCPU(int playerNumber) {
        if (mode == 4) return RadioButtons.yesOrNo[0].isSelected();
        else return RadioButtons.cpu[playerNumber].isSelected();
    }

    public static String getNameOfPlayer(int playerNumber) {
        return TextField.textPlayerNames[playerNumber].getText();
    }

    public static int getCPUDiff(int playerNumber) {
        int Diff = 0;
        if (mode == 4) {
            for (int i = 0; i < RadioButtons.diffDuel.length; i++) {
                if (RadioButtons.diffDuel[i].isSelected()) {
                    Diff+=1;
                }
            }
        } else {
            for (int i = 0; i < RadioButtons.diffCPU[playerNumber].length; i++) {
                if (RadioButtons.diffCPU[playerNumber][i].isSelected()) {
                    Diff+=1;
                }
            }
        }
        return Diff;
    }

    private static void initArrayCoordinates() {
        arrayCoordinatesX = new int[maxCardNo];
        arrayCoordinatesY = new int[maxCardNo];
    }

    static void setCoordinates(int x, int y, Table table, JButton[][] cardButtons, JButton[][] openCardButtons) {
        arrayCoordinatesX[cardNo] = x;
        arrayCoordinatesY[cardNo] = y;
        if (mode == 4){
            Panels.removeCardButton(cardButtons, x, y, isFirstPlayingNow());
            Panels.addCardButton(openCardButtons, x, y, table, isFirstPlayingNow());
        } else {
            Panels.removeCardButton(cardButtons, x, y);
            Panels.addCardButton(openCardButtons, x, y, table);
        }


        //If final Card choice
        if (cardNo == maxCardNo - 1) {
            //if Cards match
            if (checkCardsMatch()) {
                numOfPairedCards++;
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    inDelay = false;
                    Labels.setTopMessageRules();
                });
                Labels.setTopMessageCorrect();
                timer.setRepeats(false);
                timer.start();
                //if Cards don't match
            } else {
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    if (mode == 4){
                        if (!isFirstPlayingNow()){
                            Panels.removeCardButton(Buttons.openCardButtonsDuelOne, arrayCoordinatesX[0],arrayCoordinatesY[0], true);
                            Panels.addCardButton(Buttons.cardButtonsDuelOne, arrayCoordinatesX[0], arrayCoordinatesY[0], tempTable, true);

                            Panels.removeCardButton(Buttons.openCardButtonsDuelTwo, arrayCoordinatesX[1],arrayCoordinatesY[1], false);
                            Panels.addCardButton(Buttons.cardButtonsDuelTwo, arrayCoordinatesX[1], arrayCoordinatesY[1], table, false);
                        }
                        else {
                            Panels.removeCardButton(Buttons.openCardButtonsDuelTwo, arrayCoordinatesX[0],arrayCoordinatesY[0], false);
                            Panels.addCardButton(Buttons.cardButtonsDuelTwo, arrayCoordinatesX[0], arrayCoordinatesY[0], tempTable, false);

                            Panels.removeCardButton(Buttons.openCardButtonsDuelOne, arrayCoordinatesX[1],arrayCoordinatesY[1], true);
                            Panels.addCardButton(Buttons.cardButtonsDuelOne, arrayCoordinatesX[1], arrayCoordinatesY[1], table, true);
                        }
                    } else {
                        for (int i = 0; i < maxCardNo; i++) {
                            Panels.removeCardButton(openCardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i]);
                            Panels.addCardButton(cardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i], table);
                        }
                    }
                    inDelay = false;
                    Labels.setTopMessageRules();
                });
                Labels.setTopMessageWrong();
                timer.setRepeats(false);
                timer.start();
            }
            cardNo = 0;
        } else {
            cardNo++;
            if (playingNow < getNumOfPlayers() - 1) playingNow++;
            else playingNow = 0;
            if (mode == 4) {
                tempTable = table;
            }
        }
        Labels.setBottomMessagePlayerTurn(playingNow);
    }

    private static boolean checkCardsMatch() {
        return logic.checkCards(arrayCoordinatesX, arrayCoordinatesY);
    }

    static boolean notInDelay() {
        return !inDelay;
    }

    public static void beginGamePlay(Table newTable) {
        initArrayCoordinates();
        GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(), newTable);
        DelaysInGUI.delayForPreview(newTable);
    }

    public static void beginGamePlayDuel(Table newTable, Table newTable2) {
        initArrayCoordinates();
        GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), newTable, newTable2);
        DelaysInGUI.delayForPreview(newTable, newTable2);
    }

    static void begin() {
        logic = new Logic(getGameMode());
    }

    static boolean isFirstPlayingNow() {
        return playingNow == 0;
    }
}
