package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipWreckAdd {

	WebDriver driver;
	WebDriverWait wait;

	By shipname = By.id("name");
	By description = By.id("description");
	By condition = By.id("condition");
	By yearDiscovered = By.id("yearDiscovered");
	By depth = By.id("depth");
	By latitude = By.id("latitude");
	By longitude = By.id("longitude");

	By save = By.xpath("//input[@type='submit']");

	public ShipWreckAdd(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void createShip(String name, String desc) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(shipname));
		driver.findElement(shipname).sendKeys(name);
		driver.findElement(description).sendKeys(desc);
		driver.findElement(condition).sendKeys("Old");
		driver.findElement(yearDiscovered).sendKeys("1967");
		driver.findElement(depth).sendKeys("13");
		driver.findElement(latitude).sendKeys("2");
		driver.findElement(longitude).sendKeys("2");

		driver.findElement(save).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(save));
	}

}
