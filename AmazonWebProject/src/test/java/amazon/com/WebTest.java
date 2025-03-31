package amazon.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import amazon.com.home.HomePage;
import amazon.com.home.page.CartPage;
import amazon.com.home.page.OrderPage;
import amazon.com.home.page.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTest {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private HomePage homePage;
	private OrderPage orderPage;
	private CartPage cartPage;
	private SignInPage signInPage;

	@BeforeTest
	public static WebDriver setUp() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\amazon\\com\\resources\\driverData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver.quit();
			System.out.println("Driver is not Availble");
		}
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (driver.getPageSource().contains("Type the characters you see in this image")) {
			System.out.println("CAPTCHA detected! Please solve it manually and press Enter to continue...");
			new Scanner(System.in).nextLine(); // Wait for user input
		}

		return driver;
	}

	@Test
	public void lunchApplication() {
		homePage = new HomePage(driver);
		homePage.getVerifyFirstHeader();
		homePage.getVerifySecondHeader();
		homePage.openSignPage();
		signInPage = new SignInPage(driver);
		signInPage.hoverOverAccountList();
		signInPage.clickSignIn();
		signInPage.enterText();
//		homePage.clickOrderPage();
//		orderPage = new OrderPage(driver);
//		orderPage.clickOnSeachItem();
//		orderPage.clickAddToCart();
//		orderPage.goToCartPage();
//		cartPage = new CartPage(driver);
//		cartPage.verifyText();
//		cartPage.getProceedToBuy();
	}

	@AfterTest
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public String getScreenShot(String testCaseNames, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseNames + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseNames + ".png";

	}

}
