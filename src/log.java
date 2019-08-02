//package proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class log extends JFrame {

	private JPanel contentPane;
	boolean flagAdmin=true,flagStudent=true;
	private JPasswordField passwordStudent;
	private JTextField txtStudentId;
	private JPasswordField passwordAdmin;
	private JTextField txtAdminId;

	private boolean EmptyOrNot(String u,String p)
	{
		
		if(u.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter user Name");
			//u.requestFocus();
			return false;
		}
		else
		if(p.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Password");
			//p.requestFocus();
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					log frame = new log();
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
	public log() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginSystem3.class.getResource("/images/logo.png")));
		setTitle("Login System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 534, 350);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		////////////////////////////////////////////////////////////////////////////
		JPanel panelAdminLogin = new JPanel();
		panelAdminLogin.setBackground(Color.LIGHT_GRAY);
		panelAdminLogin.setBounds(210, 65, 307, 205);
		contentPane.add(panelAdminLogin);
		panelAdminLogin.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Arial", Font.BOLD, 20));
		lblAdminLogin.setBounds(99, 0, 134, 39);
		panelAdminLogin.add(lblAdminLogin);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(12, 37, 290, 2);
		panelAdminLogin.add(separator_2);
		
		JLabel lblUserNameAdmin = new JLabel("UserName");
		lblUserNameAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserNameAdmin.setBounds(12, 52, 81, 31);
		panelAdminLogin.add(lblUserNameAdmin);
		
		JLabel lblUserPasswordAdmin = new JLabel("Password");
		lblUserPasswordAdmin.setFont(new Font("Arial", Font.BOLD, 15));
		lblUserPasswordAdmin.setBounds(12, 96, 81, 31);
		panelAdminLogin.add(lblUserPasswordAdmin);
		
		JButton btnAdminLogin = new JButton("Login");
		
		//LOGIN AND VERIFICATION OF ADMIN		
		
		btnAdminLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
					Statement stmt = con.createStatement();
					//String sql ="Select * from adminlogin where a_Name =  '" + txtAdminId.getText() +" '    and a_Password = '" + 		passwordAdmin.getText().toString() +"'";
					//ResultSet rs =stmt.executeQuery(sql);
					
					String sql="Select * from adminlogin";
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next())
					{
					   String foo = rs.getString(2);
					   System.out.println(foo);
					   System.out.println("-------------");
					   String foo1 = rs.getString(6);
					   System.out.println(foo1);
					   System.out.println("++++++++++++++++");
					   
					   

						if(txtAdminId.getText().equalsIgnoreCase(rs.getString("a_Name")))
						{
							System.out.println("yessssssss");
							
							System.out.println(rs.getString("a_Name"));	
						//	System.out.println(rs.getString("a_Password"));
							
							System.out.println(txtAdminId.getText());	
						//	System.out.println(passwordAdmin.getText().toString());
							
						}
						else
						{
							System.out.println("No");	
							
							System.out.println(rs.getString("a_Name"));	
							System.out.println(rs.getString("a_Password"));
							
							System.out.println(txtAdminId.getText());	
							System.out.println(passwordAdmin.getText().toString());
						}
					
					}
					
					
					
					
					
					
					
					
					
					
					System.out.println(txtAdminId.getText());	
					System.out.println(passwordAdmin.getText().toString());
					
					
					//FIRST IT CHECKS WHEATHER NAME FIELD AND PASSWORD IS EMPTY OR NOT
					//EmptyOrNot METHOD IS DEFINE AT THE TOP
					if(EmptyOrNot(txtAdminId.getText(),passwordAdmin.getText().toString()))
					{
						if(rs.next()) 
						{
							
							
							
							
							JOptionPane.showMessageDialog(null, "LOGIN SUCESSFULLY ...");
							txtAdminId.setText(null);
							passwordAdmin.setText(null);
							dispose();
							new Home().show();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "INCORRECT LOGIN DETAILS ...");
							txtAdminId.setText(null);
							passwordAdmin.setText(null);
						}
					}
					txtAdminId.requestFocus();
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
		
		
			}
			
		
		});
		btnAdminLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdminLogin.setBounds(13, 156, 89, 34);
		panelAdminLogin.add(btnAdminLogin);
		
		JButton btnAdminExit = new JButton("Exit");
		//BELOW
		
		btnAdminExit.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdminExit.setBounds(221, 155, 81, 36);
		panelAdminLogin.add(btnAdminExit);
		
		JButton btnAdminReset = new JButton("Reset");
		btnAdminReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TO RESET THE TEXT AND PASSWORD FIELDS OF STUDENT LOGIN
				txtAdminId.setText(null);
				passwordAdmin.setText(null);
			}
		});
		btnAdminReset.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAdminReset.setBounds(114, 156, 89, 34);
		panelAdminLogin.add(btnAdminReset);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(12, 140, 290, 2);
		panelAdminLogin.add(separator_3);
		
		passwordAdmin = new JPasswordField();
		passwordAdmin.setBounds(96, 100, 197, 31);
		panelAdminLogin.add(passwordAdmin);
		
		txtAdminId = new JTextField();
		txtAdminId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAdminId.setColumns(10);
		txtAdminId.setBounds(98, 56, 194, 31);
		panelAdminLogin.add(txtAdminId);
		
		///////////////////////////////////////////////////////////////////////////////////////
		JPanel panelStudentLogin = new JPanel();
		panelStudentLogin.setBackground(Color.LIGHT_GRAY);
		panelStudentLogin.setBounds(12, 65, 300, 217);
		contentPane.add(panelStudentLogin);
		panelStudentLogin.setLayout(null);
		
		JLabel lblStudentLogin = new JLabel("Student Login");
		lblStudentLogin.setFont(new Font("Arial", Font.BOLD, 20));
		lblStudentLogin.setBounds(76, 13, 188, 31);
		panelStudentLogin.add(lblStudentLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 50, 275, 2);
		panelStudentLogin.add(separator);
		
		JLabel lblUserNameStudent = new JLabel("UserName");
		lblUserNameStudent.setBounds(12, 65, 97, 31);
		panelStudentLogin.add(lblUserNameStudent);
		lblUserNameStudent.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblUserPasswordStudent = new JLabel("Password");
		lblUserPasswordStudent.setBounds(12, 109, 97, 31);
		panelStudentLogin.add(lblUserPasswordStudent);
		lblUserPasswordStudent.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnStudentLogin = new JButton("Login");
		btnStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//LOGIN BUTTON OF STUDENT
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
					Statement stmt = con.createStatement();
					String sql ="Select * from studentlogin"
							+ " where s_Name =  '" + txtStudentId.getText() +" '    and s_Password = '" + 		passwordStudent.getText().toString() +"'";
					ResultSet rs =stmt.executeQuery(sql);
					//FIRST IT CHECKS WHEATHER NAME FIELD AND PASSWORD IS EMPTY OR NOT
					//EmptyOrNot METHOD IS DEFINE AT THE TOP
					//System.out.print(passwordStudent.getText().toString());
					if(EmptyOrNot(txtStudentId.getText(),passwordStudent.getText().toString()))
					{
						if(rs.next()) 
						{
							JOptionPane.showMessageDialog(null, "LOGIN SUCESSFULLY ...");
							txtStudentId.setText(null);
							passwordStudent.setText(null);
							
							//String c=rs.getString("S_Course");
						//	String n=rs.getString(txtStudentId.getText());
						//	System.out.println(c);
						//	FinalTest f = new FinalTest();
						//	f.Student=txtStudentId.getText();
						//	f.Course=c;
							
							String c=rs.getString("S_Course");
							String n=rs.getString("s_name");
							
							new Student1copy1(n,c).show();
							dispose();
							//NAME OF STUDENT PORTAL CLASS
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "INCORRECT LOGIN DETAILS ...");
							txtStudentId.setText(null);
							passwordStudent.setText(null);
						}
					}
					txtAdminId.requestFocus();
					con.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
		
				
			}
		});
		btnStudentLogin.setBounds(6, 169, 97, 34);
		panelStudentLogin.add(btnStudentLogin);
		btnStudentLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnStudentExit = new JButton("Exit");
		//below actionlistenr
		btnStudentExit.setBounds(212, 168, 75, 36);
		panelStudentLogin.add(btnStudentExit);
		btnStudentExit.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnStudentReset = new JButton("Reset");
		btnStudentReset.setBounds(115, 169, 85, 34);
		panelStudentLogin.add(btnStudentReset);
		btnStudentReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//TO RESET THE TEXT AND PASSWORD FIELDS OF STUDENT LOGIN
				txtStudentId.setText(null);
				passwordStudent.setText(null);
			}
		});
		btnStudentReset.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 153, 276, 2);
		panelStudentLogin.add(separator_1);
		
		passwordStudent = new JPasswordField();
		passwordStudent.setBounds(99, 109, 188, 31);
		panelStudentLogin.add(passwordStudent);
		
		txtStudentId = new JTextField();
		txtStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStudentId.setColumns(10);
		txtStudentId.setBounds(99, 64, 186, 31);
		panelStudentLogin.add(txtStudentId);
		
		//TO SET INITIALLY BOTH INVISIBLE
		panelAdminLogin.setVisible(false);
		panelStudentLogin.setVisible(false);
		
		JPanel panelAdminBtn = new JPanel();
		panelAdminBtn.setBounds(12, 65, 173, 228);
		contentPane.add(panelAdminBtn);
		panelAdminBtn.setLayout(null);
		
		
		JButton btnAdmin = new JButton("");
		btnAdmin.setBounds(0, 0, 173, 180);
		panelAdminBtn.add(btnAdmin);
		btnAdmin.setIcon(new ImageIcon(LoginSystem3.class.getResource("/images/Admin.png")));
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdmin.setBounds(47, 181, 73, 34);
		panelAdminBtn.add(lblAdmin);
		
		JPanel panelStudentBtn = new JPanel();
		panelStudentBtn.setLayout(null);
		panelStudentBtn.setBounds(333, 65, 173, 228);
		contentPane.add(panelStudentBtn);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblStudent.setBounds(47, 181, 97, 34);
		panelStudentBtn.add(lblStudent);
		
		JButton btnStudent = new JButton("");
		btnStudent.setBounds(0, 0, 173, 180);
		panelStudentBtn.add(btnStudent);
		btnStudent.setIcon(new ImageIcon(LoginSystem3.class.getResource("/images/Student1.png")));
		
		JLabel lblLoginSystem = new JLabel("Login System");
		lblLoginSystem.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblLoginSystem.setBounds(190, 13, 199, 39);
		contentPane.add(lblLoginSystem);
		
		//BTN STUDENT CODING
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flagStudent==true)
				{
					panelAdminLogin.setVisible(false);
					panelStudentLogin.setVisible(true);
					
					panelAdminBtn.setVisible(false);
					flagStudent=false;
				}
				else
				{
					panelAdminLogin.setVisible(false);
					panelStudentLogin.setVisible(false);
					
					panelAdminBtn.setVisible(true);
					panelStudentBtn.setVisible(true);
					flagStudent=true;
					
				}
			}
		});
		
		
		//BTN ADMIN CODING
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(flagAdmin==true)
				{
					panelAdminLogin.setVisible(true);
					panelStudentLogin.setVisible(false);
					
					panelStudentBtn.setVisible(false);
					flagAdmin=false;
				}
				else
				{
					panelAdminLogin.setVisible(false);
					panelStudentLogin.setVisible(false);
					
					panelAdminBtn.setVisible(true);
					panelStudentBtn.setVisible(true);
					flagAdmin=true;
				}
				
			}
		});
		
		//EXIT BTN STUDENT PANEL'S  CODING
		btnStudentExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//FOR EXIT BUTTON FROM STUDENT PANEL
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					
					//System.exit(0);
					//its terminate the whole screen
					
					panelAdminLogin.setVisible(false);
					panelStudentLogin.setVisible(false);
					
					panelAdminBtn.setVisible(true);
					panelStudentBtn.setVisible(true);
					flagStudent=true;
				}
			}
		});
		
		
		btnAdminExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//FOR EXIT BUTTON FROM ADMIN PANEL
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Login System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					
					//System.exit(0);
					//its terminate the whole screen
					
					panelAdminLogin.setVisible(false);
					panelStudentLogin.setVisible(false);
					
					panelAdminBtn.setVisible(true);
					panelStudentBtn.setVisible(true);
					flagStudent=true;
				}
			}
		});
		
		
		//To MAKE BOTH BUTTONS VISIBLE AGAIN
	/*	contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelAdmin.setVisible(false);
				panelStudent.setVisible(false);
				
				btnAdmin.setVisible(true);
				btnStudent.setVisible(true);
			}
		});
	*/
		
/*
		//background image
				// 
				JLabel label_20 = new JLabel("");
				label_20.setIcon(new ImageIcon(Feedback.class.getResource("/images/b10.jpg")));
				//label_20.setBounds(0, 0, 710, 450);
				label_20.setBounds(-5, 0, 1930, 1035);
				
				contentPane.add(label_20);
				
				*/
	}
}
