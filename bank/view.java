package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class view {

	JFrame frame;
	private JTextField name;
	private JTextField number;
	private JTextField accType;
	private JTextField deposit;
	private JTextField withdraw;
	private JTextField balance;
	private JTextField accNumber;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view window = new view();
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
	public view() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton view = new JButton("View");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(accNumber.getText());
				try {    
				      Connection con= DriverManager.getConnection("JDBC:mysql://localhost:3306/bank?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");  
				    		 String sql= "select * from customers where id=?";
				    		 PreparedStatement pst = con.prepareStatement(sql);  
						      pst.setInt(1,num);
				    		 ResultSet rs = pst.executeQuery();  

						      while(rs.next()) {
						    	 String nm=rs.getString("name");
						    	 int id=rs.getInt("id");
						    	 String ac=rs.getString("ac_type");
						    	 int depo=rs.getInt("last_deposited");
						    	 int draw=rs.getInt("last_withdraw");
						    	 int ba=rs.getInt("balance");

						        name.setText(nm);
						        number.setText(Integer.toString(id));
						        accType.setText(ac);
						        deposit.setText(Double.toString(depo));
						        withdraw.setText(Double.toString(draw));
						        balance.setText(Double.toString(ba));
						      }
				     } catch (SQLException ex) {    
				     }  	
				
			
			}
		});
		view.setBounds(306, 47, 88, 23);
		frame.getContentPane().add(view);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 92, 377, 224);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		nameLabel.setBounds(10, 11, 43, 14);
		panel.add(nameLabel);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblAccountNumber.setBounds(10, 36, 121, 14);
		panel.add(lblAccountNumber);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(10, 96, 348, 117);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Last Deposited:");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 110, 21);
		panel_1.add(lblNewLabel);
		
		JLabel lblLastWithdraw = new JLabel("Last Withdraw:");
		lblLastWithdraw.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblLastWithdraw.setBounds(10, 45, 110, 21);
		panel_1.add(lblLastWithdraw);
		
		deposit = new JTextField();
		deposit.setBackground(SystemColor.controlHighlight);
		deposit.setEditable(false);
		deposit.setColumns(10);
		deposit.setBounds(118, 11, 145, 20);
		panel_1.add(deposit);
		
		withdraw = new JTextField();
		withdraw.setBackground(SystemColor.controlHighlight);
		withdraw.setEditable(false);
		withdraw.setColumns(10);
		withdraw.setBounds(118, 43, 145, 20);
		panel_1.add(withdraw);
		
		balance = new JTextField();
		balance.setBackground(SystemColor.controlHighlight);
		balance.setEditable(false);
		balance.setColumns(10);
		balance.setBounds(118, 71, 145, 20);
		panel_1.add(balance);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblBalance.setBounds(10, 73, 110, 21);
		panel_1.add(lblBalance);
		
		JLabel lblAccountType = new JLabel("Account type:");
		lblAccountType.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		lblAccountType.setBounds(10, 61, 99, 14);
		panel.add(lblAccountType);
		
		name = new JTextField();
		name.setForeground(SystemColor.desktop);
		name.setBackground(SystemColor.controlHighlight);
		name.setEditable(false);
		name.setBounds(63, 8, 212, 20);
		panel.add(name);
		name.setColumns(10);
		
		number = new JTextField();
		number.setBackground(SystemColor.controlHighlight);
		number.setEditable(false);
		number.setColumns(10);
		number.setBounds(132, 33, 143, 20);
		panel.add(number);
		
		accType = new JTextField();
		accType.setBackground(SystemColor.controlHighlight);
		accType.setEditable(false);
		accType.setColumns(10);
		accType.setBounds(105, 61, 170, 20);
		panel.add(accType);
		
		accNumber = new JTextField();
		accNumber.setBounds(129, 48, 148, 20);
		frame.getContentPane().add(accNumber);
		accNumber.setColumns(10);
		
		JLabel label = new JLabel("Account Number:");
		label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 15));
		label.setBounds(10, 51, 121, 14);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("View Account Info");
		lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(129, 11, 193, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
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
		button.setBounds(10, 10, 96, 30);
		frame.getContentPane().add(button);
	}
}
