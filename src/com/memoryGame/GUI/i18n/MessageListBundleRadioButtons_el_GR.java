package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleRadioButtons_el_GR extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            {"player1", "1 Παίκτης"},
            {"players", " Παίκτες"},
            {"noCPU", "Κανένας Υπολογιστής"},
            {"cpuRadioButton", " Υπολογιστής"},
            {"easyRadioButton", "Εύκολο"},
            {"normalRadioButton", "Μέτριο"},
            {"hardRadioButton", "Δύσκολο"},
            {"yesRadioButton", "Ναι"},
            {"noRadioButton", "Όχι"}
    };
}
