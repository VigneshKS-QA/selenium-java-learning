package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.AbstractComponents;

public class HomePage extends AbstractComponents {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="input[type='search']") 
	List<WebElement> searchBox;
	
	@FindBy(xpath="(//h3/a[contains(@href, 'index.html')])[1]")
	WebElement firstBook;
	
	@FindBy(css="div[class*='page-header']") 
	WebElement pageHeader;
	
	@FindBy(xpath="//a[text()='next']")
	WebElement nextButton;
	
	@FindBy(xpath="//h3/a[contains(@href, 'index.html')]")
	WebElement book;
	
	By Bybook = By.xpath("//h3/a[contains(@href, 'index.html')]");
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean searchBoxValidation() {
		return searchBox.isEmpty();
	}
	
	public String getFirstBook() {
		String firstBookText = firstBook.getText();
		
		return firstBookText;
		
	}
	
	public BookPage clickFirstBook() {
		firstBook.click();
		BookPage bookPage = new BookPage(driver);
		return bookPage;
	}
	
	public String getFirstBookText() {
	    return firstBook.getText();
	}
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickNext() {
		nextButton.click();
	}
	
	public boolean validateBookIsPresent() {
		waitElementToAppear(Bybook);
		return book.isDisplayed();
	}
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
}
