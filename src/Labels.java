import javax.swing.*;
import java.awt.*;

public class Labels {
    public JLabel chooseGameMode, chooseNumOfPlayers;
    public JLabel label;

    //private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    public void setLabelName(){
        chooseGameMode=makeLabel("Select Game mode");
        chooseNumOfPlayers=makeLabel("Select Number of Players");
    }

    public JLabel makeLabel(String name){
        label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 52));
        label.setForeground(Color.BLUE);

        return label;
    }


}
