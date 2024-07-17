package waitMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class PageLoadTimeOut {

	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {

		driver = new ChromeDriver();

		driver.manage().window().maximize();



	}
	@Test(enabled = false)
	public void pageLoadTimeOut() {
		// Page did not load in 3 milli Seconds 

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		//Thread.sleep(3000);// should not use Thread.sleep As a wait Method


		driver.navigate().to("https://opensource-demo.orangehrmlive.com");

		System.out.println("What is the Title " + driver.getTitle());

	}

	@Test

	public void DemoimplicitWait() {

		driver.get("http://the-internet.herokuapp.com/");

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.xpath("//button[text() = 'Start']")).click();


		String helloWorldMessage = driver.findElement(By.xpath("//div[@id = 'finish']/h4")).getText();
		System.out.println("Dynamic element is " + helloWorldMessage);
	}

	@Test

	public void DemoexplicitWait() {

		driver.get("http://the-internet.herokuapp.com/");
		
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
		driver.findElement(By.xpath("//button[text() = 'Start']")).click();
		

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'finish']")));
		WebElement finish = driver.findElement(By.xpath("//div[@id = 'finish']/h4"));
		
		String helloWorldMessage = finish.getText();
		System.out.println("Dynamic element is " + helloWorldMessage);
	}
	
	@Test
	public void demoFluentWait() {
		
		driver.get("https://demoqa.com/alerts");
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoAlertPresentException.class);
		
		Alert foo=(Alert) wait.until(new Function<WebDriver, WebElement>() {
			public  WebElement apply(WebDriver driver) {
				driver.findElement(By.id("timerAlertButton")).click();;
			return (WebElement) driver.switchTo().alert();
			}
		});
		
		foo.accept();
		
		String altText = foo.getText();
		
		System.out.println(altText);
		
		//WebElement After5Seconds = driver.findElement(By.id("timerAlertButton"));
		
			
		
		
		
		
		
		
		
	}

}
