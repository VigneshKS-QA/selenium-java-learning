package Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesSwitch {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		/*driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));	 //this is by frame webelement
		//this is frame so we need to switch it to frame, so gave frame du element location
		Actions a=new Actions(driver);
		WebElement drag= driver.findElement(By.id("draggable"));
		WebElement drop= driver.findElement(By.id("droppable"));
		a.dragAndDrop(drag, drop).build().perform();*/
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());  //this will get how many frames are there
		driver.switchTo().frame(0);
		Actions a=new Actions(driver);
		WebElement drag= driver.findElement(By.id("draggable"));
		WebElement drop= driver.findElement(By.id("droppable"));
		a.dragAndDrop(drag, drop).build().perform();
		
		
		driver.switchTo().defaultContent();		//this will switch back to driver from frame
		
		//also we can find frame by its "id" in html
		
	}

}
