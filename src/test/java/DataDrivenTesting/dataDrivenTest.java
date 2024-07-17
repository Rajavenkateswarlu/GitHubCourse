package DataDrivenTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataDrivenTest {
	
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");
	}
	
	@Test(dataProvider = "ajaxData")
	public void testAjexForm(String name  , String commit) {
		
		System.out.println("Name " + name);
		System.out.println("commit" + commit);
		
		
	}
	
	@DataProvider
	public Object[][] ajaxData() {
		Object[][] data = new Object[2][2];
		
		data[0][0] = "Raja" ; data[0][1] = "Manual Tester";
		data[1][0] = "Venkateswarlu" ; data[1][1] = "Selenium";
		return data;
		
	}

}
