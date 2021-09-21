package commondata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	
	
//read the data from json from file
	
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
