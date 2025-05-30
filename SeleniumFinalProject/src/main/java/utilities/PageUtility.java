package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	JavascriptExecutor javascript;
	WebDriver driver;
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	
	public void selectRadiobuttonAndCheckbox(WebElement element) {
		element.click();
	}
	
	public void handleAlert() {
		Alert alert= driver.switchTo().alert();//to switch to the alert box
		alert.accept();
	}
	
	public void pagedown() {
		javascript.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void pageup() {
		javascript.executeScript("window.scrollBy(0,-350)", "");
	}
	public void rightclick() {
		javascript.executeScript("window.scrollBy(0,-350)", "");
	}
	public void mouseover() {
		javascript.executeScript("window.scrollBy(0,-350)", "");
	}
	public void radiobutton() {
		javascript.executeScript("window.scrollBy(0,-350)", "");
	}
}
