package amazon.com.home;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.com.BasePage;
import amazon.com.home.page.OrderPage;
import amazon.com.home.page.SignInPage;

public class HomePage extends BasePage {
	protected WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-logo-sprites")
	WebElement byBtnHomeAmazon;

	@FindBy(id = "glow-ingress-line1")
	WebElement byBtnAddress1;

	@FindBy(id = "glow-ingress-line2")
	WebElement byBtnAddress2;

	@FindBy(id = "nav-search-label-id")
	WebElement byBtnTaskAllListBox;

	@FindBy(id = "twotabsearchtextbox")
	WebElement byBoxSearch;

	@FindBy(id = "nav-search-submit-button")
	WebElement byBtnSearch;

	@FindBy(id = "icp-nav-flyout")
	WebElement byBtnLanguage;

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement byTextHelloName;

	@FindBy(xpath = "//span[text()='Account & Lists']")
	WebElement byAccountandList;

	@FindBy(id = "nav-orders")
	WebElement byBtnReturnOrder;

	@FindBy(id = "nav-cart-text-container")
	WebElement byBtnCart;

	@FindBy(id = "nav-hamburger-menu")
	WebElement byBtnAll;

	@FindBy(id = "nav-link-groceries")
	WebElement byBtnListFresh;

	@FindBy(xpath = "//a[text()='MX Player']")
	WebElement byBtnMXPlayer;

	@FindBy(xpath = "//a[text()='Sell']")
	WebElement byBtnSell;

	@FindBy(xpath = "//a[text()='Bestsellers']")
	List<WebElement> byBtnBestSellers;

	@FindBy(xpath = "//a[@href='/deals?ref_=nav_cs_gb']")
	WebElement byBtnTodayDeals;

	@FindBy(xpath = "//a[text()='Mobiles']")
	WebElement byBtnMobiles;

	@FindBy(id = "nav-link-amazonprime")
	WebElement byBtnListAmazonPrime;

	@FindBy(xpath = "//a[text()='Customer Service']")
	WebElement byBtnCustomerService;

	@FindBy(xpath = "//a[text()='New Releases']")
	WebElement byBtnNewReleases;

	@FindBy(xpath = "//a[text()=' Electronics ']")
	WebElement byBtnElectronics;

	@FindBy(xpath = "//a[text()='Fashion']")
	WebElement byBtnFashion;

	@FindBy(xpath = "//a[text()='Amazon Pay']")
	WebElement byBtnAmazonPay;

	@FindBy(xpath = "//a[text()='Computers']")
	WebElement byBtnComputers;

	@FindBy(xpath = "//a[text()='Books']")
	WebElement byBtnBooks;

	@FindBy(xpath = "//a[text()='Car & Motorbike']")
	WebElement byBtnCarAndMotorbike;

	public void getVerifyFirstHeader() {

		softAssert.assertEquals(byBtnAddress1.getText(),
				"\r\n" + "                   Delivering to Pune 411007\r\n" + "                ",
				"\r\n" + "Delivering to Pune 411007 is mis matched");

		softAssert.assertEquals(byBtnAddress2.getText(),
				"\r\n" + "                   Update location\r\n" + "                ",
				"Update location is mis matched");

		softAssert.assertEquals(byBtnTaskAllListBox.getText(), "All", "All text is mis matched");

		softAssert.assertEquals(byBoxSearch.getAttribute("placeholder"), "Search Amazon.in",
				"Search Amazon.in text is mis matched");

		softAssert.assertEquals(byTextHelloName.getText(), "Hello, sign in", "Hello, sign in text is mis matched");

		softAssert.assertEquals(byAccountandList.getText(), "Account & Lists", "Account & Lists text is mis matched");

		softAssert.assertEquals(byBtnReturnOrder.getText(), "Returns\n" + "& Orders",
				"Returns & Orders text is mis matched");

		softAssert.assertEquals(byBtnCart.getText(), "\r\n" + "        Cart\r\n" + "        ",
				"\r\n" + "Cart text is mis matched");

	}

	public void getVerifySecondHeader() {

		softAssert.assertEquals(byBtnAll.getText(), "All", "All text is mis matched");

		softAssert.assertEquals(byBtnListFresh.getText(), "Fresh", "Fresh text is mis matched");

		softAssert.assertEquals(byBtnMXPlayer.getText(), "MX Player", "MX Player text is mis matched");

		softAssert.assertEquals(byBtnSell.getText(), "Sell", "Sell text is mis matched");

		softAssert.assertEquals(byBtnBestSellers.get(0).getText(), "Bestsellers", "Bestsellers text is mis matched");

		softAssert.assertEquals(byBtnTodayDeals.getText(), "Today's Deals", "Today's Deals text is mis matched");

		softAssert.assertEquals(byBtnMobiles.getText(), "Mobiles", "Mobiles text is mis matched");

		softAssert.assertEquals(byBtnListAmazonPrime.getText(), "Prime", "Prime text is mis matched");

		softAssert.assertEquals(byBtnCustomerService.getText(), "Customer Service",
				"Customer Service text is mis matched");

		softAssert.assertEquals(byBtnNewReleases.getText(), "New Releases", "New Releases text is mis matched");

		softAssert.assertEquals(byBtnElectronics.getText(), "Fashion", "Fashion text is mis matched");

		softAssert.assertEquals(byBtnFashion.getText(), "Amazon Pay", "Amazon Pay text is mis matched");

		softAssert.assertEquals(byBtnAmazonPay.getText(), "Home & Kitchen", "Home & Kitchen text is mis matched");

		softAssert.assertEquals(byBtnComputers.getText(), "Computers", "Computers text is mis matched");

		softAssert.assertEquals(byBtnBooks.getText(), "Books", "Books text is mis matched");

		softAssert.assertEquals(byBtnCarAndMotorbike.getText(), "Car & Motorbike",
				"Car & Motorbike text is mis matched");

	}
	
	public OrderPage clickOrderPage() {
		return new OrderPage(driver);
	}
	
	public SignInPage openSignPage() {
		return new SignInPage(driver);
	}

}
