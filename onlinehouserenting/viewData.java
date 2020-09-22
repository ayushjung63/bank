package onlinehouserenting;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class viewData {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewData window = new viewData();
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
	public viewData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		
		frame = new JFrame();
		
		frame.setBounds(100, 100, 902, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE HOUSE RENTING");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblNewLabel.setBounds(305, 11, 276, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(37, 161, 266, 268);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Rooms Available:");
		label.setBounds(10, 14, 114, 17);
		panel.add(label);
		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel room = new JLabel("");
		room.setBounds(129, 11, 80, 17);
		panel.add(room);
		room.setBackground(Color.WHITE);
		
		JLabel label_2 = new JLabel("Rent per room:");
		label_2.setBounds(20, 45, 104, 17);
		panel.add(label_2);
		label_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel rent = new JLabel("");
		rent.setBounds(134, 49, 80, 13);
		panel.add(rent);
		rent.setBackground(Color.WHITE);
		
		JLabel label_4 = new JLabel("Location:");
		label_4.setBounds(63, 73, 61, 17);
		panel.add(label_4);
		label_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel location = new JLabel("");
		location.setBounds(134, 77, 80, 13);
		panel.add(location);
		location.setBackground(Color.WHITE);
		
		JLabel label_6 = new JLabel("Price:");
		label_6.setBounds(90, 97, 34, 17);
		panel.add(label_6);
		label_6.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel price = new JLabel("");
		price.setBounds(134, 97, 80, 17);
		panel.add(price);
		price.setBackground(Color.WHITE);
		
		JTextArea extra = new JTextArea();
		extra.setBounds(129, 125, 126, 33);
		panel.add(extra);
		extra.setEditable(false);
		
		JLabel label_8 = new JLabel("Extra Information:");
		label_8.setBounds(10, 133, 130, 17);
		panel.add(label_8);
		label_8.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel label_9 = new JLabel("Your Name:");
		label_9.setBounds(44, 165, 80, 17);
		panel.add(label_9);
		label_9.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel name = new JLabel("");
		name.setBounds(134, 165, 80, 13);
		panel.add(name);
		name.setBackground(Color.WHITE);
		
		JLabel label_11 = new JLabel("Contact:");
		label_11.setBounds(63, 193, 61, 17);
		panel.add(label_11);
		label_11.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
		
		JLabel contact = new JLabel("");
		contact.setBounds(134, 193, 80, 17);
		panel.add(contact);
		contact.setBackground(Color.WHITE);
		
		JButton button = new JButton("APPLY");
		button.setBounds(96, 220, 89, 23);
		panel.add(button);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.CYAN);
		
		JButton btnNewButton_1 = new JButton("My Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
			frame.dispose();
			profile prof=new profile();
			prof.frame.setVisible(true);
			}
		});
		
		
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
		btnNewButton_1.setBounds(772, 10, 104, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnLogou = new JButton("Logout");
		btnLogou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			lobby lobby = new lobby();
			lobby.frame.setVisible(true);
			}
		});
		btnLogou.setForeground(Color.WHITE);
		btnLogou.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
		btnLogou.setBackground(Color.RED);
		btnLogou.setBounds(772, 49, 104, 31);
		frame.getContentPane().add(btnLogou);
		
		JButton btnAddRoom = new JButton("Add Room");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			owner owner=new owner();
			owner.frame.setVisible(true);
			}
		});
		btnAddRoom.setForeground(Color.DARK_GRAY);
		btnAddRoom.setFont(new Font("Segoe UI Emoji", Font.ITALIC, 14));
		btnAddRoom.setBackground(Color.CYAN);
		btnAddRoom.setBounds(772, 86, 104, 31);
		frame.getContentPane().add(btnAddRoom);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 127, 866, 464);
	
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				 try {
						Connection con = DriverManager.getConnection("JDBC:mysql://localhost:3306/houserent?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
						String sql="select * from roomdetail";
						PreparedStatement pst=con.prepareStatement(sql);
						ResultSet rs= pst.executeQuery();
						
//						while(rs.next()){
//						String nameDB=rs.getString("owner");
//						String contactDB=rs.getString("contact");
//						String emailDB=rs.getString("email");
//						int roomDB=rs.getInt("room");
//						int rentDB=rs.getInt("rent");
//						String priceDB =rs.getString("price");
//						String locDB=rs.getString("location");
//						String detailsDB=rs.getString("details");;
//						System.out.println(nameDB+contactDB+emailDB+roomDB+priceDB+locDB+detailsDB);
//						
//						name.setText(nameDB);
//						contact.setText(contactDB);
//						room.setText(Integer.toString(roomDB));
//						rent.setText(Integer.toString(rentDB));
//						price.setText(priceDB);
//						location.setText(locDB);
//						extra.setText(detailsDB);
//						}
						
						
						
				 } catch (SQLException ex) {
						ex.printStackTrace();
					} 		
	
						
				
			}
		});
		
		
		
		   
	}
}
