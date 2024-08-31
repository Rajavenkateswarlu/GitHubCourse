package TECH_AND_MORE;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class javaScriptExecutor {
	
	
	@Test
	public void demo1() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://moneyboats.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title  = js.executeScript("return document.title").toString();
		System.out.println("page Title " + title);
		
		String domainName = js.executeScript("return document.domain").toString();
		System.out.println("Domain Name  " + domainName);
		
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[text() = 'Blog']")));
	    js.executeScript("window.scrollBy(0, 1000)");
	}

}
