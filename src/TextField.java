import javax.swing.JLabel;
import javax.swing.JTextField;

public class TextField {

    public JTextField textP1;
    public JLabel labelP1;
    public JTextField textP2;
    public JLabel labelP2;
    public JTextField textP3;
    public JLabel labelP3;
    public JTextField textP4;
    public JLabel labelP4;

    public TextField() {
        labelP1 = new JLabel("1st Player");
        textP1 = new JTextField(" ");

        labelP2 = new JLabel("2nd Player");
        textP2 = new JTextField(" ");

        labelP3 = new JLabel("3rd Player");
        textP3 = new JTextField(" ");

        labelP4 = new JLabel("4th Player");
        textP4 = new JTextField(" ");
        //textP1.setEditable(false);

        /*JPanel panel2 = new JPanel();
        JButton buttonCalculate = new JButton("Υπολογισμός Δόσης");
        buttonCalculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calculateDose();
            }
        });
        panel2.add(buttonCalculate);
        add(panel2, BorderLayout.PAGE_END);*/
    }

}
