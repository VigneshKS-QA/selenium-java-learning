package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Exercise2 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		/*Questions:
		Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked

		How to get the Count of number of check boxes present in the page*/
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		driver.findElement(By.name("checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.name("checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		driver.close();
	}

}
