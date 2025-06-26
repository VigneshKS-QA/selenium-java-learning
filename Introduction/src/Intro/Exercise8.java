package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Exercise8 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,480)");
		
		int rows = driver.findElements(By.cssSelector(".table-display tr")).size();
		int column = driver.findElements(By.cssSelector(".table-display tr:first-child th")).size();
		System.out.println("total rows=" + rows); 
		System.out.println("total column=" + column); 
		
		//System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(1)")).getText());
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(2)")).getText());
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(3)")).getText());
		
		//Rahul code, he focused on table, but i used table parent tag
		/*WebElement table=driver.findElement(By.id("product"));

		System.out.println(table.findElements(By.tagName("tr")).size());

		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println(secondrow.get(0).getText());

		System.out.println(secondrow.get(1).getText());

		System.out.println(secondrow.get(2).getText());*/

	}

}
