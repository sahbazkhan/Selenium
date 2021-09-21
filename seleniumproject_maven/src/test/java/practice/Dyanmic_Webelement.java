package practice;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.dsa512;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import commondata.JSONFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dyanmic_Webelement {
	
	WebDriver driver;
	@Test
	public void handleelemnt() throws Throwable {
		JSONFileUtility jsonLib=new JSONFileUtility();
		
		// fetch the common data from json file
		
		String browser=jsonLib.readData("browser");
		String url=jsonLib.readData("url");
		String username=jsonLib.readData("username");
		String password=jsonLib.readData("password");
		WebDriverManager.chromedriver().setup();
		
		
		// choose the browser
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver=new InternetExplorerDriver();
		}
		//load url
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		
		// input to login to application
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		// click on organisation
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on the check box
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td/input[@name='selected_id']"));
		
		
		for(WebElement wb:list) {
			wb.click();
		}
      list.get(list.size()-1).click();
      List<WebElement> col = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
      for(WebElement d1:col)
      {
    	 System.out.println( d1.getText());
      }
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[8]//a[text()='del']")).click();
		 Alert al = driver.switchTo().alert();
		 al.accept();
		
		
		
		
		
	}

}
