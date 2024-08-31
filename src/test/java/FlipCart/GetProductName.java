package FlipCart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductName {
	WebDriver driver;
	
	@Test
	public void getProductNames() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		
		List<WebElement>lisEle = driver.findElements(By.xpath("//div[@class='_58bkzq63 _3n8fnay4 _3n8fnapm _3n8fnah3 _3n8fna1 _3n8fna8k _58bkzq2 _1i2djtb9 _1i2djt0']"));
	     System.out.print(lisEle.size());
	}

}
