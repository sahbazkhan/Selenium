package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Database {
    public static void main(String[] args) throws Throwable {
    	Driver driverref=new Driver();
    	DriverManager.registerDriver(driverref);
    	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
    	Statement stat=con.createStatement();
    	String query="insert into students_info(regno, firstname, middlename, lastname) values('12', 'ram','gowda', 'hassan')";
    	int Result=stat.executeUpdate(query);
    	if(Result==1) {
    		System.out.println("user is created");
    	}
    	else {
    		   System.out.println("user is not created");
    		   
    	}
    	   con.close();
    }
}
