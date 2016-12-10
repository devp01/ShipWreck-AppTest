package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShipWreckPage {

	WebDriver driver;
	WebDriverWait wait;

	By addNew = By.xpath("//a[@ui-sref='newShipwreck']");

	By delete = By.xpath("//a[text()='Delete']");

	public ShipWreckPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	public void addNew() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNew));
		WebElement element = driver.findElement(addNew);
		element.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(addNew));
	}

	public void clearAll() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(addNew));
		List<WebElement> deleteButtons = driver.findElements(delete);
		if (!deleteButtons.isEmpty()) {
			deleteButtons.get(0).click();
			driver.switchTo().alert().accept();
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wd) {
					return ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete");
				}
			});
			clearAll();
		}
	}

}
