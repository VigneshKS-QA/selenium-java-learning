package Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Exercise6 {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		//it has nested frames so first moved to parent frame then it moved to second frame which is inside parent frame
		driver.switchTo().frame("frame-top");	
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		
	}

}
