/**
 * 
 */
package com.infra.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.infra.base.TestInfraBase;

import selenium.infra.utils.InfraUtils;

/**
 * @author ronb
 *
 *The login page 
 */
public class LoginPage extends TestInfraBase
{
	//Using page factory annotation , this is same as using : driver.findElement(By.Name()) , but faster and easy
	// to use on page object
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	// In the Ctor initialize the page objects using PageFactory
	public LoginPage() 
	{
		PageFactory.initElements(driver,this);
	}
	
	
	// Actions:
	//////////////////////////////////////////
	
	public String validateLoginTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}

	// Do the login into the site and return the HomePage
	public HomePage Login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		// click the login Button using js
		InfraUtils.jsClickByWebElement(driver, loginBtn);
		// loginBtn.click();
	
		return new HomePage();
	}
	
}
