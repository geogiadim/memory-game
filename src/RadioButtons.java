import javax.swing.*;

public class RadioButtons {
    public JRadioButton p1, p2, p3, p4;
    public JRadioButton radioButton;

    public void setRadioButtonName(){
        p1=makeRadioButton("1 Player");
        p2=makeRadioButton("2 Players");
        p3=makeRadioButton("3 Players");
        p4=makeRadioButton("4 Players");
    }

    public JRadioButton makeRadioButton(String name){
        radioButton=new JRadioButton(name);

        return radioButton;
    }

}
