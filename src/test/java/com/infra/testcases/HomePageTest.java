/**
 * 
 */
package com.infra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.infra.base.TestInfraBase;
import com.infra.pages.ContactsPage;
import com.infra.pages.DealsPage;
import com.infra.pages.HomePage;
import com.infra.pages.LoginPage;
import com.infra.pages.TasksPage;
import com.infra.util.TestUtil;


// Ctrl+SHift+O automatically will import


/**
 * @author ronb
 *
 */
public class HomePageTest extends TestInfraBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	DealsPage dealsPage;
	ContactsPage contactsPage;
	TasksPage tasksPage;
	
	// call the parent Ctor to initialize Properties object
	public HomePageTest() {
		super();
	}
	
	
	//test cases should be seperated -- independed with each other
	// before each test case -- launch the browser and login
	//after each test cases -- close the browser
	
	@BeforeMethod
	public void setUp(){
		
		// call the driver init operation at base class level
		initializtion();
		
		// create object for genericUtils
		testUtil = new TestUtil();
		//contactsPage = new ContactsPage();
		
		// in order to check the HomePage I need to login first to
		// the application , so create Login and do the login first
		
		loginPage = new LoginPage();		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String hoemPagetitle = homePage.verifyHomePageTitle();
		
		// assert with error message if assert failed
		Assert.assertEquals(hoemPagetitle, "CRMPRO","Homepage title not matched");	
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		contactsPage = homePage.clickOnContactslink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
