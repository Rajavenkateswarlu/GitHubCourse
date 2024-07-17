package DropDownElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown_Select {
	
	WebDriver driver ;
	
	@BeforeTest
	public void setup() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.get("https://www.toolsqa.com/automation-practice-form/");
	
	}
	@Test(priority = 1 )
	public void AccesEmployeeList() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.tagName("button")).click();
		
		driver.findElement(By.linkText("PIM")).click();
	}
	@Test(priority = 2)
	public void selectDropDown() {
		//System.out.println("Select option via SelectByindex ,SelectByValue , visible Text() Methods");
		
		driver.findElement(By.xpath("//label[text() = 'Job Title']//following :: div[1]/div/div/div[1]")).click();
		
	}

}
