package Go;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test_2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSub;
	private JTextField txtCode;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_2 frame = new Test_2();
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
	public Test_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(80, 75, 56, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Subject");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(80, 126, 56, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Code");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(80, 183, 45, 17);
		contentPane.add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtName.setBounds(175, 76, 242, 27);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSub = new JTextField();
		txtSub.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtSub.setColumns(10);
		txtSub.setBounds(175, 130, 242, 27);
		contentPane.add(txtSub);
		
		txtCode = new JTextField();
		txtCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCode.setColumns(10);
		txtCode.setBounds(175, 183, 242, 27);
		contentPane.add(txtCode);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data[] = {txtName.getText(),txtSub.getText(),txtCode.getText()};
				
				DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
				
				tblModel.addRow(data);
				
				JOptionPane.showMessageDialog(null,"data add successfuly");
				
				txtName.setText("");
				txtSub.setText("");
				txtCode.setText("");
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(183, 256, 95, 27);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(322, 256, 95, 27);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(508, 78, 347, 189);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"name", "subject", "code"
			}
		));
	}
}
