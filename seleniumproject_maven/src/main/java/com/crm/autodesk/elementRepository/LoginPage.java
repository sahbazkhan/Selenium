package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// create a seperate class for every webpage
	
	
	//create a constructor and use pagefactory classses and inililize
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//identify all the elemnt using @FindBy,@findBys,@FindAll
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//declare aal the elemnbt as a private and getter
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//acess the webElemnt using geteer
	
	public void login(String username, String password ) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	

}
