import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Suggestion extends JFrame {

	private JPanel contentPane;
	JTextArea textAreaSugesstion,textAreaProblem;
	String Name;
	String Course;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suggestion frame = new Suggestion("abc","xyz");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public Suggestion(String n,String c) {
		 Name=n;
		 Course=c;
		connection = SqlConnection.dbConnector();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-10, 0, 1930, 1094);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(0, 0, 1912, 104);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(619, 159, 688, 691);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 688, 82);
		panel_2.setBackground(Color.CYAN);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSuggestion = new JLabel("SUGGESTION");
		lblSuggestion.setBounds(294, 28, 76, 41);
		panel_2.add(lblSuggestion);
		
		JLabel lblProblem = new JLabel("PROBLEM : ");
		lblProblem.setBounds(48, 179, 87, 37);
		panel_1.add(lblProblem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 140, 561, 118);
		panel_1.add(scrollPane);
		
		 textAreaProblem = new JTextArea();
		scrollPane.setViewportView(textAreaProblem);
		
		JLabel lblSuggestions = new JLabel("Suggestions : ");
		lblSuggestions.setBounds(37, 336, 82, 16);
		panel_1.add(lblSuggestions);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(121, 283, 561, 129);
		panel_1.add(scrollPane_1);
		
		 textAreaSugesstion = new JTextArea();
		scrollPane_1.setViewportView(textAreaSugesstion);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{				
				addOperation();
			}
		});
		btnSend.setBounds(484, 529, 127, 67);
		
		panel_1.add(btnSend);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(94, 529, 133, 67);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Student1copy1 frame1=new Student1copy1(n,c);
				frame1.setVisible(true);
			}
		});
		panel_1.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Education Hub\\Images\\susan-yin-647448-unsplash.jpg"));
		label.setBounds(0, 0, 1912, 1045);
		contentPane.add(label);
	}
	
	
	
	private void addOperation() 
	{
		
		
		String Problem=textAreaProblem.getText();
		String Sugesstion=textAreaSugesstion.getText();
		
		
		//RIHGHT CODE TO GET BELOW DETAILS
		
		//String Name="sal";
		//String Course="MCA";
		String Id="7";
		
	
		
		try 
		{
			String query = "INSERT INTO suggestion (S_SId,S_Name,S_Problem,S_Suggestion,S_SCourse) " +
					"Values ('	"+Id+"'," +
							"'"+Name+"'," +
							"'"+Problem+"'," +
							"'"+Sugesstion+"'," +
							"'"+Course+"')";
			
								
				Statement st = connection.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Suggestion is send");
				resetFields();
			
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}	
		
			
		
	
	}
	private void resetFields()
	{
		textAreaProblem.setText(null);
		textAreaSugesstion.setText(null);
				
	}
}
