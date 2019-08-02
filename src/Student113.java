import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

public class Student113 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student113 frame = new Student113("abc","xyz");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//CONEECTION TO SQLCONNECTION CLASS
			Connection connection = null;
	/**
	 * Create the frame.
	 */
	public Student113(String n,String c) {
		connection = SqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1939, 1092);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(0, 0, 1930, 68);
		contentPane.add(panel);
		
		JLabel lblResults = new JLabel("RESULTS");
		panel.add(lblResults);
		lblResults.setFont(new Font("Serif", Font.PLAIN,30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setBounds(614, 95, 694, 867);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Student1copy1 frameSc= new Student1copy1(n,c);
				frameSc.setVisible(true);
			}
		});
		btnBack.setBounds(310, 727, 109, 45);
		panel_1.add(btnBack);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(0, 0, 694, 71);
		panel_1.add(panel_2);
		
		JLabel lblKeepItUp = new JLabel("KEEP IT UP !");
		panel_2.add(lblKeepItUp);
		lblKeepItUp.setFont(new Font("Serif", Font.PLAIN,30));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 169, 670, 294);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Education Hub\\Images\\susan-yin-647448-unsplash.jpg"));
		label.setBounds(0, 0, 1914, 1045);
		contentPane.add(label);
		
		
		Display();
		
	}
	
	private void Display() 
	{
		try 
		{
			String query="select * from report";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e)
		{
			
		}	
	}
}
