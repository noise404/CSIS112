package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener {

    /*new CalculatorListener object is created via for loop in CalculatorWindow.java and when the actionPerformed method is evoked, the action command is gottan via
    getactioncommand and sent to calcMath method in CalculatorWindow*/

    public void actionPerformed(ActionEvent e){

        CalculatorWindow.calcMath(e.getActionCommand());

    }
}
