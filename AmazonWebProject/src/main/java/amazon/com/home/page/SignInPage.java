package amazon.com.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import amazon.com.BasePage;

public class SignInPage extends BasePage{
	protected WebDriver driver;

	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "nav-link-accountList")
	WebElement accountList;
	
	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement signInButton;
	
	@FindBy(xpath = "//*[@id='ap_email']")
	WebElement enterEmail;
	
	@FindBy(id = "continue")
	WebElement btnContinue;
	
	public void hoverOverAccountList() {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountList).perform();
		
		assert signInButton.isDisplayed() : "Sign-in option not visible!";
		System.out.println("Mouse hover successful. Sign-in option is visible.");
		
	}
	
	public void clickSignIn() {
		signInButton.click();
	}

	public void enterText() {
		waitForvisibilty(enterEmail);
		enterEmail.sendKeys("kumaraman748811@gmail.com");
		
		btnContinue.click();
	}
}
