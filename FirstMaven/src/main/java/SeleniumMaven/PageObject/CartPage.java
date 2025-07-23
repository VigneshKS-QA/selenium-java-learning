package SeleniumMaven.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumMaven.AbstactComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	
	By totalButton = By.xpath("//div[contains(@class,'subtotal')]//button");
	
	public String goToCart(String productNameToAdd) {

		cartButton.click();
		waitUntilElementToAppear(By.xpath("//h3[contains(text(),'" + productNameToAdd + "')]"));
		WebElement cart =driver.findElement(By.xpath("//h3[contains(text(),'" + productNameToAdd + "')]"));
		return cart.getText();
		
	}

	public CheckOutPage subTotal() {
		waitUntilElementToAppear(totalButton);
		waitUntilElementToClick(totalButton).click();
		
		CheckOutPage checkOut= new CheckOutPage(driver);
		return checkOut;
	}
}
