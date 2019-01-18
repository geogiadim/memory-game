package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Translated contents of Resource Bundle in 2D Array.
 */
public class MessageListBundleButtons_el_GR extends ListResourceBundle {
    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"basicButton", "Βασικό Παιχνίδι"},
            {"doubleButton", "Διπλό  Παιχνίδι"},
            {"tripleButton", "Τριπλό  Παιχνίδι"},
            {"duelButton", "Μονομαχία"},
            {"nextButton", "Επόμενο"},
            {"backButton", "Πίσω"}
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
