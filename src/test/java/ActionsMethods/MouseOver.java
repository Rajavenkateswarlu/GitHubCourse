package ActionsMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOver {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	@Test
	public void hoverAmazonMenu() {
		
		driver.get("https://www.amazon.com/");
		
		WebElement mainMenu = driver.findElement(By.id("nav-link-accountList"));
	
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).moveToElement(driver.findElement(By.xpath("//span[text() = 'Account']"))).click().build().perform();
		
		System.out.println(driver.getTitle());
	
	}

}
