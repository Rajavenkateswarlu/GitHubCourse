package TestNG.Parameterized;

import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterizeTest {
	
	
	WebDriver driver;
	@Parameters({"URL"})
	@BeforeClass
	public void setUp(String url) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lambdatest.com/selenium-playground/");
		//Step -1 set up AUT
		driver.get(url);
	}
	
	@Test
	@Parameters({"Task", "TestResult"})
	public void testFileDownLoad(String task, String result) {
		//System.out.println(task + " " + result);
		//STEP 2 Click on file download
		driver.findElement(By.linkText("File Download")).click();
		//STEP 3 Enter the DATA
		driver.findElement(By.xpath("//textArea[@id = 'textbox']")).
		sendKeys(task +" Execution :  " + result);
		//STEP 4 Click on genrate file button
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("create")));
		driver.findElement(By.id("create")).click();
		// STEP 5 Click on download File
		driver.findElement(By.id("link-to-download")).click();
		
		
		
		
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}

}
