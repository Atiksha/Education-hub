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



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Toolkit;

public class AddNotes extends JFrame {

	private JPanel contentPane;
	private JTextField txtFileName;
	JScrollPane scrollPaneNotes ;
	JTextPane textPaneNotes;

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
					AddNotes frame = new AddNotes();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddNotes()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddNotes.class.getResource("/images/logo.png")));
		setTitle("Add Notes");
		
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
		label.setIcon(new ImageIcon(AddNotes.class.getResource("/images/logo.png")));
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
		
		JLabel lblAddNotes = new JLabel("Add Notes");
		lblAddNotes.setForeground(Color.WHITE);
		lblAddNotes.setFont(new Font("Arial", Font.BOLD, 30));
		lblAddNotes.setBackground(new Color(0, 102, 255));
		lblAddNotes.setBounds(935, 21, 205, 63);
		panel_1.add(lblAddNotes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(0, 136, 1301, 801);
		panel.add(panel_2);
		panel_2.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(131, 13, 1048, 751);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.controlShadow);
		panel_4.setBounds(5, 5, 1037, 72);
		panel_3.add(panel_4);
		
		JLabel lblSaveAs = new JLabel("Save as");
		lblSaveAs.setFont(new Font("Arial", Font.BOLD, 20));
		lblSaveAs.setBounds(24, 7, 86, 52);
		panel_4.add(lblSaveAs);
		
		txtFileName = new JTextField();
		txtFileName.setFont(new Font("Arial", Font.PLAIN, 17));
		txtFileName.setColumns(10);
		txtFileName.setBounds(122, 9, 203, 50);
		panel_4.add(txtFileName);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(SystemColor.controlShadow);
		panel_5.setBounds(5, 82, 1037, 664);
		panel_3.add(panel_5);
		
		 scrollPaneNotes = new JScrollPane();
		scrollPaneNotes.setBounds(12, 13, 1013, 638);
		panel_5.add(scrollPaneNotes);
		
		 textPaneNotes = new JTextPane();
		 textPaneNotes.setFont(new Font("Arial", Font.PLAIN, 20));
		scrollPaneNotes.setViewportView(textPaneNotes);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Arial", Font.BOLD, 20));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				go();
			}
		});
		btnSave.setBounds(834, 13, 123, 46);
		panel_4.add(btnSave);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(1191, 693, 93, 65);
		panel_2.add(panel_6);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
		{
			JOptionPane.showMessageDialog(null, "Going back to Home Window");
			dispose();
			Home frameObj=new Home();
			frameObj.setVisible(true);	
		}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 18));
		button_1.setBounds(6, 4, 80, 57);
		panel_6.add(button_1);
		
		
		
		
		
		
		
		
		
		
		
		
		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(AddNotes.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
	
		
		
	}
	public void go()
	{
		
		String str=textPaneNotes.getText();
		String FName=txtFileName.getText();
		try {
			String add="D:\\SEC A 12\\Atiksha\\DatabaseConnection\\Notes\\"+FName+".txt";
			//System.out.println(add);
			File file = new File(add);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(str);
			//fileWriter.write("a test");
			fileWriter.flush();
			fileWriter.close();
			JOptionPane.showMessageDialog(null, "Notes Added Sucessfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
