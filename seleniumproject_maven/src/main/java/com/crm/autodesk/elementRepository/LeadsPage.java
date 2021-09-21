package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	//constructor
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	  // locate all the WebElement
	
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLdsImg;
//provide getter
	public WebElement getCreateLdsImg() {
		return createLdsImg;
	}
	//provide business method
	public void clickOnCreateLeads() {
		createLdsImg.click();
		
	}
	

	

}
