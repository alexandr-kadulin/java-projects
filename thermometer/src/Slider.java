import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener {
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JSlider slider;
	
	Slider() {
		
		frame = new JFrame("Thermometer");
		panel = new JPanel();
		label = new JLabel();
		slider = new JSlider(0, 100, 50);
		
		slider.setPreferredSize(new Dimension(400, 200));
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(25);
		slider.setPaintLabels(true);
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setFont(new Font("Monospaced", Font.PLAIN, 15));
		slider.addChangeListener(this);
		
		label.setText("\u00B0C = " + slider.getValue());
		label.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		panel.add(slider);
		panel.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setVisible(true);
		frame.add(panel);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
		label.setText("\u00B0C = " + slider.getValue());
		
	}

}
