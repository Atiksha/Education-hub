import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MockTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MockTest frame = new MockTest("abc","xyz");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 */
	public MockTest(String n,String c) throws InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1930, 1094);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 1912, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFinalTest = new JLabel("Mock Test");
		lblFinalTest.setBounds(1435, 13, 168, 39);
		lblFinalTest.setFont(new Font("Serif", Font.PLAIN,30));
		panel.add(lblFinalTest);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(322, 108, 1301, 937);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBounds(0, 0, 1301, 74);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTotalNoOf = new JLabel("Total no. of Questions : ");
		lblTotalNoOf.setBounds(161, 23, 191, 27);
		lblTotalNoOf.setFont(new Font("Serif", Font.PLAIN,20));
		panel_2.add(lblTotalNoOf);
		
		textField_5 = new JTextField();
		textField_5.setBounds(360, 23, 49, 27);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEachQuestionMarks = new JLabel("Each Question Marks : ");
		lblEachQuestionMarks.setBounds(526, 23, 185, 27);
		lblEachQuestionMarks.setFont(new Font("Serif", Font.PLAIN,20));
		panel_2.add(lblEachQuestionMarks);
		
		textField_6 = new JTextField();
		textField_6.setBounds(722, 23, 49, 27);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblTimer = new JLabel("TIMER : ");
		lblTimer.setBounds(980, 23, 76, 27);
		lblTimer.setFont(new Font("Serif", Font.PLAIN,20));
		panel_2.add(lblTimer);
		
		JLabel label = new JLabel("");
		label.setBounds(1074, 23, 110, 33);
		label.setBackground(Color.LIGHT_GRAY);
		panel_2.add(label);
		
		
		int x=30;
		while (x>=0)
		{
		//	t.sleep( 1000 );
			x--;
			label.setToolTipText(""+x);
			Thread t=null; 
			
			
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(0, 879, 1301, 58);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Submitted frameSc= new Submitted(n,c);
				frameSc.setVisible(true);
			}
		});
		btnSubmit.setBounds(655, 13, 96, 32);
		panel_3.add(btnSubmit);
		
		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setBounds(141, 232, 81, 27);
		lblQuestion.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblQuestion);
		
		JLabel lblOption = new JLabel("Option 1 :");
		lblOption.setBounds(142, 364, 80, 27);
		lblOption.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblOption);
		
		JLabel lblOption_1 = new JLabel("Option 2 :");
		lblOption_1.setBounds(142, 484, 80, 27);
		lblOption_1.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblOption_1);
		
		JLabel lblOption_2 = new JLabel("Option 3 :");
		lblOption_2.setBounds(142, 588, 80, 27);
		lblOption_2.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblOption_2);
		
		JLabel lblOption_3 = new JLabel("Option 4 :");
		lblOption_3.setBounds(142, 697, 80, 27);
		lblOption_3.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblOption_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(104, 145, 1156, 619);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(131, 176, 1025, 71);
		panel_4.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 40, 1025, 76);
		panel_4.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		textArea_1.setDropMode(DropMode.INSERT);
		textArea_1.setLineWrap(true);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(131, 297, 1025, 71);
		panel_4.add(scrollPane_4);
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_4.setViewportView(textArea_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(131, 409, 1025, 71);
		panel_4.add(scrollPane_3);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_3.setViewportView(textArea_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(131, 513, 1025, 71);
		panel_4.add(scrollPane_2);
		
		JTextArea textArea_4 = new JTextArea();
		scrollPane_2.setViewportView(textArea_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"}));
		comboBox.setBounds(182, 805, 108, 35);
		panel_1.add(comboBox);
		
		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setBounds(97, 806, 73, 27);
		lblAnswer.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblAnswer);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(882, 810, 108, 30);
		panel_1.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(1065, 810, 113, 30);
		panel_1.add(btnNext);
	}
}
