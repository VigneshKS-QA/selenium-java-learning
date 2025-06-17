package Intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		
		if(driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("its enabled");
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(3000);
		  int i=1;
		  while(i<5){
		  driver.findElement(By.id("hrefIncAdt")).click();
		  i++;
		  } 
		  driver.findElement(By.id("btnclosepaxoption")).click();
		  Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		  driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		  
		  
		  driver.close();
		  
	}

}
