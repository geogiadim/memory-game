package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleLabels_el_GR extends ListResourceBundle {
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

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
