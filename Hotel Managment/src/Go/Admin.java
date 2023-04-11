package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable table;
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
					Admin frame = new Admin();
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
	public Admin() {
		
		con = DataBase.connection();
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				try {
					
					stmt = con.createStatement();
					
					String query = "SELECT * FROM signup";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						
						String name = rs.getString(1);
						String mail = rs.getString(2);
						
						String security = rs.getString(4);
						
						String address = rs.getString(6);
						String status = rs.getString(7);
						
						String tbData[] = {name,mail,security,address,status};
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
						
						
						
					}
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1387,741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(42, 35, 400, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to logout ","select",JOptionPane.YES_NO_OPTION);
				if(a==0){
					
					setVisible(false);
					new Login().setVisible(true);
					
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\logout.png"));
		btnNewButton.setBounds(1083, 26, 142, 50);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close application ","select",JOptionPane.YES_NO_OPTION);
				if(a==0){
					
					System.exit(0);
				}
					
				
				
			}
		});
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\exit.png"));
		btnExit.setBounds(1236, 26, 127, 50);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("Search by name or Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(344, 131, 238, 22);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(629, 133, 298, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					stmt = con.createStatement();
					String name = txtName.getText();
					
					String query = "SELECT * FROM signup";
					
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						if(name.equals(rs.getString(1))) {
							
						    table.setModel(new DefaultTableModel(null,new String[]{"Name","Email","Security Quection","Address","Status"}));
							
							String name_1 = rs.getString(1);
							String mail = rs.getString(2);
							
							String security = rs.getString(4);
							
							String address = rs.getString(6);
							String status = rs.getString(7);
							
							String tbData[] = {name_1,mail,security,address,status};
							DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
							
							tblModel.addRow(tbData);
							
							
							
						}
						else {
							
							//JOptionPane.showMessageDialog(null,"no name");
							//break;
						}
					}
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 0, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(955, 131, 97, 25);
		contentPane.add(btnNewButton_2);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseClicked(MouseEvent e) {
				
				/*int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String mail = model.getValueAt(index,1).toString();
				String status = model.getValueAt(index,4).toString();
				if(status.equals("true")) {
					
					status = "false";
					
					
				}else {
					
					status = "false";
				}
				try {
					
					int a = JOptionPane.showConfirmDialog(null,"Do you really want to change status of"+mail+"","Selecet",JOptionPane.YES_NO_OPTION );
					if(a==0) {
						
						stmt = con.createStatement();
						
						String query = "UPDATE signup SET status = ?, WHERE email = ?";
						
						PreparedStatement pre = con.prepareStatement(query);
						
						pre.setString(1,status);
						pre.setString(2,mail);
						
						pre.executeUpdate();
						
						setVisible(false);
						new Admin().setVisible(true);
						
					}
					
				}catch(Exception r) {
					
					System.out.println(r);
				}*/
				
			//}
			//@Override
			public void mouseEntered(MouseEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String mail = model.getValueAt(index,1).toString();
				String status = model.getValueAt(index,4).toString();
				if(status.equals("true")) {
					
					status = "false";
					
					
				}else {
					
					status = "true";
				}
				try {
					stmt = con.createStatement();
					int a = JOptionPane.showConfirmDialog(null,"Do you really want to change status of"+mail+"","Selecet",JOptionPane.YES_NO_OPTION );
					if(a==0) {
						
						
						
						String query = ("UPDATE signup SET status = ? WHERE email = ?");
						
						PreparedStatement pre = con.prepareStatement(query);
						
						pre.setString(1,status);
						pre.setString(2,mail);
						
						pre.executeUpdate();
						
						setVisible(false);
						new Admin().setVisible(true);
						
					}
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
				
				
			}
		});
		scrollPane.setBounds(69, 216, 1105, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Email", "Security Quection", "Address", "Status"
			}
		));
		
		JButton btnNewButton_3 = new JButton("Clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new Admin().setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(1266, 132, 79, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\admin Home.png"));
		lblNewLabel_2.setBounds(0, 0, 1405, 734);
		contentPane.add(lblNewLabel_2);
	}
}
