import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ReadNotes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadNotes frame = new ReadNotes("abc","xyz");
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
	public ReadNotes(String n,String c) {
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
		
		JScrollPane scrollPaneNotes = new JScrollPane();
		scrollPaneNotes.setBounds(47, 101, 614, 717);
		panel_1.add(scrollPaneNotes);
		
		JTextArea textAreaNotes = new JTextArea();
		scrollPaneNotes.setViewportView(textAreaNotes);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Education Hub\\Images\\susan-yin-647448-unsplash.jpg"));
		label.setBounds(0, 0, 1914, 1045);
		contentPane.add(label);
		
		JLabel lblWelomeBack = new JLabel("SELECT NOTES   :");
		lblWelomeBack.setBounds(174, 13, 248, 39);
		lblWelomeBack.setFont(new Font("Serif", Font.PLAIN,30));
		panel_2.add(lblWelomeBack);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{	/*
				JFileChooser jFileChooser = new JFileChooser();
			       //jFileChooser.setCurrentDirectory(new File("C:/Users/ASUS/Desktop"));
			       jFileChooser.setCurrentDirectory(new File("D:\\SEC A 12\\Atiksha\\DatabaseConnection\\Notes"));
			       
			       int result = jFileChooser.showOpenDialog(new JFrame());
			       if (result == JFileChooser.APPROVE_OPTION) 
			       {
			    	   
			    	  // File selectedFile = new jFileChooser("C:/Users/ASUS/Desktop");
			    	   File selectedFile = jFileChooser.getSelectedFile();
			    	   System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			    	   
			    	   try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {

			    		   String strCurrentLine;

			    		   while ((strCurrentLine = br.readLine()) != null) 
			    		   {
			    		    System.out.println(strCurrentLine);
			    		    System.out.println("--------");
			    		    textAreaNotes.read(br , null);
			    		   }

			    		  } catch (IOException e) {
			    		   e.printStackTrace();
			    		  }
			       }
				
				
				
				
				*/
				
				JFileChooser jFileChooser = new JFileChooser();
			       jFileChooser.setCurrentDirectory(new File("D:\\\\SEC A 12\\\\Atiksha\\\\DatabaseConnection\\\\Notes"));
			       int result = jFileChooser.showOpenDialog(new JFrame());
			       if (result == JFileChooser.APPROVE_OPTION) 
			       {
			    	   
			    	   File selectedFile = jFileChooser.getSelectedFile();
			    	   System.out.println("Selected file: " + selectedFile.getAbsolutePath());
			    	   
			    	   try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {

			    		   String strCurrentLine;

			    		   while ((strCurrentLine = br.readLine()) != null) 
			    		   {
			    		    System.out.println(strCurrentLine);
			    		    System.out.println("--------");
			    		    textAreaNotes.read(br , null);
			    		   }

			    		  } catch (IOException e) {
			    		   e.printStackTrace();
			    		  }
			       }
			}
		});
		btnView.setBounds(472, 10, 126, 42);
		panel_2.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
				Student1copy1 frameSc= new Student1copy1(n,c);
				frameSc.setVisible(true);
			}
		});
		btnBack.setBounds(556, 819, 105, 35);
		panel_1.add(btnBack);
		
		
	}
}
