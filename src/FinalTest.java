import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FinalTest extends JFrame {

	private JPanel contentPane;
	
	
	 JTextField textFieldTotalNoQue;
	 JTextField textFieldMark;
	
	JTextArea textAreaQuestion,textAreaOpt1,textAreaOpt2,textAreaOpt3,textAreaOpt4;
	JComboBox comboBoxA;
	JButton btnPrevious,btnNext;
	JLabel labelTime;
	ResultSet rs;
	float total=0,gain=0;
	String Ans,Mark,optChoose,TNQ,TName,TID,TSub,Student,Course;
	
	float[] AMark,AAtempt,AScore;
	int flage=0,flage1=0,counter=0,n=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalTest frame = new FinalTest("abc","xyz");
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
	 * @throws InterruptedException 
	 */
	public FinalTest(String n,String c)// throws InterruptedException
	{
		Student=n;
		Course=c;
		connection = SqlConnection.dbConnector();
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
		
		JLabel lblFinalTest = new JLabel("FINAL TEST");
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
		
		textFieldTotalNoQue = new JTextField();
		textFieldTotalNoQue.setBounds(360, 23, 49, 27);
		panel_2.add(textFieldTotalNoQue);
		textFieldTotalNoQue.setColumns(10);
		
		JLabel lblEachQuestionMarks = new JLabel("Each Question Marks : ");
		lblEachQuestionMarks.setBounds(526, 23, 185, 27);
		lblEachQuestionMarks.setFont(new Font("Serif", Font.PLAIN,20));
		panel_2.add(lblEachQuestionMarks);
		
		textFieldMark = new JTextField();
		textFieldMark.setBounds(722, 23, 49, 27);
		panel_2.add(textFieldMark);
		textFieldMark.setColumns(10);
		
		JLabel lblTimer = new JLabel("TIMER : ");
		lblTimer.setBounds(980, 23, 76, 27);
		lblTimer.setFont(new Font("Serif", Font.PLAIN,20));
		panel_2.add(lblTimer);
		
		 labelTime = new JLabel("30");
		labelTime.setFont(new Font("Arial", Font.BOLD, 20));
		labelTime.setBounds(1056, 22, 40, 33);
		labelTime.setBackground(Color.LIGHT_GRAY);
		panel_2.add(labelTime);
		
		JLabel lblmin = new JLabel("min");
		lblmin.setBounds(1098, 30, 29, 16);
		panel_2.add(lblmin);
		
		
		/*int x=30;
		while (x>=0)
		{
			x--;
			labelTime.setToolTipText(""+x);
			Thread t=null; 
			t.sleep( 1000 );
			
		}
		*/
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(0, 879, 1301, 58);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
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
		
		 textAreaOpt1 = new JTextArea();
		scrollPane_1.setViewportView(textAreaOpt1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(131, 40, 1025, 76);
		panel_4.add(scrollPane);
		
		 textAreaQuestion = new JTextArea();
		scrollPane.setViewportView(textAreaQuestion);
		textAreaQuestion.setDropMode(DropMode.INSERT);
		textAreaQuestion.setLineWrap(true);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(131, 297, 1025, 71);
		panel_4.add(scrollPane_4);
		
		 textAreaOpt2 = new JTextArea();
		scrollPane_4.setViewportView(textAreaOpt2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(131, 409, 1025, 71);
		panel_4.add(scrollPane_3);
		
		 textAreaOpt3 = new JTextArea();
		scrollPane_3.setViewportView(textAreaOpt3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(131, 513, 1025, 71);
		panel_4.add(scrollPane_2);
		
		 textAreaOpt4 = new JTextArea();
		scrollPane_2.setViewportView(textAreaOpt4);
		
		 comboBoxA = new JComboBox();
		comboBoxA.setModel(new DefaultComboBoxModel(new String[] {"Option 1", "Option 2", "Option 3", "Option 4"}));
		comboBoxA.setBounds(182, 805, 108, 35);
		panel_1.add(comboBoxA);
		comboBoxA.setSelectedIndex(-1);
		comboBoxA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) 
			{
				
				checkAns();
			}
		});
		
		JLabel lblAnswer = new JLabel("Answer :");
		lblAnswer.setBounds(97, 806, 73, 27);
		lblAnswer.setFont(new Font("Serif", Font.PLAIN,20));
		panel_1.add(lblAnswer);
		
		 btnPrevious = new JButton("Previous");
		 btnPrevious.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) 
		 	{
		 		previousNavigation();
		 	}
		 });
		btnPrevious.setBounds(882, 810, 108, 30);
		panel_1.add(btnPrevious);
		
		 btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				nextNavigation();
				
			}
		});
		btnNext.setBounds(1065, 810, 113, 30);
		panel_1.add(btnNext);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(592, 806, 96, 32);
		panel_1.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				for(int i=1;i<=10;i++)
				{
					System.out.println(AMark[i]);
					System.out.println(AScore[i]);
					System.out.println("-------");
					total=total+AMark[i];
					gain=gain+AScore[i];
				}
				addOperation();
				dispose();
				Submitted frameSc= new Submitted(n,c);
				frameSc.setVisible(true);
				frameSc.labelScored.setText(gain+"");
				frameSc.labelTotal.setText(total+"");
			}
		});
	}
	
	
	
	private void nextNavigation() 
	{
			try
			{
				if(rs == null)
				{
					
					String sql = "SELECT * FROM createpaper";
					Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
																ResultSet.CONCUR_UPDATABLE);
					
					 rs = st.executeQuery(sql);
				}
				if(rs.next())
				{
					counter=counter+1;
					populateValue();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You attempt all Question.click ok to submit");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                                JOptionPane.ERROR_MESSAGE);
			}
	}
	
	
	private void previousNavigation() 
	{
			try
			{
				if(rs == null)
				{
					String sql = "SELECT * FROM createpaper";
					Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
																ResultSet.CONCUR_UPDATABLE);
					
					 rs = st.executeQuery(sql);
				}
				if(rs.previous())
				{
					counter=counter-1;
					populateValue();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You reach at First Question");
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                                JOptionPane.ERROR_MESSAGE);
			}
	}
	
	

	private void populateValue()
	{
		
		try
		{
			
			String Que = rs.getString("C_Que");
			String Op1 = rs.getString("C_Option1");
			String Op2 = rs.getString("C_Option2");
			String Op3 = rs.getString("C_Option3");
			String Op4 = rs.getString("C_Option4");
			
			
		
			
			
			String Exp = rs.getString("C_Explaination");
			 Ans = rs.getString("C_Ans");
			 Mark = rs.getString("C_Marks");
			// System.out.println(""+Float.valueOf(Mark));
				int Time = rs.getInt("C_Time");
				//	String TNQ = "10";
			 if(flage1==0)
				{
				
				 
					TNQ = rs.getString("C_NoOfQue");
					TName = rs.getString("C_ExamName");
					TID = rs.getString("C_ID");
					TSub= rs.getString("C_Sub");
					//Student="Kirti";
					//Course="B.Tech";
					//Student=s;
					//Course=s;
					flage1=1;
				}
			 
			
			
			textAreaQuestion.setText(Que);
			textAreaOpt1.setText(Op1);
			textAreaOpt2.setText(Op2);
			textAreaOpt3.setText(Op3);
			textAreaOpt4.setText(Op4);
			
			textFieldTotalNoQue.setText(TNQ);
			textFieldMark.setText(Mark);
			labelTime.setText(Time +"");
			comboBoxA.setSelectedIndex(-1);
			
	    } catch(Exception e){}
	}
	private void checkAns()
	{
		if(flage==0)
		{
			 n=Integer.parseInt(TNQ);
			//System.out.println("valiye if n is"+n);
			AMark = new float[11];	
			AScore = new float[11];	
			AAtempt = new float[11];
			flage=1;
		}
		//System.out.println("value of"+counter);
		AMark[counter]=Float.valueOf(Mark);
		System.out.println("val" +counter);
		System.out.println(AMark	[counter]);
		String opt=comboBoxA.getSelectedItem().toString();
		if(opt.equals(Ans))
		{	
			AScore[counter]=Float.valueOf(Mark);
			
			//total=total+Float.valueOf(Mark);
			//gain=gain+Float.valueOf(Mark);
		}
		else
		{
			AScore[counter]=0;
			//total=total+Float.valueOf(Mark);
		}
	}
	
	
	
	private void addOperation() 
	{
			try 
		{
			String query = "INSERT INTO report(R_TestName,R_TestId,R_Sub,R_Student,R_Course,R_Total,R_Scored) " +
					"Values ('	"+TName+"'," +
							"'"+TID+"'," +
							"'"+TSub+"'," +
							"'"+Student+"'," +
							"'"+Course+"'," +
							
							"'"+total+"'," +
							"'"+gain+"')";
			
								
				Statement st = connection.createStatement();
				st.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Your Test rescord is saved ");
				//resetFields();
			
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}	
		
	}
	
	
	
}
