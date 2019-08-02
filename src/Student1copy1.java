import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Student1copy1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student1copy1 frame = new Student1copy1("abc","xyz");
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
	public Student1copy1(String n,String c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5, 0, 1939, 1092);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 1914, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEducationHub = new JLabel("Education Hub");
		lblEducationHub.setBounds(169, 13, 179, 39);
		lblEducationHub.setFont(new Font("Serif", Font.PLAIN,30));
		panel.add(lblEducationHub);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(609, 97, 694, 867);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(0, 0, 694, 57);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblWelomeBack = new JLabel("Welome Back :-)");
		lblWelomeBack.setBounds(285, 13, 203, 39);
		lblWelomeBack.setFont(new Font("Serif", Font.PLAIN,30));
		panel_2.add(lblWelomeBack);
		
		JButton btnSubject = new JButton("Test");
		btnSubject.setFont(new Font("Serif", Font.PLAIN,20));
		btnSubject.setIcon(new ImageIcon("C:\\Education Hub\\Icons\\icons8-Reading-100.png"));
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//this.dispose();
				//Student112 framest= new Student112();
				//framest.setVisible(true);

				FinalTest frameFinal=new FinalTest(n,c);
				frameFinal.setVisible(true);
			}
		});
		btnSubject.setBounds(65, 104, 221, 109);
		panel_1.add(btnSubject);
		
		JButton btnNotes = new JButton("Notes");
		btnNotes.setFont(new Font("Serif", Font.PLAIN,20));
		btnNotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				ReadNotes framestu= new ReadNotes(n,c);
				framestu.setVisible(true);
			}
		});
		btnNotes.setBounds(471, 433, 183, 80);
		panel_1.add(btnNotes);
		
		JButton btnResult = new JButton("Result");
		btnResult.setFont(new Font("Serif", Font.PLAIN,20));
		btnResult.setIcon(new ImageIcon("C:\\Education Hub\\Icons\\icons8-Task Completed-100.png"));
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
				Student113 framestu= new Student113(n,c);
				framestu.setVisible(true);
			}
		});
		btnResult.setBounds(442, 104, 214, 109);
		panel_1.add(btnResult);
		
		JButton btnSuggestion = new JButton("Suggestion");
		btnSuggestion.setFont(new Font("Serif", Font.PLAIN,20));
		btnSuggestion.setIcon(new ImageIcon("C:\\Education Hub\\Icons\\icons8-Communication-96.png"));
		btnSuggestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Suggestion framestud= new Suggestion(n,c);
				framestud.setVisible(true);
			}
		});
		btnSuggestion.setBounds(428, 702, 221, 97);
		panel_1.add(btnSuggestion);
		
	/*	JButton btnProfile = new JButton("Profile");
		btnProfile.setFont(new Font("Serif", Font.PLAIN,20));
		btnProfile.setIcon(new ImageIcon("C:\\Education Hub\\Icons\\icons8-Administrator Male-100.png"));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				StudentProfile framestude= new StudentProfile();
				framestude.setVisible(true);
			}
		});
		btnProfile.setBounds(65, 696, 224, 109);
		panel_1.add(btnProfile);
	*/	
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Education Hub\\Images\\638c40e20579791f59f28a6aa70d3884.png"));
		label_1.setBounds(12, 245, 482, 447);
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Education Hub\\Images\\susan-yin-647448-unsplash.jpg"));
		label.setBounds(0, 0, 1914, 1045);
		contentPane.add(label);
	}
}
