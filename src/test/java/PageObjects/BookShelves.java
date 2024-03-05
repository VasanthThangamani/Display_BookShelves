package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class BookShelves extends BasePage {

	public BookShelves(WebDriver driver) {
		super(driver);	
	}
	Actions act=new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	@FindBy(xpath="//a[@data-gaaction='popup.auth.close']")
	WebElement popup;
	
	@FindBy(xpath="(//div[@class='gname'])[1]")
	WebElement price;
	
	@FindBy(xpath="//div[@class='noUi-handle noUi-handle-upper']")
	WebElement maxPrice;
	
	@FindBy(xpath="//li[@data-group='storage type']")
	WebElement category;
	
	@FindBy(xpath="//input[@value='Open']")
	WebElement open;
	
	@FindBy(id="filters_availability_In_Stock_Only")
	WebElement ExOutStock;
	
	@FindBy(xpath="//div[@class='product-title product-title-sofa-mattresses']")
	List<WebElement> productTitle;
	
	@FindBy(xpath="//div[@class='price-number']/span")
	List<WebElement> productPrice;
	
	public void closePopup() {
		popup.click();
	}
	public void price() throws InterruptedException {
		Thread.sleep(5000);
		act.moveToElement(price).perform();
		Thread.sleep(2000);
		act.dragAndDropBy(maxPrice, -274,0).perform();
	}
	public void category() {
		act.moveToElement(category).perform();
		js.executeScript("arguments[0].click()",open);
	}
	
	public void ExcludeOutOfStock() {
		js.executeScript("arguments[0].click();", ExOutStock);
	}
	
	public void productDetails() throws IOException {
		int row=1;
//		wait(productTitle.get(0),30);
		for(int i=0;i<3;i++) {
			String pTitle=productTitle.get(i).getText();
			String pPrice=productPrice.get(i).getText();
			System.out.println(pTitle+"  :  "+pPrice+"\n");
			excelUtils.setCellData("XLwrite", row, 0, pTitle);
			row++;
			excelUtils.setCellData("XLwrite", row, 0, pPrice);
			row++;
		}
		js.executeScript("window.scrollBy(0,-300)");
	}
	
//	actions.moveToElement(click_bookshelves).click().perform();

}
