package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Language Bundle for TextFields in en_US Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleTextField_en_US extends ListResourceBundle {

    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"playerTextField", "Player "},
            {"player1", "1st Player"},
            {"player2", "2nd Player"},
            {"player3", "3rd Player"},
            {"player4", "4th Player"}
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