package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleButtons_en_US extends ListResourceBundle {
    private Object[][] contents = {
            {"basicButton", "Basic Mode"},
            {"doubleButton", "Double Mode"},
            {"tripleButton", "Triple Mode"},
            {"duelButton", "Duel Mode"},
            {"nextButton", "Next"},
            {"backButton", "Back"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
