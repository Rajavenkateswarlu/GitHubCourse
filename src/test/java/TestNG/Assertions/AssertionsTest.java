package TestNG.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsTest {
	
	SoftAssert softassert =  new SoftAssert();
	
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}
	@Test
	public void testSingleCheckBoxes() {
		driver.findElement(By.linkText("Checkbox Demo")).click();
		driver.findElement(By.xpath("//input[@id = 'isAgeSelected']")).click();
		String singleCheckBox = driver.findElement(By.xpath("//div[@id = 'txtAge']")).getText();
		Assert.assertTrue(singleCheckBox.contains("Checked"),
				" \n Message : Test Case Failed \n");
	}
	
	@Test
	public void testRadiobuttons() throws InterruptedException {
		
		WebElement gender;
		WebElement Age ;
		WebElement getValues; 
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		
		gender =driver.findElement(By.xpath(
		"//p[contains(text() , ' Gender and Age')]//following :: div[1]/label[1]/input"));
		
		Age = driver.findElement(By.
				xpath("//h4[text() = 'Age : ' ]//following :: input[@value = '5 - 15']"));
		getValues = driver.findElement(By.xpath("//button[text()= 'Get values']"));
	    gender.click();
	    Age.click();
	    Thread.sleep(3000);
	    getValues.click();
	    
	    String actualGender =driver.findElement(By.xpath("//span[@class = 'genderbutton']")).getText();
	    String actualGroup = driver.findElement(By.xpath("//span[@class = 'groupradiobutton']")).getText();
	    
	    softassert.assertEquals(actualGender, "Male", " \n ActualtGender is not Correct \n");
	    softassert.assertTrue(actualGroup.contains("15") , "\n Actual Age Group is not Correct \n");
	    softassert.assertAll("We are applied soft Assert : ");
	    
	}

}
