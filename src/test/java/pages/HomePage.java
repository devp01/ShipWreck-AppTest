package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	By toggleMenu = By.cssSelector("button.navbar-toggle");

	By container = By.xpath("//div[@class='container text-center']");
	By shipWreckButton = By.xpath("//a[text()='Shipwrecks']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void goToHome() {
		driver.get("http://custom-env.gchkxz5pce.us-east-1.elasticbeanstalk.com/index.html");
	}

	public void goToShipWrecks() {
		toggleIfPresent();
		wait.until(ExpectedConditions.elementToBeClickable(shipWreckButton));
		driver.findElement(shipWreckButton).click();
		toggleIfPresent();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(container));
	}

	private void toggleIfPresent() {
		WebElement toggle = driver.findElement(toggleMenu);
		if (toggle.isDisplayed()) {
			toggle.click();
		}
	}

}
