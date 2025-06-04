package universitymanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton b1, b2;
	JTextField t1;
	JPasswordField t2;
	Login() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 20);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 20);
		add(t1);
		
		JLabel l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 20);
		add(l2);
		
		t2 = new JPasswordField();
		t2.setBounds(150, 70, 150, 20);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(40, 140, 120, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setFont(new Font("Tahome", Font.BOLD, 15));
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180, 140, 120, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setFont(new Font("Tahome", Font.BOLD, 15));
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(600, 300);
		setLocation(500, 250);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == b1) {
			String username = t1.getText();
			String password = t2.getText();
			
			String query = "select * from login where username ='"+username+"' and password='"+password+"'";
			
			try {
				Conn c = new Conn();
				ResultSet rs = c.s.executeQuery(query);
				
				if (rs.next() ) {
					setVisible(false);
					new Project();
				}else {
					JOptionPane.showMessageDialog(null, "invalid username or password");
					setVisible(false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == b2) {
			setVisible(false);

		}
		
	}
	
	public static void main(String[] args) {
		new Login();

	}
}
