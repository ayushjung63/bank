package onlinehouserenting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class profile {

	JFrame frame;
	private JTextField name;
	private JTextField username;
	private JTextField contact;
	private JTextField email;
	private JButton button;
	private JButton edit;
	private JButton save;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profile window = new profile();
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
	public profile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				String dbEmail;
				String dbContact;
				String dbName;
				save.setVisible(false);
				edit.setVisible(true);
				String user=lobby.getUser1();
				
			
					Connection con;
					try {
						con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						String sql="select * from customer where username=?";
						PreparedStatement pst = con.prepareStatement(sql);
						pst.setString(1,user);
						ResultSet rs=pst.executeQuery();
						while(rs.next()) {
							 dbEmail = rs.getString("email");
							 dbContact=rs.getString("contact");
							 dbName=rs.getString("name");
							System.out.println(dbContact+dbEmail+dbName);
							username.setText(user);
							name.setText(dbName);
							email.setText(dbEmail);
							contact.setText(dbContact);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			
			}
		});
		frame.setBounds(100, 100, 606, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblMyProfile.setBounds(219, 11, 132, 21);
		frame.getContentPane().add(lblMyProfile);
		
		JLabel label = new JLabel("Name:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		label.setBounds(124, 92, 46, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		label_1.setBounds(105, 131, 65, 23);
		frame.getContentPane().add(label_1);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(193, 94, 190, 21);
		frame.getContentPane().add(name);
		
		username = new JTextField();
		username.setEditable(false);
		username.setColumns(10);
		username.setBounds(193, 133, 190, 21);
		frame.getContentPane().add(username);
		
		contact = new JTextField();
		contact.setEditable(false);
		contact.setColumns(10);
		contact.setBounds(193, 176, 190, 21);
		frame.getContentPane().add(contact);
		
		JLabel label_2 = new JLabel("Contact:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		label_2.setBounds(118, 179, 52, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		label_3.setBounds(124, 213, 46, 23);
		frame.getContentPane().add(label_3);
		
		email = new JTextField();
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(193, 215, 190, 21);
		frame.getContentPane().add(email);
		
		button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			viewData view=new viewData();
			view.frame.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 10));
		button.setBackground(Color.ORANGE);
		button.setBounds(10, 11, 90, 30);
		frame.getContentPane().add(button);
		
		edit = new JButton("Edit Profile");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setEditable(true);
				username.setEditable(false);
				contact.setEditable(true);
				email.setEditable(true);
				edit.setVisible(false);
				save.setVisible(true);
			}
		});
		edit.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 16));
		edit.setBackground(Color.CYAN);
		edit.setBounds(193, 265, 132, 34);
		frame.getContentPane().add(edit);
		
		save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=lobby.getUser1();
				String upName=name.getText();
				String upEmail=email.getText();
				String upContact=contact.getText();
				Connection con;
				try {
					con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					String sql="update  customer set name=?,contact=?,email=? where username=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,upName);
					pst.setString(2,upContact);
					pst.setString(3,upEmail);
					pst.setString(4, user);
					pst.executeUpdate();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				save.setVisible(false);
				edit.setVisible(true);
			}
		});
		save.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 16));
		save.setBackground(Color.CYAN);
		save.setBounds(193, 265, 132, 34);
		frame.getContentPane().add(save);
	}
}
