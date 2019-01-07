package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleButtons_el_GR extends ListResourceBundle {
    private Object[][] contents = {
            {"basicButton", "Βασικό Παιχνίδι"},
            {"doubleButton", "Διπλό  Παιχνίδι"},
            {"tripleButton", "Τριπλό  Παιχνίδι"},
            {"duelButton", "Μονομαχία"},
            {"nextButton", "Επόμενο"},
            {"backButton", "Πίσω"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
