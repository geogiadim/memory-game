package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;
/**
 * Language Bundle for Labels in en_US Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleLabels_en_US extends ListResourceBundle {

    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"selectGM", "Select Game mode"},
            {"selectNumPlayers", "Select Number of Players"},
            {"selectCPULevel", "Choose CPU Level: "},
            {"cpuLabel", "CPU "},
            {"writeNames", "Write the names of the players"},
            {"duelCPU", " Do you want to play against CPU?"},
            {"topMessagePreview1", "Showing Cards for "},
            {"topMessagePreview2", " seconds. Memorize as many as you can."},
            {"topRuleTriple", "Choose three cards in each round."},
            {"topRuleDuel", "Choose only one card from your table in each round."},
            {"topRuleBasicDouble", "Choose two cards in each round."},
            {"topWrong", "Wrong choice !!!"},
            {"topCorrect", "Correct choice !!!"},
            {"bottomPlayerTurn", "It is the turn of "},
            {"gameOver", "Game Over"},
            {"highScoresLabel", "Check in the document <<Memory-Game-Scores.txt>> the high scores of the game"},
            {"soloResults1","You matched all cards in "},
            {"soloResults2", " steps."},
            {"winnerResults", "The winner is: "},
            {"drawResults", "There is not a winner."}
    };


    /**
     * Getter for translated Resource Bundle content.
     *
     * @return Resource Bundle content
     */
    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
