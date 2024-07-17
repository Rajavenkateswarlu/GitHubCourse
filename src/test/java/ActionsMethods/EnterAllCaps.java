package ActionsMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class EnterAllCaps {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();


	}

	@Test

	public void enterAllCaps() throws InterruptedException {

		driver.get("https://www.google.com");


		driver.findElement(By.xpath("//textarea[@name = 'q']")).sendKeys("Selenium");

		Thread.sleep(3000);

		List<WebElement> searchs =driver.findElements(By.xpath("//div[@role = 'presentation']/ul/li"));

		System.out.println(searchs.size());
		int count = 0;
		for(WebElement search : searchs) {
			count++;
			System.out.println( count + "  "+ search.getText());

		}

	}

	@Test

	public void enterInSearch_Action() {

		driver.get("https://www.google.com");


		WebElement search = driver.findElement(By.xpath("//textarea[@name = 'q']"));

		Actions actions = new Actions(driver);
		
		actions.keyDown(search, Keys.SHIFT);
		
		actions.sendKeys(search, "Autiomation Testing");
		
		actions.keyUp(search, Keys.SHIFT);
		
		Action act =actions.build();
		
		act.perform();
	}
	@Test
	public void enterInSearch_Actions() {

		driver.get("https://www.google.com");


		WebElement search = driver.findElement(By.xpath("//textarea[@name = 'q']"));

		Actions actions = new Actions(driver);
		
		actions.keyDown(search, Keys.SHIFT).sendKeys("rajavenkateswarlu").keyUp(Keys.SHIFT).build().perform();
	}
}
