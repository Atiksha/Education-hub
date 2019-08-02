import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.JOptionPane;   

public class DabaseExampleAll  implements ActionListener 
{
	Label lblEcode,lblEname,lblDesignation,lblDno;
	Label lblecVal,lblenVal,lbldesgnVal,lbldnoVal;
	TextField txtEcode,txtEname,txtDesignation,txtDno;
	Button btnAdd,btnUpdate,btnDelete,btnPrev,btnNext;
	ResultSet rs;
	Connection con = null;
	
	public static void main(String[] args) 
	{
		DabaseExampleAll obj = new DabaseExampleAll();
		obj.createUI();
	}

	private void createUI()
	{
		Frame frame = new Frame("JDBC All in One");

		Panel pnlInput = new Panel(new GridLayout(4,2));

		lblEcode = new Label("  Employee Code : ");
		txtEcode = new TextField(15);

		lblEname = new Label("  Employee Name : ");
		txtEname = new TextField();

		lblDesignation = new Label("  Designation : ");
		txtDesignation = new TextField();

		lblDno = new Label("  Dept No : ");
		txtDno = new TextField();

		pnlInput.add(lblEcode);
		pnlInput.add(txtEcode);

		pnlInput.add(lblEname);
		pnlInput.add(txtEname);

		pnlInput.add(lblDesignation);
		pnlInput.add(txtDesignation);

		pnlInput.add(lblDno);
		pnlInput.add(txtDno);

		Panel pnlButton = new Panel(new GridLayout(1,3));

		btnAdd = new Button("Add");
		btnAdd.addActionListener(this);

		
		btnUpdate = new Button("Update");
		btnUpdate.addActionListener(this);

		btnDelete = new Button("Delete");
		btnDelete.addActionListener(this);

		pnlButton.add(btnAdd);
		pnlButton.add(btnUpdate);
		pnlButton.add(btnDelete);

		Panel pnlNavigate = new Panel(new GridLayout(1,2));
		btnPrev = new Button(" << ");
		btnPrev.setActionCommand("Prev");
		btnPrev.addActionListener(this);

		btnNext = new Button(" >> ");
		btnNext.setActionCommand("Next");
		btnNext.addActionListener(this);

		pnlNavigate.add(btnPrev);
		pnlNavigate.add(btnNext);

		Panel pnlNavAns = new Panel(new GridLayout(4,2));

		Label lblec = new Label("  Emp Code : ");
		lblecVal = new Label("Val");

		Label lblen = new Label("  Emp Name : ");
		lblenVal = new Label("Val");

		Label lbldesgn = new Label("  Designation : ");
		lbldesgnVal = new Label("Val");

		Label lbldno = new Label("  Dept No. : ");
		lbldnoVal = new Label("Val");

		pnlNavAns.add(lblec);
		pnlNavAns.add(lblecVal);

		pnlNavAns.add(lblen);
		pnlNavAns.add(lblenVal);

		pnlNavAns.add(lbldesgn);
		pnlNavAns.add(lbldesgnVal);

		pnlNavAns.add(lbldno);
		pnlNavAns.add(lbldnoVal);

		//Container cn = ((JFrame) frame).getContentPane();
		//cn.setLayout(new BoxLayout(cn,BoxLayout.Y_AXIS));
        frame.setLayout(new GridLayout(4,1));
		frame.add(pnlInput);
		frame.add(pnlButton);
		frame.add(pnlNavAns);
		frame.add(pnlNavigate);
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(350, 350);
		
		frame.addWindowListener(new WindowAdapter()
        {
        	public void windowClosing(WindowEvent arg0) 
        	{
        		// TODO Auto-generated method stub
        		System.exit(0);
        	}
        });
	}

	public void actionPerformed(ActionEvent evt) 
	{
		// TODO Auto-generated method stub
		String action = evt.getActionCommand();
		if(action.equals("Add"))
		{
			addOperation();
		}else if(action.equals("Update"))
		{
			updateOperation();
		}else if(action.equals("Delete"))
		{
			deleteOperation();
		}else if(action.equals("Prev"))
		{
			preNavigation();
		}else if(action.equals("Next"))
		{
			nextNavigation();
		}
		
	}

	private void nextNavigation() 
	{
		// TODO Auto-generated method stub
		try{
			if(rs == null)
			{
			//Load Jdbc Odbc Driver
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:odbc:empdsn");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");

			String sql = "SELECT * FROM pers";

			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
		             ResultSet.CONCUR_UPDATABLE);
			
			rs = st.executeQuery(sql);
			}
			if(rs.next())
			{
				populateValue();
			}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                                JOptionPane.ERROR_MESSAGE);
			}
	}

		
	private void populateValue()
	{
		// TODO Auto-generated method stub
		try
		{
		int Ecode = rs.getInt("empcode");
		String Ename = rs.getString("empname");
		String Designation = rs.getString("designation");
		int dno = rs.getInt("dno");

		lblecVal.setText(Ecode +"");
		lblenVal.setText(Ename);
		lbldesgnVal.setText(Designation);
		lbldnoVal.setText(dno + "");  

		txtEcode.setText(Ecode + "" );
		txtEname.setText(Ename);
		txtDesignation.setText(Designation);
		txtDno.setText(dno +""); 	
	    } catch(Exception e){}
	}

	private void preNavigation() 
	{
		// TODO Auto-generated method stub
		try
		{
			if(rs == null)
			{
			//Load Jdbc Odbc Driver
				//Load Jdbc Odbc Driver
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//Class.forName("com.mysql.jdbc.Driver");  

				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//Connection con = DriverManager.getConnection("jdbc:odbc:empdsn");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");

				String sql = "SELECT * FROM pers";

				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery(sql);
			 }
			  if(rs.previous())
			  {
				populateValue();
			  }
			}
		    catch(Exception e){}
				
	}

	private void deleteOperation() 
	{
		// TODO Auto-generated method stub
		int ans = JOptionPane.showConfirmDialog(null,
				"Are you sure to delete the Record ?", "Delete Record",
                           JOptionPane.YES_NO_OPTION);
		if(ans == JOptionPane.YES_OPTION)
		{
			try{
			//Load Jdbc Odbc Driver
				//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				//Class.forName("com.mysql.jdbc.Driver");
				Class.forName("com.mysql.cj.jdbc.Driver");
				//Connection con = DriverManager.getConnection("jdbc:odbc:empdsn");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");

			String sql = "Delete FROM pers where empname = '"+txtEname.getText()+"'";

			Statement st = con.createStatement();
			//st.execute(sql);
			st.executeUpdate(sql);
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",
                                JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(null, "Record Deleted","Success",
                        JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Operation Canceled","Cancel",
                        JOptionPane.INFORMATION_MESSAGE);
		}

		
	}

	private void updateOperation() 
	{
		// TODO Auto-generated method stub
		try
		{
			//Load Jdbc Odbc Driver
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:odbc:empdsn");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");

			String sql = "Update pers " +
					        "SET empcode = '"+txtEcode.getText()+"'," +
							"empname = '"+txtEname.getText()+"',"+
					        "Designtion = '"+txtDesignation.getText()+"'," +
							"dno = '"+txtDno.getText()+"'" +
							"Where empcode = '"+txtEcode.getText()+"'";

			
			JOptionPane.showMessageDialog(null, sql,"Record Updated",
                        JOptionPane.INFORMATION_MESSAGE);
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			st.executeUpdate(sql);
			//st.setAutoCommit(true);
			JOptionPane.showMessageDialog(null, "Record Update Succesfully.",
                        "Record Updated",JOptionPane.INFORMATION_MESSAGE);
			clearControls();
		}catch(Exception e)
		{
		}

		
	}

	private void addOperation() 
	{
		
		// TODO Auto-generated method stub
		try
		{
			//Load Jdbc Odbc Driver
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:odbc:empdsn");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");
			
			String sql = "INSERT INTO pers (empcode,empname,designation,dno) " +
				"Values ('"+txtEcode.getText()+"'," +
						"'"+txtEname.getText()+"'," +
						"'"+txtDesignation.getText()+"'," +
						"'"+txtDno.getText()+"')";

			Statement st = con.createStatement();
			st.executeUpdate(sql);
			clearControls();
		}
		catch(Exception e) {}
	}
	
	private void clearControls() 
	{
		txtEcode.setText("");
		txtEname.setText("");
		txtDesignation.setText("");
		txtDno.setText("");	// TODO Auto-generated method stub
	}
}
