import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JCheckBoxMenuItem;
import java.awt.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;


public class Student112 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student112 frame = new Student112("abc","xyz");
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
	public Student112(String n,String c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 615, 422);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Student1copy1 aa=new Student1copy1(n,c);
		aa.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 51));
		panel.setBounds(0, 0, 597, 51);
		contentPane.add(panel);
		
		JLabel lblChooseSubject = new JLabel("CHOOSE SUBJECT");
		panel.add(lblChooseSubject);
		lblChooseSubject.setBackground(Color.BLUE);
		lblChooseSubject.setFont(new Font("Serif", Font.PLAIN,30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 191, 216));
		panel_1.setBounds(42, 64, 513, 290);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSubject = new JLabel("SUBJECT  :");
		lblSubject.setBounds(33, 76, 98, 27);
		lblSubject.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblSubject);
		
		JList list = new JList();
		list.setBounds(198, 15, 1, 1);
		panel_1.add(list);
		
		JLabel lblUnit = new JLabel("UNIT :");
		lblUnit.setBounds(75, 116, 56, 40);
		lblUnit.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblUnit);
		
		JButton btnMockTest = new JButton("MOCK TEST");
		btnMockTest.setBounds(333, 73, 118, 38);
		btnMockTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			/*	MockTest mm= new MockTest();
				mm.setVisible(true);
				*/
			}
		});
		panel_1.add(btnMockTest);
		
		JButton btnFinalTest = new JButton("FINAL TEST");
		btnFinalTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aa.setVisible(false);
				dispose();
				
				FinalTest frameFinal=new FinalTest(n,c);
				frameFinal.setVisible(true);
				
			}
		});
		btnFinalTest.setBounds(333, 165, 124, 38);
		panel_1.add(btnFinalTest);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 79, 107, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"DAA", "JAVA", "O.S", "PDP", "DBMS"}));
		comboBox.setToolTipText("DAA\r\nJAVA\r\nO.S\r\nPDP");
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(143, 125, 107, 28);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"UNIT I", "UNIT II", "UNIT III", "UNIT IV", "UNIT V"}));
		panel_1.add(comboBox_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("I:\\A B.Tech(CS_V SEM)\\JAVA\\Education Hub\\Images\\colorful-pens-and-pencils_23-2147650791.jpg"));
		label.setBounds(0, 0, 513, 290);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("I:\\A B.Tech(CS_V SEM)\\JAVA\\Education Hub\\Images\\kimberly-farmer-287677-unsplash.jpg"));
		label_1.setBounds(0, 0, 597, 375);
		contentPane.add(label_1);
	}
}
