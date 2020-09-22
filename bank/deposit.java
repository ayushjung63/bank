package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.mail.NoSuchProviderException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;

public class deposit {

	JFrame frame;
	private JTextField depositAmount;
	private JTextField accNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit window = new deposit();
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
	public deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		depositAmount = new JTextField();
		depositAmount.setFont(new Font("Tahoma", Font.ITALIC, 19));
		depositAmount.setBounds(216, 167, 176, 34);
		frame.getContentPane().add(depositAmount);
		depositAmount.setColumns(10);
		
		JLabel depositLabel = new JLabel("Deposit Amount:");
		depositLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		depositLabel.setBounds(63, 166, 155, 34);
		frame.getContentPane().add(depositLabel);
		
		JLabel lblNewLabel = new JLabel("Amount Deposit");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblNewLabel.setBounds(169, 79, 160, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JButton buttonDeposit = new JButton("Deposit");
		buttonDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num=Integer.parseInt(accNum.getText());
				int amount=Integer.parseInt(depositAmount.getText());
				String checkEmail = null;
				try {
					Connection conCheck = DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
					String checkSql="Select * from customers where id=?";
				     PreparedStatement checkPst=conCheck.prepareStatement(checkSql);
				     checkPst.setInt(1,num);
				     ResultSet checkRs=checkPst.executeQuery();
				     while(checkRs.next()) {
				     checkEmail=checkRs.getString("email");
				     }
				}catch (SQLException ex) {}
				
				
				
				try{
		          String sql="update customers set balance=balance+?, last_deposited=? where id=?";
		          Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
		          PreparedStatement pst =con.prepareStatement(sql);
		          pst.setInt(3,num);
		          pst.setInt(1,amount);
		          pst.setInt(2, amount);
		          pst.executeUpdate();
		          JOptionPane.showMessageDialog(null,"Cash Deposited Successfully..");
		          try {
					depositMsg.main(amount,num,checkEmail);
				} catch (NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				catch (SQLException ex) {
				}  
				frame.dispose();
				user user = new user();
				user.frmBankingManagementSystem.setVisible(true);
			}
		});
		buttonDeposit.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 20));
		buttonDeposit.setBackground(new Color(135, 206, 235));
		buttonDeposit.setBounds(172, 228, 117, 40);
		frame.getContentPane().add(buttonDeposit);
		
		accNum = new JTextField();
		accNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				int num=Integer.parseInt(accNum.getText());
				 try { 
						Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root",""); 
						String checkSql="Select id from customers";
					     PreparedStatement checkPst=con.prepareStatement(checkSql);
					     ResultSet checkRs=checkPst.executeQuery();
					     
					     while(checkRs.next()) {
					    	 if(checkRs.getInt("id")==num) {
					    		 JOptionPane.showMessageDialog(null,"Account Found");
					    		  break;
					    	 }else {
					    		 //JOptionPane.showMessageDialog(null,"No Account Found");
					    		 //break;
					    	 }
					     }
					     
					   }catch(SQLException ex) {}
			}
		});
		
		
		accNum.setFont(new Font("Tahoma", Font.ITALIC, 19));
		accNum.setColumns(10);
		accNum.setBounds(216, 119, 176, 25);
		frame.getContentPane().add(accNum);
		
		JLabel lblEnterAccountNumber = new JLabel("Account Number:");
		lblEnterAccountNumber.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblEnterAccountNumber.setBounds(63, 114, 155, 34);
		frame.getContentPane().add(lblEnterAccountNumber);
		
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
		button.setBounds(6, 11, 108, 34);
		frame.getContentPane().add(button);
	}

}
