package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class CustomerIn extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtMob;
	private JTextField txtNat;
	private JTextField txtId;
	private JTextField txtAdd;
	private JTextField txtDate;
	private JTextField txtPrice;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_2_1;
	Connection con;
	Statement stmt;
	ResultSet rs;
	private JTextField txtMail;
	
	


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerIn frame = new CustomerIn();
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
	
	public void roomDetail() {
		
		comboBox_2_1.removeAllItems();//combobox_2_1 is room number 
		txtPrice.setText("");
		String bed = (String)comboBox_1.getSelectedItem();// combobox_1 is bed
		String room = (String)comboBox_2.getSelectedItem();// combobox_2 is room type
		//String status;
		
		
		try {
			
			/*ResultSet rs  = Select.getData("SELECT * FROM manage WHERE b_type='"+bed+"', AND r_type='"+room+"' AND STATUS='not book'");
			while(rs.next()) {
				
				comboBox_2_1.addItem(rs.getString(1));
				
			}*/
			
			stmt = con.createStatement();
			String query = "SELECT * FROM manage";
			rs = stmt.executeQuery(query);
			//String status;
			while(rs.next()) {
				
				String status = rs.getString(5);
				if(room.equals(rs.getString(2)) & bed.equals(rs.getString(3)) & status.equals("not book")) {
					
					comboBox_2_1.addItem(rs.getString(1));
					
				}
			}//problem
			
			
			
			
			
			
			
		}catch(Exception r) {
			
			JOptionPane.showMessageDialog(null, r);
		}
		
		
	}
	
	/*private void comboBox_1ActionPerformed(java.awt.event.ActionEvent evt) {
		
		roomDetail();
		
	}*/
	
	public CustomerIn() {
		
		setUndecorated(true);
		
		con = DataBase.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(91, 92, 86, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMobileNumber.setBounds(91, 166, 143, 27);
		contentPane.add(lblMobileNumber);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNationality.setBounds(91, 237, 104, 27);
		contentPane.add(lblNationality);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGender.setBounds(91, 311, 86, 27);
		contentPane.add(lblGender);
		
		String[] gender = {"Male","Female"};
		comboBox = new JComboBox(gender);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setBounds(91, 348, 283, 27);
		contentPane.add(comboBox);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtName.setBounds(91, 129, 283, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtMob = new JTextField();
		txtMob.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMob.setColumns(10);
		txtMob.setBounds(91, 203, 283, 27);
		contentPane.add(txtMob);
		
		txtNat = new JTextField();
		txtNat.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNat.setColumns(10);
		txtNat.setBounds(91, 274, 283, 27);
		contentPane.add(txtNat);
		
		JLabel lblNewLabel_1 = new JLabel("Id Proof");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(464, 92, 93, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(464, 166, 93, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Check In Date");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(464, 237, 124, 27);
		contentPane.add(lblNewLabel_1_2);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtId.setBounds(464, 129, 274, 27);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtAdd = new JTextField();
		txtAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtAdd.setColumns(10);
		txtAdd.setBounds(464, 203, 274, 27);
		contentPane.add(txtAdd);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDate.setColumns(10);
		txtDate.setBounds(464, 280, 274, 27);
		contentPane.add(txtDate);
		
		txtDate.setEditable(false);
		SimpleDateFormat myFormate = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		txtDate.setText(myFormate.format(cal.getTime()));
		
		
		
		
		
		

		JLabel lblNewLabel_1_3 = new JLabel("Bed");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(870, 92, 93, 27);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Room Type");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(870, 166, 104, 27);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Room Number");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(870, 237, 131, 27);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Price");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(870, 311, 93, 27);
		contentPane.add(lblNewLabel_1_6);
		
		String[] bType = {"single","double"};
		comboBox_1 = new JComboBox(bType);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				roomDetail();
			}
		});
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setBounds(870, 129, 283, 27);
		contentPane.add(comboBox_1);
		
		String[] rType = {"Ac","Non-Ac"};
		comboBox_2 = new JComboBox(rType);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				roomDetail();
			}
		});
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_2.setBounds(870, 203, 283, 27);
		contentPane.add(comboBox_2);
		
		txtPrice = new JTextField();
		txtPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPrice.setColumns(10);
		txtPrice.setBounds(870, 354, 283, 27);
		contentPane.add(txtPrice);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Check In");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Registration & Check IN.png"));
		lblNewLabel_2.setForeground(new Color(255, 128, 64));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_2.setBounds(49, 25, 283, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new CustomerIn().setVisible(true);
				
				
			}
		});
		btnClear.setBackground(new Color(176, 34, 4));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(878, 468, 123, 27);
		contentPane.add(btnClear);
		
		JButton btnAlloteRoom = new JButton("Allote Room");
		btnAlloteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					stmt = con.createStatement();
					
					//String b_status = "book";
					//String room = (String)comboBox_2_1.getSelectedItem();
					String name = txtName.getText();
					String mobile = txtMob.getText();
					String nationality = txtNat.getText();
					String gender = (String)comboBox.getSelectedItem();
					String idProof = txtId.getText();
					String address = txtAdd.getText();
					String checkIn = txtDate.getText();
					String bed = (String)comboBox_1.getSelectedItem();
					String roomType = (String)comboBox_2.getSelectedItem();
					String roomNumber = (String)comboBox_2_1.getSelectedItem();
					String stPrice = txtPrice.getText();
					String stMail = txtMail.getText();
					int intPrice = Integer.parseInt(txtPrice.getText());
					
					if(!stPrice.equals("")) {
						
						String query_1 = ("UPDATE manage SET STATUS = 'book'  WHERE r_number = ?");
						
						PreparedStatement pre = con.prepareStatement(query_1);
						
						//pre.setString(1,b_status);
						pre.setString(1,roomNumber);
						pre.executeUpdate();
						
						
						
						String query_2 = ("INSERT INTO customer(name,mobile,nationality,gender,email,id_proof,address,check_in,roomNo,bed,room_type,price_per_day) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
						pre = con.prepareStatement(query_2);
						
						pre.setString(1,name);
						pre.setString(2,mobile);
						pre.setString(3,nationality);
						pre.setString(4,gender);
						pre.setString(5,stMail);
						pre.setString(6,idProof);
						pre.setString(7,address);
						pre.setString(8,checkIn);
						pre.setString(9,roomNumber);
						pre.setString(10,bed);
						pre.setString(11,roomType);
						pre.setInt(12,intPrice);
						//pre.setString(13,null);
						//pre.setString(14,null);
						//pre.setString(15,null);
						
						pre.executeUpdate();
						
						
						JOptionPane.showMessageDialog(null,"Sucessful Add On Data");
						
						
						
						
						
						
					}
					
					//String query = ("INSERT INTO student(id,name,grade,address,gender,age,birth_day) VALUES(?,?,?,?,?,?,?)");
					
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
			}
		});
		btnAlloteRoom.setForeground(Color.WHITE);
		btnAlloteRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAlloteRoom.setBackground(new Color(176, 34, 4));
		btnAlloteRoom.setBounds(878, 417, 123, 27);
		contentPane.add(btnAlloteRoom);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close application ","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					setVisible(false);
					//System.exit(0);
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\close.png"));
		btnNewButton.setBounds(1300, 10, 47, 33);
		contentPane.add(btnNewButton);
		
		comboBox_2_1 = new JComboBox(new Object[]{});
		comboBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 String room = (String)comboBox_2_1.getSelectedItem();
			 roomDetail();
			 
				
				try {
					
					stmt = con.createStatement();
					String query = "SELECT * FROM manage";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						if(room.equals(rs.getString(1))) {
							
							txtPrice.setText(rs.getString(4));
							
						}
						
						
						
					}
					
					
					
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
			}
		});
		comboBox_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_2_1.setBounds(870, 274, 283, 27);
		contentPane.add(comboBox_2_1);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMail.setBounds(91, 404, 86, 27);
		contentPane.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMail.setColumns(10);
		txtMail.setBounds(91, 441, 283, 27);
		contentPane.add(txtMail);
	}
}
