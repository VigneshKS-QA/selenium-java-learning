package Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.edge.driver", "E:/Selenium/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());		//tagname.classname du value	for tagname#id du value
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Tim");		// for xpath //input@[attribute='value'] 
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Tim@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("Tim@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9824567815");				//xpath //parentTag/childtag[iindex]
		driver.findElement(By.className("reset-pwd-btn")).click();							
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());			//css  parenttag space childtag
		
		driver.findElement(By.xpath("//div/button[1]")).click();
		driver.findElement(By.cssSelector("input[placeholder=Username]")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		driver.findElement(By.cssSelector("input#chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
	}

}
