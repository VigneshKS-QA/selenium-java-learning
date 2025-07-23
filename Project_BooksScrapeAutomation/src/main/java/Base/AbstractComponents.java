package Base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	WebDriverWait w;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		this.w =new WebDriverWait(driver,Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(), 'Home')]")
	WebElement homeButton;
	
	@FindBy(xpath="//div[@class='side_categories']/ul/li/ul/li/a")
	List<WebElement> links;
	
	public void clickHome() {
		homeButton.click();
	}
	
	public void debugCategories() {
	    links.forEach(s -> System.out.println("Category: "+ s.getText()));
	}
	
	public void clickCategory(String filterBy) {
		links.stream().filter(s->s.getText().equalsIgnoreCase(filterBy)).findFirst().ifPresent(WebElement::click);
	}
	
	public void waitElementToAppear(By element) {
		w.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
}
