import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Emoji extends JFrame implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	JLabel label;
	ImageIcon smile;
	ImageIcon nervous;
	ImageIcon pain;
	ImageIcon dizzy;
	
	Emoji() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new FlowLayout());	
		
		smile = new ImageIcon("smile.png");
		nervous = new ImageIcon("nervous.png");
		pain = new ImageIcon("angry.png");
		dizzy = new ImageIcon("dizzy.png");
		label = new JLabel();
		
		label.setIcon(smile);
		label.addMouseListener(this);
		
		this.add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		label.setIcon(dizzy);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		label.setIcon(pain);
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		label.setIcon(nervous);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		label.setIcon(smile);
	}

}
