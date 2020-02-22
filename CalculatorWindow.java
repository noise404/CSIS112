package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorWindow {
	public static JTextField textField = new JTextField("0");
	public static String actionEventString = "";
	public static String modifier = "";
	public static int value1 = 0;
	public static int value2 = 0;
	public static int answer = 0;

	public CalculatorWindow(String titleIn){

		/*super(titleIn);
		super.setSize(300,300);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 */
		JFrame testFrame = new JFrame("CalcWindow");
		testFrame.setSize(300, 300);
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
		/*super.add(mainPanel);
		super.setVisible(true);

		 */
		testFrame.add(mainPanel);
		testFrame.setVisible(true);


	}
	public static void setTextField(String e){

		textField.setText(e);
	}

	public static void setTemp(String t){
		if (t.equals("C")){
			actionEventString = "";
			setTextField("0");
			modifier = "";
		}
		else if(t.equals("+")){
			modifier = "+";
			value1 = getText() + value1;
			setTextField("0");
			actionEventString = "";
		}
		else if(t.equals("-")){
			modifier = "-";
			value1 = getText();
			System.out.println(value1);
			setTextField("0");
			actionEventString = "";
		}
		else if(t.equals("=") && modifier.equals("+")){
			value2 = getText();
			answer = value1 + value2;
			setTextField(String.valueOf(answer));
			value1 = 0;
			value2 = 0;
		}
		else if(t.equals("=") && modifier.equals("-")){
			value2 = getText();
			answer = value1 - value2;
			setTextField(String.valueOf(answer));
			value1 = 0;
			value2 = 0;
		}
		else{
			actionEventString = actionEventString + t;
			setTextField(actionEventString);
		}
	}

	public static int getText(){
		return Integer.parseInt(textField.getText());
	}
}
