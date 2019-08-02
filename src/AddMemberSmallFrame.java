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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class AddMemberSmallFrame extends JFrame {

	private JPanel contentPane;
	boolean flagAdmin=true,flagStudent=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberSmallFrame frame = new AddMemberSmallFrame();
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
	public AddMemberSmallFrame() {
		
		Home frameObj=new Home();
		frameObj.setVisible(true);	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddMemberSmallFrame.class.getResource("/images/logo.png")));
		setTitle("Add Member");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 534, 350);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(88, 13, 340, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setForeground(UIManager.getColor("Button.shadow"));
		panel_1.setBounds(5,5, 329, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLoginSystem = new JLabel("Add Member");
		lblLoginSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginSystem.setBounds(12, 0, 270, 39);
		panel_1.add(lblLoginSystem);
		lblLoginSystem.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 55, 329, 174);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSubject = new JLabel("Choose Wheather To add new Member as");
		lblSubject.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSubject.setBounds(24, 0, 293, 39);
		panel_2.add(lblSubject);
		
		JComboBox comboBoxMember = new JComboBox();
		comboBoxMember.setModel(new DefaultComboBoxModel(new String[] {"Student", "Faculty", "Admin"}));
		comboBoxMember.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxMember.setBounds(103, 84, 113, 32);
		panel_2.add(comboBoxMember);
		
		JLabel lblFacultyStudent = new JLabel("Faculty , Student or new Admin");
		lblFacultyStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacultyStudent.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFacultyStudent.setBounds(12, 44, 293, 39);
		panel_2.add(lblFacultyStudent);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setForeground(UIManager.getColor("Button.shadow"));
		panel_3.setLayout(null);
		panel_3.setBounds(5, 233, 329, 50);
		panel.add(panel_3);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnCancel.setBounds(30, 15, 94, 29);
		panel_3.add(btnCancel);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ans = comboBoxMember.getSelectedItem().toString();
			
				if(ans.contains("Student"))
				{
					frameObj.setVisible(false);	
					dispose();
					AddStudent frameObj=new AddStudent();
					frameObj.setVisible(true);	
				}
				else
				if(ans.contains("Faculty"))
				{
					frameObj.setVisible(false);	
					dispose();
					AddFaculty frameObj=new AddFaculty();
					frameObj.setVisible(true);	
				}
				else
				if(ans.contains("Admin"))
				{
					frameObj.setVisible(false);	
					dispose();
					AddFaculty frameObj=new AddFaculty();
					frameObj.setVisible(true);	
				}
				else
				{
					System.out.println("Wrong Choice");
				}
			}
		});
		btnGo.setBounds(202, 15, 94, 29);
		panel_3.add(btnGo);
		
		
		//background image
				// 
				JLabel label_20 = new JLabel("");
				label_20.setIcon(new ImageIcon(Feedback.class.getResource("/images/b10.jpg")));
				//label_20.setBounds(0, 0, 710, 450);
				label_20.setBounds(-5, 0, 1930, 1035);
				
				contentPane.add(label_20);
	
	}
}
