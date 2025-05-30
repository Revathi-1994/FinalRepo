package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement addnewsbutton;
	@FindBy(xpath = "//textarea[@class=\'form-control\']")
	private WebElement newstextbox;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveNewsButton;
	
	

	

	public ManageNewsPage clickaddnewsbutton() {
		addnewsbutton.click();
		return this;
	}

	public ManageNewsPage enternewsonnewstextbox(String testnewsdata) {
		newstextbox.sendKeys(testnewsdata);
		return this;
	}

	public ManageNewsPage clickOnSaveNewsButton() {
		saveNewsButton.click();
		return this;
	}

	
	@FindBy(xpath="//i[@class='icon fas fa-check']")
	private WebElement alertbox;
	
	public boolean alertboxVisiblity() {
		return alertbox.isDisplayed();
	}
}