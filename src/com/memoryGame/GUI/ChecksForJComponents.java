package com.memoryGame.GUI;

/**
 * Enables the right TextFields and sets the correct Labels in Frame3 according to the state of RadioButtons in Frame2.
 *
 * @author Giorgos Giannios
 */
class ChecksForJComponents {
    private static int numberOfCPU = 0;

    /**
     * Checks Player Radio Button position and enables corresponding TextFields.
     */
    static void checkForTextField() {
        if (RadioButtons.player[0].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(false);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[1].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(false);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[2].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(false);
        }
        if (RadioButtons.player[3].isSelected()) {
            TextField.textPlayerNames[0].setEnabled(true);
            TextField.textPlayerNames[1].setEnabled(true);
            TextField.textPlayerNames[2].setEnabled(true);
            TextField.textPlayerNames[3].setEnabled(true);
        }
    }


    /**
     * Checks CPU Radio Button position and changes corresponding TextFields.
     */
    static void checkForTextField2() {
        if (RadioButtons.cpu[0].isSelected()) {
            TextField.playerLabel(0);
            TextField.playerLabel(1);
            TextField.playerLabel(2);
            TextField.playerLabel(3);
            numberOfCPU = 0;
        }
        if (RadioButtons.cpu[1].isSelected()) {
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 1);
            numberOfCPU = 1;
        }
        if (RadioButtons.cpu[2].isSelected()) {
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 1);
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 2);
            numberOfCPU = 2;
        }
        if (RadioButtons.cpu[3].isSelected()) {
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 1);
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 2);
            TextField.cpuLabel(GUIConnectionToLogic.getNumOfPlayers() - 3);
            numberOfCPU = 3;
        }
    }


    /**
     * Getter to return the number of CPUs.
     *
     * @return Number of CPUs
     */
    static int getNumberOfCPU() {return numberOfCPU;}
}
