package DropDownElements;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDown_get {
	
	WebDriver driver ;
	
	@BeforeClass
	
	public void setUp() {
		
		driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/automation-practice-form");
		
	}
	
	@Test
	
	public void getFirstSelectedOption() {
		
	}

}
