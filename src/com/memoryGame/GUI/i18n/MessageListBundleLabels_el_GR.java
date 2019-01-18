package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Language Bundle for Labels in el_GR Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleLabels_el_GR extends ListResourceBundle {
    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"selectGM", "Επιλέξτε Κατηγορία Παιχνιδιού"},
            {"selectNumPlayers", "Επιλέξτε αριθμό Παικτών"},
            {"selectCPULevel", "Επιλέξτε δυσκολία Υπολογιστή: "},
            {"cpuLabel", "Υπολογιστής "},
            {"writeNames", "Γράψτε τα ονόματα των Παικτών"},
            {"duelCPU", " Θέλετε ως αντίπαλο Υπολογιστή;"},
            {"topMessagePreview1", "Οι κάρτες εμφανίζονται για "},
            {"topMessagePreview2", " δεύτερα. Απομνημονεύστε όσες μπορείτε."},
            {"topRuleTriple", "Επιλέξτε τρεις κάρτες σε κάθε γύρο."},
            {"topRuleDuel", "Επιλέξτε μόνο μία κάρτα από το ταμπλό σας σε κάθε γύρο."},
            {"topRuleBasicDouble", "Επιλέξτε δύο κάρτες σε κάθε γύρο."},
            {"topWrong", "Λάθος επιλογή !!!"},
            {"topCorrect", "Σωστή επιλογή !!!"},
            {"bottomPlayerTurn", "Παίζει ο/η "},
            {"gameOver", "Τέλος παιχνιδιού"},
            {"highScoresLabel", "Οι καλύτερες επιδόσεις του παιχνιδιού βρίσκονται στο αρχείο <<Memory-Game-Scores.txt>>"},
            {"soloResults1","Ταίριαξες όλες τις κάρτες σε "},
            {"soloResults2", " βήματα."},
            {"winnerResults", "Νικητής είναι ο/η: "},
            {"drawResults", "Δεν υπάρχει νικητής."}
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
