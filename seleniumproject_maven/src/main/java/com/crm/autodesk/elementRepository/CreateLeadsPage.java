package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericLibraries.WebDriverUtility;

public class CreateLeadsPage extends WebDriverUtility {
	WebDriver driver;
	
	//constructor
	
	public CreateLeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//locate all the webelemnt
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="company")
	private WebElement compEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadDrop;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="themes/softed/images/user.PNG")
	private WebElement administatorImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signBtn;
	
	@FindBy(name="assigntype")
	private WebElement radiobtn;
	
	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getIndustryDrop() {
		return industryDrop;
	}

	@FindBy(name="industry")
	private WebElement industryDrop;
	
	@FindBy(name="leadstatus")
	private WebElement leadstatusDrop;
	
	@FindBy(name="rating")
	private WebElement leadsRatingDrop;
	
	
	
	
	//provide getter

	public WebElement getLeadsRatingDrop() {
		return leadsRatingDrop;
	}

	public WebElement getLeadstatusDrop() {
		return leadstatusDrop;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getCompEdt() {
		return compEdt;
	}

	public WebElement getLeadDrop() {
		return leadDrop;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getAdministatorImg() {
		return administatorImg;
	}

	public WebElement getSignBtn() {
		return signBtn;
	}
	
	//provide business method
	public void lastname(String lastname) {
		lastnameEdt.sendKeys(lastname);
	
		
		}
	public void company(String cName) {
		compEdt.sendKeys(cName);
		
	}
	 public void leadDrop( String ldSource) {
		 //lastnameEdt.sendKeys(lastname);
		 select(leadDrop, ldSource);
		 saveBtn.click();
		 
		 
	 }
	 public void signout()
	 {
		 mouseOver(driver, administatorImg);
		 saveBtn.click();
		 
		 
		 
	 }
	 public void createLeadWithIndustry(String last,String cName,String indName) {
		lastnameEdt.sendKeys(last); 
		compEdt.sendKeys(cName);
		select(industryDrop, indName);
		saveBtn.click();
	 }
	 public void createLeadsWithStatus(String last,String cName, String statusName) {
		 lastnameEdt.sendKeys(last); 
			compEdt.sendKeys(cName);
			select(leadstatusDrop, statusName);
			saveBtn.click();
	 }
	  public void createLeadsRating(String last,String cName, String rating) {
		  lastnameEdt.sendKeys(last); 
			compEdt.sendKeys(cName);
			select(leadsRatingDrop, rating);
			saveBtn.click();
			
	  }
	  public void clickRadio(String last, String cName) {
		  lastnameEdt.sendKeys(last); 
			compEdt.sendKeys(cName);
		  radiobtn.click();
		  saveBtn.click();
		  
		  
	  }
	
	
	

	
	
	
	
	
	
	
	
	
		 
	 }
	 


