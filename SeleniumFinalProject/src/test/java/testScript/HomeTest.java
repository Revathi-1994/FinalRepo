package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.loginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage homepage;

	@Test(description = "Verify whether user able to logout from home page")
	public void verifyUserLogoutFromHomepage() throws IOException {

		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=login.clickOnsubmit();
		homepage.clickOnAdminlink();
		login=homepage.clickOnLogout();

		String expected = "Sign in to start your session";
		String actual = homepage.getsigninpagetitle();
		Assert.assertEquals(actual, expected,Messages.LOGOUTERROR);

	}

	
}
