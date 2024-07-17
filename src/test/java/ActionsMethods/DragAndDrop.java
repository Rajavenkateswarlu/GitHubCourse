package ActionsMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {

	WebDriver driver;

	@BeforeMethod

	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}

	@Test
	public void dragAndDrop() {

		driver.get("https://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

		WebElement dragable =	driver.findElement(By.id("draggable"));

		WebElement dropable =driver.findElement(By.id("droppable"));
		
	    System.out.println( " Before dropable "+ dropable.getText());

		Actions act = new Actions(driver);

		act.dragAndDrop(dragable, dropable).build().perform();
		
		 System.out.println( " After dropable "+ dropable.getText());
	}

}
