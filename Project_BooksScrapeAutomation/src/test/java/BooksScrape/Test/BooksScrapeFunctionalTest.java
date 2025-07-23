package BooksScrape.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Test.Base;
import PageObject.BookPage;
import PageObject.HomePage;

public class BooksScrapeFunctionalTest extends Base{
	
	@Test
	public void BookApplication() throws InterruptedException, IOException {
		
		
		String title =homePage.getTitle();
		//All products | Books to Scrape - Sandbox
		Assert.assertEquals(title, "All products | Books to Scrape - Sandbox");
		
		boolean match =homePage.searchBoxValidation();
		Assert.assertTrue(match, "Search bar should not be present but was found!");
		
		String firstBookText= homePage.getFirstBook();
		BookPage bookPage =homePage.clickFirstBook();
		
		boolean bookTitle = bookPage.getBookTitle();
		Assert.assertTrue(bookTitle);
		
		boolean bookPrice = bookPage.getBookPrice();
		Assert.assertTrue(bookPrice);
		
		boolean bookStock = bookPage.getBookStock();
		Assert.assertTrue(bookStock);
		
		String pageHeader1 = homePage.getPageHeader();
		homePage.clickNext();
		String pageHeader2 = homePage.getPageHeader();
		Assert.assertTrue(pageHeader1.equalsIgnoreCase(pageHeader2));
		boolean bookPresent =homePage.validateBookIsPresent();
		Assert.assertTrue(bookPresent);
		
		String filterBy ="science";
		homePage.clickCategory(filterBy);
		String filterHeader = homePage.getPageHeader();
		Assert.assertTrue(filterHeader.equalsIgnoreCase(filterBy));
	
		
		String ScienceBookText =homePage.getFirstBookText();
		Assert.assertNotEquals(ScienceBookText, firstBookText);
		String scienceURL =homePage.getCurrentURL();
		Assert.assertTrue(scienceURL.contains(filterBy));
		
	
		
	}

}

