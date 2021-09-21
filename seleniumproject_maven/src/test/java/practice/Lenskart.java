package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lenskart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		 driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='trending_block']"));
		
		
		for(WebElement b:list) {
			System.out.println(b.getText());
		}
		
		
		
		
		

	}

}
