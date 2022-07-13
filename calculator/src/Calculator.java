import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JTextField textField;
	Font font = new Font("Monospaced", Font.BOLD, 30);
	JButton[] numButtons = new JButton[10];
	JButton[] funcButtons = new JButton[9];
	JButton addBtn, subBtn, mulBtn, divBtn;
	JButton decBtn, equBtn, delBtn, clrBtn, negBtn;
	JPanel panel;
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField = new JTextField();
		textField.setBounds(50, 25, 300, 50);
		textField.setFont(font);
		textField.setEditable(false);
		
		addBtn = new JButton("+");
		subBtn = new JButton("-");
		mulBtn = new JButton("*");
		divBtn = new JButton("/");
		decBtn = new JButton(".");
		equBtn = new JButton("=");
		delBtn = new JButton("Del");
		clrBtn = new JButton("Clr");
		negBtn = new JButton("(-)");
		
		funcButtons[0] = addBtn;
		funcButtons[1] = subBtn;
		funcButtons[2] = mulBtn;
		funcButtons[3] = divBtn;
		funcButtons[4] = decBtn;
		funcButtons[5] = equBtn;
		funcButtons[6] = delBtn;
		funcButtons[7] = clrBtn;
		funcButtons[8] = negBtn;
		
		for (int i = 0; i < 9; i ++) {
			funcButtons[i].addActionListener(this);
			funcButtons[i].setFont(font);
			funcButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i ++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFont(font);
			numButtons[i].setFocusable(false);
		}
		
		negBtn.setBounds(50, 430, 100, 50);
		delBtn.setBounds(150, 430, 100, 50);
		clrBtn.setBounds(250, 430, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addBtn);
		
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subBtn);
		
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulBtn);
		panel.add(decBtn);
		
		panel.add(numButtons[0]);
		panel.add(equBtn);
		panel.add(divBtn);
		
		frame.add(panel);
		frame.add(textField);
		frame.add(delBtn);
		frame.add(clrBtn);
		frame.add(negBtn);
		
		frame.setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i ++) {
			if (e.getSource() == numButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		
		if (e.getSource() == decBtn) {
			textField.setText(textField.getText().concat("."));
		}
		
		if (e.getSource() == addBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		
		if (e.getSource() == subBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		
		if (e.getSource() == mulBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		
		if (e.getSource() == divBtn) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		
		if (e.getSource() == equBtn) {
			num2 = Double.parseDouble(textField.getText());
			
			switch (operator) {
			
				case '+':
					result = num1 + num2;
					break;
				case '-':
					result = num1 - num2;
					break;
				case '*':
					result = num1 * num2;
					break;
				case '/':
					result = num1 / num2;
					break;
			}
			
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		
		if (e.getSource() == clrBtn) {
			textField.setText("");
		}
		
		if (e.getSource() == delBtn) {
			String str = textField.getText();
			textField.setText("");
			
			for (int i = 0; i < str.length() - 1; i ++) {
				textField.setText(textField.getText() + str.charAt(i));
			}
		}
		
		if (e.getSource() == negBtn) {
			double temp = Double.parseDouble(textField.getText());
			temp *= -1;
			textField.setText(String.valueOf(temp));
		}
		
	}

}
