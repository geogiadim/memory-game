package com.memoryGame.GUI.i18n;

import java.util.ListResourceBundle;

public class MessageListBundleTextField_en_US extends ListResourceBundle {
    private Object[][] contents = {
            {"playerTextField", "Player "},
            {"player1", "1st Player"},
            {"player2", "2nd Player"},
            {"player3", "3rd Player"},
            {"player4", "4th Player"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }

}
