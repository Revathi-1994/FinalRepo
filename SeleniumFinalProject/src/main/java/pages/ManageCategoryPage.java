
package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;

public class ManageCategoryPage {
	
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	private WebElement Newcategoryfield;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement image;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement savecategorybutton;
	

	

	public ManageCategoryPage clickOnAddNewCategoryField() {
		Newcategoryfield.click();
		return this;
	}

	public ManageCategoryPage EnterCategory(String categoryname) {
		category.sendKeys(categoryname);
		return this;
	}

	public ManageCategoryPage selectGroup() {
		selectgroup.click();
		return this;
	}

	public ManageCategoryPage uploadImage() {
		image.sendKeys(Constant.TESTDATAIMAGE);
		return this;
	}

	public ManageCategoryPage saveCategory() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", savecategorybutton);//add in page utility class
		return this;
	}

	
	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchcategory;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryname;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchcategorybutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertmessage;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/category/edit?edit=2072&page_ad=1']")
	WebElement editcategory;
	@FindBy(xpath="//span[text()='Active']")
	WebElement searchcategoryfoundmessage;

	public ManageCategoryPage searchCategory() {
		searchcategory.click();
		return this;
	}

	public ManageCategoryPage enterCategoryname(String searchcategoryname) {
		categoryname.sendKeys(searchcategoryname);
		return this;
	}

	public ManageCategoryPage clickOnSearchCategoryButton() {
		searchcategorybutton.click();
		return this;
	}
	public boolean getAlertMessageForSuccessfullCategoryCreation()
	{
		return alertmessage.isDisplayed();
	}
	public String getSearchedCategoryMessage()
	{
		return searchcategoryfoundmessage.getText();
	}

}
