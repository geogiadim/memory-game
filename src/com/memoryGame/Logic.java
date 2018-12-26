package com.memoryGame;

import com.memoryGame.GUI.GUI;
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
    private Player player1, player2, player3, player4;

    /**
     * Initializes the appropriate table and chooses the correct version to start the game.
     */
    public Logic(int mode) {
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
        switch (GUIConnectionToLogic.getNumOfPlayers()) {
            case 1:
                player1 = new Player(GUIConnectionToLogic.getNameOfPlayer1());
            case 2:
                player1 = new Player(GUIConnectionToLogic.getNameOfPlayer1());
                player2 = new Player(GUIConnectionToLogic.getNameOfPlayer2());
            case 3:
                player1 = new Player(GUIConnectionToLogic.getNameOfPlayer1());
                player2 = new Player(GUIConnectionToLogic.getNameOfPlayer2());
                player3 = new Player(GUIConnectionToLogic.getNameOfPlayer3());
            case 4:
                player1 = new Player(GUIConnectionToLogic.getNameOfPlayer1());
                player2 = new Player(GUIConnectionToLogic.getNameOfPlayer2());
                player3 = new Player(GUIConnectionToLogic.getNameOfPlayer3());
                player4 = new Player(GUIConnectionToLogic.getNameOfPlayer4());
        }
    }

    /**
     * This is the logic for the Basic and Double game.
     */
    private void basicDoubleGame() {
        createPlayers();

        initTablePairs(1);
        shuffleTable();

        GUI.showCards(newTable, true);
        //GUI.showCards(newTable, false);

        /*int numberOfPairedCards = 0;
        do {
            //If Cards are same!

            if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                numberOfPairedCards += 2;
                player1.increaseNumOfTries();
                player1.increaseNumberOfPairs();
            } //else Cards are not same!
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);
                player1.increaseNumOfTries();
            }
        }while (numberOfPairedCards<newTable.sizeOfTable());
        //GUI.array with results and game over*/
    }

    /**
     * This is the logic for the triple game.
     */
    private void tripleGame() {
        createPlayers();

        initTablePairs(3);
        shuffleTable();

        GUI.showCards(newTable, true);
        //GUI.showCards(newTable, false);

        /*int numberOfPairedCards = 0;
        do {
            //If Cards are same!
            if (newTable.getCardValue(x1, y1) == newTable.getCardValue(x2, y2)
                    && newTable.getCardValue(x1, y1) == newTable.getCardValue(x3, y3)) {
                newTable.unableCard(x1, y1);
                newTable.unableCard(x2, y2);
                newTable.unableCard(x3, y3);
                numberOfPairedCards += 3;
                player1.increaseNumOfTries();
                player1.increaseNumberOfPairs();
            } //else Cards are not same!
            else {
                newTable.closeCard(x1, y1);
                newTable.closeCard(x2, y2);
                newTable.closeCard(x3, y3);
                player1.increaseNumOfTries();
            }
        } while (numberOfPairedCards < newTable.sizeOfTable());
        //GUI.array with results and game over*/
    }

    private void duelGame() {
        createPlayers();
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
        }
        //Fills the table with different cards, each card three times
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
     * Shuffles the table with the cards
     */
    private void shuffleTable() {
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
