package StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumMaven.PageObject.CartPage;
import SeleniumMaven.PageObject.CheckOutPage;
import SeleniumMaven.PageObject.LandingPage;
import SeleniumMaven.PageObject.ProductCatalog;
import SeleniumMaven.Test.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitOrderImpl extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	public CartPage cartPage;
	public CheckOutPage checkOut;
	
	
	@Given ("I landed on Ecommerce Website")
	public void I_landed_on_Ecommerce_Website() throws IOException {
		landingPage =launchApp();
	}
	
	@Given ("^Login wih username (.+) and password (.+)$")
	public void Login_wih_username_and_password(String username, String password) {
		productCatalog =landingPage.loginApplication(username,password);
	}
	
	@When ("^Add the (.+) to Cart$")
	public void addProduct(String productName) throws InterruptedException {
		List<WebElement> products = productCatalog.getProductList();
		//productCatalog.addProductToCart(productName);
		cartPage =productCatalog.addProductToCart(productName);
	}
	
	@When ("^Checkout (.+) and Submit the order$")	//we can use "@And" also
	public void Checkout_Product_and_Submit_the_order(String productName ) {
		String cart =cartPage.goToCart(productName);
		Assert.assertTrue(cart.equals(productName));
		String country ="ind";
		checkOut = cartPage.subTotal(); 
		checkOut.enterCountry(country);              
		checkOut.selectCountry("India");
		checkOut.submit();
	}
	
	@Then("{string} message is displayed on confirmationPage")
	public void message_confirmation(String string) {
		String Confirmtext =checkOut.confirmMsg();
		Assert.assertTrue(Confirmtext.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Given ("I landed on Application")
	public void I_landed_on_Application() throws IOException {
		landingPage =launchApp();
	}
	
	@When ("^Enter username (.+) and password (.+)$")
	public void Enter_username_and_password(String username, String password) {
		productCatalog =landingPage.loginApplication(username,password);
	}
	
	@Then ("{string} Error message is displayed.")
	public void Error_message_is_displayed(String string) {
		Assert.assertEquals(string, landingPage.errorMsg());
		driver.close();
	}
	
}
