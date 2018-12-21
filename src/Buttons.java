import javax.swing.*;
import java.awt.*;

public class Buttons {
    public JButton basicButton, doubleButton, tripleButton, duelButton, nextbutton, backbutton;
    public JButton button;
    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 18);

    private final static int WIDTH_MODE=250;
    private final static int HEIGHT_MODE=150;
    private final static int FONT_SIZE_MODE=30;
    private final static int FONT_SIZE_GAME=18;


    public void setButtonsName(){
        basicButton=makeButton("Basic Game",WIDTH_MODE, HEIGHT_MODE);
        doubleButton=makeButton("Double Game",WIDTH_MODE,HEIGHT_MODE);
        tripleButton=makeButton("Triple Game",WIDTH_MODE,HEIGHT_MODE);
        duelButton=makeButton("Duel Game",WIDTH_MODE,HEIGHT_MODE);
        nextbutton=makeButton("Next",90,45);
        backbutton=makeButton("Back",90,45);
    }

    public JButton makeButton(String name,int w, int h){
        Dimension dimension = new Dimension(w,h);

        button = new JButton(name);
        button.setFocusPainted(false);
        //button.setMnemonic(KeyEvent.VK_B);
        button.setPreferredSize(dimension);
        button.setFont(buttonFont);

        return button;
    }
}
