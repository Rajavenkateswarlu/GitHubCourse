package SwitchMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwithMethods_Frames {
	
	WebDriver driver;
	
	@BeforeMethod
	public  void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
	
	@Test
	
	public void switchToFrames() {
		driver.get("https://paytm.com");
		WebElement paytmLogo = driver.findElement(By.xpath("//div[@class = 'MMLFt']/a"));
		
		if(paytmLogo.isDisplayed()) {
			driver.findElement(By.xpath("//span[text() = 'Sign In']")).click();
			
			WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src , 'login?isIframe')]"));
			
			driver.switchTo().frame(iframe);
			
			driver.switchTo().frame("oauth-iframe");
			
			
			
			WebElement privacy = driver.findElement(By.xpath("//div[contains(text(), 'By signing')]/div[1]"));
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
			
			wait.until(ExpectedConditions.elementToBeClickable(privacy));
			
			privacy.click();
			
			String parent = driver.getWindowHandle();
			
			Set<String > listChildWin = driver.getWindowHandles();
			
			List<String> ls = new ArrayList<>(listChildWin);
			
			driver.switchTo().window(ls.get(1));
			
			String afterClickOnPrivacy = driver.findElement(By.className("allPadd10")).getText();
			System.out.print(afterClickOnPrivacy);
			
		}
	}
	
	@Test
	public void switchToFrame_WebElement() {
		driver.get("https://www.chase.com");
		
		//driver.switchTo().frame("logonbox");
		//driver.switchTo().frame("logonbox");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'cpo-signin']")));
		driver.findElement(By.name("userId")).sendKeys("RajaVenkateswarlu");
		driver.findElement(By.id("password-text-input-field")).sendKeys("Raja@223");
		driver.findElement(By.id("input-rememberMe")).click();
	}
	
	@Test
	public void switchToFrame_Index() throws InterruptedException {
		
		driver.get("https://www.yourhtmlsource.com/frames/inlineframes.html");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1600)");
		
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'inlineframesblank.html')]")));
		
		String messageBeforeClick = driver.findElement(By.id("htmlsource")).getText();
		System.out.println(messageBeforeClick);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'inlineframes2.html')]")));
		
		driver.findElement(By.xpath("//a[text() = 'Click me']")).click();
		
		driver.switchTo().parentFrame();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'inlineframesblank.html')]")));
		
		String messageAfterClick = driver.findElement(By.id("htmlsource")).getText();
		System.out.println(messageAfterClick);
		
	}

}
