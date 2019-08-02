import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection
{
	private Connection conn;
	private Statement st;
	private ResultSet rs;

	public static Connection DBConnection() 
	{
	
		try
		{
			Connection conn = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/educationhub","root","");
			
			return conn;
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Some Error In Connection Please Try after some time");
			return null;
		}
	}

}
