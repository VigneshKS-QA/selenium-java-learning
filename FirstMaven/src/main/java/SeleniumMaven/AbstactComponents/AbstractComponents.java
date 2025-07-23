package SeleniumMaven.AbstactComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumMaven.PageObject.OrderPage;

public class AbstractComponents {
	
	

	WebDriver driver;
	WebDriverWait w;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement OrderButton;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		this.w =new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	public void waitUntilElementToAppear(By element) {
		
		w.until(ExpectedConditions.visibilityOfElementLocated((element)));
	}
	public void waitUntilElementToDisappear(WebElement ele) {
		
		w.until(ExpectedConditions.invisibilityOf((ele)));
	}
	
	public WebElement waitUntilElementToClick(By eleClick) {
		
		return w.until(ExpectedConditions.elementToBeClickable(eleClick));
	}
	public OrderPage goToOrders() {
		OrderButton.click();
		OrderPage orders = new OrderPage(driver);
		return orders;
	}
	
	
}
