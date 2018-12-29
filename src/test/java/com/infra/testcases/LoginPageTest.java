/**
 * 
 */
package com.infra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infra.base.TestInfraBase;
import com.infra.pages.HomePage;
import com.infra.pages.LoginPage;

/**
 * @author ronb
 * LoginPageTest using testNG
 */
public class LoginPageTest extends TestInfraBase 
{
	LoginPage loginPage;
	HomePage  homePage; // reference to the HomePage class

	public LoginPageTest() {
		// first calling the Parent (Supper class Constructor) by using 'Supper' keyword
		// to initialize the file properties in the parent base class.
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		// call the base class method
		initializtion();
		
		// create the loginPage object layer
		loginPage = new LoginPage();
	}
	
	
	// Test the title on the login page
	@Test(priority=1)
	public void LoginPageTileTest()
	{
		String title = loginPage.validateLoginTitle();
		
		// check that Title as expected on the login page
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean isDisplayed = loginPage.validateCRMImage();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		homePage =loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
	
	

}
