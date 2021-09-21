package com.crm.autodesk.genericLibraries;

import java.util.Random;

/*
 * this class contains generic 
 * @author sah
 * 
 */

public class JavaUtility {
	/*
	 * 
	 * this method generates random number
	 */
	
	public int getRandomNum() {
		Random ran=new Random();
		int randomNum = ran.nextInt();
		return randomNum;
	}

}
