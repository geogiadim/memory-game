package com.memoryGame.GUI;

class DrawTableGUI {

    static void showTable(boolean previewMode) {
        GUI.clearFrame(GUI.getGameFrame());
        GUI.frame4GamePlay(GUI.getGameFrame().getContentPane(),previewMode);
        GUI.getGameFrame().validate();
    }
}
