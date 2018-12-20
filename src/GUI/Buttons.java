package GUI;

import javax.swing.*;
import java.awt.*;

class Buttons {
    JButton basicButton, doubleButton, tripleButton, duelButton;
    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    void setButtonsName() {
        basicButton = makeButton("Basic Game");
        basicButton.setMnemonic(basicButton.getText().charAt(1));
        doubleButton = makeButton("Double Game");
        doubleButton.setMnemonic(doubleButton.getText().charAt(1));
        tripleButton = makeButton("Triple Game");
        tripleButton.setMnemonic(tripleButton.getText().charAt(1));
        duelButton = makeButton("Duel Game");
        duelButton.setMnemonic(duelButton.getText().charAt(1));
    }

    private JButton makeButton(String name) {
        Dimension dimension = new Dimension(180, 90);

        JButton button = new JButton(name);
        button.setFocusPainted(false);
        button.setPreferredSize(dimension);
        button.setFont(buttonFont);

        return button;
    }
}
