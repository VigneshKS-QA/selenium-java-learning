package Intro;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class SortTable {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click column
		driver.findElement(By.xpath("//tr/th[1]")).click()	;
		
		//collects elements
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		
		//get text from those elements
		List<String> originalText = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort it
		List<String> sortedText = originalText.stream().sorted().collect(Collectors.toList());
		
		//compare sorted text with the text got from elements
		Assert.assertTrue(originalText.equals(sortedText));
		
		//get price of specific item and pagination
		List<String> price;
		do
		{
			List<WebElement> elements1 = driver.findElements(By.xpath("//tr/td[1]"));
			price = elements1.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());		
		
		price.forEach(s->System.out.println(s));
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);
		
		driver.close();
		
		
		}

	private static String getPriceVeggie(WebElement s) {
		String text =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return text;
	}

}
