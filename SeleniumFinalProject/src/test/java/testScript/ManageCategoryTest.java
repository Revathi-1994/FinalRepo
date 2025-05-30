package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import AutomationCore.Base;
import constants.Messages;
import pages.HomePage;
import pages.ManageCategoryPage;
import pages.loginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base{
	HomePage homepage;
	ManageCategoryPage managecategory;
	
	
	@Test(description = "Verifying user able to add new Category ")
	public void verifyAddCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=login.clickOnsubmit();
		
		RandomDataUtility randomdatautility = new RandomDataUtility();
		String categoryname = randomdatautility.createRandomName();
		
		managecategory=homepage.clickOnManageCategoryField();
		managecategory.clickOnAddNewCategoryField().EnterCategory(categoryname).selectGroup().uploadImage().saveCategory();
		
		boolean alertmessage=managecategory.getAlertMessageForSuccessfullCategoryCreation();
		Assert.assertTrue(alertmessage,Messages.ADDCATEGORYERROR);

	}

	@Test(description = "Verifying User able to search an existing category")
	public void verifySearchCategory() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		loginPage login = new loginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homepage=login.clickOnsubmit();
		
		
		managecategory=homepage.clickOnManageCategoryField();
		String searchcategoryname = ExcelUtility.getStringData(1, 0, "ManageCategory");
		managecategory.searchCategory().enterCategoryname(searchcategoryname).clickOnSearchCategoryButton();
		
		String Expected="Active";
		String actual=managecategory.getSearchedCategoryMessage();
		Assert.assertEquals(actual,Expected,Messages.SEARCHCATEGORYERROR);
	}
}
