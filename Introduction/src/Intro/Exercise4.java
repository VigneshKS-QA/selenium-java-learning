package Intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exercise4 {

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span[@class='checkmark']")).click();
		
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#okayBtn")));
		
		driver.findElement(By.cssSelector("#okayBtn")).click();
		
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@data-style='btn-info']")));
		dropdown.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
	
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='card-footer']/button[@class='btn btn-info']"));
		//System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			list.get(i).click();
		}

		driver.findElement(By.partialLinkText("Checkout")).click();
		
		
		
		
		

		
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
