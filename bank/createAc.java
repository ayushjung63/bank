package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class createAc {

	JFrame frame;
	private JTextField name;
	private JTextField address;
	private JTextField email;
	private JTextField depositAmount;
	private JComboBox acType;
	private JTextField contact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAc window = new createAc();
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
	public createAc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 619, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setBounds(252, 82, 187, 31);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel nameLabel = new JLabel("Enter Full Name:");
		nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nameLabel.setBounds(123, 84, 121, 23);
		frame.getContentPane().add(nameLabel);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(252, 127, 187, 31);
		frame.getContentPane().add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(252, 228, 187, 31);
		frame.getContentPane().add(email);
		
		JLabel lblEnterEmailAddress = new JLabel("Enter Email Address:");
		lblEnterEmailAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEnterEmailAddress.setBounds(86, 230, 158, 23);
		frame.getContentPane().add(lblEnterEmailAddress);
		
		JLabel lblEnterAddress = new JLabel("Enter Address:");
		lblEnterAddress.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEnterAddress.setBounds(134, 129, 110, 23);
		frame.getContentPane().add(lblEnterAddress);
		
		depositAmount = new JTextField();
		depositAmount.setColumns(10);
		depositAmount.setBounds(252, 321, 187, 31);
		frame.getContentPane().add(depositAmount);
		
		acType = new JComboBox();
		acType.setFont(new Font("Tahoma", Font.ITALIC, 13));
		acType.setModel(new DefaultComboBoxModel(new String[] {"FixedDeposit", "Saving", "Current"}));
		acType.setBounds(252, 274, 187, 31);
		frame.getContentPane().add(acType);
		
		JLabel lblEnterAccountType = new JLabel("Enter Account Type:");
		lblEnterAccountType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEnterAccountType.setBounds(95, 276, 149, 23);
		frame.getContentPane().add(lblEnterAccountType);
		
		JLabel lblEnterAmountTo = new JLabel("Enter Amount to deposit:");
		lblEnterAmountTo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		lblEnterAmountTo.setBounds(64, 323, 180, 23);
		frame.getContentPane().add(lblEnterAmountTo);
		
		JLabel lblNewLabel = new JLabel("Create New Bank Account");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		lblNewLabel.setBounds(182, 11, 252, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("( Fill the form correctly leaving no input blank )");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(123, 53, 347, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton createAc = new JButton("Create Account");
		
		createAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				String nameCheck=name.getText();
				String adCheck=address.getText();
				String contCheck=contact.getText();
				String emCheck=email.getText();
				int length=contCheck.length();
				
				if(nameCheck.equals("")|| adCheck.equals("") ||contCheck.equals("")||emCheck.equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill the form correctly..");
				} else if(length>10||length<10){
					JOptionPane.showMessageDialog(null,"Contact cannot be less or more than 10");
				}
				else {
					int withdrawAmount=0;
					try{
		            String sql="insert into customers"
		            +"(name,address,contact,email,ac_type,balance,last_deposited,last_withdraw)"
		            +"Values(?,?,?,?,?,?,?,?)";
		            Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		            PreparedStatement pst =con.prepareStatement(sql);
		       
		           pst.setString(1,name.getText());
		           pst.setString(2,address.getText());
		           pst.setString(3,contact.getText());
		           pst.setString(4, email.getText());
		           pst.setString(5,(String)acType.getSelectedItem());
		           pst.setString(6,depositAmount.getText());
		           pst.setString(7,depositAmount.getText());
		           pst.setInt(8,withdrawAmount);
		           pst.executeUpdate();
		           JOptionPane.showMessageDialog(null,"Account Created Successfully..");
		           frame.dispose();
					user user = new user();
					((Window) user.frame).setVisible(true);
					}
					catch (SQLException ex) {
		       
					}  	
				}
			}
		});
		createAc.setBackground(new Color(135, 206, 235));
		createAc.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 20));
		createAc.setBounds(209, 376, 149, 40);
		frame.getContentPane().add(createAc);
		
		JLabel label = new JLabel("Enter Contact Number:");
		label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		label.setBounds(76, 171, 168, 23);
		frame.getContentPane().add(label);
		
		JLabel message = new JLabel("");
		message.setForeground(Color.RED);
		message.setFont(new Font("Tahoma", Font.ITALIC, 11));
		message.setBounds(251, 203, 277, 14);
		frame.getContentPane().add(message);
		
		
		contact = new JTextField();
		contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				String value = contact.getText();
	            int l = value.length();
	            if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9') {
	               contact.setEditable(true);
	               message.setText("");
	            } else {
	               contact.setEditable(true);
	               message.setText("* Enter only numeric digits(0-9)");
	            }
			
			}
		});
		contact.setColumns(10);
		contact.setBounds(252, 169, 187, 31);
		frame.getContentPane().add(contact);
		
		JButton button = new JButton("Go back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				user user=new user();
				user.frmBankingManagementSystem.setVisible(true);
}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 15));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(10, 8, 108, 34);
		frame.getContentPane().add(button);
		
		JLabel depositMsg = new JLabel("");
		depositMsg.setFont(new Font("Tahoma", Font.ITALIC, 11));
		depositMsg.setForeground(Color.RED);
		depositMsg.setBounds(252, 351, 218, 14);
		frame.getContentPane().add(depositMsg);
		
		depositAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				String value = depositAmount.getText();
	            int l = value.length();
	            if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9') {
	               contact.setEditable(true);
	              depositMsg.setText("");
	            } else {
	               contact.setEditable(true);
	               depositMsg.setText("Please enter valid number");
	            }
			}
		});
		
			}
}
