package TestNG.AutomatedTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class First_Automated_test {
	WebDriver driver;

	/*
	 * I use befoeClass because it executes Before the 1st test method in the class
	 * 
	 * I use AfterClass because it executes Before the last test method in the class
	 */
	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void testTableSortAndSearch() {
		WebElement tableSort = driver.findElement(By.xpath("//a[contains(@href, 'table-sort')]"));
		tableSort.click();
		WebElement search = driver.findElement(By.xpath("//div[@id = 'example_filter']//input[@type = 'search']"));
		search.sendKeys("Greer");
	}
	
	@Test(priority = 2)
	public void testBootStrapDatePicker() {
		WebElement bootstrapDatePicker = driver.findElement(By.linkText("Bootstrap Date Picker"));
		bootstrapDatePicker.click();
		
		//WebElement birthday = driver.findElement(By.id("birthday"));
		
		driver.findElement(By.cssSelector("#birthday")).sendKeys("06/07/2008");
		
		//driver.navigate().back();
	}
}
