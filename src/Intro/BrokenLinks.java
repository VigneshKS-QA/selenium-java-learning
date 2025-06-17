package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String URL =driver.findElement(By.xpath("//a[contains(@href, 'soapui')]")).getDomAttribute("href");
		//System.out.println(URL);
	}

}
