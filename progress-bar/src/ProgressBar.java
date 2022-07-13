import java.awt.*;
import javax.swing.*;

public class ProgressBar {
	
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar(0, 100);
	
	ProgressBar() {
		
		bar.setValue(0);
		bar.setBounds(0, 0, 420, 50);
		bar.setStringPainted(true);
		bar.setForeground(Color.red);
		bar.setBackground(Color.black);
		bar.setFont(new Font("Monospaced", Font.BOLD, 25));
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(bar);
		
		fill();
	}
	
	public void fill() {
		
		int counter = 100;
		
		while(counter > 0) {
			
			bar.setValue(counter);
			bar.setString(counter + "/" + "0" + " HP");
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			counter -= 1;
		}
		
		bar.setString("YOU DIED");
	}
}
