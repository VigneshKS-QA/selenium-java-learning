package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class UpdatedDropdown {



	public static void main(String[] args) throws InterruptedException {
		
		//System.setProperty("webdriver.edge.driver", "E:/Selenium/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//Instead of above line we use TestNG assertions
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());	
		//this is false scenario so assertfalse will match with it code continues, otherwise not
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); 
		//this will say "true" even it is disabled so we use getdomattribute to verify the changed attribute in html
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("Style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("Style"));
		if(driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("1")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("its disabled");
			Assert.assertTrue(false);
		}
		
		
		//this is my code
		/*String check1 =driver.findElement(By.id("Div1")).getDomAttribute("Style");  //stored attribute value
		if(check1.contains("0.5")) {
			System.out.println("its disabled");
		}
		else {
			System.out.println("its enabled");
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(2000);
		String check2 =driver.findElement(By.id("Div1")).getDomAttribute("Style");
		System.out.println(check2);
		if(check2.contains("1")) {
			System.out.println("its enabled");
		}
		else {
			System.out.println("its disabled");
		}*/
		
		
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(3000);
		  int i=1;
		  while(i<5){
		  driver.findElement(By.id("hrefIncAdt")).click();
		  i++;
		  } 
		  
		/*for(int i=1; i<5; i++) {
		driver.findElement(By.id("hrefIncAdt")).click();
		}*/
		  
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		//System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		driver.close();

	}

}
