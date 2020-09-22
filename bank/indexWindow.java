package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class indexWindow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					indexWindow window = new indexWindow();
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
	public indexWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton createAc = new JButton("Create New Account");
		createAc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			createAc create =new createAc();
			create.frame.setVisible(true);
			indexWindow window=new indexWindow();
			window.frame.setVisible(false);
			}
		});
		createAc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		createAc.setToolTipText("Create New Account");
		createAc.setBounds(117, 177, 185, 43);
		frame.getContentPane().add(createAc);
		
		JLabel title = new JLabel("Online Banking\r\n\r\n");
		title.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		title.setBounds(147, 11, 155, 27);
		frame.getContentPane().add(title);
		
		JLabel title2 = new JLabel("Shady Bank Limited");
		title2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		title2.setBounds(129, 37, 197, 38);
		frame.getContentPane().add(title2);
		
		JButton login = new JButton("Login\r\n");
		login.setFont(new Font("Arial", Font.PLAIN, 17));
		login.setBounds(117, 105, 185, 43);
		frame.getContentPane().add(login);
	}
}
