

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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class AddFaculty extends JFrame {

	private JPanel contentPane;
	/*private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//private JPasswordField passwordField;*/
	
	 JTextField textFieldName;
	 JTextField textFieldFName;
	 JTextField textFieldMName;
	 JTextField textFieldEmail;
	 JTextField textFieldMob;
	
	private JPasswordField passwordField_1;
		
	ButtonGroup bg;
	JSpinner spinnerDate,spinnerYear ;
	JComboBox comboBoxMonth;
	JRadioButton radioButtonMale,radioButtonFemale,radioButtonOthers ;
	JComboBox comboBoxCourse;
	JTextArea textAreaAddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFaculty frame = new AddFaculty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	Connection connection = null;
	
	/**
	 * Create the frame.
	 */
	public AddFaculty() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddFaculty.class.getResource("/images/logo.png")));
		setTitle("Add Faculty");
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
		panel.setBounds(418, 38, 1122, 937);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(51, 102, 255));
		panel_1.setBounds(0, 0, 1122, 150);
		panel.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(AddStudent.class.getResource("/images/logo.png")));
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
		
		JLabel lblQuestionBank = new JLabel("Add Faculty");
		lblQuestionBank.setForeground(Color.WHITE);
		lblQuestionBank.setFont(new Font("Arial", Font.BOLD, 30));
		lblQuestionBank.setBackground(new Color(0, 102, 255));
		lblQuestionBank.setBounds(829, 40, 223, 63);
		panel_1.add(lblQuestionBank);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.menu);
		panel_2.setBounds(0, 139, 1122, 798);
		panel.add(panel_2);
		panel_2.setOpaque(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(109, 13, 837, 751);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(SystemColor.controlShadow);
		panel_4.setBounds(5, 5, 826, 72);
		panel_3.add(panel_4);
		
		JButton btnViewAllFaculty = new JButton("View All Faculty Details");
		btnViewAllFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
//				JOptionPane.showMessageDialog(null, "Going back to Home Window");
				dispose();
				ViewAllFaculty frameObj=new ViewAllFaculty();
				frameObj.setVisible(true);					
			}
		});
		btnViewAllFaculty.setFont(new Font("Arial", Font.PLAIN, 18));
		btnViewAllFaculty.setBounds(262, 13, 316, 49);
		panel_4.add(btnViewAllFaculty);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(5, 82, 826, 664);
		panel_3.add(panel_5);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setHorizontalAlignment(SwingConstants.TRAILING);
		label_3.setFont(new Font("Arial", Font.PLAIN, 20));
		label_3.setBounds(86, 13, 91, 39);
		panel_5.add(label_3);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldName.setColumns(10);
		textFieldName.setBounds(254, 13, 477, 39);
		panel_5.add(textFieldName);
		
		textFieldFName = new JTextField();
		textFieldFName.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldFName.setColumns(10);
		textFieldFName.setBounds(254, 75, 477, 39);
		panel_5.add(textFieldFName);
		
		JLabel label_4 = new JLabel("Father's Name");
		label_4.setHorizontalAlignment(SwingConstants.TRAILING);
		label_4.setFont(new Font("Arial", Font.PLAIN, 20));
		label_4.setBounds(86, 75, 133, 39);
		panel_5.add(label_4);
		
		textFieldMName = new JTextField();
		textFieldMName.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldMName.setColumns(10);
		textFieldMName.setBounds(254, 142, 477, 39);
		panel_5.add(textFieldMName);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setHorizontalAlignment(SwingConstants.TRAILING);
		lblExperience.setFont(new Font("Arial", Font.PLAIN, 20));
		lblExperience.setBounds(86, 142, 133, 39);
		panel_5.add(lblExperience);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(254, 210, 477, 39);
		panel_5.add(textFieldEmail);
		
		JLabel label_6 = new JLabel("Mobile No.");
		label_6.setHorizontalAlignment(SwingConstants.TRAILING);
		label_6.setFont(new Font("Arial", Font.PLAIN, 20));
		label_6.setBounds(440, 274, 99, 39);
		panel_5.add(label_6);
		
		textFieldMob = new JTextField();
		textFieldMob.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldMob.setColumns(10);
		textFieldMob.setBounds(551, 274, 180, 39);
		panel_5.add(textFieldMob);
		
		JLabel label_7 = new JLabel("Email");
		label_7.setHorizontalAlignment(SwingConstants.TRAILING);
		label_7.setFont(new Font("Arial", Font.PLAIN, 20));
		label_7.setBounds(86, 210, 91, 39);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("Address");
		label_8.setHorizontalAlignment(SwingConstants.TRAILING);
		label_8.setFont(new Font("Arial", Font.PLAIN, 20));
		label_8.setBounds(86, 381, 91, 39);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("Password");
		label_9.setHorizontalAlignment(SwingConstants.TRAILING);
		label_9.setFont(new Font("Arial", Font.PLAIN, 20));
		label_9.setBounds(86, 274, 106, 39);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("D.O.B");
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		label_10.setFont(new Font("Arial", Font.PLAIN, 20));
		label_10.setBounds(86, 326, 106, 39);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Gender");
		label_11.setHorizontalAlignment(SwingConstants.TRAILING);
		label_11.setFont(new Font("Arial", Font.PLAIN, 20));
		label_11.setBounds(86, 488, 106, 39);
		panel_5.add(label_11);
		
		
		 bg=new ButtonGroup();

		 radioButtonMale = new JRadioButton("Male");
		radioButtonMale.setFont(new Font("Arial", Font.PLAIN, 20));
		radioButtonMale.setBounds(254, 495, 99, 39);
		panel_5.add(radioButtonMale);
		bg.add(radioButtonMale);
		
		 radioButtonFemale = new JRadioButton("Female");
		radioButtonFemale.setFont(new Font("Arial", Font.PLAIN, 20));
		radioButtonFemale.setBounds(440, 495, 99, 39);
		panel_5.add(radioButtonFemale);
		bg.add(radioButtonFemale);
		
		 radioButtonOthers = new JRadioButton("Others");
		radioButtonOthers.setFont(new Font("Arial", Font.PLAIN, 20));
		radioButtonOthers.setBounds(627, 495, 99, 39);
		panel_5.add(radioButtonOthers);
		bg.add(radioButtonOthers);
				
		JLabel lblDe = new JLabel("Academic Qualification");
		lblDe.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDe.setBounds(28, 556, 214, 39);
		panel_5.add(lblDe);
		
		 textAreaAddr = new JTextArea();
		textAreaAddr.setFont(new Font("Arial", Font.PLAIN, 20));
		textAreaAddr.setBounds(254, 384, 477, 80);
		panel_5.add(textAreaAddr);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		passwordField_1.setBounds(254, 278, 180, 31);
		panel_5.add(passwordField_1);
		
		 spinnerDate = new JSpinner();
		spinnerDate.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinnerDate.setFont(new Font("Arial", Font.PLAIN, 20));
		spinnerDate.setBounds(253, 326, 61, 39);
		panel_5.add(spinnerDate);
		
		 spinnerYear = new JSpinner();
		spinnerYear.setModel(new SpinnerNumberModel(2000, 1940, 2000, 1));
		spinnerYear.setFont(new Font("Arial", Font.PLAIN, 20));
		spinnerYear.setBounds(401, 326, 70, 39);
		panel_5.add(spinnerYear);
		
		 comboBoxCourse = new JComboBox();
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"PHD", "MCA", "MTech CSE", "MTech IT", "BTech CSE", "BTech IT", "Other"}));
		comboBoxCourse.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxCourse.setBounds(254, 560, 138, 39);
		panel_5.add(comboBoxCourse);
		
		 comboBoxMonth = new JComboBox();
		comboBoxMonth.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		comboBoxMonth.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxMonth.setBounds(326, 326, 65, 39);
		panel_5.add(comboBoxMonth);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.BLACK);
		panel_6.setBounds(958, 538, 132, 225);
		panel_2.add(panel_6);
		
		JButton button_2 = new JButton("Register");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				addOperation();
			}
		});
		button_2.setFont(new Font("Arial", Font.PLAIN, 18));
		button_2.setBounds(12, 13, 108, 57);
		panel_6.add(button_2);
		
		JButton button_3 = new JButton("Reset");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				resetFields();
			}
		});
		button_3.setFont(new Font("Arial", Font.PLAIN, 18));
		button_3.setBounds(12, 83, 108, 57);
		panel_6.add(button_3);
		
		JButton button_4 = new JButton("Cancel");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				JOptionPane.showMessageDialog(null, "Going back to Home Window");
				dispose();
				Home frameObj=new Home();
				frameObj.setVisible(true);	
			}
		});
		button_4.setFont(new Font("Arial", Font.PLAIN, 18));
		button_4.setBounds(12, 158, 108, 57);
		panel_6.add(button_4);
		
		
		
		
		
		
		
		
		
		
		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(AddFaculty.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
		
	
		
		
		
	}
	

	private void addOperation() 
	{
		
		
		String Name=textFieldName.getText();
		String FName=textFieldFName.getText();
		String MName=textFieldMName.getText();
		String Email=textFieldEmail.getText();
		String Mob=textFieldMob.getText();
		String Pass=passwordField_1.getText();
		
		String Date=spinnerDate.getValue().toString();
		String Month=comboBoxMonth.getSelectedItem().toString();
		String Year=spinnerYear.getValue().toString();		
		String Gender="";
		if(radioButtonMale.isSelected())
		{
			 Gender="Male";
		}
		else
		if(radioButtonFemale.isSelected())
		{
			 Gender="FeMale";
		}
		else
		if(radioButtonOthers.isSelected())
		{
			 Gender="Other";
		}
		
		String Course=comboBoxCourse.getSelectedItem().toString();
		String Addr=textAreaAddr.getText();
	
	
		boolean val=false;
		val=Validation.EmptyOrNot(Name,FName, MName, Email, Mob, Pass, Date, Month, Year, Gender, Course, Addr);
		
		if(val)
		{
		try 
		{
			String query = "INSERT INTO adminlogin (a_name,a_Fname,a_Mname,a_Email,a_Password,a_Phone,a_DOB_D,a_DOB_M,a_DOB_Y,a_Addr,a_G,a_Edu) " +
					"Values ('"+Name+"'," +
							"'"+FName+"'," +
							"'"+MName+"'," +
							"'"+Email+"'," +
							"'"+Pass+"'," +
							"'"+Mob+"'," +
							"'"+Date+"'," +
							"'"+Month+"'," +
							"'"+Year+"'," +
							"'"+Addr+"'," +
							"'"+Gender+"'," +
							"'"+Course+"')";
			
								
				Statement st = connection.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"One Member Added");
				resetFields();
			
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}	
		}
		else
		{
			//System.out.println(e);
		}
		
		
	
	}
	private void resetFields()
	{
		textFieldName.setText(null);
		textFieldFName.setText(null);
		textFieldMName.setText(null);
		textFieldEmail.setText(null);
		textFieldMob.setText(null);
		passwordField_1.setText(null);
		
		spinnerDate.setValue(1);
		comboBoxMonth.setSelectedIndex(-1);
		spinnerYear.setValue(2000);
		
		bg.clearSelection();
		
		textAreaAddr.setText(null);
		comboBoxCourse.setSelectedIndex(-1);
	}
}
