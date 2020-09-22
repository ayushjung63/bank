package onlinehouserenting;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigInteger;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class admin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
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
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 894, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel name = new JLabel("New label");
		name.setBounds(10, 25, 73, 14);
		frame.getContentPane().add(name);
		
		JLabel contact = new JLabel("New label");
		contact.setBounds(187, 25, 73, 14);
		frame.getContentPane().add(contact);
		
		JLabel email = new JLabel("New label");
		email.setBounds(284, 25, 73, 14);
		frame.getContentPane().add(email);
		
		JLabel username = new JLabel("New label");
		username.setBounds(374, 25, 73, 14);
		frame.getContentPane().add(username);
		
		JLabel password = new JLabel("New label");
		password.setBounds(469, 25, 73, 14);
		frame.getContentPane().add(password);
		
		JLabel answer = new JLabel("New label");
		answer.setBounds(563, 25, 73, 14);
		frame.getContentPane().add(answer);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			
				 try {
						Connection con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						String sql="select * from customer";
						PreparedStatement pst=con.prepareStatement(sql);
						ResultSet rs= pst.executeQuery();
						 ResultSetMetaData md = rs.getMetaData();
						
				        	 while(rs.next()) {
									
									String nameDB=rs.getString("name");
									String contactDB=rs.getString("contact");
									String emailDB=rs.getString("email");
									String usernameDB=rs.getString("username");
									String pwDB =rs.getString("password");
									String security=rs.getString("security");
									
									System.out.println(nameDB+contactDB+emailDB+usernameDB+pwDB+security);
									name.setText(nameDB);
									contact.setText(contactDB);
									email.setText(emailDB);
									username.setText(usernameDB);
									password.setText(pwDB);
									answer.setText(security);
									} 
				            
						
					 } catch (SQLException ex) {
						ex.printStackTrace();
					} 
			}
		});
		
	}
}
