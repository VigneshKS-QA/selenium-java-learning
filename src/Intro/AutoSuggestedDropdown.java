package Intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestedDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		
		List<WebElement> options= driver.findElements(By.cssSelector("a[class='ui-corner-all']")); 
		 //above line will find element"s" and it is a list of webelements so stored it first
		
		//below line will says it might have many elements and india order may get change so just stored those list in option so used for loop
		//if i use only options.getText it wont appear. we cant get text from many webelemts
		
		  for (WebElement option : options) {
			  if(option.getText().equalsIgnoreCase("India")){ 
				  option.click(); 
				  }
		  }
		 
		/*
		 * for(int i=0; i<options.size(); i++) { String text =options.get(i).getText();
		 * if(text.equalsIgnoreCase("India")) { options.get(i).click(); } }
		 */
		
		driver.close();
	}

}
