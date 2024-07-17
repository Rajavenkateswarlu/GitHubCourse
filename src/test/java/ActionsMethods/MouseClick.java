package ActionsMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseClick {
	
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	@Test
	public void leftClickButton() {
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/trigger-left-click.html");
		WebElement btn =driver.findElement(By.cssSelector("span.btn-neutral"));
		
		Actions act = new Actions(driver);
		act.click(btn).build().perform();
		
		driver.findElement(By.xpath("//ul[@class = 'context-menu-list context-menu-root']/li[7]")).click();
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		
		
		
	}
	
	@Test
	public void rightClick() {
		
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClick = driver.findElement(By.xpath("//span[contains(@class, 'btn')]"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rightClick).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[contains(@class , 'context')]"))));
		
		List<WebElement>afterRightClicks = driver.findElements(By.xpath("//ul[contains(@class , 'context')]/li"));
		System.out.println(afterRightClicks.size());
		
		for(WebElement opt : afterRightClicks) {
			
			String text = opt.getText();
			
			System.out.println(text);
		}
		
	}

}
