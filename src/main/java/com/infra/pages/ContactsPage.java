/**
 * 
 */
package com.infra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.infra.base.TestInfraBase;

/**
 * @author ronb
 *
 */
public class ContactsPage extends TestInfraBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	
	
	// Initializing the page objects:
	public ContactsPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	
	// select contact by name
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title,String firstname,String lastname,String companyName) 
	{
				
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
	
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company.sendKeys(companyName);
		saveBtn.click();
		
	}
	
	
}
