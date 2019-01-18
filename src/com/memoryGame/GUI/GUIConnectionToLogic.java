package com.memoryGame.GUI;

import com.memoryGame.Logic;
import com.memoryGame.Table;
import com.memoryGame.CPU;

import javax.swing.*;

/**
 * Connect the GUI package to Logic. Handles the coordinates of the Card/Buttons pressed.
 * Has getters for the number of Players, their names, whether they are CPUs and the difficulty of those CPUs.
 * Also handles Logic initialisation.
 *
 * @author George Giannios
 * @author Giorgos Christidis
 */
public class GUIConnectionToLogic {
    private static final int MESSAGE_DELAY = 2;

    private static int mode = 0;

    private static int[] arrayCoordinatesX;
    private static int[] arrayCoordinatesY;

    private static int cardNo = 0;
    private static int maxCardNo;
    private static int numOfPairedCards = 0;
    private static boolean playerCanNotPlay = false;

    private static Logic logic;

    private static int playingNowDuel = 0;
    private static int playingNow = 0;

    private static Table tempTable;

    private static boolean areCPUPlaying;
    private static boolean isCPUPlaying;
    private static boolean randomCPUCard = false;

    /**
     * Loads the game play Frame and starts the Card/Button preview for normal(not Duel) Game Modes.
     *
     * @param newTable The Table of Card Object, ready from Logic Class
     */
    public static void beginGamePlay(Table newTable) {
        initArrayCoordinates();
        GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(), newTable);
        DelaysInGUI.delayForPreview(newTable);
    }

    /**
     * Loads the game play Frame and starts the Card/Button preview for Duel Game Modes.
     *
     * @param newTable  The first Table of Card Object, ready from Logic Class
     * @param newTable2 The second Table of Card Object, ready from Logic Class
     */
    public static void beginGamePlayDuel(Table newTable, Table newTable2) {
        initArrayCoordinates();
        GUI.frame3GamePlayDuel(GUI.getGameFrame().getContentPane(), newTable, newTable2);
        DelaysInGUI.delayForPreview(newTable, newTable2);
    }

    /**
     * Creates a Logic Object.
     */
    static void begin() {
        areCPUPlaying();
        logic = new Logic(getGameMode());
    }

    static void setMode(int i) {
        mode = i;
    }

    /**
     * Returns the chosen Game Mode.
     *
     * @return The Game Mode
     */
    public static int getGameMode() {
        if (mode == 3) maxCardNo = 3;
        else  maxCardNo = 2;
        return mode;
    }

    /**
     * Returns the number of Players.
     *
     * @return The number of Players
     */
    public static int getNumOfPlayers() {
        int numOfPlayers = 0;
        if (mode == 4) {
            numOfPlayers = 2;
        }
        else {
            for (int i = 0; i < RadioButtons.player.length; i++) {
                if (RadioButtons.player[i].isSelected()) numOfPlayers = i + 1;
            }
        }
        return numOfPlayers;
    }

    /**
     * Returns whether given Player number corresponds to a CPU or not.
     *
     * @param playerNumber The Player number to check
     * @return Whether or not the Player is a CPU.
     */
    public static boolean isCPU(int playerNumber) {
        if (mode == 4) return RadioButtons.yesOrNo[0].isSelected();
        else return (getNumOfPlayers() - playerNumber - 1) < ChecksForJComponents.getNumberOfCPU();
    }

    private static void areCPUPlaying(){
        if (mode == 4) areCPUPlaying = true;
        else {
            areCPUPlaying = false;
            for (int i = 0; i <= getNumOfPlayers(); i ++){
                if (isCPU(i)) areCPUPlaying = true;
            }
        }
    }

    /**
     * Returns the name of Player according to given Player number.
     *
     * @param playerNumber The Player number to get the name
     * @return The Player's name
     */
    public static String getNameOfPlayer(int playerNumber) {
        return TextField.textPlayerNames[playerNumber].getText();
    }

    /**
     * Returns the difficulty of the CPU according to given Player number.
     *
     * @param playerNumber The Player number to get the difficulty
     * @return The difficulty of the CPU
     */
    public static int getCPUDiff(int playerNumber) {
        int Diff = 0;
        if (mode == 4) {
            for (int i = 0; i < RadioButtons.diffDuel.length; i++) {
                if (RadioButtons.diffDuel[i].isSelected()) {
                    Diff = i;
                }
            }
        } else {
            for (int i = 0; i < RadioButtons.diffCPU[playerNumber - 1].length; i++) {
                if (RadioButtons.diffCPU[playerNumber - 1][i].isSelected()) {
                    Diff = i;
                }
            }
        }
        return Diff;
    }

    /**
     * Returns the maximum number of Cards per Player turn.
     *
     * @return The max number of cards
     */
    public static int getMaxCardsNum(){
        return maxCardNo;
    }

    /**
     * Initialises two arrays of size equal to the max number of Cards per Player turn to keep Card selection coords.
     */
    private static void initArrayCoordinates() {
        arrayCoordinatesX = new int[maxCardNo];
        arrayCoordinatesY = new int[maxCardNo];
    }


    static void setCoordinates(int x, int y, Table table, JButton[][] cardButtons, JButton[][] openCardButtons) {
        if (mode == 4) {
            if (!isCPUPlaying || randomCPUCard){
                CPU.addCardToArrayListsDuel(x, y, isFirstPlayingNow());
            }
            Panels.removeCardButton(cardButtons, x, y, isFirstPlayingNow());
            Panels.addCardButton(openCardButtons, x, y, table, isFirstPlayingNow());
            checkCoordinates(x, y, table, cardButtons, openCardButtons);
        } else {
            if (!isCPUPlaying || randomCPUCard){
                CPU.addCardToArrayLists(x,y);
            }
            Panels.removeCardButton(cardButtons, x, y);
            Panels.addCardButton(openCardButtons, x, y, table);
            checkCoordinates(x, y, table, cardButtons, openCardButtons);
        }
    }

    /**
     * Turns the Card/Buttons pressed, checks if values of cards are equal and handles game play messages.
     *
     * @param x               The x coordinate of the Card/Button pressed
     * @param y               The y coordinate of the Card/Button pressed
     * @param table           The Table that the Card/Button belongs to
     * @param cardButtons     The 2D JButton array of closed Card/Buttons
     * @param openCardButtons The 2D JButton array of open Card/Buttons
     */
    private static void checkCoordinates(int x, int y, Table table, JButton[][] cardButtons, JButton[][] openCardButtons) {
        arrayCoordinatesX[cardNo] = x;
        arrayCoordinatesY[cardNo] = y;
        playerCanNotPlay = true;

        if (cardNo == maxCardNo - 1) {
            //if Cards match
            if (checkCardsMatch()) {
                if (mode == 4) CPU.removeCardsFromArrayListsDuel(table.getCardValue(x,y));
                else {
                    CPU.removeCardsFromArrayList(table.getCardValue(x,y));
                }
                numOfPairedCards++;
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    playerCanNotPlay = isCPU(playingNowDuel);
                    if (mode != 4){
                        if (isCPUPlaying) CPU.play(playingNow);
                    }
                    Labels.setTopMessageRules();
                });
                Labels.setTopMessageCorrect();
                timer.setRepeats(false);
                timer.start();
                //if Cards don't match
            } else {
                Timer timer = new Timer(MESSAGE_DELAY * 1000, actionEvent -> {
                    if (mode == 4) {
                        //if player 2 playing
                        if (!isFirstPlayingNow()) {
                            Panels.removeCardButton(Buttons.openCardButtonsDuelOne, arrayCoordinatesX[0], arrayCoordinatesY[0], true);
                            Panels.addCardButton(Buttons.cardButtonsDuelOne, arrayCoordinatesX[0], arrayCoordinatesY[0], tempTable, true);

                            Panels.removeCardButton(Buttons.openCardButtonsDuelTwo, arrayCoordinatesX[1], arrayCoordinatesY[1], false);
                            Panels.addCardButton(Buttons.cardButtonsDuelTwo, arrayCoordinatesX[1], arrayCoordinatesY[1], table, false);
                        } else {
                            Panels.removeCardButton(Buttons.openCardButtonsDuelTwo, arrayCoordinatesX[0], arrayCoordinatesY[0], false);
                            Panels.addCardButton(Buttons.cardButtonsDuelTwo, arrayCoordinatesX[0], arrayCoordinatesY[0], tempTable, false);

                            Panels.removeCardButton(Buttons.openCardButtonsDuelOne, arrayCoordinatesX[1], arrayCoordinatesY[1], true);
                            Panels.addCardButton(Buttons.cardButtonsDuelOne, arrayCoordinatesX[1], arrayCoordinatesY[1], table, true);
                        }
                        Labels.setBottomMessagePlayerTurn(playingNowDuel);
                        playerCanNotPlay = isCPU(playingNowDuel);
                    } else {
                        for (int i = 0; i < maxCardNo; i++) {
                            Panels.removeCardButton(openCardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i]);
                            Panels.addCardButton(cardButtons, arrayCoordinatesX[i], arrayCoordinatesY[i], table);
                        }
                        Labels.setBottomMessagePlayerTurn(playingNow);
                        playerCanNotPlay = isCPU(playingNow);
                        if (isCPUPlaying) CPU.play(playingNow);
                    }
                    Labels.setTopMessageRules();
                });
                Labels.setTopMessageWrong();
                if (mode != 4) {
                    if (playingNow < getNumOfPlayers() - 1) playingNow++;
                    else playingNow = 0;
                }
                timer.setRepeats(false);
                timer.start();
            }
            cardNo = 0;
            if (mode == 4) tempTable = table;
        } else {
            cardNo++;
            if (mode == 4) {
                playingNowDuel = getNumOfPlayers() - playingNowDuel - 1;
                Labels.setBottomMessagePlayerTurn(playingNowDuel);
                tempTable = table;
            }
            playerCanNotPlay = false;
        }

        if (mode == 3) {
            if (isCPU(playingNow)){
                playerCanNotPlay = true;
                isCPUPlaying = true;
            } else isCPUPlaying = false;
            if (numOfPairedCards == table.sizeOfTable() / 3) {
                System.out.println("end");
                gameOver();
            }
        } else if (mode == 4) {
            Timer timer = new Timer( 1000, actionEvent -> {
                if (isCPUPlaying) CPU.playDuel();
            });
            timer.setRepeats(false);
            timer.start();
            if (isCPU(playingNowDuel)){
                playerCanNotPlay = true;
                isCPUPlaying = true;
            } else {
                isCPUPlaying = false;
                playerCanNotPlay = false;
            }
            if (numOfPairedCards == table.sizeOfTable()){
                System.out.println("end");
                gameOver();
            }
        } else{
            if (isCPU(playingNow)){
                playerCanNotPlay = true;
                isCPUPlaying = true;
            } else isCPUPlaying = false;
            if (numOfPairedCards == table.sizeOfTable() / 2) {
                System.out.println("end");
                gameOver();
            }
        }
    }

    private static void gameOver(){
        logic.createFile();
        if (mode != 4){
            Timer timer = new Timer(2* 1000, actionEvent -> {
                GUI.getGameFrame().setVisible(false);
                GUI.getGameFrame().dispose();
                GUI.createFrame3(logic.getSteps(), logic.getWinner(), logic.getName());
            });
            timer.setRepeats(false);
            timer.start();
        }

    }

    /**
     * Sends the arrays containing the Card coordinates to Logic
     * and returns whether the corresponding values are equal.
     *
     * @return Whether the values are equal or not
     */
    private static boolean checkCardsMatch() {
        return logic.checkCards(arrayCoordinatesX, arrayCoordinatesY);
    }

    static boolean getPlayerCanNotPlay(){
        return !playerCanNotPlay;
    }

    /**
     * Returns whether the current Player in Duel Game Mode, is the first Player.
     *
     * @return Whether the current Player is the first Player.
     */
    static boolean isFirstPlayingNow() {
        return playingNowDuel == 0;
    }

    public static void openCard(int x, int y, boolean random){
        randomCPUCard = random;
        Timer timer = new Timer(1000, actionEvent -> {
            playerCanNotPlay = false;
            if (mode == 4) Buttons.cardButtonsDuelTwo[x][y].doClick();
            else {
                Buttons.cardButtons[x][y].doClick();
                playerCanNotPlay = true;
            }
        });
        timer.setRepeats(false);
        timer.start();

    }

    public static boolean getAreCPUPlaying() {
        return areCPUPlaying;
    }
}