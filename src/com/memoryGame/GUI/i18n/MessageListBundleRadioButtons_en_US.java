package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleRadioButtons_en_US extends ListResourceBundle {
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

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
