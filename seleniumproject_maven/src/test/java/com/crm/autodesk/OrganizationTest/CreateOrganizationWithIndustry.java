package com.crm.autodesk.OrganizationTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;
import com.crm.autodesk.genericLibraries.BaseClass;
import com.crm.autodesk.genericLibraries.ExcelFileUtility;
import com.crm.autodesk.genericLibraries.JSONFileUtility;
import com.crm.autodesk.genericLibraries.JavaUtility;
import com.crm.autodesk.genericLibraries.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
//@Listeners(com.crm.autodesk.genericLibraries.Listners.class)

public class CreateOrganizationWithIndustry extends BaseClass {
	
	@Test(groups="Smoke",retryAnalyzer=com.crm.autodesk.genericLibraries.RetryAnalyzer.class)
	public void createOrganizationWithIndustry() throws Throwable {
		
		JavaUtility jLib=new JavaUtility();
	
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		//get all the data
		
	   
	  String OrgName = eLib.getExcelData("Sheet1", 3, 2)+jLib.getRandomNum();
	  String indType = eLib.getExcelData("Sheet1", 3, 3);
	  
	  //launch the browser
	  
		 
		 //navaigate to organization page
		 HomePage hp=new HomePage(driver);
		 hp.createOnOrganizations();
		 //navaigate to create organisation page
		 OrganizationsPage OrgPage= new OrganizationsPage(driver);
		 OrgPage.clickOnCreateOrgImg();
		 
		 //create organization
		 CreateOrganizationPage createOrgP=new CreateOrganizationPage(driver);
		 createOrgP.createOrganizationWithIndustry(OrgName, indType);
		 
		 
		 //verification
		 OrganizationsInfoPage OrgInfoP=new OrganizationsInfoPage(driver);
		  // String actualOrgInfo = OrgInfoP.getOganizationsInfo();
		  // Assert.assertTrue(actualOrgInfo.contains(OrgName));
		 //  System.out.println(actualOrgInfo);
		 //  String actualIndInfo = OrgInfoP.getIndustriesInfo();
		  // Assert.assertTrue(actualIndInfo.equals(indType));
		   System.out.println("indType");
		   Assert.assertEquals(false, true);
		   
		   
		
	}

}
