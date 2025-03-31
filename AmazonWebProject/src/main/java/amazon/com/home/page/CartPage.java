package amazon.com.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.com.BasePage;

public class CartPage extends BasePage {
	protected WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "a-size-extra-large a-text-normal")
	WebElement byTextShoppingCart;
	
	@FindBy(xpath = "//*[@id=\"gutterCartViewForm\"]/div/div[2]/div[2]/div/div/div/span/b")
	WebElement byTextOrderList;
	
	@FindBy(id = "sc-buy-box-ptc-button-announce")
	WebElement byBtnProceedToBuy;
	
	

	public void verifyText() {
		softAssert.assertEquals(byTextShoppingCart.getText(), "\r\n" + "        Shopping Cart\r\n" + "    ",
				"Shopping cart text is mis matched");
		
		softAssert.assertEquals(byTextOrderList.getText(), " Your order is eligible for FREE Delivery. ");

		}
	public void getProceedToBuy() {
		waitForvisibilty(byBtnProceedToBuy);
		byBtnProceedToBuy.click();
	}

}
