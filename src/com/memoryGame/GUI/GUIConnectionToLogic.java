package com.memoryGame.GUI;

import com.memoryGame.Table;

import javax.swing.*;

public class GUIConnectionToLogic {
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static String name1, name2, name3, name4;
    private static int x1, y1;
    private static int[] arrayCoordsX;
    private static int[] arrayCoordsY;
    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean inDelay = false;

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
//            maxCardNo = ;
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

   /* public static int getNumOfCPUs() {
        if (RadioButtons.cpu0.isSelected()) {
            numOfCPUs = 0;
        } else if (RadioButtons.cpu1.isSelected()) {
            numOfCPUs = 1;
        } else if (RadioButtons.cpu2.isSelected()) {
            numOfCPUs = 2;
        } else if (RadioButtons.cpu3.isSelected()) {
            numOfCPUs = 3;
        }
        return numOfCPUs;
    }*/

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

    static void initArrayCoords() {
        arrayCoordsX = new int[maxCardNo];
        arrayCoordsY = new int[maxCardNo];
    }

    static void setCoords(int x, int y, Table table) {
            arrayCoordsX[cardNo] = x;
            arrayCoordsY[cardNo] = y;
            Panels.removeButton(Panels.gamePanel,Buttons.cardButtons,x,y);
            Panels.addButton(Panels.gamePanel,Buttons.openCardButtons,x,y, table);
            System.out.println(cardNo);
        if (cardNo == maxCardNo - 1){
            if (GUIConnectionToLogic.checkCardsMatch()){
                numOfPairedCards++;
                inDelay = true;
                Timer timer = new Timer(2000, actionEvent -> {
                    inDelay = false;
                });
                timer.setRepeats(false);
                timer.start();
            } else {
                inDelay = true;
                Timer timer = new Timer(2000, actionEvent -> {
                    for (int i = 0;i < maxCardNo; i++) {
                        Panels.removeButton(Panels.gamePanel, Buttons.openCardButtons, arrayCoordsX[i], arrayCoordsY[i]);
                        System.out.println("removed " + (arrayCoordsX[i] + 1) + (arrayCoordsY[i] + 1));
                        Panels.addButton(Panels.gamePanel, Buttons.cardButtons, arrayCoordsX[i], arrayCoordsY[i], table);
                        System.out.println("added " + (arrayCoordsX[i] + 1) + (arrayCoordsY[i] + 1));
                        inDelay = false;
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
            cardNo = 0;
        } else cardNo++;
    }

    private static boolean checkCardsMatch(){
        return GUI.getLogic().checkCards(arrayCoordsX, arrayCoordsY);
    }

    static boolean inDelay() {
        return inDelay;
    }
}
