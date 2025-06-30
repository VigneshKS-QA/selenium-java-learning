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
	
	By addToCart =By.cssSelector("button.btn.w-10.rounded");
	public List<WebElement> getProductList() {
		
		waintUntilElementToAppear(addToCart);
		return addToCartButtons;
	}
	

	
}
