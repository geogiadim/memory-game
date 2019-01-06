package com.memoryGame;

import com.memoryGame.GUI.GUIConnectionToLogic;

import java.util.Random;

/**
 * This class represents the logic of the game. Creates the table with the cards and separates the game in the three different types.
 * This class is connected to Ui in order to make the game interactive to the player.
 *
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 */
public class Logic {

    private Table newTable, newTable2;
    private Player[] players;
    private int playerTurn = 0;
    private static int maxPlayers;
    private int mode;

    /**
     * Initializes the appropriate table and chooses the correct version to start the game.
     */
    public Logic(int mode) {
        this.mode = mode;
        if (mode == 1) {
            newTable = new Table(4, 6);
            basicDoubleGame();
        } else if (mode == 2) {
            newTable = new Table(6, 8);
            basicDoubleGame();
        } else if (mode == 3) {
            newTable = new Table(6, 6);
            tripleGame();
        } else if (mode == 4) {
            newTable = new Table(6, 4);
            newTable2 = new Table(6, 4);
            duelGame();
        }
    }

    private void createPlayers() {
        maxPlayers = GUIConnectionToLogic.getNumOfPlayers();
        //System.out.println(maxPlayers);
        players = new Player[maxPlayers];
        for (int i = 0; i < maxPlayers; i++) {
            if (GUIConnectionToLogic.isCPU(i)) players[i] = new CPU(GUIConnectionToLogic.getNameOfPlayer(i),GUIConnectionToLogic.getCPUDiff(i));
            else players[i] = new Player(GUIConnectionToLogic.getNameOfPlayer(i));
            //System.out.println(players[i].getName());
        }
    }

    /**
     * This is the logic for the Basic and Double game.
     */
    private void basicDoubleGame() {
        createPlayers();

        initTablePairs(1);
        shuffleTable(newTable);

        GUIConnectionToLogic.beginGamePlay(newTable);
        //GUI.array with results and game over
    }

    /**
     * This is the logic for the triple game.
     */
    private void tripleGame() {
        createPlayers();

        initTablePairs(3);
        shuffleTable(newTable);

        GUIConnectionToLogic.beginGamePlay(newTable);
        //GUI.array with results and game over*/
    }

    private void duelGame() {
        createPlayers();

        initDuelTable(newTable);
        shuffleTable(newTable);
        initDuelTable(newTable2);
        shuffleTable(newTable2);

        GUIConnectionToLogic.beginGamePlayDuel(newTable, newTable2);
    }

    public boolean checkCards(int[] coordinatesX, int[] coordinatesY) {
        boolean state;

        int x1 = coordinatesX[0];
        int x2 = coordinatesX[1];
        int y1 = coordinatesY[0];
        int y2 = coordinatesY[1];

        if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)){
            newTable.unableCard(x1, y1);
            newTable.unableCard(x2, y2);
            //check for mode 3
            if (mode == 3){
                int x3 = coordinatesX[2];
                int y3 = coordinatesY[2];
                if (newTable.getCardValue(x2, y2) == newTable.getCardValue(x3, y3)){
                    newTable.unableCard(x3, y3);
                    players[playerTurn].increaseNumOfTries();
                    players[playerTurn].increaseNumberOfPairs();
                    state = true;
                } else {
                    players[playerTurn].increaseNumOfTries();
                    state = false;
                }
            } else {
                players[playerTurn].increaseNumOfTries();
                players[playerTurn].increaseNumberOfPairs();
                state = true;
            }
        } else {
            players[playerTurn].increaseNumOfTries();
            state = false;
        }

        if (playerTurn < maxPlayers - 1) playerTurn++;
        else playerTurn = 0;
        return state;
    }

    /**
     * Fills the table with different cards
     */
    private void initTablePairs(int mode) {
        int value = 0;

        if (mode == 1 || mode == 2) {
            //Fills the table with different cards, each card two times
            for (int i = 0; i < newTable.sizeX(); i++) {
                for (int j = 1; j < newTable.sizeY(); j += 2) {
                    newTable.setCardValue(i, j - 1, value);
                    newTable.setCardValue(i, j, value++);
                }
            }
        }//Fills the table with different cards, each card three times
        else {
            for (int i = 0; i < newTable.sizeX(); i++) {
                for (int j = 2; j < newTable.sizeY(); j += 3) {
                    newTable.setCardValue(i, j - 2, value);
                    newTable.setCardValue(i, j - 1, value);
                    newTable.setCardValue(i, j, value++);
                }
            }
        }
    }

    private void initDuelTable(Table newTable) {
        int value = 0;
        for (int i = 0; i < newTable.sizeX(); i++) {
            for (int j = 1; j <= newTable.sizeY(); j++) {
                newTable.setCardValue(i, j - 1, value);
                value++;
            }
        }
    }

    /**
     * Shuffles the table with the cards
     */
    private void shuffleTable(Table newTable) {
        Random rnd;
        rnd = new Random();
        //Fisher Yates shuffle algorithm for 2D arrays
        for (int i = newTable.sizeX() - 1; i > 0; i--) {
            for (int j = newTable.sizeY() - 1; j > 0; j--) {
                int m = rnd.nextInt(i + 1);
                int n = rnd.nextInt(j + 1);

                int temp = newTable.getCardValue(i, j);
                newTable.setCardValue(i, j, newTable.getCardValue(m, n));
                newTable.setCardValue(m, n, temp);
            }
        }
    }
}
