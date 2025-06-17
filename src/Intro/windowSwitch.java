package Intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class windowSwitch {

	public static void main(String[] args) {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		
		String emailId =driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//my code
		/*System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String text =driver.findElement(By.cssSelector(".im-para.red")).getText();
		String[] userName =text.split("with");
		String text1 =userName[0];
		String[] uId = text1.split("at");
		String u=uId[1].trim();
		System.out.println(u);*/
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("username")).sendKeys(emailId);
	}

}
