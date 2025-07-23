package Intro;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.apache.commons.io.FileUtils;
public class InsecureHandle {

	public static void main(String[] args) throws IOException {
		
		EdgeOptions opts = new EdgeOptions();
		
		Proxy prox = new Proxy();
		prox.setHttpProxy("ipAddress:4444");
		
		opts.setCapability("proxy", prox);
		opts.setAcceptInsecureCerts(true);
		
		
		WebDriver driver = new EdgeDriver(opts);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("nameOfCookie");  //this will help to go back to login when we click any link 
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\screenshot.png"));
		 
		
		
	}

}
