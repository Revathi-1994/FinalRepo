package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.ManageNewsPage;
import pages.loginPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage managenews;
	HomePage homepage;

	@Test(description = "Verify whether user able to add new News")
	public void verifyAddNews() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=login.clickOnsubmit();
		
		managenews=homepage.clickOnManageNewsIcon();
		String news = ExcelUtility.getStringData(1, 0, "News");
		managenews.clickaddnewsbutton().enternewsonnewstextbox(news).clickOnSaveNewsButton();
		
		boolean isalertboxVisible = managenews.alertboxVisiblity();
		Assert.assertTrue(isalertboxVisible,Messages.ADDNEWSERROR);

	}
}
