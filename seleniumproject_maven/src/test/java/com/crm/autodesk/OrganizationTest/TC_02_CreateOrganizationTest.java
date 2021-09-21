package com.crm.autodesk.OrganizationTest;

import org.testng.annotations.Test;

import com.crm.autodesk.elementRepository.CreateOrganizationPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.OrganizationsInfoPage;
import com.crm.autodesk.elementRepository.OrganizationsPage;
import com.crm.autodesk.genericLibraries.BaseClass;
import com.crm.autodesk.genericLibraries.ExcelFileUtility;
import com.crm.autodesk.genericLibraries.JavaUtility;

public class TC_02_CreateOrganizationTest extends BaseClass {
	
	@Test(groups="Regression")
	public void createOrganizationTest() throws Throwable {
		
		
		JavaUtility jLib=new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		
		//get all the data
		
	   
	  String OrgName = eLib.getExcelData("Sheet1", 1, 3)+jLib.getRandomNum();
	  
	  
		
		 //navaigate to organization page
		 HomePage hp=new HomePage(driver);
		 hp.createOnOrganizations();
		 //navaigate to create organisation page
		 OrganizationsPage OrgPage= new OrganizationsPage(driver);
		 OrgPage.clickOnCreateOrgImg();
		 
		 //create organization
		 CreateOrganizationPage createOrgP=new CreateOrganizationPage(driver);
		 createOrgP.createOrganization(OrgName);
		 
		 //verification
		 OrganizationsInfoPage OrgInfoP=new OrganizationsInfoPage(driver);
		   String actualOrgInfo = OrgInfoP.getOganizationsInfo();
		   if(actualOrgInfo.contains(OrgName)) {
			   System.out.println("test script passed");
			   System.out.println("actualorgInfo");
		   }
		   else {
			   System.out.println("script is falied");
		   }
	   
		
	}

}
