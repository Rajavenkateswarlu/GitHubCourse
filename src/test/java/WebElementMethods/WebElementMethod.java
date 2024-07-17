package WebElementMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElementMethod {
	
	WebDriver driver;
	@BeforeMethod
	public void setUpBrowser() {
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
	}
	//@BeforeTest
	public void openApplication() {
		driver.get("https://sharpspring.com/" );
	}
	@Test
	public void webElementsMethods() {
		driver.get("https://sharpspring.com/" );
		driver.findElement(By.xpath("//button[text() = 'I Agree']")).click();
		//driver.findElement(By.linkText(" Login")).click();
		driver.findElement(By.xpath("//ul[@id = 'mega-menu-main-menu']/li[9]")).click();
		
		driver.findElement(By.id("okta-signin-username")).sendKeys("Raja");
		driver.findElement(By.id("okta-signin-password")).sendKeys("Raja@1996");
		driver.findElement(By.xpath("//label[. = 'Remember me']")).click();
		//driver.findElement(By.id("okta-signin-submit")).click();
		
		driver.findElement(By.id("okta-signin-submit")).submit();
		
		String error = driver.findElement(By.xpath("//div[contains(@class,  'okta-form')]//p")).getText();
		System.err.println("ErrorMEssage is " + error);
		
		driver.findElement(By.id("okta-signin-username")).clear();
		driver.findElement(By.id("okta-signin-password")).clear();
		
		String userName = driver.findElement(By.name("username")).getText();
		
		System.out.println("UserName Text" + userName);
		
		String userNamePalceHolder = driver.findElement(By.name("username")).getAttribute("placeholder");
		
		System.out.println("User Name place holder " + userNamePalceHolder);
		
		String userNameError = driver.findElement(By.id("input-container-error57")).getText();
		System.err.println("userName Error message is " + userNameError);
		driver.findElement(By.xpath("//label[. = 'Remember me']")).click();
		driver.quit();
	}
	@Test
	public void testIsDisplayedIsEnabled() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		
		driver.findElement(By.linkText("PIM")).click();
		
	//	WebElement deleteButton = driver.findElement(By.xpath("//button//i[@class = 'oxd-icon bi-trash-fill oxd-button-icon']"));
		
		//System.out.println(deleteButton.isDisplayed());
		//System.out.println(deleteButton.isEnabled());
		
		
		driver.findElement(By.xpath("//div[text() = 'Amelia '] /preceding :: i[1]")).click();
		WebElement deleteButton = driver.findElement(By.xpath("//button//i[@class = 'oxd-icon bi-trash-fill oxd-button-icon']"));
		
		System.out.println("After click on id " + "\n \t" +
		
				 "Displayed = "+ deleteButton.isDisplayed() + "\n \t" +
				 "enabled = "+ deleteButton.isEnabled());
				 
		

		
		
	}

}
