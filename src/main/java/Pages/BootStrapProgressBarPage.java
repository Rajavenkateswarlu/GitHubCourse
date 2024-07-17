package Pages;

import org.openqa.selenium.By;

import BasePages.BasePage;

public class BootStrapProgressBarPage extends BasePage{
	
	
	private By startDownloadButton = By.xpath("//button[@id = 'dwnBtn']");
	private By progressBarpercentage = By.xpath("//p[@class = 'counter']");
	private By completedMessage = By.xpath("//p[text() = 'Download completed!']");

	
	
	public void clickOnStartDownload() {
		
		click(startDownloadButton);
	}
	
	public String getProgressbarMessage() {
		
	
	WaitForVisibilityOfLocators(progressBarpercentage);
	String barPercentage = 	getText(progressBarpercentage);
	return barPercentage;
	}
	
	public  String getcompletedMessage() {
		
		WaitForVisibilityOfLocators(completedMessage);
		
		String msg = getText(completedMessage);
		return msg;
	}
	
	
}
