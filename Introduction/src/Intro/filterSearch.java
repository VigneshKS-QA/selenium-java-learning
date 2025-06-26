package Intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.stream.Collectors;
public class filterSearch {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		//after entering the text rice, will collect the list of webElements (which is table)
		List<WebElement> list =driver.findElements(By.xpath("//tr/td[1]"));	//1 result contain rice
		
		//after collecting list of webElements , will get list of webElements contains rice 
		List<WebElement> text = list.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList()); //1 result contain rice
		
		//then compare size of list
		Assert.assertEquals(list.size(), text.size());
		
		driver.close();
		
		
	}

}
