import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class CreatePaperSmallFrame extends JFrame {

	private JPanel contentPane;
	boolean flagAdmin=true,flagStudent=true;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePaperSmallFrame frame = new CreatePaperSmallFrame();
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
	public CreatePaperSmallFrame() {
		Home frameObj=new Home();
		frameObj.setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreatePaperSmallFrame.class.getResource("/images/logo.png")));
		setTitle("Create Exam Paper");
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
		//panel.setOpaque(false);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlShadow);
		panel_1.setForeground(UIManager.getColor("Button.shadow"));
		panel_1.setBounds(5,5, 329, 45);
		panel.add(panel_1);
		panel_1.setLayout(null);
		//panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		
		JLabel lblLoginSystem = new JLabel("Create Exam Paper");
		lblLoginSystem.setBounds(12, 0, 270, 39);
		panel_1.add(lblLoginSystem);
		lblLoginSystem.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 55, 329, 174);
		panel.add(panel_2);
		panel_2.setLayout(null);
		//panel_2.setOpaque(false);
		//panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSubject.setBounds(12, 13, 76, 29);
		panel_2.add(lblSubject);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Java(core)", "java(Advance)", "DBMS", "DAA", "OOPS", "Computer Organisation", "Operationg System", "Computer Networks"}));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBox.setBounds(100, 11, 178, 32);
		panel_2.add(comboBox);
		
		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setModel(new DefaultComboBoxModel(new String[] {"Mock/Pratice", "Final Exam"}));
		comboBoxType.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxType.setBounds(100, 55, 178, 32);
		panel_2.add(comboBoxType);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Arial", Font.PLAIN, 20));
		lblType.setBounds(12, 57, 76, 29);
		panel_2.add(lblType);
		
		JLabel lblNoOfQuestios = new JLabel("No. of Questios");
		lblNoOfQuestios.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNoOfQuestios.setBounds(12, 97, 151, 29);
		panel_2.add(lblNoOfQuestios);
		
		JLabel lblTime = new JLabel("Duration");
		lblTime.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTime.setBounds(12, 135, 76, 29);
		panel_2.add(lblTime);
		
		JSpinner spinnerNoOfQue = new JSpinner();
		spinnerNoOfQue.setFont(new Font("Arial", Font.PLAIN, 20));
		spinnerNoOfQue.setModel(new SpinnerNumberModel(10, 5, 100, 5));
		spinnerNoOfQue.setBounds(176, 96, 102, 29);
		panel_2.add(spinnerNoOfQue);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setBounds(130, 135, 110, 29);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblMins = new JLabel("Mins");
		lblMins.setFont(new Font("Arial", Font.PLAIN, 15));
		lblMins.setBounds(246, 135, 32, 29);
		panel_2.add(lblMins);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlShadow);
		panel_3.setForeground(UIManager.getColor("Button.shadow"));
		panel_3.setLayout(null);
		panel_3.setBounds(5, 233, 329, 50);
		panel.add(panel_3);
		//panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//FOR EXIT BUTTON 
				JFrame frmLoginSystem = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit", "Create Paper System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnCancel.setBounds(26, 15, 94, 29);
		panel_3.add(btnCancel);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			
				frameObj.setVisible(false);
				//new CreatePaper().show();
				CreatePaper frame1 =new CreatePaper();
				frame1.setVisible(true);
				frame1.lblAbc.setText(comboBox.getSelectedItem().toString());
				frame1.txtDuration.setText(textField.getText());
				frame1.txtNoOfQuestion.setText(spinnerNoOfQue.getValue().toString());
				frame1.lblPratice.setText(comboBoxType.getSelectedItem().toString());
				dispose();
				//lblType	comboBoxType
				
				//comboBox;
				
				
			}
		});
		btnGo.setBounds(207, 15, 94, 29);
		panel_3.add(btnGo);
		
		

		//background image
		// 
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(CreatePaperSmallFrame.class.getResource("/images/b10.jpg")));
		//label_20.setBounds(0, 0, 710, 450);
		label_20.setBounds(-5, 0, 1930, 1035);
		
		contentPane.add(label_20);
		
		
	}
}
