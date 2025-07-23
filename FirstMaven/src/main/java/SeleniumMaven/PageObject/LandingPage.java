package SeleniumMaven.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userName =driver.findElement(By.id("userEmail")).sendKeys("vigneshks@gmail.com");
	//instead of above line we can write as below line by using PageFactory
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyIn']")
	WebElement errorMsg;
	
	
	
	public ProductCatalog loginApplication(String username, String pass) {
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
		ProductCatalog productCatalog =new ProductCatalog(driver);
		return productCatalog;
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorMsg() {
		return errorMsg.getText();
	}
	
}
