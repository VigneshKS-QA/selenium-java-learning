package Base.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	
	public WebDriver driver;
	public HomePage homePage;
	
	
	public WebDriver  initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("src/main/java/Utils/GetDriver.properties");
		prop.load(file);
		
		String browser =System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "E:/Selenium/edgedriver_win64/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.edge.driver", "E:/Selenium/geckodriver-v0.36.0-win-aarch64/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod
	public void getApplication() throws IOException {
		driver=initializeDriver();
		driver.get("http://books.toscrape.com/");
		homePage = new HomePage(driver);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
	File ss =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ss, new File(System.getProperty("user.dir")+"/Screenshot"+ testcaseName +".png"));
	return System.getProperty("user.dir")+"/Screenshot.png";
	}
	
}
