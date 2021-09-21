package com.crm.autodesk.genericLibraries;

import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public DataBaseUtility dbLib=new DataBaseUtility();
	public JSONFileUtility jsonLib=new JSONFileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelFileUtility eLib=new ExcelFileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	
	
	
	@BeforeSuite(groups={"Smoke","Regression"})
	public void connectDB() {
		//dbLib.connectToDB();
		System.out.println("====make db connection======");
	}
	//@Parameters("BROWSER")
	//@Parameters("BROWSER")
	@BeforeClass(groups={"Smoke","Regression"})
	public void launchBrowser( ) throws Throwable {
		System.out.println("======launchbrowser=====");
		String BROWSER = jsonLib.readData("browser");
		String URL = jsonLib.readData("url");
		WebDriverManager.chromedriver().setup();
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		staticdriver=driver;
	}
	@BeforeMethod(groups={"Smoke","Regression"})
	public void loginToApp() throws Throwable {
		System.out.println("======LogintoApp=====");
		String USERNAME=jsonLib.readData("username");
		String PASSWORD = jsonLib.readData("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	@AfterMethod(groups={"Smoke","Regression"})
	public void logoutofApp() throws InterruptedException {
		System.out.println("====logoutofApp====");
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		hp.signOut(driver);
	}
	@AfterClass(groups={"Smoke","Regression"})
	public void closeBrowser() {
		System.out.println("====closeBrowser====");
		driver.close();
	}
	@AfterSuite(groups={"Smoke","Regression"})
	public void closeDB() {
		System.out.println("=======closeDb===");
	}
	 public String getScreenshot(String name) throws IOException {
		 File srcfile=((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
		 String destfile=System.getProperty("user.dir")+ "/Screenshot/"+name+".png";
		 File finaldest=new File(destfile);
		 FileUtils.copyFile(srcfile, finaldest);
		 
		 return destfile;
	 }
	
	

}
