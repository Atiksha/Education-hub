import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Validation{
	
	
	
	
	
	public static boolean EmptyOrNot(String Name,String FName,String MName,String Email,String Mob,String Pass,String Date,String Month,String Year,String Gender,String Course,String Addr)
	{
		if(Name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter user Name.eg Atiksha");
			//u.requestFocus();
			return false;
		}
		else
		if (!Name.matches("^\\pL+[\\pL\\pZ\\pP]{0,}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Name.eg Atiksha");
			return false;
		}
		if(FName.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Father Name.eg abc xyz");
			//p.requestFocus();
			return false;
		}
		else
		if (!FName.matches("^\\pL+[\\pL\\pZ\\pP]{0,}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Father Name.eg abc xyz");
			return false;
		}
		else
		if(MName.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Experience Details.eg 3 year teaching experience at GEU");
			//u.requestFocus();
			return false;
		}

		if (!MName.matches("^[A-Za-z0-9- ]+$")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Addr.eg 3 year teaching experience at GEU");
			return false;
		}
		else
		
		if(Email.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Email.eg atiksha1311@gmail.com");
			//p.requestFocus();
			return false;
		}
		else
		if (!Email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
	            "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) 
		{
			// (!Name.matches("\\wt@\\w+[.]com"))
			//if (!Name.matches("^(.+)@(.+)$")) 
			JOptionPane.showMessageDialog(null, "Please Enter valid Email.eg atiksha1311@gmail.com");
			return false;
		}
			
		
		else
		if(Mob.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter user Mobile number.eg 8091234567");
			//u.requestFocus();
			return false;
		}
		else
		if (!Mob.matches("\\d{10}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid number.eg 8091234567");
			return false;
		}
		else
		if(Addr.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Address.eg sec-3 BHEL Haridwar ");
			//u.requestFocus();
			return false;
		}
		else

		if (!Addr.matches("^[A-Za-z0-9- ]+$")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Addr.eg sec-3 BHEL Haridwar ");
			return false;
		}
		else
		if(Gender.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Gender");
			//p.requestFocus();
			return false;
		}
		else
		if(Pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Password of length 6 to 16 character.eg abcx123");
			//p.requestFocus();
			return false;
		}
		else
		if (!Pass.matches("^[a-zA-Z0-9]{6,16}$")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Password of length 6 to 16 character.eg abcx123");
			return false;
		}
		else
		if(Date.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Date");
			//u.requestFocus();
			return false;
		}
		else
		if(Month.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Month");
			//p.requestFocus();
			return false;
		}
		else
		if(Year.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Year");
			//u.requestFocus();
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	
	
	
	
	
	

	public static boolean ValidationStudent(String Name,String FName,String MName,String Email,String Mob,String Pass,String Date,String Month,String Year,String Gender,String Course,String Addr)
	{
		if(Name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter user Name.eg Atiksha");
			return false;
		}
		else
		if (!Name.matches("^\\pL+[\\pL\\pZ\\pP]{0,}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Name.eg Atiksha");
			return false;
		}
		if(FName.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Father Name.eg abc xyz");
			return false;
		}
		else
		if (!FName.matches("^\\pL+[\\pL\\pZ\\pP]{0,}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Father Name.eg abc xyz");
			return false;
		}
		else
		if(MName.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Mothers Name.eg abc xyz");
			return false;
		}
		else
		if (!MName.matches("^\\pL+[\\pL\\pZ\\pP]{0,}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Father Name.eg abc xyz");
			return false;
		}
		else
		
		if(Email.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Email.eg atiksha1311@gmail.com");
			return false;
		}
		else
		if (!Email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
	            "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) 
		{
			// (!Name.matches("\\wt@\\w+[.]com"))
			//if (!Name.matches("^(.+)@(.+)$")) 
			JOptionPane.showMessageDialog(null, "Please Enter valid Email.eg atiksha1311@gmail.com");
			return false;
		}
			
		
		else
		if(Mob.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter user Mobile number.eg 8091234567");
			return false;
		}
		else
		if (!Mob.matches("\\d{10}")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid number.eg 8091234567");
			return false;
		}
		else
		if(Addr.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Address.eg sec-3 BHEL Haridwar ");
			return false;
		}
		else

		if (!Addr.matches("^[A-Za-z0-9- ]+$")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Addr.eg sec-3 BHEL Haridwar ");
			return false;
		}
		else
		if(Gender.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Gender");
			return false;
		}
		else
		if(Pass.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Password of length 6 to 16 character.eg abcx123");
			return false;
		}
		else
		if (!Pass.matches("^[a-zA-Z0-9]{6,16}$")) 
		{
			JOptionPane.showMessageDialog(null, "Please Enter valid Password of length 6 to 16 character.eg abcx123");
			return false;
		}
		else
		if(Date.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Date");
			return false;
		}
		else
		if(Month.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Month");
			return false;
		}
		else
		if(Year.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please Enter Year");
			return false;
		}
		else
		{
			return true;
		}
	}
	
	

}
