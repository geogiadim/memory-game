package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleLabels_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            {"selectGM","Select Game mode"},
            {"selectNumPlayers","Select Number of Players"},
            {"selectCPULevel", "Choose CPU Level"},
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
            {"bottomPlayerTurn", "It is the turn of "}
    };
}
