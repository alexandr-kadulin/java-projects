import javax.swing.*;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	CustomPanel panel;
	
	CustomFrame() {
		
		panel = new CustomPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
