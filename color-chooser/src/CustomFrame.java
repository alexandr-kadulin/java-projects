import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class CustomFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JButton button;
	JLabel label;
	
	CustomFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Pick Color");
		button.addActionListener(this);
		
		label = new JLabel();
		label.setBackground(Color.white);
		label.setText("Selected Color");
		label.setFont(new Font("Monospaced", Font.PLAIN, 100));
		label.setOpaque(true);
		
		this.add(button);
		this.add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button) {
			Color color = JColorChooser.showDialog(null, "Pick Color", Color.black);
			
			label.setBackground(color);
		}
	}
}
