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
    private Table tableOfCards, tableOfCards2;
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
            tableOfCards = new Table(4, 6);
            basicDoubleGame();
        } else if (mode == 2) {
            tableOfCards = new Table(6, 8);
            basicDoubleGame();
        } else if (mode == 3) {
            tableOfCards = new Table(6, 6);
            tripleGame();
        } else if (mode == 4) {
            tableOfCards = new Table(6, 4);
            tableOfCards2 = new Table(6, 4);
            playerTurn = 1;
            duelGame();
        }
    }

    /**
     * Creates Player Objects either as normal Users or computer controlled Players.
     */
    private void createPlayers() {
        maxPlayers = GUIConnectionToLogic.getNumOfPlayers();
        players = new Player[maxPlayers];
        if (mode == 4) {
            players[0] = new Player(GUIConnectionToLogic.getNameOfPlayer(0));
            if (GUIConnectionToLogic.isCPU(1))
                players[1] = new CPU(GUIConnectionToLogic.getNameOfPlayer(1), GUIConnectionToLogic.getCPUDiff(1));
            else players[1] = new Player(GUIConnectionToLogic.getNameOfPlayer(1));
        }
        for (int i = 0; i < maxPlayers; i++) {
            if (GUIConnectionToLogic.isCPU(i)) {
                players[i] = new CPU(GUIConnectionToLogic.getNameOfPlayer(i), GUIConnectionToLogic.getCPUDiff(i));
            } else players[i] = new Player(GUIConnectionToLogic.getNameOfPlayer(i));
        }
    }

    /**
     * This is the initialisation for the Basic and Double Game Modes Table and the transfer of it to the GUI.
     */
    private void basicDoubleGame() {
        createPlayers();

        initTablePairs(1);
        shuffleTable(tableOfCards);

        GUIConnectionToLogic.beginGamePlay(tableOfCards);
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
        int y1 = coordinatesY[0];

        int x2 = coordinatesX[1];
        int y2 = coordinatesY[1];

        if (mode == 4) {
            if (tableOfCards.getCardValue(coordinatesX[maxPlayers-playerTurn-1], coordinatesY[maxPlayers-playerTurn-1]) == tableOfCards2.getCardValue(coordinatesX[playerTurn], coordinatesY[playerTurn])) {
                tableOfCards.unableCard(coordinatesX[maxPlayers-playerTurn-1], coordinatesY[maxPlayers-playerTurn-1]);
                tableOfCards2.unableCard(coordinatesX[playerTurn], coordinatesY[playerTurn]);
                players[playerTurn].increaseNumOfTries();
                players[playerTurn].increaseNumberOfPairs();
                state = true;
                } else {
                    players[playerTurn].increaseNumOfTries();
                    state = false;
                }
            playerTurn = maxPlayers - playerTurn - 1;
        } else {
            if (tableOfCards.getCardValue(x1, y1) == tableOfCards.getCardValue(x2, y2)) {
                tableOfCards.unableCard(x1, y1);
                tableOfCards.unableCard(x2, y2);
                if (mode == 3) {
                    int x3 = coordinatesX[2];
                    int y3 = coordinatesY[2];
                    if (tableOfCards.getCardValue(x2, y2) == tableOfCards.getCardValue(x3, y3)) {
                        tableOfCards.unableCard(x3, y3);
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
        }
        return state;
    }

    /**
     * This is the initialisation for the Triple Game Mode Table and the transfer of it to the GUI.
     */
    private void tripleGame() {
        createPlayers();

        initTablePairs(3);
        shuffleTable(tableOfCards);

        GUIConnectionToLogic.beginGamePlay(tableOfCards);

        //GUI.array with results and game over*/
    }

    /**
     * This is the initialisation for the Duel Game Mode Tables and the transfer of them to the GUI.
     */
    private void duelGame() {
        createPlayers();

        initDuelTable(tableOfCards);
        shuffleTable(tableOfCards);
        initDuelTable(tableOfCards2);
        shuffleTable(tableOfCards2);

        GUIConnectionToLogic.beginGamePlayDuel(tableOfCards, tableOfCards2);
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
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 1; j < tableOfCards.sizeY(); j += 2) {
                    tableOfCards.setCardValue(i, j - 1, value);
                    tableOfCards.setCardValue(i, j, value++);
                }
            }
        }//Fills the table with different cards, each card three times
        else {
            for (int i = 0; i < tableOfCards.sizeX(); i++) {
                for (int j = 2; j < tableOfCards.sizeY(); j += 3) {
                    tableOfCards.setCardValue(i, j - 2, value);
                    tableOfCards.setCardValue(i, j - 1, value);
                    tableOfCards.setCardValue(i, j, value++);
                }
            }
        }
    }

    /**
     * Fills the Duel Game Mode Table with different Cards values
     *
     * @param tableOfCards The Table of Cards to set Card values.
     */
    private void initDuelTable(Table tableOfCards) {
        int value = 0;
        for (int i = 0; i < tableOfCards.sizeX(); i++) {
            for (int j = 1; j <= tableOfCards.sizeY(); j++) {
                tableOfCards.setCardValue(i, j - 1, value);
                value++;
            }
        }
    }

    /**
     * Shuffles the Table of Cards.
     *
     * @param tableOfCards The Table of Cards to be shuffled.
     */
    private void shuffleTable(Table tableOfCards) {
        Random rnd;
        rnd = new Random();
        //Fisher Yates shuffle algorithm for 2D arrays
        for (int i = tableOfCards.sizeX() - 1; i > 0; i--) {
            for (int j = tableOfCards.sizeY() - 1; j > 0; j--) {
                int m = rnd.nextInt(i + 1);
                int n = rnd.nextInt(j + 1);

                int temp = tableOfCards.getCardValue(i, j);
                tableOfCards.setCardValue(i, j, tableOfCards.getCardValue(m, n));
                tableOfCards.setCardValue(m, n, temp);
            }
        }
    }
}
