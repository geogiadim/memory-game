package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Language Bundle for TextFields in el_GR Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleTextField_el_GR extends ListResourceBundle {

    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"playerTextField", "Παίκτης "},
            {"player1", "1ος Παίκτης"},
            {"player2", "2ος Παίκτης"},
            {"player3", "3ος Παίκτης"},
            {"player4", "4ος Παίκτης"}
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