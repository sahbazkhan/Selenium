package com.crm.Leads.CreateTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateLeadsPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LeadsPage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.genericLibraries.BaseClass;
import com.crm.autodesk.genericLibraries.ExcelFileUtility;
import com.crm.autodesk.genericLibraries.JSONFileUtility;
import com.crm.autodesk.genericLibraries.JavaUtility;
import com.crm.autodesk.genericLibraries.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_07_CreaateLeadsTest extends BaseClass {
	@Test
	public void CreateLeads() throws Throwable {
		
		
	 //  String OrgName = eLib.getExcelData("Sheet1", 1, 3)+jLib.getRandomNum();
		//  String indType = eLib.getExcelData("Sheet1", 3, 3);
		 String lastname = eLib.getExcelData("Sheet1", 4, 2);
		String cName = eLib.getExcelData("Sheet1", 4, 3);
		//String leaddrop = eLib.getExcelData("Sheet1", 4, 4);
		String indName = eLib.getExcelData("Sheet1", 4, 5);
		
		 
		 //navigate to homepage
		 HomePage hp=new HomePage(driver);
		 hp.clickonLeads();
		 //navigate to create leads
		 LeadsPage pl=new LeadsPage(driver);
		 pl.clickOnCreateLeads();
		 //navigate to create Leads page
		 CreateLeadsPage cp=new CreateLeadsPage(driver);
		 //cp.lastname(lastname);
		// cp.company(cName);
		 //cp.leadDrop(leaddrop);
		 cp.createLeadWithIndustry(lastname, cName, indName);
		 
		 
		 
		 
		 
		
	}

}
