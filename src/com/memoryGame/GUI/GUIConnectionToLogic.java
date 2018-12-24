package com.memoryGame.GUI;

public class GUIConnectionToLogic {
    private static int mode=0;
    private static int numOfPlayers=0, numOfCPUs=0;
    private static String name1,name2,name3,name4;

    public static int getGameMode(){
        if (GUI.getButton().basicButton.isSelected()) {mode=1;}
        else if (GUI.getButton().doubleButton.isSelected()) {mode=2;}
        else if (GUI.getButton().tripleButton.isSelected()) {mode =3;}
        else if (GUI.getButton().duelButton.isSelected()) {mode=4;}
        return mode;
    }

    public static int getNumOfPlayers(){
        if (GUI.getRadioButtons().p1.isSelected()) {numOfPlayers=1;}
        else if (GUI.getRadioButtons().p2.isSelected()) {numOfPlayers=2;}
        else if (GUI.getRadioButtons().p3.isSelected()) {numOfPlayers = 3;}
        else if (GUI.getRadioButtons().p4.isSelected()) {numOfPlayers=4;}
        return numOfPlayers;
    }

    public static int getNumOfCPUs(){
        if (GUI.getRadioButtons().cpu0.isSelected()) {numOfCPUs=0;}
        else if (GUI.getRadioButtons().cpu1.isSelected()) {numOfCPUs=1;}
        else if (GUI.getRadioButtons().cpu2.isSelected()) {numOfCPUs = 2;}
        else if (GUI.getRadioButtons().cpu3.isSelected()) {numOfCPUs=3;}
        return numOfCPUs;
    }

    private static void setNameOfPlayer1() {name1=GUI.getTextField().textP1.getText();}
    private static void setNameOfPlayer2() {name2=GUI.getTextField().textP2.getText();}
    private static void setNameOfPlayer3() {name3=GUI.getTextField().textP3.getText();}
    private static void setNameOfPlayer4() {name4=GUI.getTextField().textP4.getText();}

    public static String getNameOfPlayer1(){
        setNameOfPlayer1();
        return name1;
    }
    public static String getNameOfPlayer2(){
        setNameOfPlayer2();
        return name2;
    }
    public static String getNameOfPlayer3(){
        setNameOfPlayer3();
        return name3;
    }
    public static String getNameOfPlayer4(){
        setNameOfPlayer4();
        return name4;
    }


}
