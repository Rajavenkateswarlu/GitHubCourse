package ActionsMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class rangeSlider {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	@Test(enabled = false)
	public void sliderLeft() {
		driver.get("https://rangeslider.js.org/");

		WebElement slider ;
		WebElement outPut;

		slider = driver.findElement(By.xpath("//div[@id = 'js-rangeslider-0'] /div[2]"));

		outPut = driver.findElement(By.id("js-output"));

		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, -150, 0).perform();

		System.out.println(outPut.getText());


	}


	@Test(enabled = false)

	public void silderRight() {

		driver.get("https://rangeslider.js.org/");

		WebElement slider ;
		WebElement outPut;

		slider = driver.findElement(By.xpath("//div[@id = 'js-rangeslider-0'] /div[2]"));

		outPut = driver.findElement(By.id("js-output"));

		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, 600, 0).perform();

		System.out.println(outPut.getText());



	}

	@Test

	public void dragAndDropByVerticallyUp() {
		driver.get("https://get.foundation/sites/docs-v5/components/range_slider.html");

		WebElement Vslider = driver.findElement(By.xpath("//div[contains(@class , 'small-3')]//div/span[1]"));
		WebElement result = driver.findElement(By.cssSelector("span#sliderOutput2"));

		Actions act = new Actions(driver);

		act.dragAndDropBy(Vslider, 0, -20).build().perform();

		System.out.println(result.getText());
	}

	@Test

	public void dragAndDropByVerticallyDown() {
		driver.get("https://get.foundation/sites/docs-v5/components/range_slider.html");

		WebElement Vslider = driver.findElement(By.xpath("//div[contains(@class , 'small-3')]//div/span[1]"));
		WebElement result = driver.findElement(By.cssSelector("span#sliderOutput2"));

		Actions act = new Actions(driver);

		act.dragAndDropBy(Vslider, 0, 30 ).build().perform();

		System.out.println(result.getText());
	}

}
