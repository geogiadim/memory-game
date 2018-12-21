/*
package GUI

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

interface ActionListenerRadioButtons {

    void addRadButActList(){
        radiobutton.p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=1;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(false);
                textField.textP3.setEnabled(false);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(false);
                radiobutton.cpu2.setEnabled(false);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=2;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(false);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(false);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=3;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(true);
                textField.textP4.setEnabled(false);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(true);
                radiobutton.cpu3.setEnabled(false);
            }
        });
        radiobutton.p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numOfPlayers=4;
                textField.textP1.setEnabled(true);
                textField.textP2.setEnabled(true);
                textField.textP3.setEnabled(true);
                textField.textP4.setEnabled(true);

                radiobutton.cpu0.setSelected(true);
                radiobutton.cpu0.setEnabled(true);
                radiobutton.cpu1.setEnabled(true);
                radiobutton.cpu2.setEnabled(true);
                radiobutton.cpu3.setEnabled(true);
            }
        });

        radiobutton.cpu0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobutton.easyCPU.setEnabled(false);
                radiobutton.normalCPU.setEnabled(false);
                radiobutton.difficultCPU.setEnabled(false);

                radiobutton.easyCPU2.setEnabled(false);
                radiobutton.normalCPU2.setEnabled(false);
                radiobutton.difficultCPU2.setEnabled(false);

                radiobutton.easyCPU3.setEnabled(false);
                radiobutton.normalCPU3.setEnabled(false);
                radiobutton.difficultCPU3.setEnabled(false);
            }
        });

        radiobutton.cpu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobutton.easyCPU.setEnabled(true);
                radiobutton.normalCPU.setEnabled(true);
                radiobutton.difficultCPU.setEnabled(true);

                radiobutton.easyCPU2.setEnabled(false);
                radiobutton.normalCPU2.setEnabled(false);
                radiobutton.difficultCPU2.setEnabled(false);

                radiobutton.easyCPU3.setEnabled(false);
                radiobutton.normalCPU3.setEnabled(false);
                radiobutton.difficultCPU3.setEnabled(false);
            }
        });

        radiobutton.cpu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobutton.easyCPU.setEnabled(true);
                radiobutton.normalCPU.setEnabled(true);
                radiobutton.difficultCPU.setEnabled(true);

                radiobutton.easyCPU2.setEnabled(true);
                radiobutton.normalCPU2.setEnabled(true);
                radiobutton.difficultCPU2.setEnabled(true);

                radiobutton.easyCPU3.setEnabled(false);
                radiobutton.normalCPU3.setEnabled(false);
                radiobutton.difficultCPU3.setEnabled(false);
            }
        });

        radiobutton.cpu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radiobutton.easyCPU.setEnabled(true);
                radiobutton.normalCPU.setEnabled(true);
                radiobutton.difficultCPU.setEnabled(true);

                radiobutton.easyCPU2.setEnabled(true);
                radiobutton.normalCPU2.setEnabled(true);
                radiobutton.difficultCPU2.setEnabled(true);

                radiobutton.easyCPU3.setEnabled(true);
                radiobutton.normalCPU3.setEnabled(true);
                radiobutton.difficultCPU3.setEnabled(true);
            }
        });
    }
}
*/