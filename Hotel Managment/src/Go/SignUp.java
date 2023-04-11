package Go;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtMail;
	private JTextField txtAns;
	private JTextField txtAdd;
	Connection con;
	Statement stmt;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		
		con = DataBase.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(671, 129, 111, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(64, 0, 64));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(469, 171, 72, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBackground(new Color(64, 0, 64));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(469, 225, 72, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_1.setBackground(new Color(64, 0, 64));
		lblNewLabel_2_1_1.setBounds(469, 276, 89, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Security Quection");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_2.setBackground(new Color(64, 0, 64));
		lblNewLabel_2_1_2.setBounds(469, 328, 144, 27);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Answer");
		lblNewLabel_2_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_3.setBackground(new Color(64, 0, 64));
		lblNewLabel_2_1_3.setBounds(469, 379, 72, 27);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Address");
		lblNewLabel_2_1_4.setForeground(Color.WHITE);
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1_4.setBackground(new Color(64, 0, 64));
		lblNewLabel_2_1_4.setBounds(469, 435, 72, 27);
		contentPane.add(lblNewLabel_2_1_4);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtName.setBounds(648, 175, 278, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMail.setColumns(10);
		txtMail.setBounds(648, 227, 278, 25);
		contentPane.add(txtMail);
		
		txtAns = new JTextField();
		txtAns.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAns.setColumns(10);
		txtAns.setBounds(648, 379, 278, 27);
		contentPane.add(txtAns);
		
		txtAdd = new JTextField();
		txtAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtAdd.setColumns(10);
		txtAdd.setBounds(648, 437, 278, 25);
		contentPane.add(txtAdd);
		
		String[] quection = {"What is name your first pet","What was your first car"};
		JComboBox comboBox = new JComboBox(quection);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(648, 329, 278, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					stmt = con.createStatement();
					
					String name = txtName.getText();
					String mail = txtMail.getText();
					String password = passwordField.getText();
					String security = (String)comboBox.getSelectedItem();
					String answer = txtAns.getText();
					String address = txtAdd.getText();
					if(name.equals("") || mail.equals("") || password.equals("") || answer.equals("") || address.equals("") ) {
						
						JOptionPane.showMessageDialog(null,"Every field is required");
					}else {
						
						String query = ("INSERT INTO signup(name,email,password,security,answer,address,status) VALUES(?,?,?,?,?,?,?)");
						
						PreparedStatement pre = con.prepareStatement(query);
						pre.setString(1,name);
						pre.setString(2,mail);
						pre.setString(3,password);
						pre.setString(4,security);
						pre.setString(5,answer);
						pre.setString(6,address);
						pre.setString(7,"false");
						
						pre.execute();
						JOptionPane.showMessageDialog(null,"Successful registered");
						new SignUp().setVisible(true);
						
					}
					
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(469, 497, 85, 27);
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new Login().setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 0, 0));
		btnLogin.setBounds(633, 497, 85, 27);
		contentPane.add(btnLogin);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnForgotPassword.setForeground(new Color(255, 255, 255));
		btnForgotPassword.setBackground(new Color(255, 0, 0));
		btnForgotPassword.setBounds(784, 497, 183, 27);
		contentPane.add(btnForgotPassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\signup.PNG"));
		lblNewLabel_1.setBounds(0, 0, 1373, 704);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(64, 0, 64));
		passwordField.setBounds(648, 282, 278, 27);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("New label");
		label.setBounds(1283, 50, 45, 13);
		contentPane.add(label);
		
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
		btnNewButton_1.setBounds(1336, 10, 27, 18);
		contentPane.add(btnNewButton_1);
	}
}
