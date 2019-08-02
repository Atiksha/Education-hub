import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class StudentProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldFName;
	private JTextField textFieldMName;
	private JTextField textField_5;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProfile frame = new StudentProfile("abc","xyz");
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
	public StudentProfile(String n,String c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 1930, 1094);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1912, 91);
		panel.setBackground(new Color(255, 0, 0));
		contentPane.add(panel);
		
		JLabel lblEducationHub = new JLabel("                                                                                                                       EDUCATION HUB   (Education for all)");
		panel.add(lblEducationHub);
		lblEducationHub.setFont(new Font("Serif", Font.PLAIN,30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(660, 188, 624, 699);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBackground(new Color(0, 51, 204));
		panel_2.setBounds(0, 0, 624, 60);
		panel_1.add(panel_2);
		
		JLabel lblEditProfile = new JLabel("EDIT PROFILE");
		lblEditProfile.setFont(new Font("Serif", Font.PLAIN,30));
		panel_2.add(lblEditProfile);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(89, 103, 506, 538);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblName = new JLabel("Student Name :");
		lblName.setBounds(12, 120, 120, 27);
		lblName.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(149, 125, 192, 22);
		panel_4.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name :");
		lblFathersName.setBounds(12, 172, 124, 27);
		lblFathersName.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblFathersName);
		
		JLabel lblMothersName = new JLabel("Mother's Name :");
		lblMothersName.setBounds(12, 227, 131, 27);
		lblMothersName.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblMothersName);
		
		textFieldFName = new JTextField();
		textFieldFName.setBounds(148, 177, 193, 22);
		panel_4.add(textFieldFName);
		textFieldFName.setColumns(10);
		
		textFieldMName = new JTextField();
		textFieldMName.setBounds(149, 232, 192, 22);
		panel_4.add(textFieldMName);
		textFieldMName.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(59, 333, 77, 27);
		lblAddress.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblAddress);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(69, 387, 67, 27);
		lblCourse.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblCourse);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Student1copy1 frame1= new Student1copy1(n,c);
				frame1.setVisible(true);
			}
		});
		btnSave.setBounds(319, 457, 97, 43);
		panel_4.add(btnSave);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setBounds(79, 285, 56, 16);
		lblDob.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblDob);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Student1copy1 frameSc= new Student1copy1(n,c);
				frameSc.setVisible(true);
			}
		});
		btnBack.setBounds(49, 457, 97, 43);
		panel_4.add(btnBack);
		
		JComboBox comboBoxD = new JComboBox();
		comboBoxD.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxD.setBounds(156, 285, 50, 22);
		panel_4.add(comboBoxD);
		
		JComboBox comboBoxM = new JComboBox();
		comboBoxM.setModel(new DefaultComboBoxModel(new String[] {"Jan", "Feb", "March", "April", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec"}));
		comboBoxM.setBounds(229, 285, 56, 22);
		panel_4.add(comboBoxM);
		
		JComboBox comboBoxY = new JComboBox();
		comboBoxY.setModel(new DefaultComboBoxModel(new String[] {"", ""}));
		comboBoxY.setBounds(304, 285, 37, 22);
		panel_4.add(comboBoxY);
		
		JLabel lblStudentId = new JLabel("Student ID : ");
		lblStudentId.setBounds(37, 13, 99, 27);
		lblStudentId.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblStudentId);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(37, 67, 89, 27);
		lblPassword.setFont(new Font("Serif", Font.PLAIN,20));
		panel_4.add(lblPassword);
		
		textField_5 = new JTextField();
		textField_5.setBounds(149, 18, 192, 22);
		panel_4.add(textField_5);
		textField_5.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 72, 192, 22);
		panel_4.add(passwordField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 338, 192, 41);
		panel_4.add(scrollPane);
		
		JTextPane textPaneAddr = new JTextPane();
		scrollPane.setViewportView(textPaneAddr);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(156, 407, 136, 22);
		panel_4.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("I:\\A B.Tech(CS_V SEM)\\JAVA\\Education Hub\\EducationHub\\Images\\susan-yin-647448-unsplash.jpg"));
		label.setBounds(0, 0, 1912, 1045);
		contentPane.add(label);
	}
}
