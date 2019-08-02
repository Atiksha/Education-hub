

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
import java.awt.Toolkit;

public class CreatePaper extends JFrame {

	private JPanel contentPane;
	//private JTextField textField;
	//private JTextField textField_1;
	//private JTextField textField_2;
	//private JTextField textField_3;
	//private JTextField textField_4;
	//private JPasswordField passwordField;
	public JTextField txtExamName;
	
	int qNo=1;
	
	public JTextField txtDuration;
	public JTextField txtNoOfQuestion;
	public JLabel lblAbc,lblPratice,labelNo;
	private JComboBox comboBox;
	

	
	JTextPane textPaneQuestionC,textPaneOpt1C,textPaneOpt2C,textPaneOpt3C,textPaneOpt4C,textPaneExplainationC;
	JComboBox comboBoxAnsC, comboBoxQLevel,comboBoxLevel,comboBoxMarks;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePaper frame = new CreatePaper();
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
	public CreatePaper() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreatePaper.class.getResource("/images/logo.png")));
		setTitle("Create Paper");
		
		
		
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
		label.setIcon(new ImageIcon(CreatePaper.class.getResource("/images/logo.png")));
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
		
		JLabel label_3 = new JLabel("Create Paper");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Arial", Font.BOLD, 30));
		label_3.setBackground(new Color(0, 102, 255));
		label_3.setBounds(955, 40, 205, 63);
		panel_1.add(label_3);
		
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
		
		JLabel label_4 = new JLabel("ExamTime");
		label_4.setFont(new Font("Arial", Font.PLAIN, 18));
		label_4.setBounds(882, 12, 94, 28);
		panel_4.add(label_4);
		
		txtDuration = new JTextField();
		txtDuration.setFont(new Font("Arial", Font.PLAIN, 18));
		txtDuration.setColumns(10);
		txtDuration.setBounds(882, 40, 50, 22);
		panel_4.add(txtDuration);
		
		JLabel label_5 = new JLabel("Mins.");
		label_5.setFont(new Font("Arial", Font.PLAIN, 18));
		label_5.setBounds(944, 43, 56, 16);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("Exam Name");
		label_6.setFont(new Font("Arial", Font.PLAIN, 18));
		label_6.setBounds(42, 15, 132, 25);
		panel_4.add(label_6);
		
		txtExamName = new JTextField();
		txtExamName.setFont(new Font("Arial", Font.PLAIN, 18));
		txtExamName.setColumns(10);
		txtExamName.setBounds(38, 40, 178, 22);
		panel_4.add(txtExamName);
		
		JLabel label_7 = new JLabel("Level");
		label_7.setFont(new Font("Arial", Font.PLAIN, 18));
		label_7.setBounds(506, 15, 56, 16);
		panel_4.add(label_7);
		
		comboBoxLevel = new JComboBox();
		comboBoxLevel.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboBoxLevel.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxLevel.setBounds(506, 40, 71, 22);
		panel_4.add(comboBoxLevel);
		
		JLabel label_8 = new JLabel("No. of Que");
		label_8.setFont(new Font("Arial", Font.PLAIN, 18));
		label_8.setBounds(302, 12, 109, 28);
		panel_4.add(label_8);
		
		txtNoOfQuestion = new JTextField();
		txtNoOfQuestion.setFont(new Font("Arial", Font.PLAIN, 18));
		txtNoOfQuestion.setColumns(10);
		txtNoOfQuestion.setBounds(302, 40, 50, 22);
		panel_4.add(txtNoOfQuestion);
		
		JLabel label_9 = new JLabel("Each Que Marks ");
		label_9.setFont(new Font("Arial", Font.PLAIN, 18));
		label_9.setBounds(687, 16, 147, 16);
		panel_4.add(label_9);
		
		 comboBoxMarks = new JComboBox();
		comboBoxMarks.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "4", "5"}));
		comboBoxMarks.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxMarks.setBounds(687, 40, 50, 22);
		panel_4.add(comboBoxMarks);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(5, 82, 1026, 685);
		panel_3.add(panel_5);
		
		JLabel label_15 = new JLabel("Question Id");
		label_15.setFont(new Font("Arial", Font.PLAIN, 17));
		label_15.setBounds(68, 21, 103, 32);
		//panel_5.add(label_15);
		
		JLabel label_17 = new JLabel("Question No");
		label_17.setFont(new Font("Arial", Font.PLAIN, 17));
		label_17.setBounds(202, 21, 96, 32);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("Que Level");
		label_18.setFont(new Font("Arial", Font.PLAIN, 17));
		label_18.setBounds(712, 26, 88, 16);
		panel_5.add(label_18);
		
		 comboBoxQLevel = new JComboBox();
		comboBoxQLevel.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		comboBoxQLevel.setFont(new Font("Arial", Font.PLAIN, 17));
		comboBoxQLevel.setBounds(795, 23, 71, 22);
		panel_5.add(comboBoxQLevel);
		
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				qNo=qNo+1;
				labelNo.setText(""+qNo);
				addOperation();
				
			}
		});
		button.setFont(new Font("Arial", Font.PLAIN, 20));
		button.setBounds(866, 561, 103, 39);
		panel_5.add(button);
		
		JButton button_2 = new JButton("Reset\r\n");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				resetFields();
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 15));
		button_2.setBounds(889, 21, 81, 32);
		panel_5.add(button_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.controlShadow);
		panel_6.setBounds(0, 613, 1026, 72);
		panel_5.add(panel_6);
		
		JButton button_3 = new JButton("Choose From Bank");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//dispose();
				ViewAllQuestion frameObj=new ViewAllQuestion();
				frameObj.setVisible(true);
			}
		});
		button_3.setFont(new Font("Arial", Font.PLAIN, 20));
		button_3.setBounds(33, 20, 215, 39);
		panel_6.add(button_3);
		
		JButton button_4 = new JButton("View");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				new ViewAllQuestionTestPaper().show();
			}
		});
		button_4.setFont(new Font("Arial", Font.PLAIN, 20));
		button_4.setBounds(872, 20, 96, 39);
		panel_6.add(button_4);
		
		JLabel label_19 = new JLabel("Subject");
		label_19.setFont(new Font("Arial", Font.PLAIN, 17));
		label_19.setBounds(335, 29, 56, 16);
		panel_5.add(label_19);
		
		lblAbc = new JLabel("abc");
		lblAbc.setFont(new Font("Arial", Font.BOLD, 17));
		lblAbc.setBounds(397, 29, 114, 16);
		panel_5.add(lblAbc);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 17));
		lblType.setBounds(523, 26, 56, 16);
		panel_5.add(lblType);
		
		 lblPratice = new JLabel("Pratice");
		lblPratice.setFont(new Font("Arial", Font.BOLD, 17));
		lblPratice.setBounds(568, 26, 120, 16);
		panel_5.add(lblPratice);
		
		JLabel label_10 = new JLabel("Question");
		label_10.setFont(new Font("Arial", Font.PLAIN, 20));
		label_10.setBounds(68, 105, 88, 28);
		panel_5.add(label_10);
		
		textPaneQuestionC = new JTextPane();
		textPaneQuestionC.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneQuestionC.setBounds(169, 96, 800, 83);
		panel_5.add(textPaneQuestionC);
		
		JLabel label_11 = new JLabel("Option 1 ");
		label_11.setFont(new Font("Arial", Font.PLAIN, 20));
		label_11.setBounds(68, 201, 81, 22);
		panel_5.add(label_11);
		
		textPaneOpt1C = new JTextPane();
		textPaneOpt1C.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneOpt1C.setBounds(169, 189, 800, 59);
		panel_5.add(textPaneOpt1C);
		
		textPaneOpt2C = new JTextPane();
		textPaneOpt2C.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneOpt2C.setBounds(170, 259, 799, 59);
		panel_5.add(textPaneOpt2C);
		
		 textPaneOpt3C = new JTextPane();
		textPaneOpt3C.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneOpt3C.setBounds(170, 329, 799, 64);
		panel_5.add(textPaneOpt3C);
		
		 textPaneOpt4C = new JTextPane();
		textPaneOpt4C.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneOpt4C.setBounds(169, 404, 800, 64);
		panel_5.add(textPaneOpt4C);
		
		textPaneExplainationC = new JTextPane();
		textPaneExplainationC.setFont(new Font("Arial", Font.PLAIN, 20));
		textPaneExplainationC.setBounds(169, 479, 800, 64);
		panel_5.add(textPaneExplainationC);
		
		JLabel label_12 = new JLabel("Explaination");
		label_12.setFont(new Font("Arial", Font.PLAIN, 20));
		label_12.setBounds(37, 491, 112, 22);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("Option 2");
		label_13.setFont(new Font("Arial", Font.PLAIN, 20));
		label_13.setBounds(68, 270, 81, 22);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Option 3");
		label_14.setFont(new Font("Arial", Font.PLAIN, 20));
		label_14.setBounds(68, 339, 81, 22);
		panel_5.add(label_14);
		
		JLabel label_16 = new JLabel("Option 4");
		label_16.setFont(new Font("Arial", Font.PLAIN, 20));
		label_16.setBounds(68, 417, 81, 22);
		panel_5.add(label_16);
		
		JLabel label_21 = new JLabel("Answer");
		label_21.setFont(new Font("Arial", Font.PLAIN, 20));
		label_21.setBounds(69, 566, 81, 22);
		panel_5.add(label_21);
		
		comboBoxAnsC = new JComboBox();
		comboBoxAnsC.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"}));
		comboBoxAnsC.setSelectedIndex(-1);
		comboBoxAnsC.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxAnsC.setBounds(166, 564, 112, 36);
		panel_5.add(comboBoxAnsC);
		
		 labelNo = new JLabel("0");
		labelNo.setFont(new Font("Arial", Font.BOLD, 17));
		labelNo.setBounds(298, 30, 25, 16);
		panel_5.add(labelNo);
		labelNo.setText(""+qNo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.BLACK);
		panel_7.setBounds(1157, 703, 132, 82);
		panel_2.add(panel_7);
		
		JButton button_7 = new JButton("Back");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
				if(qNo==Integer.parseInt(	txtNoOfQuestion.getText()	))
				{
					JOptionPane.showMessageDialog(null,"Test Paper created Sucessfully !");
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"if you exit make then make sure next time for the same question paper name add only remaining question !!!");
					
				}
				}catch(Exception e){}
				
				//TO EXIT CODE
				dispose();
				Home frameObj=new Home();
				frameObj.setVisible(true);	
			} 
		});
		button_7.setFont(new Font("Arial", Font.PLAIN, 18));
		button_7.setBounds(12, 13, 108, 57);
		panel_7.add(button_7);
		
		
		
		
		
		
		
		
		
		
		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(CreatePaper.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
		
	
		
	}
	
		
	
	private void addOperation() 
	{
		
		
		
		String EName=txtExamName.getText();
		String NOQue=txtNoOfQuestion.getText();
		String ELevel=comboBoxLevel.getSelectedItem().toString();
		String EQMark=comboBoxMarks.getSelectedItem().toString();
		String Duration=txtDuration.getText();
		String sub=lblAbc.getText();
		String examtype=lblPratice.getText();
		String EQLevel=comboBoxQLevel.getSelectedItem().toString();
		
		
		
		String Question=textPaneQuestionC.getText();
		String Option1=textPaneOpt1C.getText();
		String Option2=textPaneOpt2C.getText();
		String Option3=textPaneOpt3C.getText();
		String Option4=textPaneOpt4C.getText();
		String Explaination=textPaneExplainationC.getText();
		String ans=comboBoxAnsC.getSelectedItem().toString();
		try
		{
								
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
			
			String sql = "INSERT INTO createpaper (C_ExamName,C_NoOfQue,C_ExamLevel,C_Marks,C_Time,C_Sub,C_Type,C_Level,C_Que,C_Option1,C_Option2,C_Option3,C_Option4,C_Explaination,C_Ans) " +
					"Values ('	"+EName+"'," +
							"'"+NOQue+"'," +
							"'"+ELevel+"'," +
							"'"+EQMark+"'," +
							"'"+Duration+"'," +
							"'"+sub+"'," +
							"'"+examtype+"'," +
							"'"+EQLevel+"'," +
							
							"'"+Question+"'," +
							"'"+Option1+"'," +
							"'"+Option2+"'," +
							"'"+Option3+"'," +
							"'"+Option4+"'," +
							"'"+Explaination+"'," +
							"'"+ans+"')";
			

			Statement st = con.createStatement();
			
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"item is added");
			resetFields();
			
		}
		/*
		try 
		{System.out.println("after try");
			String query = "INSERT INTO createpaper (C_ExamName,C_NoOfQue,C_ExamLevel,C_Marks,C_Time,C_Sub,C_Type,C_Level,C_Que,C_Option1,C_Option2,C_Option3,C_Option4,C_Explaination,C_Ans) " +
					"Values ('	"+EName+"'," +
							"'"+NOQue+"'," +
							"'"+ELevel+"'," +
							"'"+EQMark+"'," +
							"'"+Duration+"'," +
							"'"+sub+"'," +
							"'"+examtype+"'," +
							"'"+EQLevel+"'," +
							
							"'"+Question+"'," +
							"'"+Option1+"'," +
							"'"+Option2+"'," +
							"'"+Option3+"'," +
							"'"+Option4+"'," +
							"'"+Explaination+"'," +
							"'"+ans+"')";
			System.out.println("after query");
								
				Statement st = connection.createStatement();System.out.println("after st");
				st.executeUpdate(query);System.out.println("after execute");
				JOptionPane.showMessageDialog(null,"item is added");System.out.println("after msg");
				resetFields();System.out.println("after reset");*
			
		} */
		catch (Exception e)
		{
			System.out.println(e);
		}	
			
			
		
	
	}
	private void resetFields()
	{
		textPaneQuestionC.setText(null);
		textPaneOpt1C.setText(null);
		textPaneOpt2C.setText(null);
		textPaneOpt3C.setText(null);
		textPaneOpt4C.setText(null);
		textPaneExplainationC.setText(null);
		comboBoxAnsC.setSelectedIndex(-1);
		
		
	}

	
	
}
