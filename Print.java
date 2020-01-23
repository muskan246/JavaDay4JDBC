package day4JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import jdbctraining.Select;


public class Print {

	Connection con;
	Statement stat;
	ResultSet res;
	public Print()
	{
		try
		{
			
		    Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "");
//			System.out.println("Database Connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getData()
	{
		try 
		{
			// Creates query object for database connected through con object
			stat=con.createStatement();
			//Executes SQL Select Query and returns data as ResultSet Object
			res=stat.executeQuery("select * from student.customer");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void printData()
	{
		try
		{
			while(res.next())
			{
				System.out.println(res.getInt("customer_id"));
				System.out.println(res.getString("customer_fname"));
				System.out.println(res.getString("customer_lname"));
				System.out.println(res.getString("customer_address"));
				System.out.println(res.getString("customer_email"));
				

				System.out.println("===============================");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean  bool = true;
		while(bool)
		{	
		System.out.println("Provide the choices");
		System.out.println("1. To add customer details");
		System.out.println("2. To edit existing customer details");
		System.out.println("3. To remove an existing customer");
		System.out.println("4. To print details of all customer details");
		System.out.println("5. Exit Application");
		
		int ch= sc.nextInt();
		
		Print rd=new Print();
		switch (ch) {
		case 1:
			Insert i = new Insert();
			i.insertPreStatement();
			rd.getData();
			rd.printData();
			break;
		case 2:
			Edit e = new Edit();
			e.editPreStatement();
			rd.getData();
			rd.printData();
			break;
			
		case 3:
			Delete d = new Delete();
			d.deletePreStatement();
			rd.getData();
			rd.printData();
			break;
		
		case 4:
		rd.getData();
		rd.printData();
		break;
		
		case 5:
			bool = false;
			System.exit(0);
			return;
			 
		default:
			System.out.println("Please Provide valid input");
		}
		
		

	}

	}
}
