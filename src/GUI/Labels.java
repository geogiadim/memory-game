package GUI;

import javax.swing.*;
import java.awt.*;

class Labels {
    JLabel chooseGameMode, chooseNumOfPlayers;

    //private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    void setLabelName() {
        chooseGameMode = makeLabel("Select Game mode");
        chooseNumOfPlayers = makeLabel("Select Number of Players");
    }

    private JLabel makeLabel(String name) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 52));
        label.setForeground(Color.BLUE);

        return label;
    }
}