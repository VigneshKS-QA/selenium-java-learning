package SeleniumMaven.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumMaven.AbstactComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> productInOrder;
	
	By orderedProduct = By.xpath("//tr/td[2]");
	
	public Boolean verifyProductInOrderPage(String productNameToAdd) {
		waitUntilElementToAppear(orderedProduct);
		Boolean match =productInOrder.stream().anyMatch(s->s.getText().equalsIgnoreCase(productNameToAdd));
		return match;
		
	}
}
