package com.memoryGame.GUI;

class ActionListenerRadioButtons {
    static void addRadButActList() {
            RadioButtons.p1.addActionListener(actionEvent -> {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(false);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);

            RadioButtons.cpu0.setSelected(true);
            RadioButtons.cpu0.setEnabled(true);
            RadioButtons.cpu1.setEnabled(false);
            RadioButtons.cpu2.setEnabled(false);
            RadioButtons.cpu3.setEnabled(false);
        });

        RadioButtons.p2.addActionListener(actionEvent -> {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(false);
            TextField.textP4.setEnabled(false);

            RadioButtons.cpu0.setSelected(true);
            RadioButtons.cpu0.setEnabled(true);
            RadioButtons.cpu1.setEnabled(true);
            RadioButtons.cpu2.setEnabled(false);
            RadioButtons.cpu3.setEnabled(false);
        });

        RadioButtons.p3.addActionListener(actionEvent -> {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(false);

            RadioButtons.cpu0.setSelected(true);
            RadioButtons.cpu0.setEnabled(true);
            RadioButtons.cpu1.setEnabled(true);
            RadioButtons.cpu2.setEnabled(true);
            RadioButtons.cpu3.setEnabled(false);
        });

        RadioButtons.p4.addActionListener(actionEvent -> {
            TextField.textP1.setEnabled(true);
            TextField.textP2.setEnabled(true);
            TextField.textP3.setEnabled(true);
            TextField.textP4.setEnabled(true);

            RadioButtons.cpu0.setSelected(true);
            RadioButtons.cpu0.setEnabled(true);
            RadioButtons.cpu1.setEnabled(true);
            RadioButtons.cpu2.setEnabled(true);
            RadioButtons.cpu3.setEnabled(true);
        });

        RadioButtons.cpu0.addActionListener(actionEvent -> {
            setEnabledLevelCPU0();
            System.out.println("0");
        });
        RadioButtons.cpu1.addActionListener(actionEvent -> {
            setEnabledLevelCPU1();
            System.out.println("0");
        });
        RadioButtons.cpu2.addActionListener(actionEvent -> {
            setEnabledLevelCPU2();
            System.out.println("0");
        });
        RadioButtons.cpu3.addActionListener(actionEvent -> {
            setEnabledLevelCPU3();
            System.out.println("0");
        });

        RadioButtons.no.addActionListener(actionEvent ->{
            TextField.textP2.setEnabled(true);
            TextField.textP2.setText("Player 2");
        });
        RadioButtons.yes.addActionListener(actionEvent ->{
            TextField.textP2.setEnabled(false);
            TextField.textP2.setText("CPU");
        });
    }

    static void setEnabledLevelCPU0() {
        RadioButtons.easyCPU.setEnabled(false);
        RadioButtons.normalCPU.setEnabled(false);
        RadioButtons.difficultCPU.setEnabled(false);

        RadioButtons.easyCPU2.setEnabled(false);
        RadioButtons.normalCPU2.setEnabled(false);
        RadioButtons.difficultCPU2.setEnabled(false);

        RadioButtons.easyCPU3.setEnabled(false);
        RadioButtons.normalCPU3.setEnabled(false);
        RadioButtons.difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU1() {
        RadioButtons.easyCPU.setEnabled(true);
        RadioButtons.normalCPU.setEnabled(true);
        RadioButtons.difficultCPU.setEnabled(true);

        RadioButtons.easyCPU2.setEnabled(false);
        RadioButtons.normalCPU2.setEnabled(false);
        RadioButtons.difficultCPU2.setEnabled(false);

        RadioButtons.easyCPU3.setEnabled(false);
        RadioButtons.normalCPU3.setEnabled(false);
        RadioButtons.difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU2() {
        RadioButtons.easyCPU.setEnabled(true);
        RadioButtons.normalCPU.setEnabled(true);
        RadioButtons.difficultCPU.setEnabled(true);

        RadioButtons.easyCPU2.setEnabled(true);
        RadioButtons.normalCPU2.setEnabled(true);
        RadioButtons.difficultCPU2.setEnabled(true);

        RadioButtons.easyCPU3.setEnabled(false);
        RadioButtons.normalCPU3.setEnabled(false);
        RadioButtons.difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU3() {
        RadioButtons.easyCPU.setEnabled(true);
        RadioButtons.normalCPU.setEnabled(true);
        RadioButtons.difficultCPU.setEnabled(true);

        RadioButtons.easyCPU2.setEnabled(true);
        RadioButtons.normalCPU2.setEnabled(true);
        RadioButtons.difficultCPU2.setEnabled(true);

        RadioButtons.easyCPU3.setEnabled(true);
        RadioButtons.normalCPU3.setEnabled(true);
        RadioButtons.difficultCPU3.setEnabled(true);
    }
}
