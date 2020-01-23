package day4JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	Connection con;
	Statement stat;
	int customer_id;
	PreparedStatement pre;
	

	public Delete()
	{
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
			System.out.println("Database Connected....");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter customer id.");
			customer_id=sc.nextInt();

}

		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void deletePreStatement()
	{
		try
		{
			pre=con.prepareStatement("delete from customer where customer_id=?");
			pre.setInt(1,customer_id);
			
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Record Deleted whose "+customer_id);
			else
				System.out.println("Record has not Deleted...");
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}