package GUI;

import javax.swing.*;
import java.awt.*;

class TextField {
    //Font for Text Field Labels
    private final static Font FONT_TEXTFIELD_LABEL = new Font(Font.SANS_SERIF, Font.ITALIC, 16);
    private final static String SPACE = " ";
    //Player Name Text Fields
    static JTextField textP1, textP2, textP3, textP4;
    //Labels for Text Fields
    static JLabel labelP1, labelP2, labelP3, labelP4;

    static void setTextFields() {
        labelP1 = new JLabel("1st Player");
        labelP1.setFont(FONT_TEXTFIELD_LABEL);
        textP1 = new JTextField(SPACE);

        labelP2 = new JLabel("2nd Player");
        labelP2.setFont(FONT_TEXTFIELD_LABEL);
        textP2 = new JTextField(SPACE);

        labelP3 = new JLabel("3rd Player");
        labelP3.setFont(FONT_TEXTFIELD_LABEL);
        textP3 = new JTextField(SPACE);

        labelP4 = new JLabel("4th Player");
        labelP4.setFont(FONT_TEXTFIELD_LABEL);
        textP4 = new JTextField(SPACE);
    }
}
