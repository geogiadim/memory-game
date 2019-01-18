package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Language Bundle for RadioButtons in el_GR Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleRadioButtons_el_GR extends ListResourceBundle {

    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
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