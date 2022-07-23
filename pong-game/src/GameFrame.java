import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	GamePanel panel;

	GameFrame() {
		
		this.add(new GamePanel());
		this.setTitle("Pong Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBackground(Color.black);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
