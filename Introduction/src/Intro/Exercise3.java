package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise3 {

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("Rahul");
		driver.findElement(By.name("email")).sendKeys("Rahul@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rahul@123");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Select gender = new Select(driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")));
		gender.selectByIndex(1);
		//gender.selectByVisibleText("Male");
		driver.findElement(By.xpath("//input[@value='option1']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01-01-2001");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
	
		driver.close();
	}
	

}
