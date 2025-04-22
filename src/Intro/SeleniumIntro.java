package Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumIntro {
	public static void main(String[] args) {
	
		
	//System.setProperty("webdriver.chrome.driver", "E:/Selenium/chrome-win64 (1)/chrome-win64/chrome.exe");
    //WebDriver driver= new ChromeDriver();
	
	System.setProperty("webdriver.edge.driver", "E:/Selenium/msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	
	//System.setProperty("webdriver.gecko.driver", "E:/Selenium/geckodriver.exe");
	//WebDriver driver = new FirefoxDriver();	
		
	driver.get("https://www.youtube.com");

	System.out.println(driver.getTitle());

	System.out.println(driver.getCurrentUrl());
	
	driver.quit();
}
}

