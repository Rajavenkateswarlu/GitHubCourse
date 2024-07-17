package DropDownElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownSelect {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://testautomationpractice.blogspot.com/");
	}
	
	
	@Test(priority = 1)
	
	public void selectFromDropDownVb() {
		WebElement country = driver.findElement(By.id("country"));
		
		Select select = new Select(country);
		select.selectByVisibleText("India");
	}
	@Test(priority = 2)
	public void selctFromDropDownValue() {
		WebElement country = driver.findElement(By.id("country"));
		Select select = new Select(country);
		select.selectByValue("france");
			
	}
	
	@Test(priority =  3)
	public void selctFromDropDownIndex() {
		WebElement country = driver.findElement(By.id("country"));
		Select select = new Select(country);
		select.selectByIndex(2);
			
	}
	
	

}
