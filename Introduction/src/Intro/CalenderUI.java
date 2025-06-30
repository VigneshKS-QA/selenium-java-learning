package Intro;

import java.time.Duration;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.collect.Iterators;

public class CalenderUI {

	public static void main(String[] args) {
		
		String month = "6";
		String year = "2027";
		String day = "15";
		String[] expectedDate= {month,day,year};
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.findElement(By.xpath("//a[contains(text(), 'Top Deals')]")).click();
		
		Set<String> window =driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();	//button[text()='2027'] this is xpath but used "+year+" instead of 2027
		
		
		//driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		
		//Above line is suggested by rahul, below one my code
		List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
		for (int i = 0; i < months.size(); i++) {
		    if (i == Integer.parseInt(month)-1) {
		        months.get(i).click();
		        break;
		    }
		}
		
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0; i<dates.size(); i++) {
			System.out.println(dates.get(i).getDomAttribute("value"));
			Assert.assertEquals(dates.get(i).getDomAttribute("value"), expectedDate[i]);
		}
		driver.quit();
		
		
	}

}
