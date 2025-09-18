package SeleniumMaven.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumMaven.AbstactComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents{

	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button.btn.w-10.rounded"));
	@FindBy(css="button.btn.w-10.rounded")
	List<WebElement> addToCartButtons;
	
	@FindBy(css=".ng-animating")
	WebElement animation;
	

	
	By addToCart =By.cssSelector("button.btn.w-10.rounded");
	By productName = By.xpath("./ancestor::div[contains(@class,'card')]//h5/b");
	By toastmsg = By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList() {
		
		waitUntilElementToAppear(addToCart);
		return addToCartButtons;
	}
	
	public CartPage addProductToCart(String productNameToAdd) throws InterruptedException {
		addToCartButtons.stream()
	    .filter(s ->s.findElement(productName).getText().equalsIgnoreCase(productNameToAdd))
	    .findFirst()
	    .ifPresent(Buttons->Buttons.click()); // Clicks the matching "Add To Cart" button
		
		waitUntilElementToAppear(toastmsg);
		Thread.sleep(3000);
		//waitUntilElementToDisappear(animation);
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	


	
}
