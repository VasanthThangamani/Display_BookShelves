package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtils;

public class Submenu extends BasePage{

	public Submenu(WebDriver driver) {
		super(driver);
	}
	Actions act=new Actions(driver);
	@FindBy(xpath="//li[@class=\"topnav_item livingunit\"]/span")
	WebElement Living;
	
	@FindBy(xpath="//a[@href='/chair?src=g_topnav_living_seating-chairs']")
	WebElement seatingAndChairs;
	
	@FindBy(xpath="//ul/li[3]/div/div/ul/li[1]//a")
	List<WebElement>  submenu;
	
	
	//html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li/a

	public void HoverToLiving() throws InterruptedException {
		act.clickAndHold(Living).perform();
		Thread.sleep(3000);;
	}
	public void seatingAndChairs() throws IOException {
		int row=1;
//		wait(seatingAndChairs,30);
		for(WebElement seat : submenu) {
			System.out.println(seat.getText());
			excelUtils.setCellData("XLwrite",row ,1 ,seat.getText() );
			row++;
		}

	}
	
}
