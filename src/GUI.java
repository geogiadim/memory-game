import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

      private JFrame frame;
      private JButton basic, doubLe,triple,duel;
      private JLabel gameplay;
      private FlowLayout aLayout;

      public GUI() {
            makeFrame();
      }

      private void makeFrame() {
            frame = new JFrame("Memory Game");
            aLayout = new FlowLayout();
            frame.setLayout(aLayout);

            frame.setResizable(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //setFrameOnCenter(frame);

            makeButton();
            makeLabel();

            frame.add(gameplay);
            frame.add(basic);
            frame.add(doubLe);
            frame.add(triple);
            frame.add(duel);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
      }

      private void makeButton() {
            basic = new JButton("Basic Game");
            basic.addActionListener(this);
            doubLe = new JButton("Double Game");
            doubLe.addActionListener(this);
            triple= new JButton("Triple Game");
            triple.addActionListener(this);
            duel= new JButton("Duel Game");
            duel.addActionListener(this);
      }

      private void makeLabel() {
            gameplay = new JLabel("Select one of the games");
            gameplay.setFont(new Font( "Sheriff",Font.BOLD,50));
            gameplay.setForeground(Color.RED);
      }

      private void setFrameOnCenter(Frame frame){
            Toolkit t= Toolkit.getDefaultToolkit();
            Dimension d=t.getScreenSize();
            frame.setLocationRelativeTo(null);
            int x=(d.width-frame.getWidth())/2;
            int y=(d.height-frame.getHeight())/2;
            frame.setLocation(x,y);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Basic Game"))
            {
                  gameplay.setText("Basic");
            }
            else if (e.getActionCommand().equals("Double Game"))
            {
                  gameplay.setText("Double");
            }
            else if (e.getActionCommand().equals("Triple Game"))
            {
                  gameplay.setText("Triple");
            }
            else if (e.getActionCommand().equals("Duel Game"))
            {
                  gameplay.setText("Duel");
            }
      }
}