
package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

/**
 * Language Bundle for RadioButtons in en_US Locale.
 *
 * @author George Christidis
 */
public class MessageListBundleRadioButtons_en_US extends ListResourceBundle {

    /**
     * Translated contents of Resource Bundle in 2D Array.
     */
    private Object[][] contents = {
            {"player1", "1 Player"},
            {"players", " Players"},
            {"noCPU", "NO CPU"},
            {"cpuRadioButton", " CPU"},
            {"easyRadioButton", "Easy"},
            {"normalRadioButton", "Normal"},
            {"hardRadioButton", "Hard"},
            {"yesRadioButton", "Yes"},
            {"noRadioButton", "No"}
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