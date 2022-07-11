import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Rocket extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	JLabel label;
	ImageIcon icon;
	
	Rocket() {
		
		label = new JLabel();
		icon = new ImageIcon("icons8-launch-64.png");
		
		label.setBounds(0, 0, 100, 100);
		label.setIcon(icon);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.getContentPane().setBackground(Color.black);
		this.setLayout(null);
		this.setVisible(true);
		this.addKeyListener(this);
		this.add(label);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		switch (e.getKeyChar()) {
			case 'a':
				label.setLocation(label.getX() - 10, label.getY());
				break;
			case 'w':
				label.setLocation(label.getX(), label.getY() - 10);
				break;
			case 's':
				label.setLocation(label.getX(), label.getY() + 10);
				break;
			case 'd':
				label.setLocation(label.getX() + 10, label.getY());
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch (e.getKeyCode()) {
			case 37:
				label.setLocation(label.getX() - 10, label.getY());
				break;
			case 38:
				label.setLocation(label.getX(), label.getY() - 10);
				break;
			case 39:
				label.setLocation(label.getX() + 10, label.getY());
				break;
			case 40:
				label.setLocation(label.getX(), label.getY() + 10);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
