package BooksScrape.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Test.Base;
import Base.Test.Retry;

public class ErrorValidation extends Base {

	@Test(retryAnalyzer=Retry.class)
public void PageHeaderValidation() throws InterruptedException, IOException {
		
		
		String filterBy ="science";
		homePage.clickCategory(filterBy);
		String filterHeader = homePage.getPageHeader();
		Assert.assertFalse(filterHeader.equalsIgnoreCase(filterBy), "Page Header is science, explicitly failing this Test.");
}
}
