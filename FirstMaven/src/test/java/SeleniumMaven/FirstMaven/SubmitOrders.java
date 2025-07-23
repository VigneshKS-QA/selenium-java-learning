package SeleniumMaven.FirstMaven;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumMaven.PageObject.CartPage;
import SeleniumMaven.PageObject.CheckOutPage;
import SeleniumMaven.PageObject.ProductCatalog;
import SeleniumMaven.Test.BaseTest;


public class SubmitOrders extends BaseTest {
	String productNameToAdd = "IPHONE 13 PRO";
	
	@Test(dataProvider = "getData", groups= "purchase")
	public void submitOrder(HashMap<String,String> maps) throws InterruptedException, IOException {
	
	
		
	
		ProductCatalog productCatalog =landingPage.loginApplication(maps.get("email"), maps.get("password"));
		
		List<WebElement> products = productCatalog.getProductList();

		CartPage cartPage =productCatalog.addProductToCart(maps.get("product"));
	
		String cart =cartPage.goToCart(maps.get("product"));

		Assert.assertTrue(cart.equals(maps.get("product")));
		
		
		//rahul used findelement"s" and then matched the productNameToAdd by using "anyMatch"
		//Boolean match = elements.stream.anyMatch(s->s.getText().equalIgnorecase(productNameToAdd));
		//Assert.assertTrue(match);
		String country ="ind";
		CheckOutPage checkOut = cartPage.subTotal(); 
		checkOut.enterCountry(country);              
		checkOut.selectCountry("India");
		
		
		//we can sendkeys by actions aslo
		/*Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//div[@class='form-group']/input")), "Ind");*/
		checkOut.submit();
		String Confirmtext =checkOut.confirmMsg();
		Assert.assertTrue(Confirmtext.equalsIgnoreCase("Thankyou for the order."));
	}
	@Test(dependsOnMethods=("submitOrder()"))
	public void OrderPage() throws InterruptedException, IOException {
		
	
		ProductCatalog productCatalog =landingPage.loginApplication("vigneshks@gmail.com", "Vignesh888@");
		SeleniumMaven.PageObject.OrderPage orders =productCatalog.goToOrders();
		Assert.assertTrue(orders.verifyProductInOrderPage(productNameToAdd));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		/*HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "vigneshks@gmail.com");
		map1.put("password", "Vignesh888@");
		map1.put("product", "IPHONE 13 PRO");
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("email", "chrisron7@gmail.com");
		map2.put("password", "Vignesh888@");
		map2.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map1},{map2}};*/
		List<HashMap<String,String>> data =getJsonData("./src/test/java/SeleniumMaven/Data/creds.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	/*@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"vigneshks@gmail.com", "Vignesh888@","IPHONE 13 PRO"},{"chrisron7@gmail.com", "Vignesh888@","ADIDAS ORIGINAL"}};
	}*/
	

}
