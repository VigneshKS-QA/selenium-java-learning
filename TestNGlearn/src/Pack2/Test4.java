package Pack2;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4 {
	@Test(timeOut=4000)		//Fail this test if it takes more than 4 seconds to complete.
	public void DemoS() {
		System.out.println("Done");
		Assert.assertTrue(false);
	}
	@Test
	public void Xe() {
		System.out.println("Xe should execute before Ze");
	}
	
	@BeforeMethod(enabled=false)
	public void before1() {
		System.out.println("I will execute before every method from test4 class ");
	}
	@AfterTest
	public void DemoSDone() {
		System.out.println("Done used aftertest");
	}
	
	@Test
	public void before2() {
		System.out.println("Hello everyone");
	}
	@AfterMethod(enabled=false)
	public void After1() {
		System.out.println("I will execute after every method from test4 class ");
	}
	@Test(dependsOnMethods="Xe")
	public void Ze() {
		System.out.println("Ze should execute after Xe");
	}
	@Parameters("URL")
	@Test
	public void CarLoan(String URL) {
		System.out.println("carloanURL");
		System.out.println(URL);
	}
}
