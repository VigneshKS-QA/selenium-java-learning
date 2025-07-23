package SeleniumMaven.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumMaven.AbstactComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='form-group']/input")
	WebElement countries;
	
	@FindBy(css=".ta-item")
	List<WebElement> listCountries;
	
	@FindBy(css="[class*='action__submit']")
	WebElement submitButton;
	
	@FindBy(css=".hero-primary")
	WebElement confirm;
	
	By element =By.xpath("//div[@class='form-group']/input");
	
	
	public void enterCountry(String country){
		 waitUntilElementToAppear(element);
		countries.sendKeys(country);
	}
	
	public void selectCountry(String countryName){
		listCountries.stream().filter(s->s.getText().equalsIgnoreCase(countryName)).findFirst()
	    .ifPresent(s->s.click());
	}
	
	public void submit(){
		submitButton.click();
	}
	
	public String confirmMsg(){
		
		return confirm.getText();
		
	}
	
	

}
