import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DatabaseExampleGUI extends Frame implements ActionListener 
{
	List ldept;
	Panel p1,p2;
	TextArea ta;
	Statement stmt=null;
	Connection con=null;
	ResultSet rs = null;
	DatabaseExampleGUI()
	{
		setLayout(new GridLayout(2,1));
		setSize(450,450);
		setTitle("Employee Information");
		p1=new Panel();
		p1.setLayout(new GridLayout(2,1));
		p2=new Panel();
		p2.setLayout(new GridLayout(1,1));
		ldept=new List(5);
		p1.add(new Label("Select Department Number",Label.CENTER));
		p1.add(ldept,p1.CENTER_ALIGNMENT);
		ta=new TextArea(10,50);
		ta.setVisible(false);
		ta.setEditable(false);
		p2.add(ta);
			      
		add(p1);
		add(p2);
		ldept.addActionListener(this);
		try 
		{
			//Class.forName("com.mysql.jdbc.Driver");  
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");
			stmt= con.createStatement();
			rs= stmt.executeQuery("select dno from dept");
			while(rs.next())
			{
				ldept.add(rs.getString("dno")+"");
			}
			stmt.close();
			rs.close();
			con.close();
		} catch (Exception e) {}
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DatabaseExampleGUI();
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ta.setVisible(true);
		try
		{
			
			
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");		
			stmt= con.createStatement();
			int n=Integer.parseInt(ldept.getSelectedItem());
			//String sql="select * from Pers where dno= "+n;
			String sql="select * from Pers where dno= "+ldept.getSelectedItem();
			rs=stmt.executeQuery(sql);
			ta.setText("Ecode\t\t Ename\t\t designation\t\t Dno\n");
					
		while(rs.next())
			{
				ta.append(rs.getString("empcode")+"\t\t "+rs.getString("empname")+"\t\t "+rs.getString("designation")+"\t\t "+rs.getInt("dno")+"\n");
			}
			stmt.close();
			rs.close();
			con.close();
		}
		catch(Exception e){}
	}

}
