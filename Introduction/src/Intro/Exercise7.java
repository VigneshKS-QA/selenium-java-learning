package Intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Exercise7 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption2")).click();
		System.out.println(driver.findElement(By.xpath("//label[@for='benz']")).getText());
		String text = driver.findElement(By.xpath("//label[@for='benz']")).getText();
		
		Select dropdown = new Select(driver.findElement(By.id("dropdown-class-example")));
		dropdown.selectByVisibleText(text);
		
		driver.findElement(By.name("enter-name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		String msg =  driver.switchTo().alert().getText();
		
		Assert.assertTrue(msg.contains(text));
		
	     /*if(msg.contains(text)) {
	    System.out.println("Alert message success");
	     }
	     else
	    System.out.println("Something wrong with execution");*/

	   
	}

}
