package Pages;

import org.openqa.selenium.By;

import BasePages.BasePage;

public class HomePage extends BasePage {
	
	private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
	
	
	public BootStrapProgressBarPage clickOnBootstrapProgressBar() {
		
		click(bootstrapProgressBar);
		
		return new BootStrapProgressBarPage();
	}
	
	

}
