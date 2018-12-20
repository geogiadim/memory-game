import javax.swing.*;

public class RadioButtons {
    public JRadioButton p1, p2, p3, p4,cpu0, cpu1,cpu2,cpu3;
    public JRadioButton radioButton;

    public void setRadioButtonName(){
        p1=makeRadioButton("Player 1");
        p2=makeRadioButton("Player 2");
        p3=makeRadioButton("Player 3");
        p4=makeRadioButton("Player 4");
        cpu1=makeRadioButton("CPU 1");
        cpu2=makeRadioButton("CPU 2");
        cpu3=makeRadioButton("CPU 3");
        cpu0=makeRadioButton("CPU 4");
    }

    public JRadioButton makeRadioButton(String name){
        radioButton=new JRadioButton(name);

        return radioButton;
    }

}
