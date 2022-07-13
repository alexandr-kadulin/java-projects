import javax.swing.JFrame;

public class CustomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	CustomPanel panel = new CustomPanel();
	
	CustomFrame() {
		
		this.add(panel);
		this.setTitle("Drag & Drop");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
