import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


//
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class ConnectionMySQL {

	public static void main(String [] args)
	{
		//Connection conn = null;
		try 
		{
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
			System.out.println("Connection success");
			
			String query = "SELECT * FROM student_table";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				System.out.println("Name : "+ rs.getString("s_name"));
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
	
}
