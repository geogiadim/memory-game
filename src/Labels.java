import javax.swing.*;
import java.awt.*;

public class Labels {
    public JLabel chooseGameMode, chooseNumOfPlayers,writeNames,levelOfCPU;
    public JLabel levelCpu1,levelCpu2,levelCpu3;
    public JLabel label;

    public void setLabelName(){
        chooseGameMode=makeLabel("Select Game mode", 60);
        chooseNumOfPlayers=makeLabel("Select Number of Players and CPUs",30);
        writeNames= makeLabel("Write the names of the players",30);
        levelOfCPU=makeLabel("Choose the level of CPU",18);
        levelCpu1=makeLabel("CPU 1: ",12);
        levelCpu2=makeLabel("CPU 2: ",12);
        levelCpu3=makeLabel("CPU 3: ",12);
    }

    public JLabel makeLabel(String name, int size){
        label = new JLabel(name);
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        label.setForeground(Color.BLUE);

        return label;
    }
}
