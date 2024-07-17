package BasePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {




	public static WebDriver driver;

	public void setDriver(WebDriver driver) {
		BasePage.driver = driver ;
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	protected void click(By locator) {
		find(locator).click();
	}

	protected void sendKeys(By locator, String input) {
		find(locator).sendKeys(input);
	}

	protected String getText(By locator) {
		String text = find(locator).getText();
		System.out.println(text);
		return text;
	}
	
	protected void WaitForVisibilityOfLocators(By Loactor) {
		
		WebDriverWait wait = new WebDriverWait(driver,
				Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Loactor));
		
	}

}
