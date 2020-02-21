package Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorWindow extends JFrame{

	public CalculatorWindow(String titleIn){

		super(titleIn);
		super.setSize(300,300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel mainPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,1));
		bottomPanel.setLayout(new GridLayout(4,4));

		JTextField textField = new JTextField("0", 20);
		textField.setEditable(false);

		topPanel.add(textField);
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		super.add(mainPanel);
		super.setVisible(true);

	}

}
