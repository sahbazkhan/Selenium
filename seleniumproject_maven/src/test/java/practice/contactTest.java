package practice;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class contactTest {
  @Test
  public void conTest() {
	  System.out.println("run the program");
	  String url = System.getProperty("url");
	  String username= System.getProperty("username");
	  String password= System.getProperty("password");
	  String browser=System.getProperty("browser");
	  String lastname = System.getProperty("lastname");
	  String tittle=System.getProperty("tittle");
	  String department=System.getProperty("department");
	  String email=System.getProperty("email");
	  String assistant=System.getProperty("assistant");
	  String assistantphone=System.getProperty("assistantphone");
	  String officephone=System.getProperty("officephone");
	  String mobile=System.getProperty("mobile"); 
	  String birthday=System.getProperty("birthday");
	  String secondaryemail=System.getProperty("secondaryemail");
	  String mailingstreet=System.getProperty("mailingstreet");
	  String mailingpobox=System.getProperty("mailingpobox");
	  String mailingcity=System.getProperty("mailingcity");
	  String mailingstate=System.getProperty("mailingstate");
	  String mailingpostalcode=System.getProperty("mailingpostalcode");
	  String mailingcountry=System.getProperty("mailingcountry");
	  String description=System.getProperty("description");
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=null;
	  if(browser.equals("chrome")) {
		  driver=new ChromeDriver();
		  
	  }
	  else if(browser.equals("firefox")) {
		  driver=new FirefoxDriver();
		  
	  }
	  else {
		  System.out.println("invalid browser");
	  }
	  
	//  WebDriverManager.chromedriver().setup();
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	  driver.findElement(By.name("user_name")).sendKeys(username);
	  driver.findElement(By.name("user_password")).sendKeys(password);
	  driver.findElement(By.id("submitButton")).click();
	  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	  driver.findElement(By.xpath("(//img[@border='0'])[10]")).click();
	 WebElement ele = driver.findElement(By.name("salutationtype"));
	 Select s=new Select(ele);
	 s.selectByValue("Mr.");
	 driver.findElement(By.name("lastname")).sendKeys(lastname);
	WebElement d = driver.findElement(By.name("leadsource"));
	Select t=new Select(d);
	t.selectByValue("Cold Call");
	driver.findElement(By.id("title")).sendKeys(tittle);
	driver.findElement(By.id("title")).sendKeys(department);
	driver.findElement(By.id("email")).sendKeys(email);
	driver.findElement(By.id("assistant")).sendKeys(assistant);
	driver.findElement(By.id("assistantphone")).sendKeys(assistantphone);
	driver.findElement(By.name("emailoptout")).click();
	driver.findElement(By.name("reference")).click();
	driver.findElement(By.name("notify_owner")).click();
	driver.findElement(By.id("phone")).sendKeys(officephone);
	driver.findElement(By.id("mobile")).sendKeys(mobile);
	driver.findElement(By.name("birthday")).sendKeys(birthday);
	driver.findElement(By.id("secondaryemail")).sendKeys(secondaryemail);
	driver.findElement(By.name("donotcall")).click();
	driver.findElement(By.name("assigntype")).click();
	driver.findElement(By.name("portal")).click();
	driver.findElement(By.name("mailingstreet")).sendKeys(mailingstreet);
	driver.findElement(By.name("mailingpobox")).sendKeys(mailingpobox);
	driver.findElement(By.name("mailingcity")).sendKeys(mailingcity);
	driver.findElement(By.name("mailingstate")).sendKeys(mailingstate);
	driver.findElement(By.name("mailingzip")).sendKeys(mailingpostalcode);
	driver.findElement(By.name("mailingcountry")).sendKeys(mailingcountry);
	driver.findElement(By.name("description")).sendKeys(description);
	driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
	driver.findElement(By.xpath("//input[@name='imagename']")).sendKeys("D:/desktop/Dheeraj.jpg");
	driver.findElement(By.name("button")).click();
	
	
	
	
	
	
			 
	  
	  
	  
	  
	  
  }
}
