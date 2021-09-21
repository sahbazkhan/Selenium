package com.crm.autodesk.genericLibraries;
/*
 * 
 * this driver contains all the generic metohd related to webdriver actions
 * @author sah
 * 
 */

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	/*
	 * 
	 * this method will wait for the page to laod for 10 second
	 * 
	 */
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/*
	 * this method will maximize window
	 * 
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*
	 * this method will perform double click on webelemnt
	 * @param driver
	 * @param element
	 * 
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
		
	}
	/*
	 * this metod will select accept on alert popup
	 * @param driver
	 */
	public void aceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/*
	 * this method will select dismiss option
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/*
	 * this method will switch to frame wrt value
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	/*
	 * this method select from the dropdown using visible text
	 */
	public void select(WebElement element,String value) {
		Select s= new Select(element);
		s.selectByVisibleText(value);
	}
	/*
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/*
	 * this method will be do mouse hover action on web elemnt
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/*
	 * this method will perform on right click on web element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/*
	 * this method will switch to frame wrt to id
	 */
	public void switchToFrameId(WebDriver driver,String frameid) {
		driver.switchTo().frame(frameid);
		
	}
	/*
	 * this method use to frame wrt to element
	 */
	public void switchToFrameId(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/*
	 * this method will to switch window wth  partialwintittle
	 */
	public void switchTowindow(WebDriver driver,String partialwinTitle) {
		Set<String> winhandle = driver.getWindowHandles();
		Iterator<String> it = winhandle.iterator();
		while(it.hasNext()) {
			String winid=it.next();
			String actualTitle=driver.switchTo().window(winid).getTitle();
			if(actualTitle.contains(partialwinTitle)) {
				//driver.switchTo().window(actualTitle);
				break;
			}
		}
	}

}
