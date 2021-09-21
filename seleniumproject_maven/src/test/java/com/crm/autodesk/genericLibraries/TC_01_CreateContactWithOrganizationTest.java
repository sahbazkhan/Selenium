package com.crm.autodesk.genericLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01_CreateContactWithOrganizationTest {
	
	WebDriver driver;

	@Test
	public void createContactWithOrganization() throws Throwable {
		//read all the necessary data
		
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility tLib=new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		String url=jsonLib.readData("url");
		
		
		String BROWSER=jsonLib.readData("browser");
		String username=jsonLib.readData("username");
		String password=jsonLib.readData("password");
		//String OrgName = tLib.getPropertyFileData("Organisationname");
		//String lname = tLib.getPropertyFileData("lastname");
		//WebDriverManager.chromedriver().setup();
		
		String lname=eLib.getExcelData("Sheet1",1,2); 
		 String Orgname=eLib.getExcelData("Sheet1",1,3);
		 //Launch the browser
		WebDriverManager.chromedriver().setup();
		 if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver=new ChromeDriver();
		 }
		 else if(BROWSER.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();
		 }
		 else {
			 System.out.println("invalid browser");
		 }
		 wLib.waitForPageLoad(driver);
		 wLib.maximizeWindow(driver);
		 driver.get(url);
		 
		 //login to apploication
		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 //click on contact
		 
		 driver.findElement(By.linkText("Contacts")).click();
		 
		 //click on create contact link
		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 //create contact
		 driver.findElement(By.name("lastname")).sendKeys(lname);
		 driver.findElement(By.xpath("//img[@title='Select']")).click();
		 
		 //switch to child window
		 wLib.switchTowindow(driver, "Accounts");
		 driver.findElement(By.id("search_txt")).sendKeys(Orgname);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText("Aecom")).click();
		 //switch back to parent window
		 wLib.switchTowindow(driver, "Contacts");
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //logout
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mouseOver(driver, ele);
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		 
		 
		
		
	}

}
