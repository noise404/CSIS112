package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame {
    JFrame base = new JFrame("Calculator" );
    JPanel buttons = new JPanel();
    JTextField txtFld = new JTextField();


    public Frame(){
        buttons.setLayout(new GridLayout(4, 4));
        base.add(buttons);
        base.add(txtFld);
        base.setVisible(true);

    }

test

}
