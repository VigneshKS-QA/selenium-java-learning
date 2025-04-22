package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "E:/Selenium/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
	
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.navigate().to("https://google.com");
		//driver.navigate().back();
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
														//parent/child/child[1]/following-sibling::tag of next child of child 1
	}

}
