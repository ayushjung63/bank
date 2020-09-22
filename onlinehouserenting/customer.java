package onlinehouserenting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class customer {
	
	public static String user1;
	JFrame frame;
	private JLabel lblNewLabel;
	private JTextField name;
	private JTextField username;
	private JLabel Usernam;
	private JTextField email;
	private JLabel lblEmail;
	private JLabel lblContac;
	private JTextField contact;
	private JTextField securityQ;
	private JLabel lblSecurityQuestion;
	private JLabel lblPassword;
	private JPasswordField password;
	private JPasswordField password2;
	private JLabel lblConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer window = new customer();
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
	public customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 604, 503);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 588, 464);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(190, 85, 46, 23);
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(259, 87, 190, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(259, 126, 190, 21);
		panel.add(username);
		
		Usernam = new JLabel("Username:");
		Usernam.setForeground(Color.WHITE);
		Usernam.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		Usernam.setBounds(171, 124, 65, 23);
		panel.add(Usernam);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(259, 208, 190, 21);
		panel.add(email);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblEmail.setBounds(190, 206, 46, 23);
		panel.add(lblEmail);
		
		lblContac = new JLabel("Contact:");
		lblContac.setForeground(Color.WHITE);
		lblContac.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblContac.setBounds(184, 172, 52, 23);
		panel.add(lblContac);
		
		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(259, 169, 190, 21);
		panel.add(contact);
		
		securityQ = new JTextField();
		securityQ.setColumns(10);
		securityQ.setBounds(259, 350, 190, 21);
		panel.add(securityQ);
		
		lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setForeground(Color.WHITE);
		lblSecurityQuestion.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblSecurityQuestion.setBounds(134, 348, 111, 23);
		panel.add(lblSecurityQuestion);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblPassword.setBounds(171, 248, 65, 23);
		panel.add(lblPassword);
		
		
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String um=username.getText();
				String nm=name.getText();
				String ct=contact.getText();
				String em=email.getText();
				String pass=password.getText();
				String sq=securityQ.getText();
				String pass2=password2.getText();
				int length=ct.length();
				
				Boolean usernameCheck=check(um);
				if(usernameCheck==false) {
					if(nm.equals("")||um.equals("")||em.equals("")||pass.equals("")||sq.equals("")||ct.equals("")) {
						 JOptionPane.showMessageDialog(null,"Please fill form correctly..");
					}
					else if(!pass.equals(pass2)) {
						 JOptionPane.showMessageDialog(null,"Password does not match");
					}
					else if(length>10||length<10){
						JOptionPane.showMessageDialog(null,"Contact cannot be less or more than 10");
					}
					else {
					 try {
						Connection con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						String sql="insert into customer"
					            +"(name,username,password,contact,email,security)"
					            +"Values(?,?,?,?,?,?)";
						PreparedStatement pst=con.prepareStatement(sql);
						pst.setString(1, nm);
						pst.setString(2, um);
						pst.setString(3, pass);
						pst.setString(4, ct);
						pst.setString(5, em);
						pst.setString(6,sq );
						pst.executeUpdate();
					 } catch (SQLException e) {
						e.printStackTrace();
					} 

					  JOptionPane.showMessageDialog(null,"Account Created Successfully..");
					  frame.dispose();
					  lobby lobby=new  lobby();
					  lobby.frame.setVisible(true);
				
				}
				
					}else {
						 JOptionPane.showMessageDialog(null,"Username already exits");
					}
					}
			
		});
		btnNewButton.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 16));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(218, 387, 161, 34);
		panel.add(btnNewButton);
		
		password = new JPasswordField();
		password.setBounds(259, 250, 190, 20);
		panel.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Which is your favourite City?");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(190, 315, 204, 24);
		panel.add(lblNewLabel_1);
		
		JLabel label = new JLabel("Your Information:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		label.setBounds(218, 42, 144, 25);
		panel.add(label);
		
		password2 = new JPasswordField();
		
		password2.setBounds(259, 284, 190, 20);
		panel.add(password2);
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setForeground(Color.WHITE);
		lblConfirmPassword.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		lblConfirmPassword.setBounds(125, 282, 111, 23);
		panel.add(lblConfirmPassword);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			lobby lobby = new lobby();
			lobby.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		btnNewButton_1.setBounds(23, 26, 89, 34);
		panel.add(btnNewButton_1);
	}
	public static boolean check(String um) {
		boolean usernameExists=false;
		Connection conTest;
		try {
		conTest = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		String sqlCheck="select username from customer";
		PreparedStatement pstCheck =conTest.prepareStatement(sqlCheck);
		ResultSet rsCheck = pstCheck.executeQuery();
		while(rsCheck.next()) {
			String uname=rsCheck.getString("username");
			if(uname.equals(um)) {
				usernameExists=true;
			}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
		return usernameExists;
	}
}


