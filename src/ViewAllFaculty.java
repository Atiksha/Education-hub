import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import java.awt.Toolkit;

public class ViewAllFaculty extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try
				{
					ViewAllFaculty frame = new ViewAllFaculty();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	//CONEECTION TO SQLCONNECTION CLASS
		Connection connection = null;
		private JTable table;

	/**
	 * Create the frame.
	 */
	public ViewAllFaculty()
	{
		setTitle("View All Faculty");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAllFaculty.class.getResource("/images/logo.png")));
		connection = SqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 10, 1100, 950);
		setBounds(-5, 0, 1930, 1035);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(321, 38, 1301, 937);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 0, 1301, 137);
		panel.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(ViewAllFaculty.class.getResource("/images/logo.png")));
		label.setBackground(new Color(211, 211, 211));
		label.setBounds(78, 21, 91, 90);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Education Hub");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 25));
		label_1.setBackground(new Color(0, 102, 255));
		label_1.setBounds(170, 21, 175, 38);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("A Learning Habbit");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		label_2.setBackground(new Color(0, 102, 255));
		label_2.setBounds(245, 54, 124, 24);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("View Details");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 30));
		label_3.setBackground(new Color(0, 102, 255));
		label_3.setBounds(935, 21, 205, 63);
		panel_1.add(label_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(0, 136, 1301, 801);
		panel.add(panel_2);
		panel_2.setOpaque(false);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(91, 13, 1048, 751);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.controlShadow);
		panel_4.setBounds(5, 5, 1037, 72);
		panel_3.add(panel_4);
		
		JLabel label_5 = new JLabel("Sort by");
		label_5.setFont(new Font("Arial", Font.PLAIN, 20));
		label_5.setBounds(729, 9, 71, 39);
		panel_4.add(label_5);
		
		
		JComboBox comboBoxSortby = new JComboBox();
		comboBoxSortby.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxSortby.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				
				String Subjectselected=comboBoxSortby.getSelectedItem().toString();
				SortBy(Subjectselected);
					
			
			}
		});
		comboBoxSortby.setModel(new DefaultComboBoxModel(new String[] {"None", "Name", "Academic Qualification", "Gender", "Newest First"}));
		comboBoxSortby.setBounds(830, 13, 157, 35);
		panel_4.add(comboBoxSortby);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(SystemColor.controlShadow);
		panel_5.setBounds(5, 82, 1037, 664);
		panel_3.add(panel_5);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 13, 1013, 638);
		panel_5.add(scrollPane_2);
		
		table = new JTable();
		scrollPane_2.setViewportView(table);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(1157, 610, 132, 154);
		panel_2.add(panel_6);
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				JOptionPane.showMessageDialog(null, "Refreshing the Content");
				Display();
				
			}
		});
		btnRefresh.setFont(new Font("Arial", Font.PLAIN, 18));
		btnRefresh.setBounds(12, 13, 108, 57);
		panel_6.add(btnRefresh);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null, "Going back to Home Window");
				dispose();
				AddFaculty frameObj=new AddFaculty();
				frameObj.setVisible(true);	
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 18));
		btnBack.setBounds(12, 83, 108, 57);
		panel_6.add(btnBack);
		
		
		
		
		
		
		
		
		
		
		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(ViewAllFaculty.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
		
		Display();
		
		
	}//END OF CONSTRUCTOR
	
	
	private void Display() 
	{
		try 
		{
			String query="select * from adminlogin";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
		catch (Exception e)
		{
			
		}	
	}
	
	private void SortBy(String sub) 
	{
		if(sub.contains("Academic Qualification"))
		{
			try 
			{
				String query="select * from adminlogin ORDER BY a_Edu ";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} 
			catch (Exception e)
			{
				
			}	
		}
		else
		if(sub.contains("Name"))
		{
			try 
			{
				String query="select * from adminlogin ORDER BY a_name ";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} 
			catch (Exception e)
			{
				
			}	
		}
		else
		if(sub.contains("Gender"))
		{
			try 
			{
				
				String query="select * from adminlogin ORDER BY a_G";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} 
			catch (Exception e)
			{
				
			}	
		}
		else
		if(sub.contains("Newest First"))
		{
			try 
			{
				String query="select * from adminlogin ORDER BY a_Id DESC";
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} 
			catch (Exception e)
			{
				
			}	
		}
	}
}
