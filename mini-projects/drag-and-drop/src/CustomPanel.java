import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class CustomPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	ImageIcon image = new ImageIcon("ball.png");
	
	final int WIDTH = image.getIconWidth();
	final int HEIGHT = image.getIconHeight();
	
	Point cornerPoint;
	Point prevPoint;
	
	CustomPanel() {
		
		cornerPoint = new Point(0, 0);
		ClickListener clickListener = new ClickListener();
		DragListener dragListener = new DragListener();
		
		this.addMouseListener(clickListener);
		this.addMouseMotionListener(dragListener);
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		image.paintIcon(this, g, (int) cornerPoint.getX(), (int) cornerPoint.getY());
	}
	
	private class ClickListener extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			
			prevPoint = e.getPoint();
		}
	}
	
	private class DragListener extends MouseMotionAdapter {
		
		public void mouseDragged(MouseEvent e) {
			
			Point currentPoint = e.getPoint();
			
			cornerPoint.translate(
					(int) (currentPoint.getX() - prevPoint.getX()),
					(int) (currentPoint.getY() - prevPoint.getY())
			);
			
			prevPoint = currentPoint;
			
			repaint();
		}
	}

}
