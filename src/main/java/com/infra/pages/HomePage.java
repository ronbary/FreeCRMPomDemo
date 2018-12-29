/**
 * 
 */
package com.infra.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infra.base.TestInfraBase;

import selenium.infra.utils.InfraUtils;

/**
 * @author ronb
 *
 */
public class HomePage extends TestInfraBase {

	// the way to use PageFactory to find elements in page
	// using xpath and 'contains' keyword
	@FindBy(xpath="//td[contains(text(),'User: naveen k')]")
	WebElement userNameLabel;
	
	///html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(@title,'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	// Initialized all these wewElements using the PageFactory
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	{
		InfraUtils.SwitchToFrame(driver, "mainpanel");
		 
		return userNameLabel.isDisplayed();
	}
	
	

	// each click return the next lending page
	// per each page in the site we should create separate class
	public ContactsPage clickOnContactslink() {
		
		// the "Contacts" link exist in a Frame so need to switch to the
		// frame first before click
		InfraUtils.SwitchToFrame(driver, "mainpanel");
		
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealslink() {
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskslink() {
		tasksLink.click();
		
		return new TasksPage();
	}
	
	// press on the 'New Contacts ' link
	// on the main menu so need to use Actions object 
	// to mouse over the menu to make the element visible , then click it
	public void clickOnNewContact() {
		
		// do the mouse over above the
		Actions actions = new Actions(driver);
		actions.moveToElement(contactsLink).build().perform();
		
		newContactLink.click();
	}
	
	
	
}
