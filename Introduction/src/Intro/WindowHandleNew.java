package Intro;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;


public class WindowHandleNew {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB); 	//WindowType.WINDOW opens new window
		
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parent =it.next();
		String child =it.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/");	//entered URL in new blank tag
		
		String nameText =driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p')]")).get(1).getText();
		driver.switchTo().window(parent);
		driver.findElement(By.name("name")).sendKeys(nameText);
		
		//take screenshot of element
		File sreenshot =driver.findElement(By.name("name")).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sreenshot, new File("ss.png"));
		
		//height and width of element
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getHeight());
		System.out.println(driver.findElement(By.name("name")).getRect().getDimension().getWidth());	
		
		//below line also works and its preferable than above one
		//System.out.println(driver.findElement(By.name("name")).getRect().getWidth());	
	}

}
