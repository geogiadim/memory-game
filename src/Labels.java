import javax.swing.*;
import java.awt.*;

public class Labels {
    public JLabel chooseGameMode, chooseNumOfPlayers,writeNames;
    public JLabel label;

    //private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    public void setLabelName(){
        chooseGameMode=makeLabel("Select Game mode", 52);
        chooseNumOfPlayers=makeLabel("Select Number of Players and CPUs",30);
        writeNames= makeLabel("Write the names of the players",30);
    }

    public JLabel makeLabel(String name, int size){
        label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        label.setForeground(Color.BLUE);

        return label;
    }


}
