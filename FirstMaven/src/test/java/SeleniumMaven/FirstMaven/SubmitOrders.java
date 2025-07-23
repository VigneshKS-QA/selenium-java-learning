package SeleniumMaven.FirstMaven;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import SeleniumMaven.PageObject.LandingPage;
import SeleniumMaven.PageObject.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicActions {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
	
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		landingPage.loginApplication("vigneshks@gmail.com", "Vignesh888@");
		ProductCatalog productCatalog =new ProductCatalog(driver);
		List<WebElement> addToCartButtons =productCatalog.getProductList();
		
		
		String productNameToAdd = "IPHONE 13 PRO";
		
		List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("button.btn.w-10.rounded"));

		addToCartButtons.stream()
		    .filter(s -> {
		        // From the button, move up to the card div, then find the product name
		    												// "." means addToCartButtons
		        String productName = s.findElement(By.xpath("./ancestor::div[contains(@class,'card')]//h5/b")).getText();
		        return productName.equals(productNameToAdd);
		    })
		    .findFirst()
		    .ifPresent(WebElement::click); // Clicks the matching "Add To Cart" button
			
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		WebElement cart =driver.findElement(By.xpath("//h3[contains(text(),'" + productNameToAdd + "')]"));
		Assert.assertTrue(cart.getText().equals(productNameToAdd));
		//rahul used findelement"s" and then matched the productNameToAdd by using "anyMatch"
		//Boolean match = elements.stream.anyMatch(s->s.getText().equalIgnorecase(productNameToAdd));
		//Assert.assertTrue(match);
		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'subtotal')]//button"))).click();
		
		driver.findElement(By.xpath("//div[@class='form-group']/input")).sendKeys("ind");
		
		List<WebElement> countries =driver.findElements(By.cssSelector(".ta-item"));
		countries.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst()
	    .ifPresent(WebElement::click);
		
		//we can sendkeys by actions aslo
		/*Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//div[@class='form-group']/input")), "Ind");*/
		driver.findElement(By.cssSelector("[class*='action__submit']")).click();
		
		String Confirmtext =driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(Confirmtext.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
	}

}
