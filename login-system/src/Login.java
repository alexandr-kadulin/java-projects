import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton loginBtn = new JButton("Login");
	JButton resetBtn = new JButton("Reset");
	JTextField idField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JLabel idLabel = new JLabel("ID:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel msgLabel = new JLabel();
	HashMap<String, String> loginInfo = new HashMap<String, String>();
	
	Login(HashMap<String, String> loginData) {
		
		loginInfo = loginData;
		
		idLabel.setBounds(50, 100, 75, 25);
		passwordLabel.setBounds(50, 150, 75, 25);
		
		msgLabel.setBounds(125, 250, 250, 35);
		msgLabel.setFont(new Font(null, Font.PLAIN, 25));
		
		idField.setBounds(125, 100, 200, 25);
		passwordField.setBounds(125, 150, 200, 25);
		
		loginBtn.setBounds(125, 200, 100, 25);
		loginBtn.setFocusable(false);
		loginBtn.addActionListener(this);
		
		resetBtn.setBounds(225, 200, 100, 25);
		resetBtn.setFocusable(false);
		resetBtn.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		frame.add(idLabel);
		frame.add(passwordLabel);
		frame.add(msgLabel);
		frame.add(idField);
		frame.add(passwordField);
		frame.add(loginBtn);
		frame.add(resetBtn);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == resetBtn) {
			idField.setText("");
			passwordField.setText("");
		}
		
		if (e.getSource() == loginBtn) {
			String userId = idField.getText();
			String userPassword = String.valueOf(passwordField.getPassword());
			
			if (loginInfo.containsKey(userId)) {
				if(loginInfo.get(userId).equals(userPassword)) {
					msgLabel.setForeground(Color.green);
					msgLabel.setText("Success!");
					frame.dispose();
					
					new Landing(userId);
				}
				else {
					msgLabel.setForeground(Color.red);
					msgLabel.setText("Invalid password");
				}
			}
			else {
				msgLabel.setForeground(Color.red);
				msgLabel.setText("No such user");
			}
		}
		
	}

}
