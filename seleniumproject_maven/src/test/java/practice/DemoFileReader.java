package practice;

import commondata.JSONFileUtility;

public class DemoFileReader {
	
	public static void main(String[] args) throws Throwable {
		JSONFileUtility j=new JSONFileUtility();
		System.out.println(j.readData("browser"));
		
	}

}
