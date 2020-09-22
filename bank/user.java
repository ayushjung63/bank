package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

public class user {

	JFrame frmBankingManagementSystem;
	 Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user window = new user();
					window.frmBankingManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		});
	}

	/**
	 * Create the application.
	 */
	public user() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankingManagementSystem = new JFrame();
		frmBankingManagementSystem.setResizable(false);
		frmBankingManagementSystem.setTitle("Banking Management System\r\n");
		frmBankingManagementSystem.setBounds(100, 100, 605, 407);
		frmBankingManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBankingManagementSystem.getContentPane().setLayout(null);
		
		JButton btnViewInfo = new JButton("View Info");
		btnViewInfo.setBackground(Color.ORANGE);
		btnViewInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frmBankingManagementSystem.dispose();
			view view= new view();
			view.frame.setVisible(true);
			
			}
		});
		btnViewInfo.setToolTipText("View your bank status");
		btnViewInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewInfo.setBounds(173, 88, 185, 43);
		frmBankingManagementSystem.getContentPane().add(btnViewInfo);
		
		JButton button_1 = new JButton("Cash WithDraw");
		button_1.setForeground(Color.BLACK);
		button_1.setBackground(Color.CYAN);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankingManagementSystem.dispose();
				withdraw withdraw=new withdraw();
				withdraw.frame.setVisible(true);
			
			}
		});
		button_1.setToolTipText("Cash with draw");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(173, 231, 185, 43);
		frmBankingManagementSystem.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Cash Deposit");
		button_2.setBackground(Color.CYAN);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBankingManagementSystem.dispose();
				deposit window=new deposit();
				window.frame.setVisible(true);
			}
			
		});
		button_2.setToolTipText("Cash Deposit");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(173, 161, 185, 43);
		frmBankingManagementSystem.getContentPane().add(button_2);
		
		JButton createAc = new JButton("Create New Account");
		createAc.setBackground(Color.GREEN);
		createAc.setForeground(Color.WHITE);
		createAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBankingManagementSystem.dispose();
				createAc create =new createAc();
				create.frame.setVisible(true);
				
			}
		});
		createAc.setToolTipText("Create New Account");
		createAc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createAc.setBounds(173, 306, 185, 43);
		frmBankingManagementSystem.getContentPane().add(createAc);
		
		JLabel lblNewLabel = new JLabel("Bank Management System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.PLAIN, 30));
		lblNewLabel.setBounds(110, 11, 339, 51);
		frmBankingManagementSystem.getContentPane().add(lblNewLabel);
	}
}
