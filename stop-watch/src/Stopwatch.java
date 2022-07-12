import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton startBtn = new JButton("Start");
	JButton resetBtn = new JButton("Reset");
	JLabel label = new JLabel();
	int time = 0;
	int secs = 0;
	int mins = 0;
	int hrs = 0;
	boolean isStarted = false;
	String seconds = String.format("%02d", secs);
	String minutes = String.format("%02d", mins);
	String hours = String.format("%02d", hrs);
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			time += 1000;
			hrs = (time / 3600000);
			mins = (time / 60000) % 60;
			secs = (time / 1000) % 60;
			
			String seconds = String.format("%02d", secs);
			String minutes = String.format("%02d", mins);
			String hours = String.format("%02d", hrs);
			
			label.setText(hours + ":" + minutes + ":" + seconds);
			
		}
	});
	
	Stopwatch() {
		
		label.setText(hours + ":" + minutes + ":" + seconds);
		label.setBounds(100, 100, 200, 100);
		label.setFont(new Font("Monospaced", Font.PLAIN, 35));
		label.setBorder(BorderFactory.createBevelBorder(1));
		label.setOpaque(true);
		label.setHorizontalAlignment(JTextField.CENTER);
		
		startBtn.setBounds(100, 200, 100, 50);
		startBtn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		startBtn.setFocusable(false);
		startBtn.addActionListener(this);
		
		resetBtn.setBounds(200, 200, 100, 50);
		resetBtn.setFont(new Font("Monospaced", Font.PLAIN, 20));
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		frame.add(label);
		frame.add(startBtn);
		frame.add(resetBtn);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == startBtn) {
			if (isStarted == false) {
				
				isStarted = true;
				startBtn.setText("Stop");
				
				start();
			}
			else {
				isStarted = false;
				startBtn.setText("Start");
				
				stop();
			}
		}
		
		if (e.getSource() == resetBtn) {
			isStarted = false;
			startBtn.setText("Start");
			
			reset();
		}
		
	}
	
	void start() {
		
		timer.start();
	}
	
	void stop() {
		
		timer.stop();
	}
	
	void reset() {
		
		timer.stop();
		
		time = 0;
		secs = 0;
		mins = 0;
		hrs = 0;
		
		String seconds = String.format("%02d", secs);
		String minutes = String.format("%02d", mins);
		String hours = String.format("%02d", hrs);
		
		label.setText(hours + ":" + minutes + ":" + seconds);
	}

}
