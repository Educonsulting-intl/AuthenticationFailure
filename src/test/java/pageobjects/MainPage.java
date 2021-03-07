package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

	@FindBy(css="[data-test-subj='discoverQueryHits']")
	WebElement hits;
	@FindBy(css="[role='search']")
	WebElement pageLoadElement;
	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getHits() {
		
		waitForElementToBeVisible(pageLoadElement);
		return getText(hits);

	}
}
