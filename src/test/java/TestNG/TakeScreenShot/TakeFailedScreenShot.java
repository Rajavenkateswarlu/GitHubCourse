package TestNG.TakeScreenShot;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeFailedScreenShot {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.lambdatest.com/selenium-playground/");

	}

	@Test
	public void testSimpleFormDemo() {

		driver.findElement(By.linkText("Simple Form Demo")).click();

		WebElement enterMessage =driver.findElement(By.
				xpath("//p[text() = 'Enter Message']//following-sibling :: input[@id = 'user-message']"));

		enterMessage.sendKeys("Welcome to TestNG Frame Work");
		driver.findElement(By.xpath("//button[@id = 'showInput']")).click();

		String actualMessage = driver.findElement(By.id("message")).getText();

		Assert.assertEquals(actualMessage, "Welcome to TestNG Frame Work",
				"\n Message is not matched \n");
	}

	@AfterMethod
	public void takeFailedScreenShot(ITestResult testResult) {

		if(ITestResult.FAILURE ==testResult.getStatus() ||
			ITestResult.SUCCESS == testResult.getStatus()) {

			TakesScreenshot screenshot = (TakesScreenshot)driver;

			File soure =screenshot.getScreenshotAs(OutputType.FILE);

			File destination = new File (System.getProperty("user.dir") +
					"/Resource/ScreenShots/"
					+ testResult.getName() + ".png");

			try {
				//FileHandler.copy(soure, destination);
				FileUtils.copyFile(soure, destination);
				FileUtils.copyFile(soure, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
