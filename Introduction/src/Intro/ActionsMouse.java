package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsMouse {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
		Thread.sleep(3000);
		}

}
