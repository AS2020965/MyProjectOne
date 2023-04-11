package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class CustomerBill extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;
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
					CustomerBill frame = new CustomerBill();
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
	public CustomerBill() {
		
		con = DataBase.connection();
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				
				SimpleDateFormat myFormate = new SimpleDateFormat("yyyy/MM/dd");
				Calendar cal = Calendar.getInstance();
				txtDate.setText(myFormate.format(cal.getTime()));
				

                try {
					
					stmt = con.createStatement();
					
					String query = "SELECT * FROM customer WHERE check_out IS NOT NULL";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						String id = rs.getString(1);
						String name = rs.getString(2);
						String mobile = rs.getString(3);
						String nation = rs.getString(4);
						String gender = rs.getString(5);
						String mail = rs.getString(6);
						String idProof = rs.getString(7);
						String address = rs.getString(8);
						String checkIn = rs.getString(9);
						String roomNo = rs.getString(10);
						String bed = rs.getString(11);
						String roomType = rs.getString(12);
						String priceDay = rs.getString(13);
						String numberDay = rs.getString(14);
						String totalAmount = rs.getString(15);
						String checkOut = rs.getString(16);
						
						
						String tbData[] = {id,name,mobile,nation,gender,mail,idProof,address,checkIn,roomNo,bed,roomType,priceDay,numberDay,totalAmount,checkOut};
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
		setBounds(100, 100,1371, 671);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Details Bill");
		lblNewLabel.setForeground(new Color(202, 66, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\Customer Details Bill.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(36, 33, 241, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search By Check Out Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(374, 99, 190, 24);
		contentPane.add(lblNewLabel_1);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDate.setBounds(603, 99, 232, 24);
		contentPane.add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
                try {
					
					stmt = con.createStatement();
					
					String checkOut = txtDate.getText();
					
					
					String query = "SELECT * FROM customer WHERE check_out IS NOT NULL";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						if(checkOut.equals(rs.getString(16))) {
							
							table.setModel(new DefaultTableModel(null, new String[] {"Id", "Name", "Mobile Number", "Nationality", "Gender", "Email", "Id Proof", "Address", "Chech In Date", "Room Number", "Bed", "Room Type", "Price Per Day", "Number Of Stay", "Total Amount", "Check Out"
							} ));
							
							String id = rs.getString(1);
							String name = rs.getString(2);
							String mobile = rs.getString(3);
							String nation = rs.getString(4);
							String gender = rs.getString(5);
							String mail = rs.getString(6);
							String idProof = rs.getString(7);
							String address = rs.getString(8);
							String checkIn = rs.getString(9);
							String roomNo = rs.getString(10);
							String bed = rs.getString(11);
							String roomType = rs.getString(12);
							String priceDay = rs.getString(13);
							String numberDay = rs.getString(14);
							String totalAmount = rs.getString(15);
							String checkOut_1 = rs.getString(16);
							
							
							String tbData[] = {id,name,mobile,nation,gender,mail,idProof,address,checkIn,roomNo,bed,roomType,priceDay,numberDay,totalAmount,checkOut};
							DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
							
							tblModel.addRow(tbData);
							
							break;
							//JOptionPane.showConfirmDialog(null,"if");
							
						}
						//JOptionPane.showConfirmDialog(null,"else");
						table.setModel(new DefaultTableModel(null, new String[] {"Id", "Name", "Mobile Number", "Nationality", "Gender", "Email", "Id Proof", "Address", "Chech In Date", "Room Number", "Bed", "Room Type", "Price Per Day", "Number Of Stay", "Total Amount", "Check Out"
						} ));
						
						
						
						
					}
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(198, 51, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(895, 103, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String id = model.getValueAt(index,0).toString();
				
				try {
					
					if(new File("D:\\"+id+".pdf").exists()) {
						
						Process p = Runtime
								.getRuntime()
								.exec("rundll32 url.dll,FileProtocolHandler D:\\"+id+".pdf");
						
						
					}else {
						
						System.out.println("file is not exists");
					}
					
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
				
			}
		});
		scrollPane.setBounds(10, 297, 1347, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Mobile Number", "Nationality", "Gender", "Email", "Id Proof", "Address", "Chech In Date", "Room Number", "Bed", "Room Type", "Price Per Day", "Number Of Stay", "Total Amount", "Check Out"
				}
			));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = JOptionPane.showConfirmDialog(null,"Do you want to close the application","Selection",JOptionPane.YES_NO_OPTION);
				if(a==0) {
					
					setVisible(false);
					//System.exit(0);
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\Hotel Images & Icon\\close.png"));
		btnNewButton_1.setBounds(1308, 10, 39, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Click On The Table Row To Open Bill");
		lblNewLabel_2.setForeground(new Color(173, 67, 16));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(518, 555, 399, 30);
		contentPane.add(lblNewLabel_2);
	}
}
