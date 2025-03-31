package amazon.com.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.com.BasePage;

public class OrderPage extends BasePage {

	protected WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "twotabsearchtextbox")
	WebElement byBoxSearch;

	@FindBy(id = "nav-search-submit-button")
	WebElement byBtnSearch;

	@FindBy(id = "a-autoid-1-announce")
	WebElement byBtnAddToCart;

	@FindBy(id = "ewc-compact-actions-container")
	WebElement addCartMessage;

	@FindBy(xpath = "//*[@id=\"ewc-compact-actions-container\"]/div/div[2]/span/span/a")
	WebElement goAddToCart;

	public void clickOnSeachItem() {
		byBoxSearch.sendKeys("iphone 16pro max");
		byBtnSearch.click();
	}

	public void clickAddToCart() {
		scrollTheElement(byBtnAddToCart);
		waitForvisibilty(byBtnAddToCart);
		byBtnAddToCart.click();

	}

	public CartPage goToCartPage() {
		waitForvisibilty(addCartMessage);
		System.out.println(addCartMessage.getText());

		goAddToCart.click();
		return new CartPage(driver);
	}
}
