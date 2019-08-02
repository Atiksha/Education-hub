import java.sql.*;
public class JDBCWithMysql 
{
	public static void main(String args[])
	{  
		try
		{  
			//Class.forName("com.mysql.jdbc.Driver"); 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from pers");  
			System.out.println("Employee Code\t\t Employee Name\t\t Designation");
			while(rs.next())  
			{
				
				System.out.println(rs.getInt("empcode")+"\t\t\t "+rs.getString("empname")+"\t\t\t "+rs.getString("designation"));  
				System.out.println("-----------------------------------------------------------");
				  
			}
			con.close();
		}
		catch(Exception e){ System.out.println(e);  
		
	}  
  }
}
