package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class Db {
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		//get register
		try {
			Driver driverref=new Driver();
			DriverManager.registerDriver(driverref);
			//get coonection
			con=DriverManager.getConnection("JDbC", "root", "root");
			//statement
			Statement stat = con.createStatement();
		String query = "insert into students_info(regno, firstname, middlename, lastname) values('190', 'ram','gowda', 'hassan')";
		//execute
		int result = stat.executeUpdate(query);
		if( result==1) {
			System.out.println("passed");
			
		}
			
		}
		catch(Exception e) {
			System.err.println("failed");
		}
		finally {
			con.close();
		}
		
		
		
	}

}
