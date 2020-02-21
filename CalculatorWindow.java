package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame{

	public CalculatorWindow(String titleIn){

		super(titleIn);
		super.setSize(300,300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton[] buttons = new JButton[16];
		String [] symbols = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "+", "="};
		JPanel mainPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(4,4));

		JTextField textField = new JTextField("0", 20);
		textField.setEditable(false);

		for (int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton(symbols[i]);
			buttons[i].setActionCommand(symbols[i]);
			bottomPanel.add(buttons[i]);
		}

		topPanel.add(textField);
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		super.add(mainPanel);
		super.setVisible(true);

	}

}
