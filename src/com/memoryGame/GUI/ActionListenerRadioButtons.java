package com.memoryGame.GUI;

class ActionListenerRadioButtons {

    ActionListenerRadioButtons(){
        addRadButActList();
    }

    private void addRadButActList() {
        GUI.getRadioButtons().p1.addActionListener(actionEvent -> {
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(false);
            GUI.getTextField().textP3.setEnabled(false);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadioButtons().cpu0.setSelected(true);
            GUI.getRadioButtons().cpu0.setEnabled(true);
            GUI.getRadioButtons().cpu1.setEnabled(false);
            GUI.getRadioButtons().cpu2.setEnabled(false);
            GUI.getRadioButtons().cpu3.setEnabled(false);
        });

        GUI.getRadioButtons().p2.addActionListener(actionEvent -> {
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(false);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadioButtons().cpu0.setSelected(true);
            GUI.getRadioButtons().cpu0.setEnabled(true);
            GUI.getRadioButtons().cpu1.setEnabled(true);
            GUI.getRadioButtons().cpu2.setEnabled(false);
            GUI.getRadioButtons().cpu3.setEnabled(false);
        });

        GUI.getRadioButtons().p3.addActionListener(actionEvent -> {
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(true);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadioButtons().cpu0.setSelected(true);
            GUI.getRadioButtons().cpu0.setEnabled(true);
            GUI.getRadioButtons().cpu1.setEnabled(true);
            GUI.getRadioButtons().cpu2.setEnabled(true);
            GUI.getRadioButtons().cpu3.setEnabled(false);
        });

        GUI.getRadioButtons().p4.addActionListener(actionEvent -> {
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(true);
            GUI.getTextField().textP4.setEnabled(true);

            GUI.getRadioButtons().cpu0.setSelected(true);
            GUI.getRadioButtons().cpu0.setEnabled(true);
            GUI.getRadioButtons().cpu1.setEnabled(true);
            GUI.getRadioButtons().cpu2.setEnabled(true);
            GUI.getRadioButtons().cpu3.setEnabled(true);
        });

        GUI.getRadioButtons().cpu0.addActionListener(actionEvent -> {
            setEnabledLevelCPU0();
            System.out.println("0");
        });
        GUI.getRadioButtons().cpu1.addActionListener(actionEvent -> {
            setEnabledLevelCPU1();
            System.out.println("0");
        });
        GUI.getRadioButtons().cpu2.addActionListener(actionEvent -> {
            setEnabledLevelCPU2();
            System.out.println("0");
        });
        GUI.getRadioButtons().cpu3.addActionListener(actionEvent -> {
            setEnabledLevelCPU3();
            System.out.println("0");
        });
    }

    static void setEnabledLevelCPU0 (){
        GUI.getRadioButtons().easyCPU.setEnabled(false);
        GUI.getRadioButtons().normalCPU.setEnabled(false);
        GUI.getRadioButtons().difficultCPU.setEnabled(false);

        GUI.getRadioButtons().easyCPU2.setEnabled(false);
        GUI.getRadioButtons().normalCPU2.setEnabled(false);
        GUI.getRadioButtons().difficultCPU2.setEnabled(false);

        GUI.getRadioButtons().easyCPU3.setEnabled(false);
        GUI.getRadioButtons().normalCPU3.setEnabled(false);
        GUI.getRadioButtons().difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU1(){
        GUI.getRadioButtons().easyCPU.setEnabled(true);
        GUI.getRadioButtons().normalCPU.setEnabled(true);
        GUI.getRadioButtons().difficultCPU.setEnabled(true);

        GUI.getRadioButtons().easyCPU2.setEnabled(false);
        GUI.getRadioButtons().normalCPU2.setEnabled(false);
        GUI.getRadioButtons().difficultCPU2.setEnabled(false);

        GUI.getRadioButtons().easyCPU3.setEnabled(false);
        GUI.getRadioButtons().normalCPU3.setEnabled(false);
        GUI.getRadioButtons().difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU2(){
        GUI.getRadioButtons().easyCPU.setEnabled(true);
        GUI.getRadioButtons().normalCPU.setEnabled(true);
        GUI.getRadioButtons().difficultCPU.setEnabled(true);

        GUI.getRadioButtons().easyCPU2.setEnabled(true);
        GUI.getRadioButtons().normalCPU2.setEnabled(true);
        GUI.getRadioButtons().difficultCPU2.setEnabled(true);

        GUI.getRadioButtons().easyCPU3.setEnabled(false);
        GUI.getRadioButtons().normalCPU3.setEnabled(false);
        GUI.getRadioButtons().difficultCPU3.setEnabled(false);
    }

    static void setEnabledLevelCPU3(){
        GUI.getRadioButtons().easyCPU.setEnabled(true);
        GUI.getRadioButtons().normalCPU.setEnabled(true);
        GUI.getRadioButtons().difficultCPU.setEnabled(true);

        GUI.getRadioButtons().easyCPU2.setEnabled(true);
        GUI.getRadioButtons().normalCPU2.setEnabled(true);
        GUI.getRadioButtons().difficultCPU2.setEnabled(true);

        GUI.getRadioButtons().easyCPU3.setEnabled(true);
        GUI.getRadioButtons().normalCPU3.setEnabled(true);
        GUI.getRadioButtons().difficultCPU3.setEnabled(true);
    }
}
