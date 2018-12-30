package com.memoryGame.GUI;

public class GUIConnectionToLogic {
    private static int mode = 0;
    private static int numOfPlayers = 0; //numOfCPUs = 0;
    private static String name1, name2, name3, name4;
    //private static int x1,y1;

    static int getGameMode() {
        if (Buttons.basicButton.isSelected()) {
            mode = 1;
        } else if (Buttons.doubleButton.isSelected()) {
            mode = 2;
        } else if (Buttons.tripleButton.isSelected()) {
            mode = 3;
        } else if (Buttons.duelButton.isSelected()) {
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

    public static String getNameOfPlayer1() {
        name1 = GUI.getTextField().textP1.getText();
        return name1;
    }

    public static String getNameOfPlayer2() {
        name2 = GUI.getTextField().textP2.getText();
        return name2;
    }

    public static String getNameOfPlayer3() {
        name3 = GUI.getTextField().textP3.getText();
        return name3;
    }

    public static String getNameOfPlayer4() {
        name4 = GUI.getTextField().textP4.getText();
        return name4;
    }

    //static void setX(int x){x1=x;}
    //static void setY(int y) {y1=y;}
    //public static int getX(){return x1;}
    //public static int getY(){return y1;}

}
