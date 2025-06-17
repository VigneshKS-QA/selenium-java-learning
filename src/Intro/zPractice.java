package Intro;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class zPractice {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("realme buds");
		Thread.sleep(5000);
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@role='row']"));  
		
		for (WebElement product : products) { 
			if(product.getText().equalsIgnoreCase("realme buds wireless 5")) {
				Thread.sleep(5000);
				product.click();
				break;
			}
		}
		driver.findElement(By.xpath("//span[text()='realme']/preceding::i[contains(@class, 'a-icon-checkbox')][1]")).click();
	    driver.findElement(By.xpath("//h2[contains(@aria-label, '(Dawn Silver)')]")).click();
	    Thread.sleep(5000);
	    
	    Set<String> windowHandles = driver.getWindowHandles();
	    Iterator<String> it=windowHandles.iterator();
	    String parent =it.next();
	    String child =it.next();
	        driver.switchTo().window(child);  // Switches focus to the window
	    
	   
	    
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//h1[contains(text(), 'Added to cart')]")).getText(), "Added to cart");
		driver.findElement(By.linkText("Go to Cart")).click();
		Thread.sleep(5000);

		WebElement quantity = driver.findElement(By.cssSelector("span[data-a-selector='value']"));
		System.out.println(quantity.getText());
		Assert.assertEquals(quantity.getText(), "1");
		
		for(int i=1; i<5; i++) {
			driver.findElement(By.cssSelector("button[aria-label='Increase quantity by one']")).click();
			Thread.sleep(5000);
		}
		
		//should relocate the webelement should not use previous element "quantity", it throws stale error
		WebElement updatedQuantity = driver.findElement(By.cssSelector("span[data-a-selector='value']")); 
		Assert.assertEquals(updatedQuantity.getText(), "5");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
