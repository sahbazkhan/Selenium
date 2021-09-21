package com.crm.autodesk.genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/*
 * this metohd contains generic method to read data from propertyfile
 * @sah
 * 
 */

public class PropertyFileUtility {
	/*
	 * 
	 * this method read the data from property file
	 * @thorws throwable
	 */
	
	public String getPropertyFileData(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.propertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}

}
