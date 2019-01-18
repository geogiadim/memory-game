package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;


/**
 * Language Bundle for Buttons in en_US Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleButtons_en_US extends ListResourceBundle {
    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"basicButton", "Basic Mode"},
            {"doubleButton", "Double Mode"},
            {"tripleButton", "Triple Mode"},
            {"duelButton", "Duel Mode"},
            {"nextButton", "Next"},
            {"backButton", "Back"}
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
