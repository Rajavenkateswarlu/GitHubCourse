package TECH_AND_MORE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ExceptionHandling {
	WebDriver driver;
	
	@Test
	public void demo() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/?locale=in");
		
		WebElement usename = driver.findElement(By.xpath("//input[@id = 'username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id = 'password']"));
		
		usename.sendKeys("rajavenkateswarlu319@gmail.com");
		password.sendKeys("Raja@319");
		
		WebElement login = driver.findElement(By.xpath("//input[@id = 'Login']"));
		//org.openqa.selenium.JavascriptException:
		login.click();
		
		
		
		driver.findElement(By.xpath("//div[@class = 'slds-icon-waffle']")).click();
		
		WebElement leads = driver.findElement(By.xpath("//a[@title = 'Leads']"));
		//leads.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()" , leads);
		
		//WebElement New = driver.findElement(By.xpath("//div[@title = 'New']"));
		//Thread.sleep(3000);
		WebElement New = driver.findElement(By.xpath("//div[@class = 'slds-grid']/child :: div[2]/ul/li[1]"));
		New.click();
		
		driver.findElement(By.xpath("//textarea[@name = 'street']")).sendKeys("Sr Nagar");
		
		
		/*
		 * org.openqa.selenium.NoSuchElementException:
		Thread.sleep(2000);
		driver.quit();
		
		
		org.openqa.selenium.NoSuchSessionException:
		System.out.println(driver.getTitle());
		*/
		
	}

}
