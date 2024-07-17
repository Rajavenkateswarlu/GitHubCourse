package LambdaTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.BootStrapProgressBarPage;
import Pages.HomePage;
import Pages.HomePage;

public class ProgressBarTest extends BaseTest{

	SoftAssert softAssert = new SoftAssert();

	BootStrapProgressBarPage progressBarPage = new BootStrapProgressBarPage();


	@Test

	public void testProgressBarPercentage() {
		home = new HomePage();
		progressBarPage = home.clickOnBootstrapProgressBar();
		progressBarPage.clickOnStartDownload();
		String actualpercent = progressBarPage.getProgressbarMessage();
		String actualCompletedmsg = progressBarPage.getcompletedMessage();

		String expectedpercentage = "100%";
		String expectedMsg = "Dowload completed";
		
		softAssert.assertEquals(actualpercent, expectedpercentage,
				"\n Percantage is not 100% \n ");
		softAssert.assertEquals(actualCompletedmsg, expectedMsg,
				"\n The Message Is Not Complete Or Correct \n");
		
		softAssert.assertAll();






	}

}
