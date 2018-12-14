import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chooseVersionGUI implements ActionListener {
    private JFrame frame;
    private FlowLayout layout;
    private static int mode=0;
    private boolean flag=false;

    public int chooseVersionGUI(){
        frame = new JFrame("Memory Game");
        layout = new FlowLayout();
        frame.setLayout(layout);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createButtons();

        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        setLocationOnCenter();
        frame.setVisible(true);

        return 2;
    }

    private void setLocationOnCenter(){
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension d =t.getScreenSize();
        frame.setLocationRelativeTo(null);
        int x = (d.width - frame.getWidth())/2;
        int y = (d.height - frame.getHeight())/2;
        frame.setLocation(x, y);
    }

    private void createButtons(){
        JButton version1 = new JButton("Version 1");
        version1.addActionListener(this);
        JButton version2 = new JButton("Version 2");
        version2.addActionListener(this);
        frame.add(version1);
        frame.add(version2);
    }

    private static int getModeGUI(){return mode;}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Version 1")) {
            mode=1;
            flag=true;
        }
        else if (e.getActionCommand().equals("Version 2"))
        {
            mode=2;
            flag=true;
        }
    }
}