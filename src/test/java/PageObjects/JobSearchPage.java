package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import driver.BaseClass;

public class JobSearchPage extends BaseClass {
	WebDriver driver;
	
	public JobSearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "keyword")
	WebElement jobTitle;
	
	@FindBy(id="location")
	WebElement location;
	
	@FindBy(xpath = "//*[@id=\"search\"]")
	WebElement searchButton;
	
	@FindBy(id = "sort")
	WebElement sortBy;
	
	@FindBy(id = "accept-cookies")
	WebElement cookiesButton;

	public void enterJobTitle(String jobtitle) {
		jobTitle.sendKeys(jobtitle);
	}
	
	public void enterLocation(String locationpreference) {
		location.sendKeys(locationpreference);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickCookiesButton() {
		cookiesButton.click();
	}
	
	public void sortByNewestDatePosted(String datepostednewest) {
		new Select(sortBy).selectByVisibleText(datepostednewest);
	}
	

}
