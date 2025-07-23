package SeleniumMaven.Test;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumMaven.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/main/java/SeleniumMaven/Resources/GetDriver.properties");
		prop.load(fis);
		
		//String browser = prop.getProperty("browser");
		String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	@BeforeMethod(alwaysRun=true)	
	public LandingPage launchApp() throws IOException {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
		//json to string
		File jsonFile = new File(filePath);
		String jsonContent =FileUtils.readFileToString(jsonFile, StandardCharsets.UTF_8);
		
		//String to Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		/*File ss =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("E:/Selenium/selenium-java-learning/FirstMaven/Screenshots"+testcaseName+".png"));*/
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		//File file =new File("E:/Selenium/selenium-java-learning/FirstMaven/Screenshots"+testcaseName+".png");
		FileUtils.copyFile(src, new File( "E:/Selenium/selenium-java-learning/FirstMaven/Screenshots"+testcaseName+".png"));
		return "E:/Selenium/selenium-java-learning/FirstMaven/Screenshots"+testcaseName+".png";
		
		
	}
	/*
	// 1. Load JSON file
    File file = new File("src/test/resources/data.json");
    FileReader reader = new FileReader(file);

    // 2. Parse JSON using JSONTokener
    JSONTokener tokener = new JSONTokener(reader);
    JSONObject jsonObject = new JSONObject(tokener);

    // 3. Extract fields if needed
    String email = jsonObject.getString("email");
    String password = jsonObject.getString("password");
	*/
	
	
}
