package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener {
    public void actionPerformed(ActionEvent e){

        //CalculatorWindow.setTextField(e.getActionCommand());
        CalculatorWindow.setTemp(e.getActionCommand());

    }
}
