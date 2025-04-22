package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "E:/Selenium/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		  int i=1;
		  while(i<5){
		  driver.findElement(By.id("hrefIncAdt")).click();
		  i++;
		  } 
		  
		/*for(int i=1; i<5; i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		}*/
		  
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
