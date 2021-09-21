package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class Readdatafrom_Xml {
	@Test
	public void Readdata(XmlTest ob) {
		System.out.println(ob.getParameter("browser"));
		System.out.println(ob.getParameter("url"));
		
		
	}

}
