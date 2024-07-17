package ActionsMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleClick {


	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@Test
	public void mouseDoubleClick() {

		driver.get("https://api.jquery.com/dblclick/#on1");

		JavascriptExecutor js =  (JavascriptExecutor) driver ;

		js.executeScript("window.scrollBy(0,2300)");

		driver.switchTo().frame(0);

		WebElement demo =driver.findElement(By.xpath("//html[@lang = 'en']/body/div"));

		Actions act = new Actions(driver);

		act.doubleClick(demo).build().perform();
	}

}
