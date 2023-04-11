package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Home() {
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1687, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Manage Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ManageR().setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(255, 128, 64));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\manage room.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(29, 26, 263, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customer Check In");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CustomerIn().setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setForeground(new Color(255, 128, 64));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Registration & Check IN.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(332, 26, 249, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Customer Chech Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CheckOut().setVisible(true);
				
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setForeground(new Color(255, 128, 64));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Check Out.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(630, 26, 249, 49);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Customer Details Bill");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CustomerBill().setVisible(true);
				//setVisible(true);
			}
		});
		btnNewButton_2_1.setBackground(new Color(192, 192, 192));
		btnNewButton_2_1.setForeground(new Color(255, 128, 64));
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Details Bill.png"));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBounds(926, 26, 257, 49);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close application ","select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					System.exit(0);
					//setVisible(true);
					
				}
				
			}
		});
		btnNewButton_3.setBackground(new Color(192, 192, 192));
		btnNewButton_3.setForeground(new Color(255, 128, 64));
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\exit.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(1393, 26, 137, 49);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("LogOut");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to logout application","select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					setVisible(false);
					new Login().setVisible(true);
					
					
					
				}
				
				
			}
		});
		btnNewButton_4.setBackground(new Color(192, 192, 192));
		btnNewButton_4.setForeground(new Color(255, 128, 64));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\logout.png"));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(1201, 26, 152, 49);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\home.png"));
		lblNewLabel.setBounds(0, 0, 1555, 694);
		contentPane.add(lblNewLabel);
	}
}
