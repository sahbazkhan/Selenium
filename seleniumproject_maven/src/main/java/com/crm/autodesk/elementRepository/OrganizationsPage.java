package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	public  OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	// locate all the elemnt
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	// provide getter

	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	//provide bisiness method
	
	public void clickOnCreateOrgImg() {
		createOrgImg.click();
		
	}
	
	

}
