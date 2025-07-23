package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AbstractComponents;

public class BookPage extends AbstractComponents {

	WebDriver driver;
	public BookPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div/h1")
	WebElement bookTitle;
	
	@FindBy(xpath="//div/p[@class='price_color']")
	WebElement bookPrice;
	
	@FindBy(css="div p[class*='instock']")
	WebElement bookStock;
	
	By bybookTitle =By.xpath("//div/h1");
	
	public boolean getBookTitle() {
		waitElementToAppear(bybookTitle);
		return bookTitle.isDisplayed();
	}
	
	public boolean getBookPrice() {
		return bookPrice.isDisplayed();
	}
	
	public boolean getBookStock() {
		boolean match = bookStock.isDisplayed();
		   if (match) {
	            clickHome();  
	        }
		return match;
	}
	
}
