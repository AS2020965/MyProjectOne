package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test_1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
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
					Test_1 frame = new Test_1();
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
	public Test_1() {
		
		con = DataBase.connection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 125, 344, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name"
			}
		));
		
		JButton btnNewButton = new JButton("Show Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					stmt = con.createStatement();
					
					String query = "SELECT * FROM test";
					rs = stmt.executeQuery(query);
					
					while(rs.next()) {
						
						String id = String.valueOf(rs.getInt(1));
						String name = rs.getString(2);
						
						
						String tbData[] = {id,name};
						DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
						
						tblModel.addRow(tbData);
						
						
						
					}
					btnNewButton.setEnabled(false);
					
				}catch(Exception r) {
					
					System.out.println(r);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(100, 212, 132, 44);
		contentPane.add(btnNewButton);
	}
}
