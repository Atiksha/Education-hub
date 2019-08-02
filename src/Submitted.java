import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Submitted extends JFrame {

	private JPanel contentPane;
	JLabel labelScored,labelTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Submitted frame = new Submitted("abc","xyz");
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
	public Submitted(String n,String c) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 615, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* FinalTest t= new FinalTest();
		t.setVisible(true);
		*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 597, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSubmitted = new JLabel("SUBMITTED");
		lblSubmitted.setBounds(216, 13, 173, 39);
		lblSubmitted.setFont(new Font("Serif", Font.PLAIN,30));
		panel.add(lblSubmitted);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(87, 70, 416, 292);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_2.setBounds(0, 0, 416, 38);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCongratulations = new JLabel("CONGRATULATIONS");
		lblCongratulations.setBounds(80, 0, 296, 39);
		lblCongratulations.setFont(new Font("Serif", Font.PLAIN,25));
		panel_2.add(lblCongratulations);
		
		JLabel lblYouScored = new JLabel("You Scored : ");
		lblYouScored.setBounds(63, 167, 137, 33);
		lblYouScored.setFont(new Font("Serif", Font.PLAIN,25));
		panel_1.add(lblYouScored);
		
		JLabel lbl = new JLabel("Total Marks : ");
		lbl.setBounds(53, 83, 138, 33);
		lbl.setFont(new Font("Serif", Font.PLAIN,25));
		panel_1.add(lbl);
		
		 labelScored = new JLabel("24");
		labelScored.setBounds(203, 174, 56, 29);
		panel_1.add(labelScored);
		
		labelTotal = new JLabel("100");
		labelTotal.setBounds(203, 90, 56, 29);
		panel_1.add(labelTotal);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			/*	t.setVisible(false);				*/
				Student1copy1 frameSc= new Student1copy1(n,c);
				frameSc.setVisible(true);
			}
		});
		btnOk.setBounds(162, 223, 97, 43);
		panel_1.add(btnOk);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Education Hub\\Images\\colorful-pens-and-pencils_23-2147650791.jpg"));
		label_2.setBounds(0, 39, 416, 253);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Education Hub\\Images\\kimberly-farmer-287677-unsplash.jpg"));
		label_3.setBounds(0, 56, 597, 319);
		contentPane.add(label_3);
	}
}
