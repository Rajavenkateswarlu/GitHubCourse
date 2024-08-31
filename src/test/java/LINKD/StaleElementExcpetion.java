package LINKD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class StaleElementExcpetion {

	public WebDriver driver;

	@Test
	public void handleStaleElementExpection() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.pavantestingtools.com/");

		driver.manage().window().maximize();

		WebElement training = driver.findElement(By.linkText("Online Training"));
		training.click();
		driver.navigate().back();

		try {

			training.click();

		}catch(StaleElementReferenceException e) {
			training = driver.findElement(By.linkText("Online Training"));
			training.click();
		}


	}
	
	@Test
	public void freeCRM() {
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		
		name.sendKeys("Rajavenkateswarlu@gmail.com");
		password.sendKeys("Venkat@1234");
		
		driver.navigate().refresh();
		
		try {
		name.sendKeys("Raja@gmail.com");
		password.sendKeys("Raja@1234");
		}catch(StaleElementReferenceException e) {
			
			name = driver.findElement(By.name("email"));
			password = driver.findElement(By.name("password"));
			name.sendKeys("Raja@gmail.com");
			password.sendKeys("Raja@1234");
		}
	}
	
	@Test
	public void freeCRMDemo2() {
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		WebElement name = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.name("password"));
		
		name.sendKeys("Rajavenkateswarlu@gmail.com");
		password.sendKeys("Venkat@1234");
		
		driver.navigate().refresh();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		password = wait.until(ExpectedConditions.refreshed(ExpectedConditions.
				visibilityOf(password)));
		name = wait.until(ExpectedConditions.refreshed(ExpectedConditions.
				visibilityOf(name)));
		
		name.sendKeys("Raja@gmail.com");
		password.sendKeys("Raja@1234");
		

}
}