package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private JTextField txtAns;
	private JPasswordField txtPass;
	private JTextField txtSec;
	
	Connection con;
	Statement stmt;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
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
	public Forgot() {
		
		con = DataBase.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(600, 155, 236, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(387, 197, 84, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Securty Quection");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(387, 245, 178, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Answer");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(387, 296, 84, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("New Password");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(387, 352, 157, 28);
		contentPane.add(lblNewLabel_1_3);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMail.setBounds(587, 200, 267, 28);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtAns = new JTextField();
		txtAns.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAns.setColumns(10);
		txtAns.setBounds(587, 299, 267, 28);
		contentPane.add(txtAns);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPass.setBounds(587, 355, 267, 28);
		contentPane.add(txtPass);
		
		txtSec = new JTextField();
		txtSec.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSec.setColumns(10);
		txtSec.setBounds(587, 248, 267, 28);
		contentPane.add(txtSec);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String quection = txtSec.getText();
				String answer = txtAns.getText();
				String password = txtPass.getText();
				String mail = txtMail.getText();
				
				if(answer.equals("") || password.equals("")) {
					
					JOptionPane.showMessageDialog(null,"All field is required");
					
					
					
				}
				else {
					
					try {
						
						stmt = con.createStatement();
						
						String query = "SELECT * FROM signup";
						
						rs = stmt.executeQuery(query);
						//String query2 = "UPDATE signup SET password = ? WHERE email = ? ";
						
						while(rs.next()) {
							
							if(answer.equals(rs.getString(5))) {
								
								String query2 = "UPDATE signup SET password = ? WHERE email = ? ";
								
								PreparedStatement pre = con.prepareStatement(query2);
								
								pre.setString(1,password);
								pre.setString(2,mail);
								
								//pre.executeUpdate();
								JOptionPane.showMessageDialog(null,"update sucessful");
								setVisible(false);
								new Forgot().setVisible(true);
								
								pre.executeUpdate();
								
								
							}
							else {
								
								JOptionPane.showMessageDialog(null,"error");
								
							}
							break;
							
						}
					
						
						
					}catch(Exception r) {
						
						System.out.println(r);
					}
				}
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(435, 408, 85, 28);
		contentPane.add(btnNewButton);
		
		JButton btnSign = new JButton("Signup");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new SignUp().setVisible(true);
			}
		});
		btnSign.setForeground(Color.WHITE);
		btnSign.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSign.setBackground(Color.RED);
		btnSign.setBounds(644, 408, 85, 28);
		contentPane.add(btnSign);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBackground(Color.RED);
		btnLogin.setBounds(854, 408, 85, 28);
		contentPane.add(btnLogin);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mail = txtMail.getText();
				int check = 0;
				
				if(mail.equals("")) {
					
					check = 1;
					JOptionPane.showMessageDialog(null,"Email field is require");
					
					
				}
				else {
					
					try {
						//check = 1;
						
						stmt = con.createStatement();
						//mail = txtMail.getText();
						String query = "SELECT * FROM signup";
						
						rs = stmt.executeQuery(query);
						
						while(rs.next()) {
							
							//JOptionPane.showMessageDialog(null,"oooooooooooooooook");
							if(mail.equals(rs.getString(2))) {
								
								//JOptionPane.showMessageDialog(null,"oooooooooooooooook");
								check = 1;
								txtSec.setEditable(false);
								txtSec.setText(rs.getString(4));
								
								
							}
						}
						
						
						
					}catch(Exception r) {
						
						System.out.println(r);
						
					}
					
				
				if(check==0) {
					
					JOptionPane.showMessageDialog(null,"incorrect email check again");
					
				}
				}
				
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBackground(Color.RED);
		btnSearch.setBounds(895, 199, 95, 28);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\forgot password.PNG"));
		lblNewLabel_2.setBounds(0, 0, 1387, 718);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close application ","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					System.exit(0);
				}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\close.png"));
		btnNewButton_1.setBounds(1295, 22, 36, 28);
		contentPane.add(btnNewButton_1);
	}
}
