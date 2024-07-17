package NavigationMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navigation_Methods {
	
	WebDriver driver;
	
	@BeforeTest
	
	public void setUp() {
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://www.linkedin.com");
	}
	
	@Test
	public void navigation() {
		
		String HomePagetitle = driver.getTitle(); 
		
		driver.findElement(By.linkText("Forgot password?")).click();
		
		String title1 = driver.getTitle();
		
		driver.navigate().back();
		driver.navigate().refresh();
		
		driver.findElement(By.linkText("Join now")).click();
		String title2 = driver.getTitle();
		driver.navigate().refresh();
		
		driver.navigate().back();
		
		System.out.println(
		"What is Home page Title ?"+HomePagetitle + " \n \t" +
		"What is the Title of the page after click on Forgot password " + title1 +"\n \t" +
		"After Click on join Now Button " + title2  );
		 
		
	}

}
