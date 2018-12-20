import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Buttons {
    public JButton basicButton, doubleButton, tripleButton, duelButton;
    public JButton button;
    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);


    public void setButtonsName(){
        basicButton=makeButton("Basic Game");
        doubleButton=makeButton("Double Game");
        tripleButton=makeButton("Triple Game");
        duelButton=makeButton("Duel Game");
    }

    public JButton makeButton(String name){
        Dimension dimension = new Dimension(180,90);

        button = new JButton(name);
        //button.addActionListener(this);
        button.setFocusPainted(false);
        //button.setMnemonic(KeyEvent.VK_B);
        button.setPreferredSize(dimension);
        button.setFont(buttonFont);

        return button;
    }
}
