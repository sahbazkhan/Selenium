package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class java_try {
	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try {
		
    	Driver driverref=new Driver();
    	DriverManager.registerDriver(driverref);
    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
    	Statement stat=con.createStatement();
    	String query="insert into students_info(regno, firstname, middlename, lastname) values('190', 'ram','gowda', 'hassan')";
    	int Result=stat.executeUpdate(query);
    	if(Result==1) {
    		System.out.println("user is created");
    	}
		}
    	
    	catch(Exception e) {
    		   System.err.println("user is not created is failed");
    		   
    	}finally {
    	   con.close();
    }
}
}


