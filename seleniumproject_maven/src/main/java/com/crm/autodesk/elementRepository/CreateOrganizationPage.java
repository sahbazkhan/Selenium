package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibraries.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	WebDriver driver;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locate all the elemnt
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDrop;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//provide getter

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDrop() {
		return industryDrop;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	 //provide business method
	/*
	 * this method will create org with mandatory
	 * @param OrgName
	 */
	
	public void createOrganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
		
	}
	/*
	 * this method create org by choosing by industry type
	 */
	
	public void createOrganizationWithIndustry(String OrgName, String indType) {
		OrgNameEdt.sendKeys(OrgName);
		select(industryDrop, indType);
		saveBtn.click();
		
		
	}
	
	

	

}
