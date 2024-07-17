package SwitchMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToAlerts {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setUp() {
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}

	@Test
	public void switchToInformationAlerts() {
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
		Alert alt = driver.switchTo().alert();
		
		System.out.println(alt.getText());
		alt.accept();
		
		System.out.print(driver.findElement(By.id("result")).getText());
	}
	
	@Test
	
	public void swithToConfirmation() {
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[contains(text()  ,  'Confirm')]")).click();
		
		Alert alt = driver.switchTo().alert();
		System.out.print(alt.getText());
		alt.accept();
		System.out.print(driver.findElement(By.id("result")).getText());
	}
	
	@Test
	
	public void switchToPromptAlert() {
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();
		
		Alert alt = driver.switchTo().alert();
		alt.sendKeys("Enter the Name");
		
		alt.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
	}
}
