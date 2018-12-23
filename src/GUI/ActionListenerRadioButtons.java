package GUI;
class ActionListenerRadioButtons {
    ActionListenerRadioButtons(){
        addRadButActList();
    }
    private void addRadButActList() {
        GUI.getRadiobuttons().p1.addActionListener(actionEvent -> {
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(false);
            GUI.getTextField().textP3.setEnabled(false);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadiobuttons().cpu0.setSelected(true);
            GUI.getRadiobuttons().cpu0.setEnabled(true);
            GUI.getRadiobuttons().cpu1.setEnabled(false);
            GUI.getRadiobuttons().cpu2.setEnabled(false);
            GUI.getRadiobuttons().cpu3.setEnabled(false);
        });

        GUI.getRadiobuttons().p2.addActionListener(actionEvent -> {
           // gui.getNumOfPlayers() = 2;
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(false);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadiobuttons().cpu0.setSelected(true);
            GUI.getRadiobuttons().cpu0.setEnabled(true);
            GUI.getRadiobuttons().cpu1.setEnabled(true);
            GUI.getRadiobuttons().cpu2.setEnabled(false);
            GUI.getRadiobuttons().cpu3.setEnabled(false);
        });

        GUI.getRadiobuttons().p3.addActionListener(actionEvent -> {
           // gui.getNumOfPlayers() = 3;
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(true);
            GUI.getTextField().textP4.setEnabled(false);

            GUI.getRadiobuttons().cpu0.setSelected(true);
            GUI.getRadiobuttons().cpu0.setEnabled(true);
            GUI.getRadiobuttons().cpu1.setEnabled(true);
            GUI.getRadiobuttons().cpu2.setEnabled(true);
            GUI.getRadiobuttons().cpu3.setEnabled(false);
        });

        GUI.getRadiobuttons().p4.addActionListener(actionEvent -> {
           // gui.getNumOfPlayers() = 4;
            GUI.getTextField().textP1.setEnabled(true);
            GUI.getTextField().textP2.setEnabled(true);
            GUI.getTextField().textP3.setEnabled(true);
            GUI.getTextField().textP4.setEnabled(true);

            GUI.getRadiobuttons().cpu0.setSelected(true);
            GUI.getRadiobuttons().cpu0.setEnabled(true);
            GUI.getRadiobuttons().cpu1.setEnabled(true);
            GUI.getRadiobuttons().cpu2.setEnabled(true);
            GUI.getRadiobuttons().cpu3.setEnabled(true);
        });

        GUI.getRadiobuttons().cpu0.addActionListener(actionEvent -> {
            setEnabledLevelCPU0();
        });
        GUI.getRadiobuttons().cpu1.addActionListener(actionEvent -> {
            setEnabledLevelCPU1();
        });
        GUI.getRadiobuttons().cpu2.addActionListener(actionEvent -> {
            setEnabledLevelCPU2();
        });
        GUI.getRadiobuttons().cpu3.addActionListener(actionEvent -> {
            setEnabledLevelCPU3();
        });
    }

    private void setEnabledLevelCPU0 (){
        GUI.getRadiobuttons().easyCPU.setEnabled(false);
        GUI.getRadiobuttons().normalCPU.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU.setEnabled(false);

        GUI.getRadiobuttons().easyCPU2.setEnabled(false);
        GUI.getRadiobuttons().normalCPU2.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU2.setEnabled(false);

        GUI.getRadiobuttons().easyCPU3.setEnabled(false);
        GUI.getRadiobuttons().normalCPU3.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU3.setEnabled(false);
    }

    private void setEnabledLevelCPU1(){
        GUI.getRadiobuttons().easyCPU.setEnabled(true);
        GUI.getRadiobuttons().normalCPU.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU.setEnabled(true);

        GUI.getRadiobuttons().easyCPU2.setEnabled(false);
        GUI.getRadiobuttons().normalCPU2.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU2.setEnabled(false);

        GUI.getRadiobuttons().easyCPU3.setEnabled(false);
        GUI.getRadiobuttons().normalCPU3.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU3.setEnabled(false);
    }

    private void setEnabledLevelCPU2(){
        GUI.getRadiobuttons().easyCPU.setEnabled(true);
        GUI.getRadiobuttons().normalCPU.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU.setEnabled(true);

        GUI.getRadiobuttons().easyCPU2.setEnabled(true);
        GUI.getRadiobuttons().normalCPU2.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU2.setEnabled(true);

        GUI.getRadiobuttons().easyCPU3.setEnabled(false);
        GUI.getRadiobuttons().normalCPU3.setEnabled(false);
        GUI.getRadiobuttons().difficultCPU3.setEnabled(false);
    }

    private void setEnabledLevelCPU3(){
        GUI.getRadiobuttons().easyCPU.setEnabled(true);
        GUI.getRadiobuttons().normalCPU.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU.setEnabled(true);

        GUI.getRadiobuttons().easyCPU2.setEnabled(true);
        GUI.getRadiobuttons().normalCPU2.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU2.setEnabled(true);

        GUI.getRadiobuttons().easyCPU3.setEnabled(true);
        GUI.getRadiobuttons().normalCPU3.setEnabled(true);
        GUI.getRadiobuttons().difficultCPU3.setEnabled(true);
    }
}
