package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.GiftCards;
import PageObjects.urbanLadderPage;
import testBase.BaseClass;

public class TC003_GiftCards extends BaseClass{

	@Test(priority=1,groups= {"sanity","master"})
	public void ChooseBirthdayGiftCard() {
		urbanLadderPage ul= new urbanLadderPage(driver);
		ul.clkGiftCards();
		logger.info("------Clicked the Giftcards-------");
		GiftCards g= new GiftCards(driver);
		logger.info("------Choosing Birthday/Anniversay-------");
		g.chooseBirthday();
		logger.info("------Select the gift amount-------");
		g.selectAmount();
	}
	@Test(priority=2,groups= {"master"})
	public void NegativeTestCase() throws InterruptedException, IOException {
		GiftCards g= new GiftCards(driver);
		logger.info("------Filling the form Lucky person-------");
		g.formLuckyPerson();
//		Thread.sleep(3000);
		logger.info("------Clicking the confirm button-------");
		g.clkConfirm();
		logger.info("------Getting the error message-------");
		g.getErrorMsg();
	} 
	@Test(priority=3,groups= {"master"})
	public void PositiveTestCase() throws InterruptedException, IOException {
		GiftCards g= new GiftCards(driver);
		logger.info("------Clearing the Form-------");
		g.clearForm();
		logger.info("------Enter the valid Email-------");
		g.validEmail();
		logger.info("------Clicking the confirm button-------");
		g.clkConfirm();
	}
	
}
