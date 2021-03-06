import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Landing {
	
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	
	Landing(String uderId) {
		
		label.setBounds(0, 0, 200, 35);
		label.setFont(new Font("Monospaced", Font.PLAIN, 25));
		label.setText("Hello " + uderId);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		frame.add(label);
		
		frame.setVisible(true);
	}
}
