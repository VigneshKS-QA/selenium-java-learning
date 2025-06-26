package Intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Second {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "E:/Selenium/chrome-win64 (1)/chrome-win64/chrome.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com");
        System.out.println("Page Title: " + driver.getTitle());

        driver.close(); // This will close the browser properly
    }
}