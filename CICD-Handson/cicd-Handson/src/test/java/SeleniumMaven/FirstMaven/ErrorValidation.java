package SeleniumMaven.FirstMaven;
import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumMaven.PageObject.CartPage;
import SeleniumMaven.PageObject.ProductCatalog;
import SeleniumMaven.Test.BaseTest;
import SeleniumMaven.Test.Retry;


public class ErrorValidation extends BaseTest {

	@Test(groups={"errorMsg"},retryAnalyzer=Retry.class)
	public void LoginPageErrorValidation() throws InterruptedException, IOException {
	
	
		landingPage.loginApplication("vigneshks@gmail.com", "Vignesh");
		
		Assert.assertEquals("Incorrect email password.", landingPage.errorMsg());

		}
	@Test
	public void ProductCartErrorValidation() throws InterruptedException, IOException {
		
		
		String productNameToAdd = "IPHONE 13 PRO";
		
		ProductCatalog productCatalog =landingPage.loginApplication("vigneshks@gmail.com", "Vignesh888@");
		
		List<WebElement> products = productCatalog.getProductList();

		productCatalog.addProductToCart(productNameToAdd);
		CartPage cartPage= new CartPage(driver); //here i need to catch the object
	
		String cart =cartPage.goToCart(productNameToAdd);

		//Assert.assertFalse(cart.equals(productNameToAdd));
		Assert.assertNotEquals("IPHONE 14 PLUS", cart);

		}
}
