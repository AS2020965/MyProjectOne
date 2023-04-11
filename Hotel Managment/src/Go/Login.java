package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPass;
	Connection con;
	Statement stmt;
	ResultSet rs;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	
	private void showPActionPerformed(final java.awt.event.ActionEvent evt) {
		
        /*if(showP.isSelected()){
			
			txtPass.setEchoChar((char)0);
			
		}
		else{
			
			txtPass.setEchoChar('*');
			
		}*/
	}
	
	public Login() {
		
		con = DataBase.connection();
		//showP = new JCheckBox("show password");
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(656, 254, 122, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(464, 313, 88, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(464, 362, 114, 25);
		contentPane.add(lblNewLabel_1_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(623, 315, 252, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPass.setBounds(623, 364, 252, 26);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					//stmt = con.createStatement();
					//String query = "SELECT * FROM signup";
					
					String userName = txtName.getText();
					String password = txtPass.getText();
					if(userName.equals("") || password.equals("")) {
						
						JOptionPane.showMessageDialog(null,"Every field is required");
						
						
					}else if(userName.equals("admin") && password.equals("admin123")) {
						
						setVisible(false);
						new Admin().setVisible(true);
						
						
					}
					
					//ResultSet rs = stmt.executeQuery(query);
					
					
					
					
					
				}catch(Exception r) {
					
					System.out.println(r);
					
					
				}
				
				try {
					
					stmt = con.createStatement();
					
                    String query = "SELECT * FROM signup";
					
					String userName = txtName.getText();
					String password = txtPass.getText();
					
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						/*if(userName.equals("") || password.equals("")) {
							
							JOptionPane.showMessageDialog(null,"Every field is required");
							break;
							
						}else if(userName.equals("admin") && password.equals("admin123")) {
							
							setVisible(false);
							new Admin().setVisible(true);
							break;
							
						}*/
						
						if(userName.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
							
							//JOptionPane.showMessageDialog(null,"Login Sucsessful");
							setVisible(false);
							new Home().setVisible(true);
							break;
							
							
						}else {
							
							JOptionPane.showMessageDialog(null,"Login fail");
							
						}
						
					}
					
					
					
				}catch(Exception r) {
					
					System.out.println(r);
					
				}
				

				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(467, 419, 85, 25);
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new SignUp().setVisible(true);
			}
		});
		btnSignup.setBackground(new Color(255, 0, 0));
		btnSignup.setForeground(new Color(255, 255, 255));
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSignup.setBounds(602, 419, 96, 25);
		contentPane.add(btnSignup);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new Forgot().setVisible(true);
			}
		});
		btnForgotPassword.setBackground(new Color(255, 0, 0));
		btnForgotPassword.setForeground(new Color(255, 255, 255));
		btnForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnForgotPassword.setBounds(739, 419, 167, 25);
		contentPane.add(btnForgotPassword);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\login.PNG"));
		lblNewLabel_2.setBounds(0, 0, 1398, 704);
		contentPane.add(lblNewLabel_2);
	}
}
