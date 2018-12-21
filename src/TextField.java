import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;

public class TextField {

    public JTextField textP1;
    public JLabel labelP1;
    public JTextField textP2;
    public JLabel labelP2;
    public JTextField textP3;
    public JLabel labelP3;
    public JTextField textP4;
    public JLabel labelP4;

    public TextField() {
        labelP1 = new JLabel("1st Player");
        labelP1.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        textP1 = new JTextField(" ");

        labelP2 = new JLabel("2nd Player");
        labelP2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        textP2 = new JTextField(" ");

        labelP3 = new JLabel("3rd Player");
        labelP3.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        textP3 = new JTextField(" ");

        labelP4 = new JLabel("4th Player");
        labelP4.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 16));
        textP4 = new JTextField(" ");
    }

}
