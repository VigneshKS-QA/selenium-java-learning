package Intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class zProject {

	public static void main(String[] args) throws InterruptedException {
		String addThis = "Nokia Edge";
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		login1(driver,wait);
		navigation(driver);
		Thread.sleep(3000);
		login2(driver,wait);
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		login1(driver,wait);
		
		List<WebElement> products =	driver.findElements(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']"));
		for(WebElement prod:products) {
			String add =prod.getText();
			if(add.contains(addThis)) {
				prod.findElement(By.cssSelector(".btn.btn-info")).click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-link.btn.btn-primary")));
		driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();
		String prodText =driver.findElement(By.cssSelector(".col-sm-8.col-md-6")).getText();
		if(prodText.contains(addThis)) {
			System.out.println("Product verified");
		}
		else {
			System.out.println("Product Not verified");
		}
		
		Thread.sleep(5000);
		driver.close();
	}
		
		public static void login1(WebDriver driver,WebDriverWait wait) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		Thread.sleep(3000);
		}
		public static void navigation(WebDriver driver) {
		driver.navigate().back();
		driver.navigate().refresh();
		}
		public static void login2(WebDriver driver,WebDriverWait wait) {
		driver.findElement(By.id("username")).sendKeys("wrongid");
		driver.findElement(By.id("password")).sendKeys("wrongpass");
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert.alert-danger.col-md-12"))));
		String errorMsg =driver.findElement(By.cssSelector(".alert.alert-danger.col-md-12")).getText();
		System.out.println(errorMsg);
		Assert.assertTrue(errorMsg.contains("Incorrect"), errorMsg);
		}
		
		
		
		}

	
		
	


