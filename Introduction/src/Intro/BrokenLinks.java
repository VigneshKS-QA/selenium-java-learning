package Intro;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert(); 
		List<WebElement> links =driver.findElements(By.cssSelector(".gf-li a")); 
			for(WebElement link : links){ 
			String url =link.getAttribute("href"); 
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD"); 
			conn.connect(); 
			int respCode=conn.getResponseCode(); 
			System.out.println(respCode);
			//Assert.assertTrue(respCode<400, "The code with text"+link.getText()+ "is broken"); //hard assertion means after failing code wont continue 
			a.assertTrue(respCode<400, "The code with text " +link.getText()+ " is broken with code"+respCode); //softassert, continues after failing } a.assertAll();
			}
		    a.assertAll();
		
		    
		    
		//below one is for single link test
		
		/*
		 * String url =driver.findElement(By.xpath("//a[contains(@href, 'soapui')]")).
		 * getDomAttribute("href"); //System.out.println(url);
		 * 
		 * 
		 * 
		 * HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		 * //openConnection() is java method conn.setRequestMethod("HEAD");
		 * conn.connect(); int respCode =conn.getResponseCode();
		 * System.out.println(respCode);
		 */
		 
	
	}
}


