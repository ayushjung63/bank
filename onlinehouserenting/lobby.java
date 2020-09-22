package onlinehouserenting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class lobby {

	JFrame frame;
	private JTextField username;
	private JPasswordField password;
	
	
	public static String user1;
	
	public static String getUser1() {
		return user1;
	}

	public static void setUser1(String user1) {
		lobby.user1 = user1;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lobby window = new lobby();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lobby() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOnlineHouse = new JLabel("ONLINE HOUSE");
		lblOnlineHouse.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblOnlineHouse.setBounds(141, 11, 216, 35);
		frame.getContentPane().add(lblOnlineHouse);
		
		JLabel lblRenting = new JLabel("RENTING");
		lblRenting.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lblRenting.setBounds(176, 49, 128, 35);
		frame.getContentPane().add(lblRenting);
		
		JButton btnNewButton = new JButton("SIGN IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			user1=username.getText();
			String uPass=password.getText();
	
			try {
				Connection con =DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				String sql="select * from customer where username=?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1,user1);
				ResultSet rs=pst.executeQuery();
				while(rs.next()) {
					String checkPass=rs.getString("password");
					if(!uPass.equals(checkPass)) {
						  JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					}else {
						frame.dispose();
						viewData view=new viewData();
						view.frame.setVisible(true);
					}
				}
			}catch (SQLException exc) {}
//			
//			
			}	
		});
		btnNewButton.setBackground(new Color(0, 255, 127));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		btnNewButton.setBounds(94, 255, 115, 43);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose(); 
			customer cust=new customer();
			cust.frame.setVisible(true);
			}
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Sitka Text", Font.ITALIC, 16));
		btnSignUp.setBackground(new Color(64, 224, 208));
		btnSignUp.setBounds(329, 255, 128, 43);
		frame.getContentPane().add(btnSignUp);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(94, 129, 136, 28);
		frame.getContentPane().add(username);
		
		JLabel label = new JLabel("Username:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		label.setBounds(94, 95, 85, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		label_1.setBounds(94, 175, 85, 23);
		frame.getContentPane().add(label_1);
		
		password = new JPasswordField();
		password.setBounds(94, 209, 136, 28);
		frame.getContentPane().add(password);
		
		JLabel lblNewLabel = new JLabel("Don't have an account?");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 13));
		lblNewLabel.setBounds(329, 230, 156, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
