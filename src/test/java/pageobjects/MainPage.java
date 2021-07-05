package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import bsh.Console;

public class MainPage extends BasePage{

	@FindBy(css="[data-test-subj='discoverQueryHits']")
	WebElement hits;
	@FindBy(css="[role='search']")
	WebElement pageLoadElement;
	@FindBy(css=".euiCallOutHeader__title")
	WebElement noResultElement;
	@FindBy(css=".euiButtonIcon.euiButtonIcon--text")
	WebElement detailsExpand;
	@FindBy(css=".euiButtonIcon.euiButtonIcon--text")
	List <WebElement> expandListValue;
	@FindBy(css=".kbnDocViewer__value")
	List <WebElement> expandListValue1;
	
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getHits() {
		
		waitForElementToBeVisible(pageLoadElement);
		return getText(hits);

	}
	
	public void noResults() {
		waitForElementToBeVisible(noResultElement);
	}
	public void hitIsInvisible() {
		waitForElementToBeInvisible(hits);
		
	}
	public void clickOnDetailsExpand() {
		click(detailsExpand);
	}
	public void getClientUser() {
		System.out.println("-----------------------------------------------");
		System.out.println("Client User: "+getText(expandListValue.get(12)));
		System.out.println("-----------------------------------------------");
	}
	public void getDeviceType() {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println("Device Type: "+getText(expandListValue.get(20)));
		System.out.println("-----------------------------------------------");
	}
	public void getRelatedUserRedGrey() {
		System.out.println("-----------------------------------------------");
		System.out.println("Client User: "+getText(expandListValue1.get(38)));
		System.out.println("-----------------------------------------------");
	}
	public void getRelatedUserIsraelVPN() {
		System.out.println("-----------------------------------------------");
		System.out.println("Client User: "+getText(expandListValue1.get(40)));
		System.out.println("-----------------------------------------------");
	}
	
}
