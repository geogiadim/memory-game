package com.memoryGame;

import com.memoryGame.GUI.GUIConnectionToLogic;

import java.util.Random;

/**
 * This class represents the logic of the game. Creates the table with the cards and separates the game in the four different types.
 * This class is connected to the GUI package via the GUIConnectionToLogic Class.
 *
 * @author Giorgos Giannios
 * @author Giorgos Christidis
 */
public class Logic {

    private static int maxPlayers;
    private Table newTable, newTable2;
    private Player[] players;
    private int playerTurn = 0;
    private int mode;

    /**
     * Initializes the appropriate table and chooses the correct version to start the game.
     *
     * @param mode The gameMode chosen by the player.
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

    /**
     * Creates Player Objects either as normal Users or computer controlled Players.
     */
    private void createPlayers() {
        maxPlayers = GUIConnectionToLogic.getNumOfPlayers();
        System.out.println(maxPlayers);
        players = new Player[maxPlayers];
        for (int i = 0; i < maxPlayers; i++) {
            if (GUIConnectionToLogic.isCPU(i))
                players[i] = new CPU(GUIConnectionToLogic.getNameOfPlayer(i), GUIConnectionToLogic.getCPUDiff(i));
            else players[i] = new Player(GUIConnectionToLogic.getNameOfPlayer(i));
            System.out.println(players[i].getName());
        }
    }

    /**
     * This is the initialisation for the Basic and Double Game Modes Table and the transfer of it to the GUI.
     */
    private void basicDoubleGame() {
        createPlayers();

        initTablePairs(1);
        shuffleTable(newTable);

        GUIConnectionToLogic.beginGamePlay(newTable);
        //GUI.array with results and game over
    }

    /**
     * Checks if Cards given by the parameters as coordinates, have the same value.
     *
     * @param coordinatesX Array of X coordinates of Cards.
     * @param coordinatesY Array of Y coordinates of Cards.
     * @return True if Cards have the same value. False if the don't.
     */
    public boolean checkCards(int[] coordinatesX, int[] coordinatesY) {
        boolean state;

        int x1 = coordinatesX[0];
        int x2 = coordinatesX[1];
        int y1 = coordinatesY[0];
        int y2 = coordinatesY[1];

        if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)) {
            newTable.unableCard(x1, y1);
            newTable.unableCard(x2, y2);
            if (mode == 3) {
                int x3 = coordinatesX[2];
                int y3 = coordinatesY[2];
                if (newTable.getCardValue(x2, y2) == newTable.getCardValue(x3, y3)) {
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
     * This is the initialisation for the Triple Game Mode Table and the transfer of it to the GUI.
     */
    private void tripleGame() {
        createPlayers();

        initTablePairs(3);
        shuffleTable(newTable);

        GUIConnectionToLogic.beginGamePlay(newTable);

        //GUI.array with results and game over*/
    }

    /**
     * This is the initialisation for the Duel Game Mode Tables and the transfer of them to the GUI.
     */
    private void duelGame() {
        createPlayers();

        initDuelTable(newTable);
        shuffleTable(newTable);
        initDuelTable(newTable2);
        shuffleTable(newTable2);

        GUIConnectionToLogic.beginGamePlayDuel(newTable, newTable2);
    }

    /**
     * Fills the normal Game Mode Tables with different Card values according to the Game Mode.
     *
     * @param mode The The gameMode chosen by the player.
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

    /**
     * Fills the Duel Game Mode Table with different Cards values
     *
     * @param newTable The Table of Cards to set Card values.
     */
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
     * Shuffles the Table of Cards.
     *
     * @param newTable The Table of Cards to be shuffled.
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
