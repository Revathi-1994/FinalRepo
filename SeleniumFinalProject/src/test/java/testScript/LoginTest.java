package testScript;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AutomationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.loginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	HomePage homepage;

	@Test(description = "Verifying user login with valid credentials",priority=1,groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=login.clickOnsubmit();
		String expected = "Dashboard";
		String actual = login.getDashboardText();
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);
		//retryAnalyzer=retry.Retry.class ->add this code to implement retry,iside the @Test tag
	}

	@Test(description = "Verify the login with Valid username and invalid password",priority=2,groups= {"smoke"})
	public void verifyUserLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnsubmit();
		// Assertion
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.INVALIDPASSWORDERROR);
	}

	@Test(description = "Verify the login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnsubmit();
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.INVALIDUSERNAMEERROR);
	}

	@Test(description = "Verify the login with invalid credentials", dataProvider="loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String username,String password) throws IOException {
		//String username = ExcelUtility.getStringData(4, 0, "LoginPage");
		//String password = ExcelUtility.getStringData(4, 1, "LoginPage");

		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnsubmit();
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,Messages.VALIDCREDENTIALERROR);
	}
	@DataProvider(name="loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException
	{
		return new Object[][] { new Object[] {"admin123","123"}
			//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
