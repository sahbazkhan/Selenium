package com.crm.autodesk.genericLibraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_03_CreateProductTest {
	WebDriver driver;
	@Test
	public void createProduct() throws Throwable {
		
		JSONFileUtility jsonLib=new JSONFileUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		PropertyFileUtility tLib=new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
	int ran = jLib.getRandomNum();
		String url=jsonLib.readData("url");
		
		String BROWSER=jsonLib.readData("browser");
		String username=jsonLib.readData("username");
		String password=jsonLib.readData("password");
		//String ProdctName = tLib.getPropertyFileData("productname");
		//String partNumb = tLib.getPropertyFileData("partnumber");
		String pname = eLib.getExcelData("Sheet1", 1, 4);
		String pnum = eLib.getExcelData("Sheet1", 1, 5);
		
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
		 
		 //logn in the application
		 
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 //click on product
		 driver.findElement(By.linkText("Products")).click();
		 //click on create product
		 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		 driver.findElement(By.name("productname")).sendKeys(pname);
		 driver.findElement(By.id("productcode")).sendKeys(pnum+ran);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 //verify the portnumber
		 
		 driver.findElement(By.linkText("Products")).click();
		 WebElement ele = driver.findElement(By.id("bas_searchfield"));
		 wLib.select(ele, "Part Number");
		 driver.findElement(By.name("search_text")).sendKeys(pnum+ran);
		 
		 driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		 List<WebElement> element = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]"));
		 for(WebElement text:element)
		 {
			String actText= text.getText();
		 
		 if(actText.equalsIgnoreCase(pnum+ran)){
			 System.out.println(actText+" "+"verified with"+" "+pnum+ran);
		 }
		 
		 }	
		 
		 
		 
		 
	}

}
