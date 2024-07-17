package RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PressKeys {
	

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	
	
	@Test
	
	public void useKeysClass() {
		driver.get("https://api.jquery.com/");
		
		driver.findElement(By.name("s")).sendKeys("Test");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		
	}
	
	@Test
	public void useRobotClass() throws AWTException {
		
		driver.get("https://api.jquery.com/");
		Robot robot = new Robot();
		driver.findElement(By.name("s")).sendKeys("Json");
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
