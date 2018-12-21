import javax.swing.*;
import java.awt.*;

public class RadioButtons {
    public JRadioButton p1, p2, p3, p4,cpu0, cpu1,cpu2,cpu3;
    public JRadioButton radioButton;
    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 16);


    public void setRadioButtonName(){
        p1=makeRadioButton("1 Player");
        p2=makeRadioButton("2 Players");
        p3=makeRadioButton("3 Players");
        p4=makeRadioButton("4 Players");
        cpu0=makeRadioButton("0 CPU");
        cpu1=makeRadioButton("1 CPU");
        cpu2=makeRadioButton("2 CPUs");
        cpu3=makeRadioButton("3 CPUs");

    }

    public JRadioButton makeRadioButton(String name){
        radioButton=new JRadioButton(name);
        radioButton.setFont(buttonFont);

        return radioButton;
    }

}
