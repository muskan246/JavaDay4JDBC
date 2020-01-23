package day4JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Insert {

	Connection con;
	Statement stat;
	int customer_id;
	String customer_fname;
	String customer_lname;
	String customer_address;
	String customer_email;

	PreparedStatement pre;
	
	
	public Insert()


	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
			System.out.println("Database Connected....");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter customer id.");
			customer_id=sc.nextInt();
			System.out.println("Enter customer first name");
			customer_fname=sc.next();
			System.out.println("Enter customer last name");
			customer_lname=sc.next();
			System.out.println("Enter customer address");
			customer_address=sc.next();
			System.out.println("Enter customer email");
			customer_email=sc.next();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		public void insertPreStatement(){
		try
		{
			pre=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			pre.setInt(1,customer_id);
			pre.setString(2,customer_fname);
			pre.setString(3,customer_lname);
			pre.setString(4,customer_address);
			pre.setString(5,customer_email);
			System.out.println(customer_id+"   "+customer_fname);
			int ra=pre.executeUpdate();
			if(ra>0)
				System.out.println("Record Inserted...");
			else
				System.out.println("Record Not Inserted...");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	


}
