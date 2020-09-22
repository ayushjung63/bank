package onlinehouserenting;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.html.Option;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class owner {

	JFrame frame;
	private JTextField owName;
	private JTextField owContact;
	private JTextField rentRoom;
	private JTextField location;
	private JTextField owEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					owner window = new owner();
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
	public owner() {
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
				String dbAddress;
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
									 
							owName.setText(dbName);
							owEmail.setText(dbEmail);
							owContact.setText(dbContact);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		frame.setBounds(100, 100, 750, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		owName = new JTextField();
		owName.setBounds(134, 65, 150, 20);
		frame.getContentPane().add(owName);
		owName.setColumns(10);
		
		owContact = new JTextField();
		owContact.setColumns(10);
		owContact.setBounds(438, 65, 165, 20);
		frame.getContentPane().add(owContact);
		
		rentRoom = new JTextField();
		rentRoom.setColumns(10);
		rentRoom.setBounds(344, 207, 156, 20);
		frame.getContentPane().add(rentRoom);
		
		location = new JTextField();
		location.setColumns(10);
		location.setBounds(344, 239, 156, 20);
		frame.getContentPane().add(location);
		
		JLabel lblNewLabel = new JLabel("Your Name:");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblNewLabel.setBounds(44, 64, 80, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblContact = new JLabel("Contact:");
		lblContact.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblContact.setBounds(374, 64, 61, 17);
		frame.getContentPane().add(lblContact);
		
		JLabel lblRoomsAvailable = new JLabel("Rooms Available:");
		lblRoomsAvailable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblRoomsAvailable.setBounds(220, 179, 114, 17);
		frame.getContentPane().add(lblRoomsAvailable);
		
		JLabel lblRentRoom = new JLabel("Rent per room:");
		lblRentRoom.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblRentRoom.setBounds(230, 210, 104, 17);
		frame.getContentPane().add(lblRentRoom);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblLocation.setBounds(273, 238, 61, 17);
		frame.getContentPane().add(lblLocation);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblPrice.setBounds(300, 270, 34, 17);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblEmail.setBounds(255, 96, 38, 17);
		frame.getContentPane().add(lblEmail);
		
		owEmail = new JTextField();
		owEmail.setColumns(10);
		owEmail.setBounds(300, 96, 165, 20);
		frame.getContentPane().add(owEmail);
		
		JComboBox roomAvi = new JComboBox();
		roomAvi.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		roomAvi.setBounds(344, 180, 113, 20);
		frame.getContentPane().add(roomAvi);
		
		JTextArea extraDetails = new JTextArea();
		extraDetails.setText("Give extra details of room here........");
		extraDetails.setBounds(173, 334, 430, 66);
		frame.getContentPane().add(extraDetails);
		
		JLabel lblExtraInformation = new JLabel("Extra Information:");
		lblExtraInformation.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		lblExtraInformation.setBounds(292, 306, 130, 17);
		frame.getContentPane().add(lblExtraInformation);
		
		JLabel lblNewLabel_1 = new JLabel("Room Information:");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(301, 143, 156, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblYourInformation = new JLabel("Your Information:");
		lblYourInformation.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lblYourInformation.setBounds(291, 29, 144, 25);
		frame.getContentPane().add(lblYourInformation);
		
		JComboBox price = new JComboBox();
		price.setModel(new DefaultComboBoxModel(new String[] {"Fixed", "Negotiable"}));
		price.setBounds(344, 271, 113, 20);
		frame.getContentPane().add(price);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			String name=owName.getText();
			String contact=owContact.getText();
			String email=owEmail.getText();
			int room=Integer.parseInt((String)roomAvi.getSelectedItem());
			int rent=Integer.parseInt(rentRoom.getText());
			String loc=location.getText();
			String details=extraDetails.getText();
			
			 try {
				Connection con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				String sql="insert into roomdetail"
			            +"(owner,contact,email,room,rent,price,location,details)"
			            +"Values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, contact);
				pst.setString(3, email);
				pst.setInt(4, room);
				pst.setInt(5, rent);
				pst.setString(6,(String)price.getSelectedItem());
				pst.setString(7, loc);
				pst.setString(8,details);
				pst.executeUpdate();
			 } catch (SQLException e) {
				e.printStackTrace();
			} 
			  JOptionPane.showMessageDialog(null,"Details Subitted Successfully..");
			  frame.dispose();
			  viewData view = new viewData();
			  view.frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnNewButton.setBounds(338, 411, 98, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Go Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   frame.dispose();
				  viewData view = new viewData();
				  view.frame.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		button.setBackground(Color.ORANGE);
		button.setBounds(10, 11, 89, 34);
		frame.getContentPane().add(button);
		
		
	}
}
