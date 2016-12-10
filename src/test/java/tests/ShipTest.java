package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ShipWreckAdd;
import pages.ShipWreckPage;

public class ShipTest {

	WebDriver driver;

	HomePage homePage;
	ShipWreckPage shipWreckPage;
	ShipWreckAdd shipWreckAdd;

	@BeforeTest
	public void reset() {
		homePage.goToHome();
		homePage.goToShipWrecks();
	}

	@Test(priority = 1)
	public void deleteShips() {
		shipWreckPage.clearAll();
	}

	@Test(priority = 0, dataProvider = "ships")
	public void addShips(String name, String desc) {
		shipWreckPage.addNew();
		shipWreckAdd.createShip(name, desc);
	}

	@DataProvider
	public Object[][] ships() {
		return new Object[][] { new Object[] { "Ship1", "Ship Desc1" }, new Object[] { "Ship2", "Ship Desc2" },
				new Object[] { "Ship3", "Ship Desc3" }, new Object[] { "Ship4", "Ship Desc4" },
				new Object[] { "Ship5", "Ship Desc5" } };
	}

	@BeforeSuite
	public void beforeSuite() { 
//		System.setProperty("webdrive	r.chrome.driver", "/home/phystem/Documents/SeleniumDriver/chromedriver");
//		driver = new ChromeDriver();
		driver = new PhantomJSDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		homePage = new HomePage(driver);
		shipWreckPage = new ShipWreckPage(driver);
		shipWreckAdd = new ShipWreckAdd(driver);
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
