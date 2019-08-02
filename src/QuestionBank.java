import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
import java.awt.Toolkit;

public class QuestionBank extends JFrame {

	private JPanel contentPane;
	//private JTextField textField;
	//private JTextField textField_1;
	//private JTextField textField_2;
	//private JTextField textField_3;
	//private JTextField textField_4;
	//private JPasswordField passwordField;
	
	JTextPane textPaneQuestion,textPaneOpt1,textPaneOpt2,textPaneOpt3,textPaneOpt4,textPaneExplaination;
	JComboBox comboBoxAns,comboBoxQueLevel,comboBoxSub,comboBoxQueMark;
	

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
					QuestionBank frame = new QuestionBank();
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

	/**
	 * Create the frame.
	 */
	public QuestionBank()
	{
		setTitle("Question Bank");
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuestionBank.class.getResource("/images/logo.png")));
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
		panel_1.setBounds(0, 0, 1301, 150);
		panel.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(QuestionBank.class.getResource("/images/logo.png")));
		label.setBackground(new Color(211, 211, 211));
		label.setBounds(113, 27, 97, 100);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Education Hub");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.BOLD, 27));
		label_1.setBackground(new Color(0, 102, 255));
		label_1.setBounds(215, 33, 205, 38);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("A Learning Habbit");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 15));
		label_2.setBackground(new Color(0, 102, 255));
		label_2.setBounds(290, 66, 130, 24);
		panel_1.add(label_2);
		
		JLabel lblQuestionBank = new JLabel("Question Bank");
		lblQuestionBank.setForeground(Color.WHITE);
		lblQuestionBank.setFont(new Font("Arial", Font.BOLD, 30));
		lblQuestionBank.setBackground(new Color(0, 102, 255));
		lblQuestionBank.setBounds(937, 40, 223, 63);
		panel_1.add(lblQuestionBank);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(0, 139, 1301, 798);
		panel.add(panel_2);
		panel_2.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(108, 13, 1037, 772);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.controlShadow);
		panel_4.setBounds(5, 5, 1026, 72);
		panel_3.add(panel_4);
		
		JLabel lblDisplaySubject = new JLabel("Subject Name");
		lblDisplaySubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplaySubject.setForeground(Color.WHITE);
		lblDisplaySubject.setFont(new Font("Arial", Font.BOLD, 30));
		lblDisplaySubject.setBackground(new Color(0, 102, 255));
		lblDisplaySubject.setBounds(258, 13, 571, 46);
		panel_4.add(lblDisplaySubject);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(5, 82, 1026, 685);
		panel_3.add(panel_5);
		
		JLabel label_10 = new JLabel("Question");
		label_10.setFont(new Font("Arial", Font.PLAIN, 20));
		label_10.setBounds(68, 103, 88, 28);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Option 1 ");
		label_11.setFont(new Font("Arial", Font.PLAIN, 20));
		label_11.setBounds(68, 199, 81, 22);
		panel_5.add(label_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(168, 93, 802, 85);
		panel_5.add(scrollPane);
		
		
		textPaneQuestion = new JTextPane();
		scrollPane.setViewportView(textPaneQuestion);
		textPaneQuestion.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(168, 186, 802, 61);
		panel_5.add(scrollPane_1);
		
		textPaneOpt1 = new JTextPane();
		scrollPane_1.setViewportView(textPaneOpt1);
		textPaneOpt1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(169, 256, 801, 61);
		panel_5.add(scrollPane_2);
		
		textPaneOpt2 = new JTextPane();
		scrollPane_2.setViewportView(textPaneOpt2);
		textPaneOpt2.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label_12 = new JLabel("Option 2");
		label_12.setFont(new Font("Arial", Font.PLAIN, 20));
		label_12.setBounds(68, 268, 81, 22);
		panel_5.add(label_12);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(169, 326, 801, 66);
		panel_5.add(scrollPane_3);
		
		textPaneOpt3 = new JTextPane();
		scrollPane_3.setViewportView(textPaneOpt3);
		textPaneOpt3.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label_13 = new JLabel("Option 3");
		label_13.setFont(new Font("Arial", Font.PLAIN, 20));
		label_13.setBounds(68, 337, 81, 22);
		panel_5.add(label_13);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(168, 401, 802, 66);
		panel_5.add(scrollPane_4);
		
		textPaneOpt4 = new JTextPane();
		scrollPane_4.setViewportView(textPaneOpt4);
		textPaneOpt4.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel label_14 = new JLabel("Option 4");
		label_14.setFont(new Font("Arial", Font.PLAIN, 20));
		label_14.setBounds(68, 415, 81, 22);
		panel_5.add(label_14);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(168, 476, 802, 66);
		panel_5.add(scrollPane_5);
		
		textPaneExplaination = new JTextPane();
		scrollPane_5.setViewportView(textPaneExplaination);
		textPaneExplaination.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblExplaination = new JLabel("Explaination");
		lblExplaination.setFont(new Font("Arial", Font.PLAIN, 20));
		lblExplaination.setBounds(37, 489, 112, 22);
		panel_5.add(lblExplaination);
		
		JLabel label_16 = new JLabel("Answer");
		label_16.setFont(new Font("Arial", Font.PLAIN, 20));
		label_16.setBounds(69, 564, 81, 22);
		panel_5.add(label_16);
		
		comboBoxAns = new JComboBox();
		comboBoxAns.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"}));
		comboBoxAns.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxAns.setBounds(166, 562, 112, 36);
		panel_5.add(comboBoxAns);
		comboBoxAns.setSelectedIndex(-1);
		
		JLabel label_18 = new JLabel("Que Level");
		label_18.setFont(new Font("Dialog", Font.PLAIN, 17));
		label_18.setBounds(674, 24, 88, 16);
		panel_5.add(label_18);
		
		comboBoxQueLevel = new JComboBox();
		comboBoxQueLevel.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboBoxQueLevel.setFont(new Font("Dialog", Font.PLAIN, 17));
		comboBoxQueLevel.setBounds(757, 21, 71, 22);
		panel_5.add(comboBoxQueLevel);
		
		JButton button_2 = new JButton("Reset\r\n");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				resetFields();
			}
		});
		button_2.setFont(new Font("Dialog", Font.PLAIN, 17));
		button_2.setBounds(889, 21, 81, 32);
		panel_5.add(button_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.controlShadow);
		panel_6.setBounds(0, 613, 1026, 72);
		panel_5.add(panel_6);
		
		JLabel lblChangeSubject = new JLabel("Change Subject");
		lblChangeSubject.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblChangeSubject.setBounds(88, 26, 125, 24);
		panel_5.add(lblChangeSubject);
		
		JLabel lblQueMarks = new JLabel("Que Marks ");
		lblQueMarks.setBounds(482, 29, 93, 16);
		panel_5.add(lblQueMarks);
		lblQueMarks.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		comboBoxQueMark = new JComboBox();
		comboBoxQueMark.setBounds(570, 26, 50, 22);
		panel_5.add(comboBoxQueMark);
		comboBoxQueMark.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "4", "5"}));
		comboBoxQueMark.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		comboBoxSub = new JComboBox();
		
		comboBoxSub.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				String Subjectselected=comboBoxSub.getSelectedItem().toString();
				lblDisplaySubject.setText(Subjectselected);
			}
		});
		comboBoxSub.setModel(new DefaultComboBoxModel(new String[] {"Java(core)", "java(Advance)", "DBMS", "DAA", "OOPS", "Computer Organisation", "Operationg System", "Computer Networks"}));
		comboBoxSub.setFont(new Font("Dialog", Font.PLAIN, 17));
		comboBoxSub.setBounds(211, 27, 192, 22);
		panel_5.add(comboBoxSub);
		
		//TO CHANGE SUBJECT NAME OF LABLE 2 METHOD	
		/*comboBoxSub.addActionListener(new ActionListener()
										{
											public void actionPerformed(ActionEvent e)
											{
												String Subjectselected=comboBoxSub.getSelectedItem().toString();
												lblDisplaySubject.setText(Subjectselected);
											}
										}
									);
		*/
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//new ViewAllQuestion().show();
				dispose();
				ViewAllQuestion frameObj=new ViewAllQuestion();
			}
		});
		btnViewAll.setFont(new Font("Arial", Font.PLAIN, 20));
		btnViewAll.setBounds(789, 20, 110, 39);
		panel_6.add(btnViewAll);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"All changes Done Sucessfully now going back to main Window");
				addOperation();
				dispose();
				Home frameObj=new Home();
				frameObj.setVisible(true);	
			}
		});
		btnDone.setFont(new Font("Arial", Font.PLAIN, 20));
		btnDone.setBounds(911, 20, 103, 39);
		panel_6.add(btnDone);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				addOperation();
			}
		});
		
		btnNext.setBounds(867, 561, 103, 39);
		panel_5.add(btnNext);
		/*
		 * btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			
			{
				String Question=textPaneQuestion.getText();
				String Option1=textPaneOpt1.getText();
				String Option2=textPaneOpt2.getText();
				String Option3=textPaneOpt3.getText();
				String Option4=textPaneOpt4.getText();
				String Explaination=textPaneExplaination.getText();
				String ans=comboBoxAns.getSelectedItem().toString();
				String Sub=comboBoxSub.getSelectedItem().toString();
				String Mark=comboBoxQueMark.getSelectedItem().toString();
				String Level=comboBoxQueLevel.getSelectedItem().toString();
				
				try
				{
										
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
					
					String sql = "INSERT INTO questionbank (Q_Sub,Q_Mark,Q_Level,Q_Que,Option1,Option2,Option3,Option4,Q_Ans,Q_Explaination) " +
						"Values ('	"+Sub+"'," +
								"'"+Mark+"'," +
								"'"+Level+"'," +
								"'"+Question+"'," +
								"'"+Option1+"'," +
								"'"+Option2+"'," +
								"'"+Option3+"'," +
								"'"+Option4+"'," +
								"'"+ans+"'," +
								"'"+Explaination+"')";
					

					Statement st = con.createStatement();
					
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"item is added");
					resetFields();
					
				}
				catch(Exception e)
				{
					//
				}
				
				
				
				
			}
		});
		
		*/
		btnNext.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(1157, 718, 115, 67);
		panel_2.add(panel_7);
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null,"Are You Sure You want to go back to main Window Without Saving");
				//TO EXIT CODE
				dispose();
				Home frameObj=new Home();
				frameObj.setVisible(true);	
				
			}
		});
		button_7.setFont(new Font("Arial", Font.PLAIN, 18));
		button_7.setBounds(6, 7, 102, 55);
		panel_7.add(button_7);
		
		
		
		
		
		
		
		
		
		
		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(QuestionBank.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
		
	
		
		
		DefaultListModel Course = new DefaultListModel();
			Course.addElement("All");
	      Course.addElement("Btech CSE");
	      Course.addElement("Btech MCE");
	      Course.addElement("Btech ECE");
	      Course.addElement("Btech IT");
	      Course.addElement("BCA");
	      Course.addElement("MCA");
	      Course.addElement("BCS IT");
	      
		
		
		
		DefaultListModel Sort = new DefaultListModel();
		Sort.addElement("None");
		Sort.addElement("Name");
		Sort.addElement("ID NO");
		Sort.addElement("Father's Name");
		Sort.addElement("Mother's Name");
		Sort.addElement("DOB");
		Sort.addElement("Gender");
	}
	
	
	
	
	
	/*public void actionPerformed(ActionEvent evt) 
	{System.out.println("-------------");
		// TODO Auto-generated method stub
		String action = evt.getActionCommand();
		if(action.equals("btnNext"))
		{
			addOperation();
		}else if(action.equals("btnDone"))
		{JOptionPane.showMessageDialog(null,"All changes Done Sucessfully now going back to main Window");
			System.out.println("ghghgh");
			//addOperation();
			//code to open new windowll
		}
		else if(action.equals("btnViewAll"))
		{
			//new ViewAllQuestion().show();
			//code to open new windowll
		}
		
	}*/
	private void addOperation() 
	{
		String Question=textPaneQuestion.getText();
		String Option1=textPaneOpt1.getText();
		String Option2=textPaneOpt2.getText();
		String Option3=textPaneOpt3.getText();
		String Option4=textPaneOpt4.getText();
		String Explaination=textPaneExplaination.getText();
		String ans=comboBoxAns.getSelectedItem().toString();
		String Sub=comboBoxSub.getSelectedItem().toString();
		String Mark=comboBoxQueMark.getSelectedItem().toString();
		String Level=comboBoxQueLevel.getSelectedItem().toString();
		
		try
		{
								
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
			
			String sql = "INSERT INTO questionbank (Q_Sub,Q_Mark,Q_Level,Q_Que,Option1,Option2,Option3,Option4,Q_Ans,Q_Explaination) " +
				"Values ('	"+Sub+"'," +
						"'"+Mark+"'," +
						"'"+Level+"'," +
						"'"+Question+"'," +
						"'"+Option1+"'," +
						"'"+Option2+"'," +
						"'"+Option3+"'," +
						"'"+Option4+"'," +
						"'"+ans+"'," +
						"'"+Explaination+"')";
			

			Statement st = con.createStatement();
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Question is added");
			resetFields();
			
		}
		catch(Exception e)
		{
			//
		}
	}
	private void resetFields()
	{
		textPaneQuestion.setText(null);
		textPaneOpt1.setText(null);
		textPaneOpt2.setText(null);
		textPaneOpt3.setText(null);
		textPaneOpt4.setText(null);
		textPaneExplaination.setText(null);
		comboBoxAns.setSelectedIndex(-1);
	}
}
