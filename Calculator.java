package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        calc c = new calc();
    }

    public static class calc {
        
        /*
        JButton[] buttons = new JButton[16];
        String[] symbols = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "C", "=", "+", "-", "x", "/"};
        
        */
        JFrame base = new JFrame("Calculator");
        JPanel buttons = new JPanel();
        JTextField txtFld = new JTextField();
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton clear = new JButton("C");
        JButton equals = new JButton("=");


        public calc(){
            buttons.setLayout(new GridLayout(4, 4));
            base.setSize(300, 300);
            base.add(buttons);
            //base.add(txtFld);
            base.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            buttons.add(one);
            buttons.add(two);
            buttons.add(three);
            buttons.add(four);
            buttons.add(five);
            buttons.add(six);
            buttons.add(seven);
            buttons.add(eight);
            buttons.add(nine);
            buttons.add(zero);
            buttons.add(clear);
            buttons.add(equals);
            base.setVisible(true);


        }
    }
}
