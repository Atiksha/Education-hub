import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.sql.*;
import javax.swing.JPasswordField;

public class LG extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LG frame = new LG();
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
	public LG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(134, 54, 269, 22);
		contentPane.add(user);
		user.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
					Statement stmt = con.createStatement();
					String sql ="Select * from adminlogin where a_Name =  '" + user.getText() +" '    and a_Password = '" + pass.getText().toString() +"'";
					ResultSet rs =stmt.executeQuery(sql);
					if(rs.next()) 
					{
						JOptionPane.showMessageDialog(null, "LOGIN SUCESSFULLY ...");
						user.setText(null);
						pass.setText(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "INCORRECT LOGIN DETAILS ...");
						user.setText(null);
						pass.setText(null);
					}
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnLogin.setBounds(134, 170, 97, 25);
		contentPane.add(btnLogin);
		
		pass = new JPasswordField();
		pass.setBounds(134, 110, 269, 22);
		contentPane.add(pass);
	}
}
