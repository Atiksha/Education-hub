import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	
	
	
	//TO SHOW THE HOVER EFFECT BY CHANGING COLOR
		public void setColor(JPanel panel_2)
		{
			//Color c = new Color(197,197,197);
			panel_2.setBackground(new java.awt.Color(197,197,197));
		}
		
		public void resetColor(JPanel panel_2)
		{
			panel_2.setBackground(new java.awt.Color(220, 220, 220));
		}
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Education Hub");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 1100, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setBounds(0, 0, 1100, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setIcon(new ImageIcon(Home.class.getResource("/images/logo.png")));
		label_2.setBackground(new Color(211, 211, 211));
		label_2.setBounds(137, 54, 102, 100);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Education Hub");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Arial", Font.BOLD, 32));
		label_4.setBackground(new Color(0, 102, 255));
		label_4.setBounds(251, 49, 223, 38);
		panel.add(label_4);
		
		JLabel label_6 = new JLabel("A Learning Habbit");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBackground(new Color(0, 102, 255));
		label_6.setBounds(340, 81, 134, 27);
		panel.add(label_6);
		
		JPanel panelButtonMenu = new JPanel();
		panelButtonMenu.setBackground(UIManager.getColor("Button.background"));
		panelButtonMenu.setBounds(0, 251, 1085, 505);
		contentPane.add(panelButtonMenu);
		panelButtonMenu.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_1);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_1);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
				new AddMemberSmallFrame().show();
			}
			
		});
		panel_1.setBackground(new java.awt.Color(220,220,220));
		panel_1.setBounds(132, 46, 204, 179);
		panelButtonMenu.add(panel_1);
		panel_1.setLayout(null);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Home.class.getResource("/images/AddMembers.png")));
		label.setBounds(23, 8, 159, 145);
		panel_1.add(label);
		
		JLabel lblAddMembers = new JLabel("Add Members");
		lblAddMembers.setForeground(new Color(51, 102, 255));
		lblAddMembers.setFont(new Font("Arial", Font.PLAIN, 22));
		lblAddMembers.setBounds(26, 153, 156, 26);
		panel_1.add(lblAddMembers);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_2);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_2);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				new AddNotes().show();
			}
			
		});
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(220, 220, 220));
		panel_2.setBounds(444, 46, 204, 179);
		panelButtonMenu.add(panel_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Home.class.getResource("/images/notes1.png")));
		label_1.setBounds(47, 8, 146, 140);
		panel_2.add(label_1);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setForeground(new Color(51, 102, 255));
		lblNotes.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNotes.setBounds(64, 153, 90, 26);
		panel_2.add(lblNotes);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_3);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_3);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				new QuestionBank().show();
			}
			
		});
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setBounds(755, 46, 204, 179);
		panelButtonMenu.add(panel_3);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Home.class.getResource("/images/questionbank.png")));
		label_3.setBounds(40, 8, 171, 145);
		panel_3.add(label_3);
		
		JLabel lblQuestionBank = new JLabel("Question Bank");
		lblQuestionBank.setForeground(new Color(51, 102, 255));
		lblQuestionBank.setFont(new Font("Arial", Font.PLAIN, 22));
		lblQuestionBank.setBounds(25, 153, 156, 26);
		panel_3.add(lblQuestionBank);
		
		JPanel panel_4 = new JPanel();
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_4);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_4);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				dispose();
				new CreatePaperSmallFrame().show();
			}
			
		});
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(220, 220, 220));
		panel_4.setBounds(132, 279, 204, 179);
		panelButtonMenu.add(panel_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Home.class.getResource("/images/Createpaper.png")));
		label_5.setBounds(39, 0, 143, 145);
		panel_4.add(label_5);
		
		JLabel lblCreatePaper = new JLabel("Create Paper");
		lblCreatePaper.setForeground(new Color(51, 102, 255));
		lblCreatePaper.setFont(new Font("Arial", Font.PLAIN, 22));
		lblCreatePaper.setBounds(26, 147, 156, 26);
		panel_4.add(lblCreatePaper);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_5);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_5);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				new Report().show();
			}
			
		});
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(444, 279, 204, 179);
		panelButtonMenu.add(panel_5);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Home.class.getResource("/images/report1.png")));
		label_7.setBounds(39, 0, 148, 145);
		panel_5.add(label_7);
		
		JLabel lblReport = new JLabel("Report");
		lblReport.setForeground(new Color(51, 102, 255));
		lblReport.setFont(new Font("Arial", Font.PLAIN, 22));
		lblReport.setBounds(61, 147, 108, 26);
		panel_5.add(lblReport);
		
		JPanel panel_6 = new JPanel();
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setColor(panel_6);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				resetColor(panel_6);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				new Feedback().show();
				dispose();
			}
			
		});
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(755, 279, 204, 179);
		panelButtonMenu.add(panel_6);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(Home.class.getResource("/images/feedback.png")));
		label_9.setBounds(37, 8, 150, 145);
		panel_6.add(label_9);
		
		JLabel lblFeedback = new JLabel("Feedback");
		lblFeedback.setForeground(new Color(51, 102, 255));
		lblFeedback.setFont(new Font("Arial", Font.PLAIN, 22));
		lblFeedback.setBounds(51, 147, 131, 26);
		panel_6.add(lblFeedback);
	}
}
