package PageObjects;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class GiftCards extends BasePage{

	public GiftCards(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="(//button[text()='Choose this'])[3]")
	WebElement Birthday;
	
	@FindBy(xpath="(//button[@class='HuPJS'])[2]")
	WebElement amt;

	@FindBy(xpath="//button[text()='Next']")
	WebElement nxt;

	@FindBy(xpath="(//input)[4]")
	WebElement reciverName;

	@FindBy(xpath="(//input)[5]")
	WebElement reciverEmail;

	@FindBy(xpath="(//input)[6]")
	WebElement reciverPh;

	@FindBy(xpath="(//input)[7]")
	WebElement senderName;

	@FindBy(xpath="(//input)[8]")
	WebElement senderEmail;

	@FindBy(xpath="(//input)[9]")
	WebElement senderPh;

	@FindBy(xpath="(//input)[10]")
	WebElement address;
	
	@FindBy(xpath="(//input)[11]")
	WebElement pincode;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement confirm;
	
	public void chooseBirthday() {
		js.executeScript("arguments[0].click()",Birthday);
	}
	public void selectAmount() {
		amt.click();
		nxt.click();
	}
	public void clearForm() {
		reciverName.clear();
		reciverEmail.clear();
		reciverPh.clear();
		senderName.clear();
		senderEmail.clear();
		senderPh.clear();
		address.clear();
		pincode.clear();
	}
	public void formLuckyPerson() throws IOException {
		String[] data=excelUtils.getCellData("XLread", 2, 8);
		
		reciverName.sendKeys(data[0]);
		reciverEmail.sendKeys(data[1]);
		reciverPh.sendKeys(data[2]);
		senderName.sendKeys(data[3]);
		senderEmail.sendKeys(data[4]);
		senderPh.sendKeys(data[5]);
		address.sendKeys(data[6]);
		pincode.sendKeys(data[7]);
	}
	public void clkConfirm() throws InterruptedException, IOException {
		Thread.sleep(1500);
		js.executeScript("arguments[0].click();",confirm);
		Thread.sleep(1500);
	}
	public void getErrorMsg() throws IOException {
		String errmsg=senderEmail.getAttribute("validationMessage");
		System.out.println(errmsg);
		excelUtils.setCellData("XLwrite",1 ,2 ,errmsg );
	}
	public void validEmail() throws InterruptedException, IOException {
		String[] validData=excelUtils.getCellData("XLread", 3, 8);
		reciverName.sendKeys(validData[0]);
		reciverEmail.sendKeys(validData[1]);
		reciverPh.sendKeys(validData[2]);
		senderName.sendKeys(validData[3]);
		senderEmail.sendKeys(validData[4]);
		senderPh.sendKeys(validData[5]);
		address.sendKeys(validData[6]);
		pincode.sendKeys(validData[7]);
	}
}
