package BooksScrape.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class e2eTest {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://books.toscrape.com/");
		
		String title =driver.getTitle();	
		//All products | Books to Scrape - Sandbox
		Assert.assertEquals(title, "All products | Books to Scrape - Sandbox");
		
		List<WebElement> searchBox = driver.findElements(By.cssSelector("input[type='search']")); 
		Assert.assertTrue(searchBox.isEmpty(), "Search bar should not be present but was found!");
		
		WebElement firstBook =driver.findElement(By.xpath("(//h3/a[contains(@href, 'index.html')])[1]"));
		String firstBookText =firstBook.getText();
		firstBook.click();
		
		WebElement bookTitle =driver.findElement(By.xpath("//div/h1"));
		Assert.assertTrue(bookTitle.isDisplayed());
		
		WebElement bookPrice =driver.findElement(By.xpath("//div/p[@class='price_color']"));
		Assert.assertTrue(bookPrice.isDisplayed());
		
		WebElement bookStock =driver.findElement(By.cssSelector("div p[class*='instock']"));
		Assert.assertTrue(bookStock.isDisplayed());
		
		driver.findElement(By.xpath("//a[contains(text(), 'Home')]")).click();
		String pageHeader =driver.findElement(By.cssSelector("div[class*='page-header']")).getText();
		driver.findElement(By.xpath("//a[text()='next']")).click();
		Assert.assertTrue(pageHeader.equalsIgnoreCase(driver.findElement(By.cssSelector("div[class*='page-header']")).getText()));
		Assert.assertTrue(driver.findElement(By.xpath("//h3/a[contains(@href, 'index.html')]")).isDisplayed());
		
		driver.findElement(By.cssSelector("a[href*='science_22']")).click();
		String pageHeader1 =driver.findElement(By.cssSelector("div[class*='page-header']")).getText();
		Assert.assertEquals(pageHeader1, "Science");
		WebElement firstBook1 =driver.findElement(By.xpath("(//h3/a[contains(@href, 'index.html')])[1]"));
		String ScienceBookText =firstBook1.getText();
		Assert.assertNotEquals(ScienceBookText, firstBookText);
		String scienceURL =driver.getCurrentUrl();
		Assert.assertTrue(scienceURL.contains("category/books/science_22"));
		
		
		driver.close();
		
	}

}
