import javax.swing.*;
import java.awt.*;

public class chooseVersionGUI {
    private JFrame frame;
    private FlowLayout layout;

    public chooseVersionGUI(){
        frame = new JFrame("Memory Game");
        layout = new FlowLayout();
        frame.setLayout(layout);

        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createButtons();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

   /* private void setLocationOnCenter(){
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d =t.getScreenSize();
        frame.setLocationRelativeTo(null);
        int x = (d.width - frame.getWidth())/2;
        int y = (d.height - frame.getHeight())/2;
        frame.setLocation(x, y);
    }*/

    private void createButtons(){
        JButton version1 = new JButton("Version 1");
        JButton version2 = new JButton("Version 2");
        frame.add(version1);
        frame.add(version2);
    }
}