import javax.swing.*;
import java.awt.*;

public class chooseVersionGUI {
    private JFrame frame;
    private FlowLayout layout;

    public chooseVersionGUI(){
        frame = new JFrame("Memory Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLocationCenter();
        frame.setResizable(false);

        createButtons();
        layout = new FlowLayout();
        frame.setLayout(layout);

        frame.pack();
        frame.setVisible(true);
    }

    private void setLocationCenter(){
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d =t.getScreenSize();
        frame.setLocationRelativeTo(null);
        int x = (d.width - frame.getWidth())/2;
        int y = (d.height - frame.getHeight())/2;
        frame.setLocation(x, y);
    }

    private void createButtons(){
        JButton version1 = new JButton("Version 1");
        JButton version2 = new JButton("Version 2");
        frame.add(version1);
        frame.add(version2);
    }
}
