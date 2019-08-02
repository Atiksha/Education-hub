import java.sql.*;

import javax.swing.*;

public class SqlConnection
{
	Connection conn = null;
	public static Connection dbConnector()
		{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
		//	JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}
	
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
