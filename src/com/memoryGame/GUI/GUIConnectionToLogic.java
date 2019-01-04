package com.memoryGame.GUI;

import com.memoryGame.Logic;
import com.memoryGame.Table;

import javax.swing.*;

public class GUIConnectionToLogic {
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static int[] arrayCoordinatesX;
    private static int[] arrayCoordinatesY;
    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean inDelay = false;
    private static final int MESSAGE_DELAY=2;
    private static Logic logic;

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

    public static boolean isCPU(int playerNumber) {
        return RadioButtons.cpu[playerNumber].isSelected();
    }

    public static String getNameOfPlayer(int playerNumber) {
        return TextField.textPlayerNames[playerNumber].getText();
    }

    public static int getCPUDiff(int playerNumber){
        int Diff = 0;
        for (int i = 0; i < RadioButtons.diffCPU[playerNumber].length; i++) {
            if (RadioButtons.diffCPU[playerNumber][i].isSelected()) {
                Diff = i+1;
            }
        }
        return Diff;
    }

    private static void initArrayCoordinates() {
        arrayCoordinatesX = new int[maxCardNo];
        arrayCoordinatesY = new int[maxCardNo];
    }

    static void setCoordinates(int x, int y, Table table) {
        arrayCoordinatesX[cardNo] = x;
        arrayCoordinatesY[cardNo] = y;
        Panels.removeCardButton(Buttons.cardButtons,x,y);
        Panels.addCardButton(Buttons.openCardButtons,x,y, table);

        //If final Card choice
        if (cardNo == maxCardNo - 1){
            //if Cards match
            if (GUIConnectionToLogic.checkCardsMatch()){
                numOfPairedCards++;
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> inDelay = false);
                Labels.setTopMessageCorrect();
                timer.setRepeats(false);
                timer.start();
                //if Cards don't match
            } else {
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    for (int i = 0;i < maxCardNo; i++) {
                        Panels.removeCardButton(Buttons.openCardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i]);
                        //System.out.println("removed " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        Panels.addCardButton(Buttons.cardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i], table);
                        //System.out.println("added " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        inDelay = false;
                    }
                });
                Labels.setTopMessageWrong();
                timer.setRepeats(false);
                timer.start();
            }
            Labels.setTopMessageRules();
            cardNo = 0;
        } else cardNo++;
    }

    private static boolean checkCardsMatch() {return logic.checkCards(arrayCoordinatesX, arrayCoordinatesY);}

    static boolean inDelay() {return inDelay;}

    public static void beginGamePlay(Table newTable) {
        initArrayCoordinates();
        GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(), newTable);
        DelaysInGUI.delayForPreview(newTable);
    }

    public static void beginGamePlayDuel(Table newTable, Table newTable2) {
        initArrayCoordinates();
        GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), newTable, newTable2);
        DelaysInGUI.delayForPreview(newTable, newTable2, true);
    }

    static void begin(){
        logic = new Logic(getGameMode());
    }
}
