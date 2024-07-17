package LambdaTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BasePages.BasePage;
import Pages.HomePage;
 


public class BaseTest {


	private WebDriver driver;
	protected BasePage base;
	protected HomePage home;

	private final String AUT_URL = "https://www.lambdatest.com/selenium-playground/";

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@AfterClass
	public void tearDown() {
		driver.close();
		//driver.quit();
	}

	@BeforeMethod
	public void loadApplication() {

		driver.get(AUT_URL);

		base = new BasePage(); 
		base.setDriver(driver);

		home = new HomePage();

	}

	@AfterMethod
	public void getScreenShot(ITestResult result ) {

		if(ITestResult.FAILURE == result.getStatus() || 
			ITestResult.SUCCESS == result.getStatus()) {
			TakesScreenshot ts = (TakesScreenshot)driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			File destination = new File(System.getProperty("user.dir")
					+ "/Resource/ScreenShots/" + result.getName() + ".png");

			try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
