package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class Account_checkTest {
	@Test
	public void acountType() throws Throwable {
		Connection con=null;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Students", "root", "root");
			
			Statement stat=con.createStatement();
			ResultSet result=stat.executeQuery("select* from Account_info");
			while(result.next()) {
				int account=result.getInt("account");
				System.out.println(account);
				if(account==123 && result.getString("accounttype").equals("gold")) {
					System.out.println("account type is gold and verified");
					break;
					
				}
			}
			
		} catch(Exception e) {
			System.out.println("account type is not gold and fail");
			
			
		}finally {
			con.close();
			
			
		}
		
	}

}
