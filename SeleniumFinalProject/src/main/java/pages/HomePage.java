package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;// global and local variables is same so use concept 'this'
		PageFactory.initElements(driver, this);// initialize elements

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement Admin;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[2]")
	private WebElement Logout;
	@FindBy(xpath = "//p[@class='login-box-msg']")
	private WebElement signinpagetitle;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminuserlink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	private WebElement managenewsicon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='active nav-link']")
	private WebElement managecategoryfield;

	public HomePage clickOnAdminlink() {
		Admin.click();
		return this;
	}

	public loginPage clickOnLogout() {
		Logout.click();
		return new loginPage(driver);
	}

	public String getsigninpagetitle() {
		return signinpagetitle.getText();

	}
	public AdminUserPage clickOnAdminuser() {
		adminuserlink.click();
		return new AdminUserPage(driver);
	}
	public ManageNewsPage clickOnManageNewsIcon() {
		managenewsicon.click();
		return new ManageNewsPage(driver);			
	}
	public ManageCategoryPage clickOnManageCategoryField() {
		managecategoryfield.click();
		return new ManageCategoryPage(driver);
	}
}