package com.memoryGame;

import com.memoryGame.GUI.GUIConnectionToLogic;

import java.util.ArrayList;import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that handles all computer generated moves. According to the difficulty of the CPU,
 * cards are calculated or chosen by random.
 *
 * @author George Christidis
 */
public class CPU {
    private static ArrayList<int[]> arrayListAll; //ArrayList of NOT paired opened Cards for diff 3.
    private static ArrayList<int[]> arrayListSome;
    private static Table table; //Table of all cards.

    private static ArrayList<int[]> arrayListAllDuel1;
    private static ArrayList<int[]> arrayListAllDuel2;
    private static ArrayList<int[]> arrayListSomeDuel1;
    private static ArrayList<int[]> arrayListSomeDuel2;
    private static Table tableDuel1; //PLAYER Table of all cards.
    private static Table tableDuel2; //CPU Table of all cards.

    private static int[] playerDiff;

    private static int maxCardNo;
    private static boolean flagSome = false;
    private static boolean flagAll = false;
    private static boolean random;


    /**
     * Initializes the table of Cards and ArrayLists to store opened Card/Buttons for normal(not Duel) game modes.
     *
     * @param tableOfCards The specific table of Cards to store
     * @param players The array of current Players
     */
    static void init(Table tableOfCards, Player[] players) {
        table = initTable(tableOfCards);
        initAllArrays(false, players);
    }


    /**
     * Initializes the table of Cards and ArrayLists to store opened Card/Buttons for the Duel game mode.
     *
     * @param table1 The right table of Cards to store
     * @param table2 The left table of Cards to store
     * @param players The array of current Players
     */
    static void init(Table table1, Table table2, Player[] players){
        tableDuel1 = initTable(table1);
        tableDuel2 = initTable(table2);
        initAllArrays(true, players);
    }

    /**
     * Used in storing the table from Logic to a local table.
     *
     * @param originTable The original table from Logic
     * @return The table to store locally
     */
    private static Table initTable(Table originTable){
        return originTable;
    }

    /**
     * Initializes all ArrayLists used in storing opened Card/Buttons,
     * for all game modes and depending on the difficulty of the CPUs selected.
     *
     * @param isDuel If the game mode is Duel
     * @param players The array of current Players
     */
    private static void initAllArrays(boolean isDuel, Player[] players){
        playerDiff = new int[players.length];
        for (int i = 0; i < players.length; i++) {
            playerDiff[i] = players[i].getDiff();
            if (playerDiff[i] == 1) flagSome = true;
            if (playerDiff[i] == 2) flagAll = true;
        }

        if (isDuel){
            if (flagSome){
                arrayListSomeDuel1 = new ArrayList<>();
                arrayListSomeDuel2 = new ArrayList<>();
            }
            if (flagAll){
                arrayListAllDuel1 = new ArrayList<>();
                arrayListAllDuel2 = new ArrayList<>();
            }
        } else {
            if (flagSome) arrayListSome = new ArrayList<>();
            if (flagAll) arrayListAll = new ArrayList<>();
        }
        maxCardNo = GUIConnectionToLogic.getMaxCardsNum();
    }

    /**
     * Adds a Card Object to the initialized ArrayLists, depending on the difficulty of the CPUs selected.
     * It first checks if the Card Object is already stored. Used in normal(not Duel) game modes.
     *
     * @param x The X coordinate of the Card to store
     * @param y The Y coordinate of the Card to store
     */
    public static void addCardToArrayLists(int x, int y) {
        if (flagAll || flagSome){
            int[] temp = new int[3];
            temp[0] = table.getCardValue(x, y);
            temp[1] = x;
            temp[2] = y;
            if (flagAll){
                checkIfCardExists(temp, arrayListAll);
            }
            if (flagSome){
                checkIfCardExists(temp, arrayListSome);
            }
        }
    }


    /**
     * Checks if a Card Object is already stored in the given ArrayList.
     * If it is not, it gets stored.
     *
     * @param temp An array containing the Card value and coords to be checked for
     * @param arrayList The specific ArrayList to check
     */
    private static void checkIfCardExists(int[] temp, ArrayList<int[]> arrayList){
        boolean flagExists = false;
        for (int[] i : arrayList){
            if (arrayList.get(arrayList.indexOf(i))[0] == temp[0]
                    && arrayList.get(arrayList.indexOf(i))[1] == temp[1]
                    && arrayList.get(arrayList.indexOf(i))[2] == temp[2]){
                flagExists = true;
            }
        }
        if (!flagExists) {
            if (flagAll) arrayList.add(temp);
            if (flagSome){
                if (ThreadLocalRandom.current().nextBoolean()){
                    arrayList.add(temp);
                }
            }
        }
    }


    /**
     * Adds a Card Object to the initialized ArrayLists, depending on the difficulty of the CPUs selected
     * and whether or not the first player is playing. It first checks if the Card Object is already stored.
     * Used in Duel game mode.
     *
     * @param x The X coordinate of the Card to store
     * @param y The Y coordinate of the Card to store
     * @param firstPlayingNow If the first player is playing
     */
    public static void addCardToArrayListsDuel(int x, int y, boolean firstPlayingNow) {
        if (flagAll || flagSome){
            int[] temp = new int[3];
            if (firstPlayingNow) temp[0] = tableDuel1.getCardValue(x,y);
            else temp[0] = tableDuel2.getCardValue(x,y);
            temp[1] = x;
            temp[2] = y;

            if (firstPlayingNow){
                if (flagAll){
                    checkIfCardExists(temp, arrayListAllDuel1);
                }
                if (flagSome){
                    checkIfCardExists(temp, arrayListSomeDuel1);
                }
            } else {
                if (flagAll){
                    checkIfCardExists(temp, arrayListAllDuel2);
                }
                if (flagSome){
                    checkIfCardExists(temp, arrayListSomeDuel2);
                }
            }
        }
    }



    /**
     * Removes card data from ArrayLists and tables accordingly.
     * Used in normal(not Duel) game modes.
     *
     * @param cardValue The value of the Card to be removed
     */
    public static void removeCardsFromArrayList(int cardValue) {
        if (flagAll) {
            removePair(cardValue, arrayListAll);
        }
        if (flagSome) {
            removePair(cardValue, arrayListSome);
        }
        removeFromTable(cardValue, table);
    }


    /**
     * Removes a Card Object from the according table.
     *
     * @param cardValue The value of the Card Object to be removed
     * @param tableToRemove The table to remove the Card Object from
     */
    private static void removeFromTable(int cardValue, Table tableToRemove){
        int limI = tableToRemove.sizeX() - 1;
        int limJ = tableToRemove.sizeY() - 1;
        for (int i = limI; i >= 0; i--){
            for (int j = limJ; j >= 0; j--){
                if (tableToRemove.getCardValue(i,j) == cardValue){
                    tableToRemove.getArrayTable().get(i).get(j).setValue(-1);
                }
            }
        }
    }


    /**
     * Removes all card data from given ArrayList. All cards with the same value are removed.
     *
     * @param cardValue The value of the Card to be removed
     * @param arrayList The ArrayList to remove the Card from
     */
    private static void removePair(int cardValue, ArrayList<int[]> arrayList) {
        int limJ = arrayList.size() - 1;
        for (int j = limJ; j >= 0; j--) {
            if (arrayList.get(j)[0] == cardValue) {
                arrayList.remove(j);
            }
        }
    }

    /**
     * Removes card data from ArrayLists and tables accordingly.
     * Used in Duel game mode.
     *
     * @param cardValue The value of the Card to be removed
     */
    public static void removeCardsFromArrayListsDuel(int cardValue){
        if (flagAll){
            removePair(cardValue, arrayListAllDuel1);
            removePair(cardValue, arrayListAllDuel2);
        } if (flagSome) {
            removePair(cardValue, arrayListSomeDuel1);
            removePair(cardValue, arrayListSomeDuel2);
        }
        removeFromTable(cardValue, tableDuel1);
        removeFromTable(cardValue, tableDuel2);
    }


    /**
     * Choose specific Card coordinates of Cards to open, according to the difficulty of the CPU playing.
     * Used in normal(not Duel) game modes.
     *
     * @param playingNow Which CPU is currently playing
     */
    public static void play(int playingNow) {
        int[][] temp;

        if (playerDiff[playingNow] == 1) {
            temp = chooseCardFromArray(arrayListSome);
        } else if (playerDiff[playingNow] == 2) {
            temp = chooseCardFromArray(arrayListAll);
        } else { //For easy diff, or if error in diffNo, choose random.
            temp = chooseRandomCard(table);
        }
        for (int i = 0; i < maxCardNo; i++) {
            //System.out.println(temp[i][0] + ", " + temp[i][1]);
            GUIConnectionToLogic.openCard(temp[i][1], temp[i][2], random);
        }
        random = false;
    }


    /**
     * Choose specific Card coordinates of Cards to open, according to the difficulty of the CPU playing.
     * Used in Duel game mode.
     */
    public static void playDuel(){
        int[] temp;
        if (playerDiff[1] == 1){
            temp = chooseCardFromArrayDuel(arrayListSomeDuel2, arrayListSomeDuel1);
        } else if (playerDiff[1] == 2){
            temp = chooseCardFromArrayDuel(arrayListAllDuel2, arrayListAllDuel1);
        } else {
            temp = chooseRandomCard(tableDuel2)[0];
        }
        GUIConnectionToLogic.openCard(temp[1], temp[2], random);
        random = false;
    }

    /**
     * Choose same Cards to play according to the ArrayList given.
     * Used in Duel game mode.
     *
     * @param arrayListCPU The player's ArrayList of opened Cards
     * @param arrayListPlayer The CPU's ArrayList of opened Cards
     * @return An array containing the x & y coords of the Card to be opened
     */
    private static int[] chooseCardFromArrayDuel(ArrayList<int[]> arrayListCPU, ArrayList<int[]> arrayListPlayer){
        boolean foundPair = false;
        int pos = 1;

        int[] temp = new int[3];

        for (int des = arrayListCPU.size() - 1; des >=0; des--) {
            temp[0] = arrayListCPU.get(des)[0];
            temp[1] = arrayListCPU.get(des)[1];
            temp[2] = arrayListCPU.get(des)[2];
            for (int asc = 0; asc < arrayListPlayer.size(); asc++) {
                if (des == asc) break;
                //System.out.println(asc + " " +des);
                if (arrayListPlayer.get(asc)[0] == arrayListCPU.get(des)[0]) {
                    temp[0] = arrayListCPU.get(asc)[0];
                    temp[1] = arrayListCPU.get(asc)[1];
                    temp[2] = arrayListCPU.get(asc)[2];
                    if (maxCardNo == 3 && pos == 1) {
                        pos++;
                    } else {
                        foundPair = true;
                        break;
                    }
                }
            }
            if (foundPair) break;
        }
        if (!foundPair) temp = chooseRandomCard(tableDuel2)[0];
        return temp;
    }

    /**
     * Chooses random Cards to play from the Table of Card Object.
     *
     * @param table The table containing all the playable Card Objects
     * @return An array containing the x & y coords of the Card to be opened
     */
    private static int[][] chooseRandomCard(Table table) {
        int maxCards;
        int lastI = -1;
        int lastJ = -1;
        int mI = -1;
        int mJ = -1;

        boolean flag3 = true;

        if (GUIConnectionToLogic.getGameMode() == 4) maxCards = 1;
        else maxCards = maxCardNo;
        int[][] cardCoords = new int[maxCards][3];

        for (int m = 0; m < maxCards; m++){
            boolean flagFoundRandom = false;
            int randomCardValue = ThreadLocalRandom.current()
                    .ints(0,table.sizeOfTable())
                    .distinct()
                    .limit(1)
                    .sum();
            for (int i = 0; i < table.sizeX(); i++){
                for (int j = 0; j < table.sizeY(); j++){
                    if (table.getCardValue(i,j) == randomCardValue && i != lastI && j != lastJ && i!= mI && j!= mJ){
                        cardCoords[m][1] = i;
                        cardCoords[m][2] = j;
                        flagFoundRandom = true;
                        lastI = i;
                        lastJ = j;
                        if (GUIConnectionToLogic.getGameMode() == 3 && flag3) {
                            mI = i;
                            mJ = j;
                            flag3 = false;
                        }
                    }
                }
            } if (!flagFoundRandom) m--;
        }
        random = true;
        return cardCoords;
    }

    /**
     * Choose same Cards to play according to the ArrayList given.
     * Used in normal(not Duel) game modes.
     *
     * @param arrayList The ArrayList of opened Cards
     * @return An array containing the x & y coords of the Card to be opened
     */
    private static int[][] chooseCardFromArray(ArrayList<int[]> arrayList) {
        boolean foundPair = false;
        int pos = 1;

        int[][] temp = new int[maxCardNo][3];

        for (int des = arrayList.size() - 1; des >= 0; des--) {
            temp[0][0] = arrayList.get(des)[0];
            temp[0][1] = arrayList.get(des)[1];
            temp[0][2] = arrayList.get(des)[2];
            for (int asc = 0; asc < arrayList.size(); asc++) {
                if (des == asc) break;
                if (arrayList.get(asc)[0] == arrayList.get(des)[0]
                        && arrayList.get(asc)[1] != arrayList.get(des)[1]
                        && arrayList.get(asc)[2] != arrayList.get(des)[2]) {
                    temp[pos][0] = arrayList.get(asc)[0];
                    temp[pos][1] = arrayList.get(asc)[1];
                    temp[pos][2] = arrayList.get(asc)[2];
                    if (maxCardNo == 3 && pos == 1) {
                        pos++;
                    } else {
                        foundPair = true;
                        break;
                    }
                }
            }
            if (foundPair) break;
        }
        if (!foundPair) temp = chooseRandomCard(table);
        return temp;
    }
}