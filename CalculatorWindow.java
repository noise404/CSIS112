package com.company;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow {
    public static JTextField textField = new JTextField("0"); 
    public static String actionEventString = ""; //recieves 't' from CalculatorListener.java. t is e.getactioncommand received from symbols array via .setactioncommand
    public static String modifier = "";
    public static int value1 = 0;
    public static int value2 = 0;
    public static int temptTotal = 0;
    public static int answer = 0;

    /*constructor called from main to create calculator window. main panel uses borderlayout and assigns textfield to the north and the bottom panel to the south.
    the bottom panel houses a grid layout of 4x4 which is populated with 16 buttons. 16 buttons are created via a for loop */

    public CalculatorWindow(String titleIn){

        JFrame calcframe = new JFrame(titleIn);
        calcframe.setSize(300, 300);
        calcframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton[] buttons = new JButton[16];
        String [] symbols = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        JPanel mainPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new GridLayout(4,4));


        textField.setEditable(false);

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton(symbols[i]);
            buttons[i].setActionCommand(symbols[i]);
            buttons[i].addActionListener(new CalculatorListener());
            bottomPanel.add(buttons[i]);
        }


        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        calcframe.add(mainPanel);
        calcframe.setVisible(true);


    }

    // end of window creation constructor


    /*method that receives e.getactioncommand from CalculatorListener.java and sets the textfield with that value. */
    public static void setTextField(String e){

        textField.setText(e);
    }


    /*main method that does the calculations. first switch receives 't' from CalculatorListener.java (which is e.getactioncommand placed in above constructor)
    and tests it via switches. depending on the value passed, (Clear, addition, subtraction), the textfield will be cleared or updated, actioneventstring will be
    cleared, and math operators will occur. */

    public static void calcMath(String t){

        switch (t){
	    //clear case. sets textfield to 0, the modifier and all values
            case "C": actionEventString = "";
                setTextField("0");
                modifier = "";
                value1 = 0;
                value2 = 0;
                answer = 0;
                break;

	    //when the math operator is pressed, value1 gets added to it whatever getText method returns. eg textfield.gettext returns 25. value1 is 0, 0+25=25. 
            case "+": modifier = "+";
                value1 = getText() + value1;
                setTextField("");
                actionEventString = "";
                break;

            case "-": modifier = "-";
                value1 = getText();
                setTextField("");
                actionEventString = "";
                break;

            case "*": modifier = "*";
                value1 = getText();
                setTextField("");
                actionEventString = "";
                break;

            case "/": modifier = "/";
                value1 /= getText();
                value1 = getText();
                setTextField("");
                actionEventString = "";
                break;

	    /*when equals is pressed, depending on what the modifier value is (+,-,*,/), different operations will occur. value2 will be whatever value was
	    entered post modifier press and will get added to, divided by, or multiplied by value1. answer will hold the result of the operation and then set to
	    the textfield for the user to see*/

            case "=":
                switch (modifier){
                    case "+":
                        value2 = getText();
                        answer = value1 + value2;
                        setTextField(String.valueOf(answer));
                        value1 = answer;
                        value2 = 0;
                        break;
                    case "-":
                        value2 = getText();
                        answer = value1 - value2;
                        setTextField(String.valueOf(answer));
                        value1 = answer;
                        value2 = 0;
                        break;
                    case "*":
                        value2 = getText();
                        answer = (value1 * value2);
                        setTextField(String.valueOf(answer));
                        value1 = answer;
                        value2 = 0;
                        break;
                    case "/":
                        value2 = getText();
                        answer = (value1 / value2);
                        setTextField(String.valueOf(answer));
                        value1 = answer;
                        value2 = 0;
                        break;
                    default: break;
                }
                break;
	    //if no operators are pressed, actioneventstring will be concatenated and displayed to allow for larger numbers
            default:
                actionEventString += t;
                setTextField(actionEventString);
                break;
        }

    }

    /*getText grabs the string from textfield and converts it to a string and then returns it. used in calcMath method to retrieve user entered values to do
    calculations on*/

    public static int getText(){
        return Integer.parseInt(textField.getText());
    }
}
