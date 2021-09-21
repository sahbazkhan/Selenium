package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibraries.WebDriverUtility;


public class HomePage extends WebDriverUtility  {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	//generate getter

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	//provide business logic
	
	public void createOnOrganizations() {
		organizationsLnk.click();
		
		
	}
	public void clickonContacts() {
		contactsLnk.click();
		
	}
	public void signOut(WebDriver driver) {
		mouseOver(driver, administatorImg);
		signoutLink.click();
		
		
		
		
		
		
		
	}
	 public void clickonLeads() {
		 leadsLink.click();
		 
		 
	 }
	 

	
		
	}
	
	
	
	


