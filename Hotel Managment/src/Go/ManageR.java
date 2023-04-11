package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ManageR extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNumber;
	private JTextField txtPrice;
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
					ManageR frame = new ManageR();
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
	public ManageR() {
		con = DataBase.connection();
		//Window[] size = ManageR.getOwnerlessWindows();
		 
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1387,741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Room");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\manage room.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(38, 17, 267, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 118, 726, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"R_Number", "R_Type", "B_Type", "Price"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("Room Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(926, 109, 161, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Room Type");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(926, 172, 161, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bed");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(926, 237, 161, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Price");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(926, 296, 161, 20);
		contentPane.add(lblNewLabel_1_3);
		
		txtNumber = new JTextField();
		txtNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNumber.setBounds(926, 139, 328, 23);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(926, 334, 328, 23);
		contentPane.add(txtPrice);
		
		String[] roomType = {"Ac","Non-Ac"};
		JComboBox comboBox = new JComboBox(roomType);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(926, 202, 328, 25);
		contentPane.add(comboBox);
		
		String[] bedType = {"single","double"};
		JComboBox comboBox_1 = new JComboBox(bedType);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setBounds(926, 261, 328, 25);
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Add Room");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					stmt = con.createStatement();
					
					int rNumber = Integer.parseInt(txtNumber.getText());
					String rType = (String)comboBox.getSelectedItem();
					String bType = (String)comboBox_1.getSelectedItem();
					int price = Integer.parseInt(txtPrice.getText());
					
					
					//String rType = txt
					
					String query = ("INSERT INTO manage(r_number,r_type,b_type,price) VALUES(?,?,?,?)");
					PreparedStatement pre = con.prepareStatement(query);
					pre.setInt(1,rNumber);
					pre.setString(2,rType);
					pre.setString(3,bType);
					pre.setInt(4,price);
					
					pre.execute();
					JOptionPane.showMessageDialog(null,"successful add");
					
					String query_2 = "SELECT * FROM manage";
					rs = stmt.executeQuery(query_2);
					
					while(rs.next()) {
						
						String rNumber_1 = String.valueOf(rs.getInt(1));
						String rType_1 = rs.getString(2);
						String bType_1 = rs.getString(3);
						String rPrice = String.valueOf(rs.getInt(4));
						
						
						
						String tbData[] = {rNumber_1,rType_1,bType_1,rPrice};
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
						
						txtNumber.setText("");
						txtPrice.setText("");
						
						
						
						
					}
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(926, 392, 112, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you want to close application","Selection",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					setVisible(false);
					
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\close.png"));
		btnNewButton_1.setBounds(1353, 17, 34, 25);
		contentPane.add(btnNewButton_1);
	}
}
