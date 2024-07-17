package BrowserMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserMethods {
	
	WebDriver driver;
	
	
	
	@BeforeMethod
	
	public  void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	
	@Test
	public  void browserMethods() {
		
		Reporter.log("Welcome testNg");
		
		String currentURL =driver.getCurrentUrl();
		
		Reporter.log(currentURL);
		System.out.println("Current Url is " + currentURL);
		
		String pageSource = driver.getPageSource();
		Reporter.log(pageSource);
		System.out.println("Page source is " + pageSource);
		
		String title = driver.getTitle();
		Reporter.log(title);
		System.out.println("Title of the page " + title);
		//driver.quit();
		driver.close();
	}

}
