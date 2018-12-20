package GUI;

import javax.swing.*;

class RadioButtons {
    JRadioButton p1, p2, p3, p4;

    void setRadioButtonName() {
        p1 = makeRadioButton("1 Player");
        p2 = makeRadioButton("2 Players");
        p3 = makeRadioButton("3 Players");
        p4 = makeRadioButton("4 Players");
    }

    private JRadioButton makeRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton(name);
        radioButton.setFocusPainted(false);
        return radioButton;
    }

}
