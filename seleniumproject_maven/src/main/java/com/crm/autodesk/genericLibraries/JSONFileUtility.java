package com.crm.autodesk.genericLibraries;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	/*
	 * this method use read data from json file
	 * @throws thowable
	 * @thorws parseExecption
	 */
	public String readData(String key) throws Throwable {
		//read the data from json
		FileReader fr=new FileReader("./commondata.json");
		//convert the jason file from java object
		JSONParser jsonobj=new JSONParser();
		Object jobj = jsonobj.parse(fr);
		//typecast java ob to hashmap
		HashMap map= (HashMap)jobj;
		String value = map.get(key).toString();
		
		//return the value
		
		
		return value;

	}
}
