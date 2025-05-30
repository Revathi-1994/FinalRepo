package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;// global and local variables is same so use concept 'this'
		PageFactory.initElements(driver, this);// initialize elements

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewLink;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement UsernameNew;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement PasswordNew;
	@FindBy(xpath = "//select[@name='user_type']")
	private WebElement Usertypedropdown;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	private WebElement savebutton;

	

	public AdminUserPage clickOnNew() {

		NewLink.click();
		return this;
	}

	public AdminUserPage enternewusernameOnField(String user) {
		UsernameNew.sendKeys(user);
		return this;
	}

	public AdminUserPage enternewPasswordOntheField(String pass) {
		PasswordNew.sendKeys(pass);
		return this;
	}

	public AdminUserPage selectUserType() {
		Select select = new Select(Usertypedropdown);
		select.selectByIndex(1);
		return this;
	}

	public AdminUserPage clickOnsavebutton() {
		savebutton.click();
		return this;
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@class='form-control' and @id='un']")
	private WebElement searchuser;
	@FindBy(xpath = "//select[@class='form-control' and @id='ut']")
	private WebElement searchusertype;
	@FindBy(xpath = "//button[@type='submit' and @name='Search']")
	private WebElement searchbutton;

	public AdminUserPage searchForCreatedUser() {
		searchButton.click();
		return this;
	}

	public AdminUserPage searchForUser(String searchusername) {
		searchuser.sendKeys(searchusername);
		return this;
	}

	public AdminUserPage selectUserTypesearch(String Admin) {
		Select select = new Select(searchusertype);
		select.selectByVisibleText(Admin);
		return this;
	}

	public AdminUserPage searchUser() {
		searchbutton.click();
		return this;
	}
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successmessage;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/user/delete?del=13862&page_ad=1']")
	private WebElement deleteExistingUserButton;

	public boolean verifyUserDisplay() {
		return deleteExistingUserButton.isDisplayed();

	}
	public boolean successMessage() {

		return successmessage.isDisplayed();
	}


}