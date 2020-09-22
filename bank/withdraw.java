package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.mail.NoSuchProviderException;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class withdraw {

	JFrame frame;
	private JTextField withdrawAmount;
	private JTextField accNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdraw window = new withdraw();
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
	public withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnWithdraw = new JButton("WithDraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int num=Integer.parseInt(accNum.getText());
			int amount=Integer.parseInt(withdrawAmount.getText());
			int checkBalance=0;
			String checkEmail=null;
			Connection conCheck;
			try {
				conCheck = DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				String checkSql="Select * from customers where id=?";
			     PreparedStatement checkPst=conCheck.prepareStatement(checkSql);
			     checkPst.setInt(1,num);
			     ResultSet checkRs=checkPst.executeQuery();
			     while(checkRs.next()) {
			     checkBalance=checkRs.getInt("balance");
			     checkEmail=checkRs.getString("email");
			     }
				if(checkBalance<amount) {
			    	 JOptionPane.showMessageDialog(null,"Insufficient Balance!!\nPlease Try Again!!!");
			     }else {
			    	 try{
				          String sql="update customers set balance=balance-?, last_withdraw=? where id=?";
				          Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
				          PreparedStatement pst =con.prepareStatement(sql);
				          pst.setInt(3,num);
				          pst.setInt(1,amount);
				          pst.setInt(2, amount);
				          pst.executeUpdate();
				          JOptionPane.showMessageDialog(null,"Cash Withdrawn Successfully..");
				          try {
							withdrawMsg.main(amount,num,checkEmail);
						} catch (NoSuchProviderException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
						catch (SQLException ex) {
						}  
			     }
			     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.dispose();
			user user = new user();
			user.frmBankingManagementSystem.setVisible(true);
		
		}

		});
		btnWithdraw.setFont(new Font("Agency FB", Font.BOLD | Font.ITALIC, 20));
		btnWithdraw.setBackground(new Color(135, 206, 235));
		btnWithdraw.setBounds(178, 204, 117, 40);
		frame.getContentPane().add(btnWithdraw);
		
		JLabel lblWithdrawAmount = new JLabel("WithDraw Amount:");
		lblWithdrawAmount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblWithdrawAmount.setBounds(50, 144, 160, 34);
		frame.getContentPane().add(lblWithdrawAmount);
		
		withdrawAmount = new JTextField();
		withdrawAmount.setFont(new Font("Tahoma", Font.ITALIC, 19));
		withdrawAmount.setColumns(10);
		withdrawAmount.setBounds(216, 145, 176, 34);
		frame.getContentPane().add(withdrawAmount);
		
		accNum = new JTextField();
		accNum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
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
		accNum.setBounds(216, 97, 176, 25);
		frame.getContentPane().add(accNum);
		
		JLabel label_1 = new JLabel("Account Number:");
		label_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		label_1.setBounds(63, 92, 155, 34);
		frame.getContentPane().add(label_1);
		
		JLabel lblAmountWithdraw = new JLabel("Amount WithDraw");
		lblAmountWithdraw.setFont(new Font("Sitka Heading", Font.PLAIN, 20));
		lblAmountWithdraw.setBounds(167, 44, 160, 25);
		frame.getContentPane().add(lblAmountWithdraw);
		
		JButton back = new JButton("Go back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			user user= new user();
			user.frmBankingManagementSystem.setVisible(true);
			
			}
		});
		back.setBackground(Color.LIGHT_GRAY);
		back.setForeground(Color.DARK_GRAY);
		back.setFont(new Font("Segoe UI Semilight", Font.ITALIC, 15));
		back.setBounds(21, 11, 108, 34);
		frame.getContentPane().add(back);
	}
}
