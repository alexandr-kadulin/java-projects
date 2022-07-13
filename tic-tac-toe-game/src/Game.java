import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game implements ActionListener {
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel buttonsPanel = new JPanel();
	JLabel label = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean firstPlayer;
	
	Game() {
		
		label.setBackground(new Color(25, 25, 25));
		label.setForeground(new Color(25, 255, 0));
		label.setFont(new Font("Monospaced", Font.BOLD, 75));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setText("Tic-Tac-Toe");
		label.setOpaque(true);
		
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 800, 100);
		panel.add(label);
		
		buttonsPanel.setLayout(new GridLayout(3, 3));
		buttonsPanel.setBackground(new Color(150, 150, 150));
		
		for (int i = 0; i < 9; i ++) {
			buttons[i] = new JButton();
			buttonsPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Monospaced", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		
		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonsPanel);
		
		frame.setVisible(true);
		
		queue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 9; i ++) {
			if (e.getSource() == buttons[i]) {
				if (firstPlayer) {
					if (buttons[i].getText() == "") {
						
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						firstPlayer = false;
						label.setText("Noughts turn");
						
						check();
					}
				}
				else {
					if (buttons[i].getText() == "") {
						
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						firstPlayer = true;
						label.setText("Crosses turn");
						
						check();
					}
				}
			}
		}
	}
	
	public void queue() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (random.nextInt(2) == 0) {
			firstPlayer = true;
			label.setText("Crosses turn");
		}
		else {
			firstPlayer = false;
			label.setText("Noughts turn");
		}
	}
	
	public void check() {
		
		if (
				(buttons[0].getText() == "X") &&
				(buttons[1].getText() == "X") &&
				(buttons[2].getText() == "X")
				) {
			crosses(0, 1, 2);
		}
		if (
				(buttons[3].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[5].getText() == "X")
				) {
			crosses(3, 4, 5);
		}
		if (
				(buttons[6].getText() == "X") &&
				(buttons[7].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			crosses(6, 7, 8);
		}
		if (
				(buttons[0].getText() == "X") &&
				(buttons[3].getText() == "X") &&
				(buttons[6].getText() == "X")
				) {
			crosses(0, 3, 6);
		}
		if (
				(buttons[1].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[7].getText() == "X")
				) {
			crosses(1, 4, 7);
		}
		if (
				(buttons[2].getText() == "X") &&
				(buttons[5].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			crosses(2, 5, 8);
		}
		if (
				(buttons[0].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[8].getText() == "X")
				) {
			crosses(0, 4, 8);
		}
		if (
				(buttons[2].getText() == "X") &&
				(buttons[4].getText() == "X") &&
				(buttons[6].getText() == "X")
				) {
			crosses(2, 4, 6);
		}
		if (
				(buttons[0].getText() == "O") &&
				(buttons[1].getText() == "O") &&
				(buttons[2].getText() == "O")
				) {
			noughts(0, 1, 2);
		}
		if (
				(buttons[3].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[5].getText() == "O")
				) {
			noughts(3, 4, 5);
		}
		if (
				(buttons[6].getText() == "O") &&
				(buttons[7].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			noughts(6, 7, 8);
		}
		if (
				(buttons[0].getText() == "O") &&
				(buttons[3].getText() == "O") &&
				(buttons[6].getText() == "O")
				) {
			noughts(0, 3, 6);
		}
		if (
				(buttons[1].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[7].getText() == "O")
				) {
			noughts(1, 4, 7);
		}
		if (
				(buttons[2].getText() == "O") &&
				(buttons[5].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			noughts(2, 5, 8);
		}
		if (
				(buttons[0].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[8].getText() == "O")
				) {
			noughts(0, 4, 8);
		}
		if (
				(buttons[2].getText() == "O") &&
				(buttons[4].getText() == "O") &&
				(buttons[6].getText() == "O")
				) {
			noughts(2, 4, 6);
		}
	}
	
	public void crosses(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for (int i = 0; i < 9; i ++) {
			buttons[i].setEnabled(false);
		}
		
		label.setText("Crosses won!");
	}
	
	public void noughts(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for (int i = 0; i < 9; i ++) {
			buttons[i].setEnabled(false);
		}
		
		label.setText("Noughts won!");
	}

}
