package TestNG.DynamicWaits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class DynamicWaits {

	WebDriver driver ;
	@BeforeMethod()
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.lambdatest.com/selenium-playground/");

	}
	@Test
	public void testExplicitWait() {

		driver.findElement(By.linkText("Dynamic Data Loading")).click();
		driver.findElement(By.xpath("//button[@id = 'save']")).click();

		By image =By.xpath("//div[@id = 'loading']/child :: img");

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//By image =By.xpath("//div[@id = 'loading']/child :: img");
		wait.until(ExpectedConditions.visibilityOfElementLocated(image));

		Boolean imageStatus = driver.findElement(image).isDisplayed();

		Assert.assertTrue(imageStatus ," \n Message : image is not displayed ");

		String name =driver.findElement(By.xpath("//div[@id = 'loading']")).getText();
		System.out.println(name);
	}
	@Test
	public void fluentWait() {
		driver.findElement(By.linkText("JQuery Download Progress bars")).click();
		driver.findElement(By.xpath("//button[@id = 'downloadButton']")).click();
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30))
		       .pollingEvery(Duration.ofSeconds(2))
		       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement progress = driver.findElement(By.cssSelector(".progress-label"));
		       
		       String progressBarText = progress.getText();
		       
		       if(progressBarText.equals("Complete!")) {
		    	   System.out.println( "Progress completed");
		    	   return progress;
		       }else {
		    	   System.out.println(progress.getText());
		    	   return null;
		       }
		     }
		   });
		
	}
	
	@Test
	
	public void implicitWait() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://the-internet.herokuapp.com/dynamic_loading");
		
		driver.findElement(By.xpath("//a[contains(text() ,  'Example 2')]")).click();
		
		driver.findElement(By.xpath("//div[@id = 'start']/button")).click();
		
		WebElement text =driver.findElement(By.xpath("//div[@id = 'finish']/h4"));
		
		System.out.println(text.getText());
		
		Assert.assertEquals(text.getText(), "Hello World!", "Message MisMatch");
	   
	
	}


}
