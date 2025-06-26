package Intro;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleAddtocart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		//this is updated selenium wait, but old syntax still works

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] vegItems= {"Cucumber","Brocolli", "Beetroot","Beans","Capsicum"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		
		addToCart(driver,vegItems);
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div[@class='action-block']/button[@type='button']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		//WebDriverWait w = new WebDriverWait(driver, 5);		called this object globally because i used "w" more than 1 time
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		
		
		
		Thread.sleep(2000);
		//driver.close();
	}
	
	public static void addToCart(WebDriver driver,String[] vegItems) {
		
List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));  
		int j=0;
		for(int i=0; i<products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String veg =name[0].trim();
			
			List item = Arrays.asList(vegItems);
			if(item.contains(veg)){
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			j++;
			if (j==vegItems.length) {
				break;
			}
		
			
		}
		
		}
	
	}

}
