package SwitchMethods;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchToWindow {


	WebDriver driver ;


	@BeforeMethod


	public  void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test

	public void swithToWindow() {

		driver.get("https://demoqa.com/browser-windows");

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollTo(30,document.body.scrollHeight)");

		String parentWindow = driver.getWindowHandle();



		driver.findElement(By.id("tabButton")).click();

		driver.findElement(By.id("windowButton")).click();

		driver.findElement(By.id("messageWindowButton")).click();


		Set<String> allChild = driver.getWindowHandles();

		System.out.println("Size of the windows " + allChild.size());


		for(  String child : allChild) {

			if( parentWindow.equals(child)) {
				//driver.switchTo().window(child);

				System.out.println(" \t child Window Id \t " + parentWindow + 
						"\n \t URL \t \t " + driver.getCurrentUrl()+ 
						"\n \t Title of the page \t \t " + driver.getTitle());
			}else {
				driver.switchTo().window(child);
				System.out.println(" \t  Window Id \t " + child + 
						"\n \t URL \t \t " + driver.getCurrentUrl()+ 
						"\n \t Title of the page \t \t " + driver.getTitle());
			}
		}
	}

	@Test

	public void switchToNewTab() {

		driver.get("https://demoqa.com/browser-windows");

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollTo(30,document.body.scrollHeight)");

		String parent = driver.getWindowHandle();

		driver.findElement(By.id("tabButton")).click();

		Set<String> childs =  driver.getWindowHandles();

		System.out.println(childs.size());


		for( String child : childs) {
			if(parent.equals(child)) {
				System.out.print(" \n \t parent windows \t \t " + parent +
						"\n \t parent window Title \t \t" +driver.getTitle() +
						"\n \t parent window current URL " + driver.getCurrentUrl()
						);

			}
			else {

				driver.switchTo().window(child);

				System.out.print(" \n \t Child windows \t \t " + parent +
						"\n \t Child window Title \t \t" +driver.getTitle() +
						"\n \t Child window current URL " + driver.getCurrentUrl()
						);

			}
		}
	}

	@Test
	public void newWindow() {

		driver.get("https://demoqa.com/browser-windows");

		JavascriptExecutor js = (JavascriptExecutor)driver;

		js.executeScript("window.scrollTo(30,document.body.scrollHeight)");

		String parent = driver.getWindowHandle();

		driver.findElement(By.id("windowButton")).click();

		Set<String> childs = driver.getWindowHandles();

		System.out.println(childs.size());
		System.out.print("parent window" + parent );

		for(String child : childs) {
			if(! parent.equalsIgnoreCase(child)) {
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				System.out.print(" \n \t Child windows \t \t " + child +
						"\n \t Child window Title \t \t" +driver.getTitle() +
						"\n \t Child window current URL " + driver.getCurrentUrl()
						);
			

			}else {
				System.out.print(" \n \t Child windows \t \t " + parent +
						"\n \t Child window Title \t \t" +driver.getTitle() +
						"\n \t Child window current URL " + driver.getCurrentUrl()
						);
			}
		}
	}


}
