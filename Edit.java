package day4JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Edit {
	Connection con;
	Statement stat;
	int customer_id;
	String customer_fname;
	String customer_lname;
	String customer_address;
	String customer_email;
	PreparedStatement pre;



public Edit()
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
	public void editPreStatement(){
	try
	{
		System.out.println("heyy");
		pre=con.prepareStatement("update customer set customer_fname=? , customer_lname=?, customer_address=?, customer_email=? where customer_id=?");
		
		pre.setString(1,customer_fname);
		pre.setString(2,customer_lname);
		pre.setString(3,customer_address);
		pre.setString(4,customer_email);
		pre.setInt(5,customer_id);
		
		int ra=pre.executeUpdate();
		if(ra>0)
			System.out.println("Record updated for id = "+customer_id);
		else
			System.out.println("Record is not updated..");
		pre.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}