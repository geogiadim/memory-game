package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;
import java.awt.*;

public class GUIConnectionToLogic {
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static String name1, name2, name3, name4;
    private static int x1, y1;
    private static int[] arrayCoordinatesX;
    private static int[] arrayCoordinatesY;
    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean inDelay = false;
    private static final int MESSAGE_DEALAY=2;

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
        if (RadioButtons.p1.isSelected()) {
            numOfPlayers = 1;
        } else if (RadioButtons.p2.isSelected()) {
            numOfPlayers = 2;
        } else if (RadioButtons.p3.isSelected()) {
            numOfPlayers = 3;
        } else if (RadioButtons.p4.isSelected()) {
            numOfPlayers = 4;
        }
        return numOfPlayers;
    }

    public static String getNameOfPlayer(int i) {
        switch (i) {
            case 0:
                name1 = TextField.textP1.getText();
                return name1;
            case 1:
                name2 = TextField.textP2.getText();
                return name2;
            case 2:
                name3 = TextField.textP3.getText();
                return name3;
            case 3:
                name4 = TextField.textP4.getText();
                return name4;
            default:
                throw new RuntimeException();
        }
    }

    static void initArrayCoordinates() {
        arrayCoordinatesX = new int[maxCardNo];
        arrayCoordinatesY = new int[maxCardNo];
    }

    static void setCoordinates(int x, int y, Table table) {
            arrayCoordinatesX[cardNo] = x;
            arrayCoordinatesY[cardNo] = y;
            Panels.removeButton(Panels.gamePanel,Buttons.cardButtons,x,y);
            Panels.addButton(Panels.gamePanel,Buttons.openCardButtons,x,y, table);
        if (cardNo == maxCardNo - 1){
            if (GUIConnectionToLogic.checkCardsMatch()){
                numOfPairedCards++;
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DEALAY*1000, actionEvent -> {
                    inDelay = false;
                    GUI.clearPanel(Panels.messagePanel);
                    messagePanelRules();
                });
                GUI.clearPanel(Panels.messagePanel);
                Panels.addMessage(Panels.messagePanel,Labels.correct);
                timer.setRepeats(false);
                timer.start();
            } else {
                inDelay = true;
                Timer timer = new Timer(MESSAGE_DEALAY*1000, actionEvent -> {
                    for (int i = 0;i < maxCardNo; i++) {
                        Panels.removeButton(Panels.gamePanel, Buttons.openCardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i]);
                        //System.out.println("removed " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        Panels.addButton(Panels.gamePanel, Buttons.cardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i], table);
                        //System.out.println("added " + (arrayCoordinatesX[i] + 1) + (arrayCoordinatesY[i] + 1));
                        GUI.clearPanel(Panels.messagePanel);
                        messagePanelRules();
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

    private static void messagePanelRules (){
        if (mode==3)
            Panels.addMessage(Panels.messagePanel,Labels.ruleTriple);
        else if (mode==4)
            Panels.addMessage(Panels.messagePanel,Labels.ruleDuel);
        else Panels.addMessage(Panels.messagePanel,Labels.ruleBasicDouble);
    }

    private static boolean checkCardsMatch() {return GUI.getLogic().checkCards(arrayCoordinatesX, arrayCoordinatesY);}

    static boolean inDelay() {return inDelay;}
}
