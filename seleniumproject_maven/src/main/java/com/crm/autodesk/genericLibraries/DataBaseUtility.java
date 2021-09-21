package com.crm.autodesk.genericLibraries;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/*
 * this class contains generic method to read data from database
 * @author sah
 */

public class DataBaseUtility {
	Connection con=null;
	ResultSet result=null;
	Driver driverRef;
	/*
	 * connection with database established
	 * #throws throwable
	 */
	public void connectToDB() throws Throwable {
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet", "root", "root");
		
	}
	/*
	 * DB connection is closed
	 * #throws throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
		
		
	}
	/*
	 * this method will return the data wrt to column index
	 * @param query
	 * @param columnindex
	 * @return
	 * @throws throwable
	 */
	public String getDataFromDB(String query, int columnindex) throws Throwable {
		String value=null;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			value=result.getString(columnindex);
			
		}
		   return value;
	}
	/*
	 * get data from DB and verify
	 * @param query
	 * @param columnname
	 * @returns
	 * 
	 */
	public String getDataFromDB(String query, int columnName,String expData) throws Throwable {
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnName).equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			       System.out.println(expData +"data  verified in database");
		}
		else {
			    System.out.println(expData +"data not verified");
		}
		return expData;
	}

}
