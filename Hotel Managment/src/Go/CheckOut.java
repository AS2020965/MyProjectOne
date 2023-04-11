package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
	private JTextField txtName;
	private JTextField txtIn;
	private JTextField txtOut;
	private JTextField txtMob;
	private JTextField txtDay;
	private JTextField txtStay;
	private JTextField txtTotal;
	private JTextField txtMail;
	Connection con;
	Statement stmt;
	ResultSet rs;
	String id;
	String name;
	String mobile;
	String mail;
	String roomNo;
	String bed;
	String roomType;
	String priceDay;
	int intTot;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOut frame = new CheckOut();
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
	public CheckOut() {
		
		con = DataBase.connection();
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
                try {
					
					stmt = con.createStatement();
					
					String query = "SELECT * FROM customer";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						id = rs.getString(1);
						name = rs.getString(2);
						mobile = rs.getString(3);
						String nation = rs.getString(4);
						String gender = rs.getString(5);
						mail = rs.getString(6);
						String idProof = rs.getString(7);
						String address = rs.getString(8);
						String checkIn = rs.getString(9);
						roomNo = rs.getString(10);
						bed = rs.getString(11);
						roomType = rs.getString(12);
						priceDay = rs.getString(13);
						//String numberDay = rs.getString(1);
						//String totalAmount = rs.getString(1);
						//String checkOut = rs.getString(1);
						
						
						String tbData[] = {id,name,mobile,nation,gender,mail,idProof,address,checkIn,roomNo,bed,roomType,priceDay};
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
						
						
						
					}
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
			}
		});
		
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1381,741);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you really want to close application","Select",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					setVisible(false);
					//System.exit(0);
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\close.png"));
		btnNewButton.setBounds(1342, 10, 29, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Customer Check Out");
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Check Out.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(32, 23, 272, 50);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 458, 1259, 273);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Mobile Number", "Nationality", "Gender", "Email", "Id Proof", "Address", "Chech In Date", "Room Number", "Bed", "Room Type", "Price Per Day"
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("Room Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(460, 103, 125, 23);
		contentPane.add(lblNewLabel_1);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSearch.setBounds(611, 103, 215, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                try {
					
					stmt = con.createStatement();
					int rNumber = Integer.parseInt(txtSearch.getText());
					
					String query = "SELECT * FROM customer";
					
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						if(rNumber == rs.getInt(10)) {
							
							txtSearch.setEditable(false);
							txtName.setText(rs.getString(2));
							txtIn.setText(rs.getString(9));
							txtMob.setText(rs.getString(3));
							txtDay.setText(rs.getString(13));
							txtMail.setText(rs.getString(6));
							
							SimpleDateFormat myFormate = new SimpleDateFormat("yyyy/MM/dd");
							Calendar cal = Calendar.getInstance();
							txtOut.setText(myFormate.format(cal.getTime()));
							
							String dateBeforeString = rs.getString(9);
							java.util.Date dateBefore = myFormate.parse(dateBeforeString);
							String dateAfterString = myFormate.format(cal.getTime());
							java.util.Date dateAfter = myFormate.parse(dateAfterString);
							long difference = dateAfter.getTime() - dateBefore.getTime();
							int noOfDayStay = (int) (difference/(1000*60*60*24));
							txtStay.setText(String.valueOf(noOfDayStay));
							if(noOfDayStay==0) {
								
								noOfDayStay = 1;
								txtStay.setText(String.valueOf(noOfDayStay));
								
								
							}
							int intPrice = Integer.parseInt(rs.getString(13));
							intTot = intPrice*noOfDayStay;
							
							txtTotal.setText(String.valueOf(intTot));
							
							
							
							
							
						}
						else {
							
							JOptionPane.showMessageDialog(null,"invali room number");
						}
						
						
						
					}
					
					
					
					
				}catch(Exception n) {
					
					System.out.println(n);
					
				}
			}
		});
		btnNewButton_1.setBackground(new Color(149, 49, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(882, 103, 85, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(63, 178, 137, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Check In Date");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(358, 178, 137, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Check Out Date(Today)");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(638, 178, 203, 23);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Customer Mobile Number");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_3.setBounds(947, 178, 224, 23);
		contentPane.add(lblNewLabel_2_3);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtName.setBounds(63, 234, 215, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtIn = new JTextField();
		txtIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtIn.setColumns(10);
		txtIn.setBounds(358, 234, 215, 19);
		contentPane.add(txtIn);
		
		txtOut = new JTextField();
		txtOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtOut.setColumns(10);
		txtOut.setBounds(638, 234, 215, 19);
		contentPane.add(txtOut);
		
		txtMob = new JTextField();
		txtMob.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMob.setColumns(10);
		txtMob.setBounds(947, 234, 215, 19);
		contentPane.add(txtMob);
		
		JLabel lblNewLabel_2_4 = new JLabel("Price Per Day");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_4.setBounds(63, 297, 137, 23);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Number Of Days Stay ");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_5.setBounds(358, 297, 185, 23);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Total Amount");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_6.setBounds(638, 304, 137, 23);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Email");
		lblNewLabel_2_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_7.setBounds(947, 304, 137, 23);
		contentPane.add(lblNewLabel_2_7);
		
		txtDay = new JTextField();
		txtDay.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDay.setColumns(10);
		txtDay.setBounds(63, 341, 215, 19);
		contentPane.add(txtDay);
		
		txtStay = new JTextField();
		txtStay.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtStay.setColumns(10);
		txtStay.setBounds(358, 342, 215, 19);
		contentPane.add(txtStay);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtTotal.setColumns(10);
		txtTotal.setBounds(638, 342, 215, 19);
		contentPane.add(txtTotal);
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtMail.setColumns(10);
		txtMail.setBounds(947, 342, 215, 19);
		contentPane.add(txtMail);
		
		JButton btnNewButton_2 = new JButton("Check Out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp = "true";
				
				
				 try {
					 
					 if(txtName.equals("")) {
							
							while(temp.equals("true")) {
								
								break;
								
							}
						}
						
						stmt = con.createStatement();
						
						/*int sId = Integer.parseInt(txtId.getText());
						String sName = txtName.getText();
						String sGrade = (String)comboBox.getSelectedItem();
						String sAddress = txtAdd.getText();
						String sGender = (String)comboBox_1.getSelectedItem();
						int sAge = Integer.parseInt(txtAge.getText());
						String sBirth = txtBirth.getText();*/
						
						String noOfDate = txtStay.getText();
						String totalAmount = txtTotal.getText();
						String checkOut = txtOut.getText();
						String rNumber = txtSearch.getText();
						String status = "not book";
						
						String query = ("UPDATE customer SET number_of_day = ?,total_amount = ?,check_out = ? WHERE roomNo = ?");
						
						PreparedStatement pre = con.prepareStatement(query);
						
						pre.setString(1,noOfDate);
						pre.setString(2,totalAmount);
						pre.setString(3,checkOut);
						pre.setString(4,rNumber);
						//pre.setInt(5,sAge);
						//pre.setString(6,sBirth);
						//pre.setInt(7, sId);
						
						String query_2 = ("UPDATE manage SET STATUS = ? WHERE r_number = ?");
						
						PreparedStatement pre_2 = con.prepareStatement(query_2);
						
						pre_2.setString(1,status);
						pre_2.setString(2,rNumber);
						
						pre.executeUpdate();
						pre_2.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Successfully Update");
						
						String path = "D:\\";
						com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
						
						try {
							
							PdfWriter.getInstance(doc, new FileOutputStream(path+""+id+".pdf"));
							doc.open();
							Paragraph p1 = new Paragraph("                         Hotel Management System                      ");
							doc.add(p1);
							Paragraph p2 = new Paragraph("**********************************************************************");
							doc.add(p2);
							Paragraph p3 = new Paragraph("Bill Id"+id+"\nCustomer Details:\nName:"+name+"\nMobile Number:"+mobile+"\nEmail "+mail+"\n");
							doc.add(p3);
							doc.add(p2);
							Paragraph p4 = new Paragraph("Room Detail"+"\n"+"Number:"+roomNo+"\nType:"+roomType+"\nBed"+bed+"\nPrice Per Day :"+priceDay+"\n");
							doc.add(p4);
							doc.add(p2);
							Paragraph p5 = new Paragraph("Total Price : "+intTot);
							doc.add(p5);
							Paragraph p6 = new Paragraph("************************************Thank You*********************************************");
							doc.add(p6);

							
							
						}catch(Exception r) {
							
							JOptionPane.showMessageDialog(null,r);
						}
						doc.close();
						
						int a = JOptionPane.showConfirmDialog(null,"Do you want to print this bill","Select",JOptionPane.YES_NO_OPTION);
						if(a==0) {
							
							try {
								
								if(new File("D:\\"+id+".pdf").exists()) {
									
									Process p = Runtime
											.getRuntime()
											.exec("rundll32 url.dll,FileProtocolHandler D:\\"+id+".pdf");
									
									
								}else {
									
									System.out.println("file is not exists");
								}
								
								
							}catch(Exception r){
								
								JOptionPane.showMessageDialog(null, r);
								
							}
						}
						
						
						
						
						
					}catch(Exception r){
						
						System.out.println(r);
					}
			}
		});
		btnNewButton_2.setBackground(new Color(149, 49, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(63, 404, 102, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Clear");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new CheckOut().setVisible(true);
			}
		});
		btnNewButton_2_1.setBackground(new Color(149, 49, 0));
		btnNewButton_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBounds(187, 404, 102, 30);
		contentPane.add(btnNewButton_2_1);
	}
}
