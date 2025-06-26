package Intro;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.collect.Iterators;

public class e2eScenario {
public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// count all links of page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//count links at footer section
		WebElement footer = driver.findElement(By.id("gf-BIG"));	//saved footer location
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//count links at footer section of particular column
		WebElement column =footer.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		//check those links are working
		for(int i=1; i<column.findElements(By.tagName("a")).size(); i++) {		//i=0 0th link is not working so used 1
			String clickOnLinks =Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			column.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinks);
		}
		
		//get title of all opened windows
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
}
}
