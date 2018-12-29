/**
 * 
 */
package com.infra.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infra.base.TestInfraBase;
import com.infra.pages.ContactsPage;
import com.infra.pages.HomePage;
import com.infra.pages.LoginPage;
import com.infra.util.TestUtil;

/**
 * @author ronb
 *
 */
public class ContactsPageTest extends TestInfraBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest(){
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
		
		// in order to check the HomePage I need to login first to
		// the application , so create Login and do the login first
		
		loginPage = new LoginPage();		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		//testUtil.SwitchToFrame("mainpanel");
		
		contactsPage = homePage.clickOnContactslink();
		
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		
		//testUtil.SwitchToFrame("mainpanel");
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest() {
		
		contactsPage.selectContactsByName("bala krishna");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		
		
		contactsPage.selectContactsByName("Angelina Jolie");
		
		contactsPage.selectContactsByName("anil kumar");
	}
	
	
	
	////////////////////////////////////////////////////
	// create DataProvider method to feed the contacts
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreatNewContactTest(String title, String firstName, String lastName, String company) {
		
		// from the homepage we click the new contact from the main menu
		homePage.clickOnNewContact();
				
		//contactsPage.createNewContact("Mr.", "simon", "Mor", "moonlight company");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
